<%-- 
    Document   : AddProduct
    Created on : Oct 13, 2023, 1:54:23 PM
    Author     : TienPro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        form {
            background-color: #fff;
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }

        form input[type="text"], form select {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        form select {
            appearance: none;
        }

        form select, form input[type="submit"] {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        form select:hover, form input[type="submit"]:hover {
            background-color: #1f77c7;
        }
    </style>
</head>
<body>
    <form action="add" method="post">
        <label for="productName">Name:</label>
        <input type="text" name="productName" id="productName"><br>

        <label for="description">Description:</label>
        <input type="text" name="description" id="description"><br>

        <label for="price">Price:</label>
        <input type="text" name="price" id="price"><br>

        <label for="stock">Stock:</label>
        <input type="text" name="stock" id="stock"><br>

        <label for="image">Image:</label>
        <input type="text" name="image" id="image"><br>

        <label for="categoryID">Category:</label>
        <select name="categoryID" id="categoryID">
            <option value="0">All categories</option>
            <c:forEach items="${data2}" var="s">
                <option value="${s.categoryID}">${s.name}</option>
            </c:forEach>
        </select><br>

        <label for="subcategoryID">Subcategory:</label>
        <select name="subcategoryID" id="subcategoryID">
            <option value="0">All Sub-categories</option>
            <c:forEach items="${data}" var="c">
                <option value="${c.subcategoryID}">${c.name}</option>
            </c:forEach>
        </select><br>

        <label for="originID">Origin:</label>
        <input type="text" name="originID" id="originID" placeholder="1:DOMESTIC||2:IMPORTED"><br>

        <input type="submit" name="add" value="ADD"><br>${mess}
    </form>
</body>
</html>
