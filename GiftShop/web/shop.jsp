<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gift Shop</title>
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

                            <form action="/search" method="get" >
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

                        <a href="login.jsp" id="customer_login_link">Log in</a>


                        <a href="signup.jsp" id="customer_register_link">Create an account</a>

                        <a href="#" id="customer_manager_link">Manager</a>

                        <!-- HEADER CART -->


                        <a class="header_cart" href="#" id="customer_cart_link"><b>Cart</b><span
                                class="cart-items"></span></a>

                    </div>
                </div>

            </div>
            <div class="row-Menu">
                <div class="clearfix" id="navigation">
                    <ul class="sf-menu">

                        <li class="first ${cid==null?"active":""} firstItem">
                            <a  href="/">Shop</a>

                        </li>


                        <li class="has-dropdown">
                            <a title="" class="${cid!=null?"active":""}" href="#">Catalog</a>


                            <ul class="sub-menu" style="width: 235px; ">
                                <c:forEach items="${listC}" var="c" >
                                    <li style="width: 100%; float: none; "><a class="${cid==c.cid?"active":""}"
                                            style="width: auto; float: none;" href="categoryController?cid=${c.cid}">${c.categoryName}</a>
                                    </li>
                                </c:forEach>


                            </ul>

                        </li>



                        <li>
                            <a  href="#">About Us</a>

                        </li>


                        <li class="last lastItem">
                            <a  href="#">Contact us</a>

                        </li>

                    </ul>
                </div>
            </div>

        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h2 class="title">THE PRODUCT IN STORE</h2>
                    <p class="combo-header-des">
                        Quality belong with time!
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">

                    <img style="width:100%;" class="img-responsive"
                         src="images/evenBanner.png" />
                </div>
            </div>


            <div class="row">
                <c:forEach items= "${listP}" var="p">
                    <div class="col-md-3">
                        <div>
                            <img src="${p.productImg}" class="img-responsive" />
                            <div class="item">
                                <p class="item-title">${p.productName}</p>
                                <p class="item-description">
                                    Discount: <span style="font-weight: bold; margin-left: 10px">10%</span>
                                </p>
                                <p>
                                    Price: 
                                    <span style="color: #f72b2f; margin-left: 10px; font-size: 20px">${p.productPrice} $ </span>
                                    <a href="#" id="add_cart">Add to cart </a>
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

                        <li class="firstItem"><a title="" href="/test1.html">Home</a></li>

                        <li><a title="" href="/collections/all">Shop</a></li>

                        <li><a title="" href="/blogs/blog">Blog</a></li>

                        <li><a title="" href="/pages/about-us">About Us</a></li>



                        <li class="lastItem"><a title="" href="/pages/contact-us">Contact us</a></li>

                    </ul>
                </div>
                <div class="col-md-3  custom_footer custom_footer2">
                    <h3>Collections</h3>
                    <ul class="list">

                        <li class=" firstItem"><a title="" href="/collections/brands">Fashion</a>
                        </li>

                        <li><a title="" href="/collections/kids">Equiment</a></li>

                        <li><a title="" href="/collections/women-s">Accessories</a></li>

                        <li><a title="" href="/collections/footwear">Other</a></li>



                    </ul>
                </div>



                <div class="col-md-3  custom_footer custom_footer3">
                    <h3>Information</h3>
                    <ul class="list">

                        <li class="firstItem"><a title="" href="/account">My account</a></li>

                        <li><a title="" href="/account/addresses">My addresses</a></li>

                        <li class="lastItem"><a title="" href="/cart">My cart</a></li>

                    </ul>
                </div>

                <div class="col-md-3  custom_footer custom_footer4">
                    <h3>Contacts</h3>
                    <ul>

                        <li class="firstItem">4578 Marmora Road, Glasgow D04 89GR Tel 1(234) 567-9842
                        </li>

                        <li class="lastItem">Email: <a href="mailto:info@demolink.org">shopGift@gmail.com</a></li>
                    </ul>
                </div>
            </div>


        </div>
    </body>
</html>