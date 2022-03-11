
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Gift Shop</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/stylepage.css" />
        <link rel="stylesheet" href="css/dropdownstyle.css" />

    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 col-lg-3 logo_wrap">
                    <a id="logo" href="homePageController">

                        <b>GiftShop</b>

                        <span>Gift & Accessories</span>
                    </a>
                </div>
                <div class="col-sm-6 col-lg-5">
                    <div class="header_row-12"></div>
                    <div class="header_row-2-search">
                        <!-- HEADER SEARCH -->
                        <div class="header_search">

                            <form action="searchProductController" method="post" >
                                <div class="col-xs-9  col-lg-8 ">

                                    <input id="search-field" name="q" type="search" placeholder="Search store..."
                                           />
                                </div>
                                <div class="col-xs-3 col-lg-4 ">
                                    <button type="submit" class="btn btn-default">                                       
                                        Search
                                    </button>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-4 header_row-both">

                    <div class="header_user">

                        <!-- USER MENU -->


                        <c:choose>
                            <c:when test="${sessionScope.acc==null}">
                                <a href="login.jsp" id="customer_login_link">Log in</a>
                                <a href="signup.jsp" id="customer_register_link">Create an account</a>

                                <a class="header_cart" href="showCartController" id="customer_cart_link"><b>Cart</b><span


                                        class="cart-items"></span></a>
                                </c:when>
                                <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin!=true }">
                                <a href="login" id="customer_login_link">Log out</a>
                                <a href="homePageController" id="customer_register_link">Hello: ${sessionScope.acc.user}</a>

                                <a class="header_cart" href="showCartController" id="customer_cart_link"><b>Cart</b><span


                                        class="cart-items"></span></a>
                                </c:when>
                                <c:when test="${sessionScope.acc!=null && sessionScope.acc.isAdmin==true }">
                                <a href="login" id="customer_login_link">Log out</a>
                                <a href="homePageController" id="customer_register_link">Hello: ${sessionScope.acc.user}</a>
                                <a href="managerController" id="customer_manager_link">Manager</a>

                                <a class="header_cart" href="showCartController" id="customer_cart_link"><b>Cart</b><span


                                        class="cart-items"></span></a>

                            </c:when>




                        </c:choose>

                    </div>
                </div>

            </div>
            <div class="row-Menu">
                <div class="clearfix" id="navigation">
                    <ul class="sf-menu">


                        <li class="active firstItem">
                            <a  href="homePageController">Home</a>

                        </li>

                        <li class="has-dropdown">
                            <a  href="shopController">Shop</a>
                        </li>


                        <li>
                            <a  href="aboutusController">About Us</a>

                        </li>


                        <li class="last lastItem">
                            <a  href="#">Contact us</a>

                        </li>

                    </ul>
                </div>
            </div>
            <div class="rowBanner">
                <div class="col-md-12 banner123">
                    <img style="height: 520px; width: 100%;" class="img-responsive"
                         src="images/ManUnitedbanner.jpg" />
                </div>
            </div>
        </div>


        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2 style="color: #f72b2f; text-transform:uppercase;"  >New Product</h2>
                    <img style="width:100%;" class="img-responsive" src="images/evenBanner.png" />
                </div>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <div class="service-row">
                        <a href="productController?pid=${listPNew[0].pid}" > 
                            <img style="width:100%;" class="img-responsive" src="${listPNew[0].productImg}" />
                        </a>
                        <div class="service-item">
                            <h3>Beauty and Cute</h3>
                            <p>Always in style!</p>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="service-row">
                        <a href="productController?pid=${listPNew[1].pid}" > 

                            <img style="width:100%;" class="img-responsive" src="${listPNew[1].productImg}" />
                        </a>

                        <div class="service-item">
                            <h3>Always On Top</h3>
                            <p>All eyes on you</p>
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="service-row">
                        <a href="productController?pid=${listPNew[2].pid}" > 

                            <img style="width:100%;" class="img-responsive" src="${listPNew[2].productImg}" />
                        </a>

                        <div class="service-item">
                            <h3>Look perfect.</h3>
                            <p>Discover the difference.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="service-row">
                        <a href="productController?pid=${listPNew[3].pid}" > 

                            <img style="width:100%; "  class="img-responsive" src="${listPNew[3].productImg} "  />
                        </a>

                        <div class="service-item">
                            <h3>Just Perfect</h3>
                            <p>Don't worry, we have it.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2 class="title">THE BEST SELL PRODUCT</h2>
                    <p class="combo-header-des">
                        Buy the best, and forget the rest!
                    </p>
                </div>
            </div>

            <div class="row">
                <c:forEach items="${listBest}" var="b">
                    <div class="col-md-3">
                        <div>
                            <a href="productController?pid=${b.pid}" > 
                                <img src="${b.productImg}" class="img-responsive" /></a>
                            <div class="item">
                                <p class="item-title">${b.productName}</p>
                                <p class="item-description">
                                    Discount: <span style="font-weight: bold; margin-left: 10px">10%</span>
                                </p>
                                <p>
                                    Price: 
                                    <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${b.productPrice} $ </span>
                                    <a href="cartController?pid=${b.pid}" id="add_cart">Add to cart </a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2 class="title">THE PRODUCT IN STORE</h2>
                    <p class="combo-header-des">
                        Quality belong with time!
                    </p>
                </div>
            </div>
            <div class="row">
                <c:forEach items= "${listP}" begin="0" end="7" var="p">
                    <div class="col-md-3">
                        <div>
                            <a href="productController?pid=${p.pid}" > 
                                <img src="${p.productImg}" class="img-responsive" /></a>
                            <div class="item">
                                <p class="item-title">${p.productName}</p>
                                <p class="item-description">
                                    Discount: <span style="font-weight: bold; margin-left: 10px">10%</span>
                                </p>
                                <p>
                                    Price: 
                                    <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${p.productPrice} $ </span>
                                    <a href="cartController?pid=${p.pid}" id="add_cart">Add to cart </a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2>SPECIAL SALE OF FOR YOU</h2>
                    <p class="combo-header-des">Limited time offer. Hurry up!</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div>
                        <img class="img-responsive" src="images/saleoff.png" />
                    </div>
                </div>

                <div class="col-md-4">
                    <div>
                        <img class="img-responsive" src="images/freeship.png" />

                    </div>
                </div>
                <div class="col-md-4">
                    <div>
                        <img class="img-responsive" src="images/saleoff.png" />
                    </div>
                </div>
            </div>
        </div>




        <div class="container-fluid ">
            <div class="row">

            </div>
            <div class="row_footer1">

                <div class="col-md-3  custom_footer custom_footer1">
                    <h3>Menu</h3>
                    <ul class="list">

                        <li class="firstItem"><a title="" href="homePageController">Home</a></li>

                        <li><a title="" href="shopController">Shop</a></li>


                        <li><a title="" href="aboutusController">About Us</a></li>



                        <li class="lastItem"><a title="" href="#">Contact us</a></li>

                    </ul>
                </div>
                <div class="col-md-3  custom_footer custom_footer2">
                    <h3>Collections</h3>
                    <ul class="list">
                        <c:forEach items="${listC}" var="c" >
                            <li> <a title="" href="categoryController?cid=${c.cid}">${c.categoryName}</a></li>

                        </c:forEach>



                    </ul>
                </div>



                <div class="col-md-3  custom_footer custom_footer3">
                    <h3>Information</h3>
                    <ul class="list">


                        <li class="lastItem"><a title="" href="showCartController">My cart</a></li>

                    </ul>
                </div>

                <div class="col-md-3  custom_footer custom_footer4">
                    <h3>Contacts</h3>
                    <ul>

                        <li class="firstItem">0210 Ram Road,  Royal Crescent Tel 136-567-9842
                        </li>

                        <li class="lastItem">Email: <a href="https://mail.google.com/">shopGift@gmail.com</a></li>
                    </ul>
                </div>
            </div>


        </div>


    </body>

</html>
