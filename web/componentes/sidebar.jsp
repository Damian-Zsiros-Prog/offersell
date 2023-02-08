<%-- 
    Document   : sidebar
    Created on : 29/09/2022, 05:21:53 PM
    Author     : DESARROLLO 1
--%>

<%@page import="co.edu.unisinu.desarrollo1.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessionActive = request.getSession();
%>

<%
    User user = (User) sessionActive.getAttribute("userLogued");
    if (user != null) {

        String email = user != null ? user.getEmail() : "";
%>
<!-- SideBar -->
<section class="full-box cover dashboard-sideBar">
    <div class="full-box dashboard-sideBar-bg btn-menu-dashboard"></div>
    <div class="full-box dashboard-sideBar-ct">
        <!--SideBar Title -->
        <div class="full-box text-uppercase text-center text-titles dashboard-sideBar-title">
            Offersell <i class="zmdi zmdi-close btn-menu-dashboard visible-xs"></i>
        </div>
        <!-- SideBar User info -->
        <div class="full-box dashboard-sideBar-UserInfo">
            <figure class="full-box">
                <img src="https://agenciavirtual.cnfl.go.cr/cnfl/AgenciaVirtual/img/user.png" alt="UserIcon">
                <figcaption class="text-center text-titles"><%= email%></figcaption>
            </figure>
            <ul class="full-box list-unstyled text-center">
                <li>
                    <a href="#!">
                        <i class="zmdi zmdi-settings"></i>
                    </a>
                </li>
                <li>
                    <a href="../CloseSessionController" class="btn-exit-system">
                        <i class="zmdi zmdi-power"></i>
                    </a>
                </li>
            </ul>
        </div>
        <!-- SideBar Menu -->
        <ul class="list-unstyled full-box dashboard-sideBar-Menu">
            <li>
                <a href="home.jsp">
                    <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Dashboard
                </a>
            </li>
            <li>
                <a href="#!" class="btn-sideBar-SubMenu">
                    <i class="zmdi zmdi-case zmdi-hc-fw"></i> Administracion <i class="zmdi zmdi-caret-down pull-right"></i>
                </a>
                <ul class="list-unstyled full-box">
                    <li>
                        <a href="offers.jsp"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Ofertas</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="../index.jsp" class="btn-sideBar-SubMenu">
                    <i class="zmdi zmdi-case zmdi-hc-fw"></i> Volver a la web principal <i class="zmdi zmdi-caret-down pull-right"></i>
                </a>
            </li>
            <!--
            <%
                if (user != null && user.getRol() == 1) {
            %>
            <li>
                <a href="#!" class="btn-sideBar-SubMenu">
                    <i class="zmdi zmdi-account-add zmdi-hc-fw"></i> Usuarios <i class="zmdi zmdi-caret-down pull-right"></i>
                </a>
                <ul class="list-unstyled full-box">
                    <li>
                        <a href="admin.jsp"><i class="zmdi zmdi-account zmdi-hc-fw"></i> Administradores</a>
                    </li>
                </ul>
            </li>
            <%
                    }
                } else {
                    response.sendRedirect("../login.jsp");
                }

            %>!-->
        </ul>
    </div>
</section>
