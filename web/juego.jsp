<%-- 
    Document   : index
    Created on : 14-nov-2016, 19:00:53
    Author     : pauva
--%>

<%@page import="java.util.Date"%>
<%@page import="java.security.Timestamp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
        <title>Lunar Landing in HTML5</title>
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/lunar.js"></script>
    </head>

    <body>
     <%Cookie c[] = request.getCookies();%>
        
        <div id="state">
   
            <div class="container">


                <h1></h1>
                <h2 id="puntos" ></h2>
                     
                <form method="POST" action="${pageContext.request.contextPath}/ServletResultado"> 
                    <button  onclick="guardarpartida()"  >Play again</button>
                    <input id="velocidad" name="velocidad" value=   '' class="invi">
                    <input id="nombre" name="nombre" value= '<%out.print(c[1].getValue());%>' class="invi">
                </form>  <button  onclick="redirect()"> volver</button>

            </div>
        </div>
        <div id="game">
            <label id="nombreDeUsuario">
                <%
                    out.print(c[1].getValue());
                    
                %>
            </label>
            <div id="gauge"><div></div></div>
            <div id="ship"></div>
            <div id="explode"></div>
            <div id="moon">
                <div id="landing-pad"><div id="ms">-</div></div>
            </div>
        </div>

        <script>
            function guardarpartida() {
                var bruh = document.getElementById("puntos").innerText;
                ;
                document.getElementById("velocidad").value = bruh;

            }
function redirect(){
            window.location="Menujuego.jsp";
        }

            
        </script>
    </body>
</html>