

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/login&signup.css" />
    </head>
    <body>
        <div class="login_signup">
            <div class="form">

                <form class="login-form" action="login" method="post">
                    <div class="alert_danger" role="alert">
                        ${alertMess}
                    </div>
                    <input type="text" placeholder="username" name="username"/>
                    <input type="password" placeholder="password" name="password"/>
                    <button>login</button>
                    <p class="message">Not registered? <a href="signup.jsp">Create an account</a></p>
                </form>
            </div>
        </div>
    </body>
</html>
