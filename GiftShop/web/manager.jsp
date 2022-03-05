<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/stylepage.css" />
        <link rel="stylesheet" href="css/dropdownstyle.css" />

        <link rel="stylesheet" href="css/managerStyle.css" />
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12 col-lg-3 logo_wrap">
                    <a id="logo" href="home.jsp">

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


                        <li class="active firstItem">
                            <a  href="#">Home</a>

                        </li>

                        <li class="">
                            <a  href="shopController">Shop</a>
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
            <div class="manager_bannerSet">
                <div class="manager_left">
                    <b>Manager System</b> 
                    <a href="#">AddProduct</a>
                </div>

            </div>
            <div class="managet_product">
                <table class="table bordered 3px ">
                    <thead >
                        <tr>
                            <td><b>ID</b></td>
                            <td><b>Name</b></td>
                            <td><b>IMG</b></td>
                            <td><b>Price</b></td>
                            <td><b>Action</b></td>

                        </tr>
                    </thead>
                    <c:forEach items="${listP}" var="p">
                        <tr>
                            <td>${p.pid}</td>
                            <td>${p.productName}</td>
                            <td> <img style="width:180px;"
                                      src="${p.productImg}"
                                      class="img-responsive" /></td>
                            <td>${p.productPrice}$</td>
                            <td><a href="updateController?id=${p.pid}" id="bt_update">
                                    <img style="width:30px;"
                                         src="images/editIcon.png"
                                         class="img-responsive" />
                                </a>
                                <a href="#" id="bt_delete" onclick="confirmDelete(${p.pid})">
                                    <img style="width:30px;"
                                         src="images/deleteIcon.png" /></a>
                            </td>

                        </tr>
                    </c:forEach>

                </table>
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
    <script>
    function confirmDelete(id) {
        if (confirm('Are you want to delete product have Id: ' + id+'?')) {
            window.location.href='deleteProductController?pid='+id;
            window.alert('Delete successfully!');
            
        }
    }
    
</script>
</html>
