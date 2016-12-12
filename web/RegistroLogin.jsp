<%-- 
    Document   : index
    Created on : 23-nov-2016, 20:12:00
    Author     : pauva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style_1.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
        <script type="text/javascript">
            function showonlyone(thechosenone) {
                $('.newboxes').each(function (index) {
                    if ($(this).attr("id") == thechosenone) {
                        $(this).show(200);
                    } else {
                        $(this).hide(600);
                    }
                });
            }
        </script>
    </head>
    <body>
        <%
        
        %>
        <div id="contenedor" >
         
            <ul>
                   <li>
                       <h1>Menu</h1>

            </li><li class='lis'>
                    
                <a href="javascript:showonlyone('magic1')">Registro</a>

            </li>

            <li class='lis'>  <a href="javascript:showonlyone('magic2')">login</a></li>
        </ul>
            <center>  <div class="menu newboxes" id="magic1" style="display: none">
                    <fieldset >      <legend>Registro</legend>
                        <form method="POST" action="${pageContext.request.contextPath}/SelventRegistroLogin" >   
                            <input type="text" name="usuario" value="" /><BR>
                            <input type="password" name="pass" value="" /><BR>
                            <input type="submit" value="enviar"/>
                        </form >
                    </fieldset>
                </div>
                <div class="menu newboxes" id="magic2" style="display: none"> <fieldset >      <legend> Login</legend>

                        <form method="get" name="formlogin" action="${pageContext.request.contextPath}/SelventRegistroLogin"   >    
                            <input type="text" name="usuario" /><BR>
                            <input type="password" name="pass"  /><BR>
                            <input type="submit" value="enviar" onclick="putCookie()"/>

                        </form >
                    </fieldset>
                </div>
            </center> 
        </div>
    </body>
</html>