<%-- 
    Document   : index
    Created on : 23-nov-2016, 20:12:00
    Author     : pauva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload='redirect()'>
        <script>
        function redirect(){
            window.location="${pageContext.request.contextPath}/ServletCookies";
        }
        </script>
    </body>


</html>

