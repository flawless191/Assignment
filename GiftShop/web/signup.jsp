

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
                <form class="signup_form" action="signup1" method="post">
                    <div class="alert_danger" role="alert">
                        ${alertMess}
                    </div>
                    <input type="text" placeholder="Username" name="username"  pattern="^[a-zA-Z][a-zA-Z0-9]{2,15}" title="User name must be start with letter and contains only letter and number. And must have at least 3 characters and max 16 characters." required/>
                    <input type="password" placeholder="Password" name="password"  pattern=".{3,16}" title="Password must have at least 3 characters and max 16 characters."  required/>
                    <input type="password" placeholder="Confirm password" name="repassword"  pattern=".{3,16}" title="Password must have at least 3 characters and max 16 characters."  required/>
                    <button>create</button>
                    <p class="message">Already registered? <a href="login.jsp">Sign In</a></p>
                </form>

            </div>
        </div>
    </body>
</html>
