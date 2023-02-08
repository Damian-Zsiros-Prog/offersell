<%@page import="co.edu.unisinu.desarrollo1.model.modelDAO.UsersDAO"%>
<%@page import="co.edu.unisinu.desarrollo1.model.User"%>
<%@page import="co.edu.unisinu.desarrollo1.model.Offer"%>
<%@page import="co.edu.unisinu.desarrollo1.model.modelDAO.OffersDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
    OffersDAO offersDAO = new OffersDAO();
    int idOffer = Integer.parseInt(request.getParameter("idOffer"));
    Offer offer = new Offer(0);
    if (idOffer > 0) {
        offer = offersDAO.searchOne(idOffer);
    } else {
        request.getSession().setAttribute("message", "La oferta no existe...");
        response.sendRedirect("./index.jsp");
    }
    User userInfo = new UsersDAO().searchOne(offer.getIdUserSeller());
    HttpSession sessionActive = request.getSession();

    User user = new User(0);
    if (sessionActive.getAttribute("userLogued") != null) {
        user = (User) sessionActive.getAttribute("userLogued");
    }

%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/view-product.css" />
        <title>Samsung Galaxy 10 - OfferSell</title>
    </head>
    <body>
        <jsp:include page="componentes/headerComp.jsp"></jsp:include>
            <main>
                <section class="product-data">
                    <div class="product-img">
                        <img
                            style="max-width: 350px;"
                            src="<%= offer.getImagePath()%>"
                        alt=""
                        />
                </div>
                <div class="product-info" style="max-width: 450px;">
                    <h1 class="product-title"><%= offer.getName()%></h1>

                    <p class="product-state">
                        Estado de subasta: <%= offer.getState().equals("2") ? "En subasta" : "Finalizada la subasta"%>
                    </p>

                    <p class="product-price">
                        <span>Precio:</span>
                        COP <%= offer.getPriceStart()%>
                    </p>
                    <form action="./OffersController?action=addOfferUser&idOffer=<%= offer.getIdOffer()%>" method="POST">

                        <div class="form-group label-floating">
                            <label class="control-label">Precio de la oferta</label>
                            <input class="form-control" name="price_offer" type="number" step="0.001" required/>
                         </div>
                        <button type="submit">Ofertar</button>
                    </form>
                    <section class="info-seller">
                        <h1>Informacion del vendedor</h1>
                        <h3>Nombre: <%= userInfo.getNames()%></h3>
                    </section>
                </div>
            </section>
        </main>
    </body>
</html>
