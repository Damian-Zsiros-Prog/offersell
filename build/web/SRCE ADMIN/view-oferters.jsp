<%@page import="co.edu.unisinu.desarrollo1.model.OfferArticle"%>
<%@page import="co.edu.unisinu.desarrollo1.model.modelDAO.OfferArticleDAO"%>
<%@page import="co.edu.unisinu.desarrollo1.model.modelDAO.UsersDAO"%>
<%@page import="co.edu.unisinu.desarrollo1.model.Offer"%>
<%@page import="co.edu.unisinu.desarrollo1.model.modelDAO.OffersDAO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.unisinu.desarrollo1.model.CategoryArticle"%>
<%@page import="co.edu.unisinu.desarrollo1.model.modelDAO.CategoriesArticlesDAO"%>
<%@page import="co.edu.unisinu.desarrollo1.model.User"%>
<%
    HttpSession sessionActive = request.getSession();
%>

<%
    if (sessionActive.getAttribute("userLogued") != null) {
        User user = (User) sessionActive.getAttribute("userLogued");
        if (Integer.parseInt(request.getParameter("idOffer")) <= 0) {
            response.sendRedirect("./SRCE ADMIN/offers.jsp");
        }
%> 
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Lista de ofertantes - Offersell</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body>

        <jsp:include page="../componentes/sidebar.jsp"></jsp:include>

        <%
            if (request.getSession().getAttribute("message") != null
                    && request.getSession().getAttribute("message").toString().length() > 0) {
        %>
        <script>alert('<%= request.getSession().getAttribute("message")%>')</script>
        <%
                request.getSession().setAttribute("message", "");
            }
        %>
        <!-- Content page-->
        <section class="full-box dashboard-contentPage">

            <!-- Content page -->
            <div class="container-fluid">
                <div class="page-header">
                    <h1 class="text-titles"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Adminisrracion <small>Lista de ofertantes</small></h1>
                </div>
                <p class="lead">En este apartado podra administrar las ofertas a las que tiene acceso.</p>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                            <li><a href="#list" data-toggle="tab">Listar ofertantes</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">

                            <div class="tab-pane fade active in" id="list">
                                <div class="table-responsive">
                                    <table class="table table-hover text-center">
                                        <thead>
                                            <tr>
                                                <th class="text-center">#</th>
                                                <th class="text-center">Ofertante</th>
                                                <th class="text-center">Precio</th>
                                                <th class="text-center">Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%                                        
                                                OfferArticleDAO offersDAO = new OfferArticleDAO();
                                                CategoriesArticlesDAO categoryDAO = new CategoriesArticlesDAO();
                                                List<OfferArticle> offers = offersDAO.listOferters(Integer.parseInt(request.getParameter("idOffer")));
                                                for (OfferArticle offer : offers) {
                                                    User userSeller = new UsersDAO().searchOne(offer.getIdUser());
                                                    Offer offerListed = new OffersDAO().searchOne(offer.getIdOffer());
                                            %>
                                        <td><%= offer.getIdOfferUser()%></td>
                                        <td><%= userSeller.getNames()%></td>
                                        <td><%= offer.getPriceOffer()%></td>
                                        <td>
                                            <a href="../OffersController?action=sellOfferAtUser&idOffer=<%= offer.getIdOffer()%>&idUser=<%= userSeller.getIdUser()%>">Acepar oferta y vender</a>
                                        </td>
                                        </li>
                                        <%
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                    <!--
                                        <ul class="pagination pagination-sm">
                                            <li class="disabled"><a href="#!">«</a></li>
                                            <li class="active"><a href="#!">1</a></li>
                                            <li><a href="#!">2</a></li>
                                            <li><a href="#!">3</a></li>
                                            <li><a href="#!">4</a></li>
                                            <li><a href="#!">5</a></li>
                                            <li><a href="#!">»</a></li>
                                        </ul>
                                    -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

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