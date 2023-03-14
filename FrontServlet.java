package etu2090_framework_servlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.HashMap;

public class FrontServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Récupération de l'URL-mapping
        String urlMapping = request.getServletPath();
        String req=request.getQueryString();

        // Récupération des paramètres de l'URL
        String fgh = request.getRequestURL().toString();
        fgh=fgh+"?"+req;
        String va1= request.getQueryString();
        
        // Génération de la réponse 
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Réponse à la requête</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Informations recues :</h1>");
            out.println("<p>URL-mapping : " + urlMapping + "</p>");
            out.println("<p>Recuperation du parametre  : " + fgh + "</p>");
            out.println("</body>");
            out.println("</html>");
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

}
