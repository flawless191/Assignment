
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
        <link rel="stylesheet" href="css/formStyle.css" />

    </head>
    <body>
        <div class="form_page">
            <div class="form">

                <form action="updateDetails" method="post" >
                    <div style="color: #db1d24; text-align: center; margin-bottom: 10px;">CART DETAILS INFORMATION</div>
                    <label>OrderID</label>
                    <input type="text" value="${cart.cartid}" name="oid"  readonly />
                     <input type="number" placeholder="OldProductID" value="${oldPid}" name="oldPid" min="1" hidden/>
                    <label>ProductID</label>
                    <input type="number" placeholder="ProductID" value="${cart.product.pid}" name="pid" min="1" required/>
                    <label>Amount</label>

                    <input type="number" placeholder="Amount"  value="${cart.amount}" name="amount" min="1" required/>
                    <div class="alert_danger" role="alert" style="text-align: center">
                        ${alertMess}
                    </div>

                    <button>Update</button>

                </form>
            </div>
        </div>

    </body>
</html>
