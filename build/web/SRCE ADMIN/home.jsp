<%@page import="co.edu.unisinu.desarrollo1.model.User"%>
<%
    HttpSession sessionActive = request.getSession();
%>

<%
    if (sessionActive.getAttribute("userLogued") != null) {
        User user = (User) sessionActive.getAttribute("userLogued");
        String email = user != null ? user.getEmail() : "";
        String rol = user != null && user.getRol() == 1 ? "Administrador" : "Usuario";
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Dashboard - <%=rol%> - <%= email%></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body>
        <!-- SideBar -->

        <jsp:include page="../componentes/sidebar.jsp"></jsp:include>
            <!-- Content page-->
            <section class="full-box dashboard-contentPage">

                <!-- Content page -->
                <div class="container-fluid">
                    <div class="page-header">
                        <h1 class="text-titles">Dashboard <small>(<%=rol%>)</small></h1>
                </div>
            </div>
            <div class="full-box text-center" style="padding: 30px 10px;">
                <%
                    if (sessionActive.getAttribute("message").toString().length() > 0) {
                %> <script>alert(sessionActive.getAttribute("message"))</script><%
                        sessionActive.setAttribute("message", "");
                    }
                %>

                <%
                    if (rol == "Administrador") {
                %>
                <article class="full-box tile">
                    <div class="full-box tile-title text-center text-titles text-uppercase">
                        Solicitudes de Ofertas
                    </div>
                    <div class="full-box tile-icon text-center">
                        <i class="zmdi zmdi-account"></i>
                    </div>
                    <div class="full-box tile-number text-titles">
                        <p class="full-box">7</p>
                        <small>Solicitudes</small>
                    </div>
                </article>
                <article class="full-box tile">
                    <div class="full-box tile-title text-center text-titles text-uppercase">
                        Ofertas del dia
                    </div>
                    <div class="full-box tile-icon text-center">
                        <i class="zmdi zmdi-account"></i>
                    </div>
                    <div class="full-box tile-number text-titles">
                        <p class="full-box">10</p>
                        <small>Ofertas</small>
                    </div>
                </article>
                <%
                    }
                %>
                <article class="full-box tile">
                    <div class="full-box tile-title text-center text-titles text-uppercase">
                        Ofertas creadas por mi
                    </div>
                    <div class="full-box tile-icon text-center">
                        <i class="zmdi zmdi-male-alt"></i>
                    </div>
                    <div class="full-box tile-number text-titles">
                        <p class="full-box">10</p>
                        <small>Ofertas</small>
                    </div>
                </article>

            </div>
        <!--====== Scripts -->
        <script src="./js/jquery-3.1.1.min.js"></script>
        <script src="./js/sweetalert2.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
        <script src="./js/material.min.js"></script>
        <script src="./js/ripples.min.js"></script>
        <script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="./js/main.js"></script>
        <script>
                    $.material.init();
        </script>
        <%
            } else {

                sessionActive.setAttribute("message", "Sesion terminada por tiempo o no existente...");
                response.sendRedirect("../login.jsp");
            }
        %>
    </body>
</html>