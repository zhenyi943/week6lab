<%-- 
    Document   : register
    Created on : Oct 11, 2019, 11:19:13 AM
    Author     : 797494
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="shoppingList" method="post">
            
            User  name: <input type="text" name="username">
            <input type="submit" value="register" name="action"><br>
        ${message}
        </form>
        
    </body>
</html>
