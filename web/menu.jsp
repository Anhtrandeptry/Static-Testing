

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
<!--    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> +84 962313361</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> anhtqhe172548@fpt.edu.vn.com</a></li>
                <li><a href="https://uni.fpt.edu.vn/en-US/Default.aspx"><i class="fa fa-map-marker"></i> FPT University</a></li>
            </ul>
            <ul class="header-links pull-right">
                <c:if test="${sessionScope.acc.permissionID == 1}">
                    <li><a href="manager"><i class="fa fa-user-o"></i>Manager Product</a></li>
                    
                    
                    </c:if>
                    <c:if test="${sessionScope.acc.permissionID == 2}">
                    
                    </c:if>

                <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
                    <c:if test="${sessionScope.acc != null}">
                    <li><a href="logout"><i class="fa fa-user-o"></i> Logout(${sessionScope.acc.username})</a></li>
                    </c:if>
                    <c:if test="${sessionScope.acc == null}">
                    <li><a href="login"><i class="fa fa-user-o"></i> Login</a></li>
                    </c:if>
            </ul>
        </div>
    </div>-->

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        nav {
            background-color: #f8f8f8; /* Màu trắng sữa */
            overflow: hidden;
            text-align: right;
        }

        nav a, nav span {
            display: inline-block;
            color: black; /* Màu đen */
            text-align: center;
            padding: 10px 12px; /* Giảm khoảng cách */
            text-decoration: none;
            font-family: Arial, sans-serif; /* Font Arial */
            font-weight: bold; /* In đậm */
            font-size: 12px; /* Cỡ chữ nhỏ hơn */
        }

        nav a:hover {
            background-color: #ddd;
            color: black;
        }

        nav span {
            color: #ddd;
        }

        .dropdown {
            display: none;
            position: absolute;
            background-color: #f8f8f8;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
            z-index: 1;
            text-align: left;
        }

        .dropdown a {
            display: block;
            color: black;
            padding: 10px 12px;
            text-decoration: none;
        }

        .dropdown a:hover {
            background-color: #ddd;
            color: black;
        }
    </style>
</head>
<body>

<nav id="navbar">
    <!-- Placeholder links, actual content will be added by JavaScript -->
</nav>

<script>
    // Replace the following logic with your own JSTL logic to determine login status
    const isLoggedIn = ${sessionScope.acc != null};

    // Function to toggle the dropdown content
    function toggleDropdown() {
        document.getElementById("dropdownContent").classList.toggle("show");
    }

    // Populate the navbar based on the login status
    function updateNavbar() {
        const navbar = document.getElementById("navbar");

        // Clear existing content
        navbar.innerHTML = "";

        if (isLoggedIn) {
            // If logged in, show logout, hi + username, and user icon
            navbar.innerHTML += `<a href="#logout">Logout</a>`;
            navbar.innerHTML += `<span>|</span>`;
            navbar.innerHTML += `<a href="#hi">Hi, ${sessionScope.acc.username}</a>`;
            navbar.innerHTML += `<span>|</span>`;
            navbar.innerHTML += `<span onclick="toggleDropdown()">User Icon</span>`;
            navbar.innerHTML += `<div id="dropdownContent" class="dropdown">
                                    <a href="#logout">Logout</a>
                                    <a href="#account">Account</a>
                                    <a href="#profile">Profile</a>
                                  </div>`;
        } else {
            // If not logged in, show help, register, and signin
            navbar.innerHTML += `<a href="#help">Help</a>`;
            navbar.innerHTML += `<span>|</span>`;
            navbar.innerHTML += `<a href="#register">Register</a>`;
            navbar.innerHTML += `<span>|</span>`;
            navbar.innerHTML += `<a href="#signin">Signin</a>`;
        }
    }

    // Call the updateNavbar function when the page loads
    window.onload = updateNavbar;
</script>

</body>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header" style="background-image: url('./img/loginform.jpeg')">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="#" class="logo">
                            <img src="./img/logo5.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form action="#" >
                            <select class="input-select" name="searchID">
                                <option value="0">All Iteams</option>
                                <!--ADD JSTL HERE -->
                            </select>
                            <input class="input" placeholder="Search here" name="txt" type="text" value="">
                            <button class="search-btn" type="submit">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        

                        

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->