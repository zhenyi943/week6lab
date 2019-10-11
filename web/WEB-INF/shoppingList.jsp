<%-- 
    Document   : shoppingList
    Created on : Oct 11, 2019, 11:20:48 AM
    Author     : 797494
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>
        <h1>Shopping List</h1>

        <form action="" method="post">
            
            <p>Hello, ${user} <a href="shoppinglist?action=logout">Logout</a></p>
        </form>
        
        <h3>List</h3>
        <form action="" method="post">
            
            Add item: <input type="text" name="item">
            <input type="submit" name="action" value="add">
            <br>
        </form>
        
         <form action="" method="post">

             <c:forEach  items="${list}" var="item" varStatus="loop">                   
                <input type="radio" name="items" value="${loop.count}"> 
                ${item}<br>
            </c:forEach>
                
            <c:if test="${list!=null}">    
            <input type="submit" name="action" value="delete">
            </c:if>  
        </form>
</body>
</html>
