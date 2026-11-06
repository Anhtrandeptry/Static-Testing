import json
import base64
import re
import time
import requests
import pandas as pd

from concurrent.futures import (
    ThreadPoolExecutor,
    as_completed
)

# ======================================
# CONFIG
# ======================================

WEB_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZF9leHBpcmVkX2F0IjoiMjAyNi0xMi0zMVQyMzo1OTo1OSIsInN1YiI6InR5dHhha2hvYWljaGF1LmtjYkBnbWFpbC5jb20iLCJzdGF0dXNfYWNjb3VudCI6IjEiLCJtYV9jc2tiIjoiODkzNDI4NjAzNTI5MSIsImRpdmlzaW9uX3R5cGUiOiJtZWQiLCJhY2NvdW50X2xldmVsIjoiMiIsInNlc3Npb25faWQiOiJySEVfSlBicEJZR0hLUnJyYWcxTlQyVTB4VmtMcFAtU2VmQzI2VVoxRkJFWDhLMDExTko2RldRLWVXZVpmZ3NnUjVKdlR0SU9CaHRwQnNrQW1Jd0NvYWJfbUZjcVBpZXdfNFhsSU5yVlZsbyIsInBlcm1pc3Npb25faWQiOiJhMWZkYTRlNi05YTg1LTQwMWItODFlMy1hNDVkMTUyNjc4OTYiLCJ0b2tlbl90eXBlIjoiYWNjZXNzIiwidXVpZCI6ImUxMDdjZDE4LTg2YzEtNGU4Ny05MTFmLTRkZmNmYzFmYzdiNiIsImF1dGhvcml0aWVzIjpbImxvZ2luIiwiZmFjaWxpdHkiXSwicHJvdmluY2VfaWQiOjMzLCJ3YXJkX2lkIjoxMjY0LCJtYV9ncl9zeXQiOiJTWVQzMyIsInVzZXJuYW1lIjoiODkzNDI4NjAzNTI5MSIsInV0IjoiZmFjaWxpdHkiLCJpc3MiOiJpZGVudGl0eSIsImV4cCI6MTc5Mzk2MjQ4OSwiaWF0IjoxNzkzOTU4ODg5fQ.DF8LI8cmFTUhICVOX96raDS-PMKWCUReWHHYmwiTbXg"

START_DATE = "20260601000000"
END_DATE = "20261105235959"

PAGE_SIZE = 30
MAX_WORKERS = 1

# ======================================
# REQUEST
# ======================================

def get_history_page(page):

    url = (
        "https://admin.csdlksk.vn"
        "/api/admin/backoffice/reports/"
        "sync-checkup/history"
    )

    params = {
        "page_number": page,
        "page_size": PAGE_SIZE,
        "status": "fail",
        "start_date": START_DATE,
        "end_date": END_DATE
    }

    r = requests.get(
        url,
        params=params,
        cookies={
            "WEB_TOKEN": WEB_TOKEN
        },
        timeout=120
    )

    r.raise_for_status()

    return r.json()


def get_detail(uuid):

    url = (
        "https://admin.csdlksk.vn"
        "/api/admin/backoffice/reports/"
        f"sync-checkup/detail/{uuid}"
    )

    r = requests.get(
        url,
        cookies={
            "WEB_TOKEN": WEB_TOKEN
        },
        timeout=120
    )

    r.raise_for_status()

    return r.json()


# ======================================
# XML
# ======================================

def extract_cccd(xml_text):

    pos = xml_text.find("SO_CCCD")

    if pos != -1:

        print("\n===== SO_CCCD AREA =====")

        print(
            xml_text[
                max(0, pos - 100):
                pos + 300
            ]
        )

        print("========================\n")

    pattern = re.compile(
        r"<SO_CCCD[^>]*>\s*(.*?)\s*</SO_CCCD>",
        flags=re.IGNORECASE | re.DOTALL
    )

    m = pattern.search(xml_text)

    if m:

        value = m.group(1).strip()

        print("REGEX FOUND =", value)

        if value:
            return value

    if re.search(
        r"<SO_CCCD\s*/>",
        xml_text,
        flags=re.IGNORECASE
    ):
        print("SELF CLOSING TAG")
        return "Không có"

    print("NOT FOUND")
    return "Không có"


# ======================================
# DETAIL PROCESS
# ======================================

def process_record(record):

    uuid = record["id"]

    print(
        f"Processing: "
        f"{record.get('ten_bn', '')} "
        f"| {uuid}"
    )

    try:

        detail = get_detail(uuid)

        request_data = (
            detail["data"]["request_data"]
        )

        request_json = json.loads(
            request_data
        )

        print(
            "\nREQUEST JSON KEYS:",
            request_json.keys()
        )

        xml_base64 = request_json["data"]

        xml_text = (
            base64
            .b64decode(xml_base64)
            .decode(
                "utf-8",
                errors="ignore"
            )
        )

        with open(
            "debug.xml",
            "w",
            encoding="utf-8"
        ) as f:
            f.write(xml_text)

        print(
            "\ndebug.xml saved"
        )

        cccd = extract_cccd(xml_text)

        print(
            f"\n--> CCCD: {cccd}\n"
        )

        return {
            "UUID": uuid,
            "TEN_BN": record.get(
                "ten_bn", ""
            ),
            "SO_CCCD": cccd,
            "LY_DO": record.get(
                "ly_do", ""
            ),
            "STATUS": record.get(
                "status", ""
            ),
            "STATUS_ETL": record.get(
                "status_etl", ""
            ),
            "CREATED_AT": record.get(
                "created_at", ""
            )
        }

    except Exception as ex:

        print(
            "\nDETAIL ERROR:"
        )

        print(ex)

        return {
            "UUID": uuid,
            "TEN_BN": record.get(
                "ten_bn", ""
            ),
            "SO_CCCD": "ERROR",
            "ERROR": str(ex)
        }


# ======================================
# MAIN
# ======================================

def main():

    print("Getting first page...")

    history = get_history_page(0)

    total = history["data"]["total_elements"]

    print(
        f"Total Records In System: {total}"
    )

    records = history["data"]["data"][:30]

    print(
        f"Will process {len(records)} records"
    )

    results = []

    for record in records:

        result = process_record(record)

        results.append(result)

    df = pd.DataFrame(results)

    df["CO_CCCD"] = df["SO_CCCD"].apply(
        lambda x:
        "YES"
        if x not in [
            "",
            "Không có",
            "ERROR"
        ]
        else "NO"
    )

    df.to_excel(
        "KetQua_30_Record.xlsx",
        index=False
    )

    print("\nDONE")

    print(
        df[
            [
                "TEN_BN",
                "SO_CCCD",
                "CO_CCCD"
            ]
        ]
    )

    print(
        "\nOutput: KetQua_30_Record.xlsx"
    )


if __name__ == "__main__":
    main()
