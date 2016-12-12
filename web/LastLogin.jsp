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
        <%    ArrayList<Datos> array = (ArrayList) request.getAttribute("array");%>


        <div id="state">
            <h1>Ultima conexión de los usuarios</h1>
            <h2>última partida guardada</h2>
            <div class="container">


                <div id ="divmodificador1">
                    <center>
                        <table>
                            <tr>
                                <td><strong>Usuarios</strong></td>
                                <td><strong>última conexion</strong></td>

                            </tr>
                            <%for (int i = 0; i < array.size(); i++) {

                            %>
                            <tr>
                                <td><%out.print(array.get(i).getUser());%></td>
                                <td><%out.print(array.get(i).getDate());%></td>

                            </tr>
                            <%}%>

                        </table>
                      
                    </center>
                                  <a href="Menujuego.jsp">volver</a>
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

        </script>
    </body>
</html>