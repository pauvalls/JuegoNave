<%-- 
  
    Document   : index
    Created on : 14-nov-2016, 19:00:53
    Author     : pauva
--%>


<%@page import="Servicios.Datos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.security.Timestamp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
        <title>Lunar Landing in HTML5</title>
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="js/lunar.js"></script>
    </head>

    <body onload="parar()">
        <%  String user = "USUARIO";
            String texto = (String) request.getAttribute("nombre");
 Cookie c[];
            c = request.getCookies();
           
            if (texto == null) {

                user = c[1].getValue();
            } else {
                user = texto;
            }


        %>



        <div id="state">
            <h1>Menu Principal</h1>
            <div class="container">


                <div id ="divmodificador1">
                    <center>
                        <h1>hola ! <%  out.print(user);%></h1>
                    </center>
                        <form method="GET" action="${pageContext.request.contextPath}/ServletResultado" >   
                            <button value="" >Jugar</button>

                            <input style="display: none" name="nombre" >
                        </form>
                        <form method="GET" action="${pageContext.request.contextPath}/TopYOnline">   
                            <button>Ranking</button>
                        </form>
                        <form method="POST" action="${pageContext.request.contextPath}/TopYOnline">   
                            <button>Ultima conexión </button>
                        </form>
                        <form method="GET" action="${pageContext.request.contextPath}/SelvnetViciados">   
                            <button>Viciados </button>
                        </form>
                        <button onclick="redirect()">Logout</button>


                </div>
            </div>
        </div>


        <div id="game">

            <div id="gauge"><div></div></div>
            <div id="ship"></div>
            <div id="explode"></div>
            <div id="moon">
                <div id="landing-pad"><div id="ms">-</div></div>
            </div>
        </div>

        <script>
            function parar() {
                pause = true;
                $('#state').show(0);
            }
            function redirect() {
                <%
                    for(int we=1; c.length < we ; we++){  
                        c[we].setValue("");
                        c[we].setMaxAge(0);
                    
                    }
                  
                %>
                window.location = "RegistroLogin.jsp";
            }
        </script>
    </body>
</html>
