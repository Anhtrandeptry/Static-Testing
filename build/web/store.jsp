

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>FLOWER SHOP</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <!-- NAVIGATION -->
            <nav id="navigation">
                <!-- container -->
                <div class="container">
                    <!-- responsive-nav -->
                    <div id="responsive-nav">
                        <!-- NAV -->
                        <ul class="main-nav nav navbar-nav">
                            <li class="active"><a href="product">Home</a></li>
                            <li><a href="category?cid=1">Wedding</a></li>
                            <li><a href="category?cid=2">Birthday</a></li>
                            <li><a href="category?cid=3">Funeral</a></li>

                        </ul>
                        <!-- /NAV -->
                    </div>
                    <!-- /responsive-nav -->
                </div>
                <!-- /container -->
            </nav>
            <!-- /NAVIGATION -->



            <!-- SECTION -->
            <div class="section">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- ASIDE -->
                        <div id="aside" class="col-md-3">
                            <!-- aside Widget -->

                            <!-- /aside Widget -->


                            <div class="aside">
                                <h3 class="aside-title">Top selling</h3>
                            <c:forEach items="${listS}" var="o">
                                <div class="product-widget">
                                    <div class="product-img">
                                        <img src="${o.image}" alt="">
                                    </div>
                                    <div class="product-body">
                                        <p class="product-category">${o.category.name}</p>
                                        <h3 class="product-name"><a href="#">${o.name}</a></h3>
                                        <h4 class="product-price">${o.price}</h4>
                                    </div>
                                </div>

                            </c:forEach>
                        </div>
                        <!-- /aside Widget -->
                    </div>
                    <!-- /ASIDE -->

                    <!-- STORE -->
                    <div id="store" class="col-md-9">
                        <!-- store top filter -->
                        <div class="store-filter clearfix">
                            <div class="store-sort">
                                <form action="sort" method="post">
                                    <label>
                                        Sort By:
                                        <select class="input-select" name="sortID">
                                            <option value="0">Price Max to Min</option>
                                            <option value="1">Price Min to Max</option>
                                            <option value="2">Name</option>
                                        </select>
                                    </label>  
                                    <button class="search-btn" type="submit">Sort</button>
                                </form>
                            </div>
                            <ul class="store-grid">
                                <li class="active"><i class="fa fa-th"></i></li>
                                <li><a href="#"><i class="fa fa-th-list"></i></a></li>
                            </ul>
                        </div>
                        <!-- /store top filter -->

                        <!-- store products -->
                        <div class="row">
                            <!-- product -->
                            <form name="f" action="#" method="post">
                                <c:forEach items="${listP}" var="o">
                                    <div class="col-md-3 col-xs-7">
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="${o.image}" alt="">
                                                <div class="product-label">
                                                    <span class="new">NEW</span>
                                                </div>
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${o.category.categoryID}</p>
                                                <c:set var="productID" value="${o.productID}"/>
                                                <h3 class="product-name"><a href="detail?pid=${productID}">${o.name}</a></h3>
                                                <h4 class="product-price">${o.price}</h4>
                                                <div class="product-rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="product-btns">
                                                    <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                    <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                </div>
                                            </div>
                                            <input type="button" onclick="buy('${productID}')" class="add-to-cart-btn" value="Add to cart"></i></input>
                                        </div>
                                    </div>
                                </c:forEach>
                            </form>
                            <!-- /product -->

                            <!-- /product -->
                        </div>
                        <!-- /store products -->

                        <!-- store bottom filter -->
                        <c:set var="page" value="${requestScope.page}"/>
                        <div class="pagination">                      
                            <c:forEach begin="1" end="${requestScope.num}" var="i">
                                <a class="active" href="product?page=${i}">${i}</a>
                            </c:forEach>
                        </div>

                        <!-- /store bottom filter -->
                    </div>
                    <!-- /STORE -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- NEWSLETTER -->
        <div id="newsletter" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="newsletter">
                            <p>Sign Up for the <strong>FLOWERSHOP</strong></p>
                            <form>
                                <input class="input" type="email" placeholder="Enter Your Email">
                                <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                            </form>
                            <ul class="newsletter-follow">
                                <li>
                                    <a href="https://www.facebook.com/profile.php?id=100042635132887"><i class="fa fa-facebook"></i></a>
                                </li>

                                <li>
                                    <a href="https://www.instagram.com/16._.centimet/"><i class="fa fa-instagram"></i></a>
                                </li>
                                
                                <li>
                                    <a href="https://www.pinterest.com/"><i class="fa fa-pinterest"></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /NEWSLETTER -->

        <jsp:include page="footer.jsp"></jsp:include>

        <!-- jQuery Plugins -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>

