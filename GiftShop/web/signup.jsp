

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="login&signup.css" />
    </head>
    <body>
        <div class="login_signup">
            <div class="form">
                <form class="signup_form" action="signup" method="post">
                    <div class="alert_danger" role="alert">
                        ${alertMess}
                    </div>
                    <input type="text" placeholder="name" name="username"/>
                    <input type="password" placeholder="password" name="password"/>
                    <input type="password" placeholder="reenter password" name="repassword"/>
                    <button>create</button>
                    <p class="message">Already registered? <a href="login.jsp">Sign In</a></p>
                </form>

            </div>
        </div>
    </body>
</html>
