

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/formStyle.css" />
    </head>
    <body>
        <div class="form_page">
            <div class="form">
                <form  action="addOrder" method="post">
                    <div style="color: #db1d24; text-align: center; margin-bottom: 10px;">ORDER INFORMATION</div>

                    <input type="number" placeholder="CustomerID" name="custId" min="1" required/>
                    <input type="number" placeholder="AccountID(Can be empty)" name="accountId" min="1"   />                  
                    <input type="text" placeholder="OrderDate"  name="orderDate" onfocus="(this.type='date')">
                    <div class="alert_danger" role="alert" style="text-align: center">
                        ${alertMess}
                    </div>
                    <button>Add</button>
                </form>

            </div>
        </div>
    </body>
</html>
