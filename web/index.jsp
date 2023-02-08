<%@page import="co.edu.unisinu.desarrollo1.model.Offer"%>
<%@page import="co.edu.unisinu.desarrollo1.model.modelDAO.OffersDAO"%>
<%@page import="co.edu.unisinu.desarrollo1.model.CategoryArticle"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.unisinu.desarrollo1.model.modelDAO.CategoriesArticlesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/index.css" />
        <title>Inicio - OfferSell</title>
    </head>
    <body> 
        <jsp:include page="componentes/headerComp.jsp"></jsp:include>

            <main>
            <%
                if (request.getSession().getAttribute("message") != null) {
            %>
            <script>alert('<%= request.getSession().getAttribute("message")%>')</script>
            <%
                    request.getSession().setAttribute("message", "");
                }
            %>
            <h1 class="title">Ofertas activas</h1>
            <%
                OffersDAO offersDAO = new OffersDAO();
                int categoryName = Integer.parseInt(request.getParameter("categoryId") == null ? "0" : request.getParameter("categoryId"));
                List<Offer> offersAccepted = offersDAO.listAcceptedOffers();
                if(categoryName > 0){
                    offersAccepted = offersDAO.listOffersByCategory(categoryName);
                }
                if (offersAccepted.size() > 0) {
            %>
            <section class="product-list">
                <%
                    for (Offer offerAccepted : offersAccepted) {
                %>

                <div class="product-item">
                    <a href="./view-product.jsp?idOffer=<%= offerAccepted.getIdOffer()%>" class="product-link">
                        <div class="product-img">
                            <img
                                src="<%= offerAccepted.getImagePath().length() > 0
                                        ? offerAccepted.getImagePath()
                                        : "https://i.pinimg.com/originals/f0/dd/ec/f0ddec76cda8ee2756e663924856f81e.png"%>"
                                title="Imagen de la oferta (<%= offerAccepted.getName()%>)"
                                />
                        </div>
                        <div class="product-info">
                            <h2 class="product-title"><%= offerAccepted.getName()%></h2>
                            <p class="product-price">$<%= offerAccepted.getPriceStart()%></p>
                        </div>
                    </a>
                </div>
            </section>

            <%
                }
            } else {
            %>
            <h1>No hay ofertas en este momento</h1>
            <%
                }

            %>

        </main>
    </body>
</html>
