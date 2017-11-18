<%-- 
    Document   : login
    Created on : Nov 18, 2017, 9:12:24 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="UsersServlet" method="post">
            <input type="text" name="username"/>
            <input type="password" name="password"/>
             <input type="hidden" name="command" value="login"/>
            <input type="submit" name="submit" value="OK"/>
        </form>
    </body>
</html>
