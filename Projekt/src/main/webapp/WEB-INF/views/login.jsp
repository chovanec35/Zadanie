<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <a href="/Projekt/home">Home</a>
        <a href="/Projekt/login">Login</a>
        <form method="post">
            E-mail <input type="email" name="login-email" value=""/><br/>
            Password <input type="password" name="possword" value=""/><br/>
            <input type="submit" value="Login">
        </form>
        <a href="/Projekt/registration">Create an account</a>
    </body>
</html>
