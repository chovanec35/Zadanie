<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <h1>Registration form</h1>
        <a href="/Projekt/home">Home</a>
        <a href="/Projekt/login">Login</a>
        
        <form action="" method="post">
            First name <input type="text" name="first-name" value=""/><br/>
            Last name <input type="text" name="last-name" value=""/><br/>
            E-mail <input type="email" name="email" value=""/><br/>
            Birthdate <input type="date" name="birthdate" value=""/><br/>
            Password <input type="password" name="password" value=""/><br/>
            Confirm Password <input type="password" name="conf-password" value=""/><br/>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
