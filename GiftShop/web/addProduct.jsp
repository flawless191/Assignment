

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link rel="stylesheet" href="css/formStyle.css" />

    </head>
    <body>
        <div class="form_page">
            <div class="form">

                <form class="login-form" action="addProductController" method="post">
                    <div style="color: #db1d24; text-align: center; margin-bottom: 10px;">PRODUCT INFORMATION</div>
                    <input type="text" placeholder="Enter product name"  name="productName" required/>

                    <input type="text" placeholder="Enter product image link" name="productImg" required/>

                    <input type="text" placeholder="Enter product price" name="productPrice" required/>

                    <input type="text" placeholder="Note" name="productNote" required/>
                    <label>Category: </label>

                    <select name="productCategory" id="sl_category" style="margin-bottom: 10px;">
                        <c:forEach items="${listC}" var="c"> 
                            <option value="${c.cid}">${c.categoryName}</option>

                        </c:forEach>

                    </select>
                    <button>Add</button>

                </form>
            </div>
        </div>
    </body>
</html>
