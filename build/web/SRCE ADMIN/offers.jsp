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
    if (sessionActive.getAttribute("userLogued") != null) {
        User user = (User) sessionActive.getAttribute("userLogued");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Ofertas - Offersell</title>
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
                    <h1 class="text-titles"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Administracion <small>Ofertas</small></h1>
                </div>
                <p class="lead">En este apartado podra administrar las ofertas a las que tiene acceso.</p>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="nav nav-tabs" style="margin-bottom: 15px;">
                            <li ><a href="#new" data-toggle="tab">Nuevo</a></li>
                            <li><a href="#list" data-toggle="tab">Listar</a></li>
                            <li><a href="#listOfferOfMe" data-toggle="tab">Listar Ofertas hechas por mi</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">

                            <div class="tab-pane fade" id="new">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xs-12 col-md-10 col-md-offset-1">
                                            <form action="../OffersController?action=createOffer" method="POST">
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Url de la imagen</label>
                                                    <input class="form-control" name="image_path" type="url" required>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Nombre</label>
                                                    <input class="form-control" name="name" type="text" required>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Descripcion</label>
                                                    <textarea class="form-control" name="description" id="descripcion" name="description" rows="10" maxlength="255" required></textarea>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Precio</label>
                                                    <input class="form-control" name="price_start" type="number" step="0.001" required>
                                                </div>
                                                <div class="form-group ">
                                                    <label class="control-label">Fecha limite</label>
                                                    <input type="date" class="form-control" name="limit_date" required />
                                                </div>
                                                <select name="id_category" class="form-control" required>
                                                    <%
                                                        CategoriesArticlesDAO categoryArticle = new CategoriesArticlesDAO();
                                                        List<CategoryArticle> categoriesList = categoryArticle.listCategories();
                                                        for (CategoryArticle category : categoriesList) {
                                                    %>
                                                    <option value="<%= category.getIdCategory()%>">
                                                        <%= category.getName()%>
                                                    </option>                         
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                                <p class="text-center">
                                                    <button type="submit" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Enviar oferta a revision</button>
                                                </p>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="edit">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xs-12 col-md-10 col-md-offset-1">
                                            <form action="../OffersController?action=editOffer" method="POST">
                                                <div class="form-group label-floating">
                                                    <label class="control-label"># de oferta</label>
                                                    <input class="form-control" name="idOffer" type="number" min="1" required>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Url de la imagen</label>
                                                    <input class="form-control" name="image_path" type="url" required>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Nombre</label>
                                                    <input class="form-control" name="name" type="text" required>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Descripcion</label>
                                                    <textarea class="form-control" name="description" id="descripcion" name="description" rows="10" maxlength="255" required></textarea>
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Precio</label>
                                                    <input class="form-control" name="price_start" type="number" step="0.001" required>
                                                </div>
                                                <div class="form-group ">
                                                    <label class="control-label">Fecha limite</label>
                                                    <input type="date" class="form-control" name="limit_date" required />
                                                </div>
                                                <select name="id_category" class="form-control" required>
                                                    <%
                                                        categoryArticle = new CategoriesArticlesDAO();
                                                        categoriesList = categoryArticle.listCategories();
                                                        for (CategoryArticle category : categoriesList) {
                                                    %>
                                                    <option value="<%= category.getIdCategory()%>">
                                                        <%= category.getName()%>
                                                    </option>                         
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                                <p class="text-center">
                                                    <button type="submit" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Editar oferta</button>
                                                </p>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="listOfferOfMe">

                                <div class="table-responsive">
                                    <table class="table table-hover text-center">
                                        <thead>
                                            <tr>
                                                <th class="text-center">#</th>
                                                <th class="text-center">Ofertante</th>
                                                <th class="text-center">Precio oferta</th>
                                                <th class="text-center">Estado</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                OfferArticleDAO offersArticleDAO = new OfferArticleDAO();
                                                List<OfferArticle> offersArticle = offersArticleDAO.listOffersMakeMe(user.getIdUser());
                                                for (OfferArticle offer : offersArticle) {
                                                    User userSeller = new UsersDAO().searchOne(offer.getIdUser());
                                                    Offer offerListed = new OffersDAO().searchOne(offer.getIdOffer());
                                            %>
                                        <td><%= offer.getIdOfferUser()%></td>
                                        <td><%= userSeller.getNames()%></td>
                                        <td>COP <%= offer.getPriceOffer()%></td>
                                        <td>
                                            <%
                                                if (offerListed.getState().equals("3") && userSeller.getIdUser() == user.getIdUser()) {
                                            %>Vendido a usted<%
                                            } else if (offerListed.getState().equals("3")) {
                                            %>Vendido a otro usuario<%
                                            } else {
                                            %>En oferta<%
                                                }
                                            %>
                                        </td>
                                        </li>
                                        <%
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="tab-pane fade active in" id="list">
                                <div class="table-responsive">
                                    <table class="table table-hover text-center">
                                        <thead>
                                            <tr>
                                                <th class="text-center">#</th>
                                                <th class="text-center">Imagen</th>
                                                <th class="text-center">Nombre</th>
                                                <th class="text-center">Descripcion</th>
                                                <th class="text-center">Estado</th>
                                                <th class="text-center">Precio inicial</th>
                                                <th class="text-center">Fecha limite</th>
                                                <th class="text-center">Usuario vendedor</th>
                                                <th class="text-center">Categoria</th>
                                                <th class="text-center">Subcategoria</th>
                                                <th class="text-center">Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                OffersDAO offersDAO = new OffersDAO();
                                                CategoriesArticlesDAO categoryDAO = new CategoriesArticlesDAO();
                                                List<Offer> offers = offersDAO.list();
                                                if (user.getRol() != 1) {
                                                    offers = offersDAO.listOffersByUser(user.getIdUser());
                                                }
                                                for (Offer offer : offers) {
                                                    User userSeller = new UsersDAO().searchOne(offer.getIdUserSeller());
                                                    CategoryArticle categoryOffer = (CategoryArticle) categoryDAO.getCategorieOne(offer.getIdCategory());
                                            %>
                                        <li>
                                        <td><%= offer.getIdOffer()%></td>
                                        <td>
                                            <img src="<%= offer.getImagePath()%>" width="250px" alt="Imagen de la oferta"/>
                                        </td>
                                        <td><%= offer.getName()%></td>
                                        <td><%= offer.getDescription()%></td>
                                        <td><%= offer.getState()%></td>
                                        <td>COP <%= offer.getPriceStart()%></td>
                                        <td><%= offer.getLimitDate()%></td>
                                        <td><%= userSeller.getNames()%></td>
                                        <td><%= categoryOffer.getName()%></td>
                                        <td><%= categoryOffer.getName()%></td>
                                        <td>
                                            <%
                                                if (user.getRol() == 1) {
                                                    if (offer.getState().equals("1")) {
                                            %>

                                            <a href="../OffersController?action=declineOffer&idOffer=<%= offer.getIdOffer()%>">Rechazar solicitud de oferta</a></br>
                                            <%
                                            } else if (offer.getState().equals("2")) {
                                            %>
                                            <a href="../OffersController?action=acceptOffer&idOffer=<%= offer.getIdOffer()%>">Aceptar solicitud de oferta</a></br>

                                            <%
                                                    }
                                                }
                                                if (user.getIdUser() == userSeller.getIdUser()) {
                                                    if (!offer.getState().equals("3")) {
                                            %>
                                            <a href="./view-oferters.jsp?idOffer=<%= offer.getIdOffer()%>">Ver ofertantes</a>
                                            <%
                                                }
                                            %>
                                            <a href="../OffersController?action=deleteOffer&idOffer=<%= offer.getIdOffer()%>">Eliminar</a>
                                        </td>
                                        </li>
                                        <%
                                                }
                                            }
                                        %>
                                        </tbody>
                                    </table>
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