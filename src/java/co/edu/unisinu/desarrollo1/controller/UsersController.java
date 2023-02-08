package co.edu.unisinu.desarrollo1.controller;

import co.edu.unisinu.desarrollo1.model.User;
import co.edu.unisinu.desarrollo1.model.modelDAO.UsersDAO;
import co.edu.unisinu.desarrollo1.utils.MessageTwilioAPIController;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
        try {
            MessageTwilioAPIController mtac = new MessageTwilioAPIController();
            String accion = request.getParameter("action");
            String phoneForMessage = "";
            if (accion.equalsIgnoreCase("registerUser")) {
                UsersDAO usersDAO = new UsersDAO();
                String nombres = request.getParameter("names");
                String apellidos = request.getParameter("surnames");
                String direccion = request.getParameter("adress");
                String correoE = request.getParameter("email");
                String phone = request.getParameter("phone");
                int rol = 2;
                phoneForMessage = phone;
                String contraseña = request.getParameter("password");
                HttpSession sesionApp = request.getSession(true);
                User userAtRegister = new User(nombres, apellidos, direccion, correoE, contraseña, phone, rol);
                if (usersDAO.signup(userAtRegister)) {
                    Date timestamp = new Date(1);
                    mtac.sendWhatsappMessage(phone, "Registrado correctamente (" + timestamp + ")...");
                    sesionApp.setAttribute("message", "Registrado correctamente...");
                } else {
                    sesionApp.setAttribute("message", "Error al registrarse...");
                }
            }

            if (accion.equalsIgnoreCase("loginUser")) {
                UsersDAO usersDAO = new UsersDAO();
                String correoE = request.getParameter("email");
                String contraseña = request.getParameter("password");
                User userAtRegister = usersDAO.signin(correoE, contraseña);
                HttpSession sesionApp = request.getSession(true);
                if (userAtRegister != null) {
                    Long datetime = System.currentTimeMillis();
                    Timestamp timestamp = new Timestamp(datetime);
                    sesionApp.setAttribute("userLogued", userAtRegister);
                    String message = "Logueado correctamente en la fecha " + timestamp.toString() + "...";
//                    mtac.sendWhatsappMessage(userAtRegister.getPhoneNumber(), message);
                    sesionApp.setAttribute("message", message);
                    response.sendRedirect("./SRCE ADMIN/home.jsp");
                } else {
                    sesionApp.setAttribute("message", "Error al loguearse, intentelo de nuevo...");
                    response.sendRedirect("./SRCE ADMIN/home.jsp");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
