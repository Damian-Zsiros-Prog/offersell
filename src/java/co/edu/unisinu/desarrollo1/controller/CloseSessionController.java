package co.edu.unisinu.desarrollo1.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CloseSessionController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CloseSessionController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CloseSessionController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            HttpSession session = request.getSession();
            session.setAttribute("userLogued", null);
            session.setAttribute("message", "Sesion cerrada correctamente...");
            RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
            vista.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
