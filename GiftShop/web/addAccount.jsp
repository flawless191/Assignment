

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
                <form  action="addAccount" method="post">
                    <div style="color: #db1d24; text-align: center; margin-bottom: 10px;">ACCOUNT INFORMATION</div>

                    <input type="text" placeholder="Username" name="username"  pattern="^[a-zA-Z][a-zA-Z0-9]{2,15}" title="User name must be start with letter and contains only letter and number. And must have at least 3 characters and max 16 characters." required/>
                    <input type="password" placeholder="Password" name="password"  pattern=".{3,16}" title="Password must have at least 3 characters and max 16 characters."  required/>
                    <label>Admin: </label><select name="isAdmin"  style="margin-bottom: 10px;">
                        <option value="true">IsAdmin</option>
                        <option value="false"selected>NotAdmin</option>

                    </select>
                    <div class="alert_danger" role="alert" style="text-align: center">
                        ${alertMess}
                    </div>
                    <button>Add</button>
                </form>

            </div>
        </div>
    </body>
</html>
