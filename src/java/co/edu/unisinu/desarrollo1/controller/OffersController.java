package co.edu.unisinu.desarrollo1.controller;

import co.edu.unisinu.desarrollo1.model.Offer;
import co.edu.unisinu.desarrollo1.model.OfferArticle;
import co.edu.unisinu.desarrollo1.model.User;
import co.edu.unisinu.desarrollo1.model.modelDAO.OfferArticleDAO;
import co.edu.unisinu.desarrollo1.model.modelDAO.OffersDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OffersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("action");
        if (accion.equalsIgnoreCase("deleteOffer")) {
            OffersDAO offersDAO = new OffersDAO();
            int idOffer = Integer.parseInt(request.getParameter("idOffer"));
            HttpSession sesionApp = request.getSession();
            if (offersDAO.delete(idOffer)) {
                sesionApp.setAttribute("message", "Oferta eliminada correctamente...");
                response.sendRedirect("./SRCE ADMIN/offers.jsp");
            } else {
                sesionApp.setAttribute("message", "Error al eliminar la oferta...");
                response.sendRedirect("./SRCE ADMIN/offers.jsp#new");
            }
        }
        if (accion.equalsIgnoreCase("acceptOffer")) {
            OffersDAO offersDAO = new OffersDAO();
            int idOffer = Integer.parseInt(request.getParameter("idOffer"));
            HttpSession sesionApp = request.getSession();
            if (offersDAO.acceptOffer(idOffer)) {
                sesionApp.setAttribute("message", "Oferta aceptada correctamente...");
                response.sendRedirect("./SRCE ADMIN/offers.jsp");
            } else {
                sesionApp.setAttribute("message", "Error al aceptar la oferta...");
                response.sendRedirect("./SRCE ADMIN/offers.jsp");
            }
        }
        if (accion.equalsIgnoreCase("declineOffer")) {
            OffersDAO offersDAO = new OffersDAO();
            int idOffer = Integer.parseInt(request.getParameter("idOffer"));
            HttpSession sesionApp = request.getSession();
            if (offersDAO.declineOffer(idOffer)) {
                sesionApp.setAttribute("message", "Oferta rechazada correctamente...");
                response.sendRedirect("./SRCE ADMIN/offers.jsp");
            } else {
                sesionApp.setAttribute("message", "Error al rechazar la oferta...");
                response.sendRedirect("./SRCE ADMIN/offers.jsp");
            }
        }
        if (accion.equalsIgnoreCase("sellOfferAtUser")) {
            OfferArticleDAO offersArticleDAO = new OfferArticleDAO();
            int idOffer = Integer.parseInt(request.getParameter("idOffer"));
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            HttpSession sesionApp = request.getSession();
            if (offersArticleDAO.sellOfferAtUser(new OfferArticle(idUser, idOffer))) {
                sesionApp.setAttribute("message", "Oferta vendida correctamente...");
                response.sendRedirect("./SRCE ADMIN/offers.jsp");
            } else {
                sesionApp.setAttribute("message", "Error al vender la oferta al usuario...");
                response.sendRedirect("./SRCE ADMIN/view-oferters.jsp?idOffer=" + idOffer);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String accion = request.getParameter("action");
            if (accion.equalsIgnoreCase("createOffer")) {
                OffersDAO offersDAO = new OffersDAO();
                String image_path = request.getParameter("image_path");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                float price_start = Float.parseFloat(request.getParameter("price_start"));
                String limit_date = request.getParameter("limit_date");
                int idCategory = Integer.parseInt(request.getParameter("id_category"));
                HttpSession sesionApp = request.getSession();
                User userSession = (User) sesionApp.getAttribute("userLogued");
                int idUserSeller = userSession.getIdUser();
                String state = "2";
                Offer offerNew = new Offer(name, description, image_path, state, price_start, limit_date, idUserSeller, idCategory, idCategory);
                if (offersDAO.createNewOffer(offerNew)) {
                    sesionApp.setAttribute("message", "Oferta creada correctamente...");
                    response.sendRedirect("./SRCE ADMIN/offers.jsp");
                } else {
                    sesionApp.setAttribute("message", "Error al crear la nueva oferta...");
                    response.sendRedirect("./SRCE ADMIN/offers.jsp#new");
                }
            }
            if (accion.equalsIgnoreCase("editOffer")) {
                OffersDAO offersDAO = new OffersDAO();
                int idOffer = Integer.parseInt(request.getParameter("idOffer"));
                String image_path = request.getParameter("image_path");
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                float price_start = Float.parseFloat(request.getParameter("price_start"));
                String limit_date = request.getParameter("limit_date");
                int idCategory = Integer.parseInt(request.getParameter("id_category"));
                HttpSession sesionApp = request.getSession();
                User userSession = (User) sesionApp.getAttribute("userLogued");
                int idUserSeller = userSession.getIdUser();
                String state = "2";
                Offer offerNew = new Offer(name, description, image_path, state, price_start, limit_date, idUserSeller, idCategory, idCategory);
                if (offersDAO.update(idOffer, offerNew)) {
                    sesionApp.setAttribute("message", "Oferta editada correctamente...");
                    response.sendRedirect("./SRCE ADMIN/offers.jsp");
                } else {
                    sesionApp.setAttribute("message", "Error al editar la nueva oferta...");
                    response.sendRedirect("./SRCE ADMIN/offers.jsp#edit");
                }
            }
            if (accion.equalsIgnoreCase("addOfferUser")) {
                HttpSession sesionApp = request.getSession();
                if (sesionApp.getAttribute("userLogued") != null) {
                    User user = (User) sesionApp.getAttribute("userLogued");
                    float priceOffer = Float.parseFloat(request.getParameter("price_offer"));
                    int idOffer = Integer.parseInt(request.getParameter("idOffer"));
                    if (idOffer != user.getIdUser()) {
                        OfferArticleDAO offerArticleDAO = new OfferArticleDAO();
                        OfferArticle offerArticle = new OfferArticle(user.getIdUser(), priceOffer, idOffer);
                        if (offerArticleDAO.addOfferOfUser(offerArticle)) {
                            sesionApp.setAttribute("message", "Oferta enviada al vendedor correctamente...");
                            response.sendRedirect("./index.jsp");
                        } else {
                            sesionApp.setAttribute("message", "Error al enviar la oferta al vendedor correctamente...");
                            response.sendRedirect("./index.jsp");
                        }
                    } else {
                        sesionApp.setAttribute("message", "Usted no puede ofertar su propio producto...");
                        response.sendRedirect("./index.jsp");
                    }
                } else {
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
