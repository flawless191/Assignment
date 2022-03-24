
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

                <form action="updateOrder" method="post" >
                    <div style="color: #db1d24; text-align: center; margin-bottom: 10px;">ORDER INFORMATION</div>
                    <label>OrderID</label>
                    <input type="text" value="${order.orderid}" name="oid"  readonly />
                    <label >CustomerID</label>

                    <input type="number" value="${order.custid}" name="custId" required/>
                    <label>AccountID</label>
                    <input type="number"  value="${order.accountorderid}" title="AccountID can be empty." name="accountId"    />  
                    <label>OrderDate</label>

                    <input type="text" placeholder="OrderDate" value="${order.orderDate}"  name="orderDate" onfocus="(this.type = 'date')" required>
                    <div class="alert_danger" role="alert" style="text-align: center">
                        ${alertMess}
                    </div>
                    <button>Update</button>

                </form>
            </div>
        </div>

    </body>
</html>
