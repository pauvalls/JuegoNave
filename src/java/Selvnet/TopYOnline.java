/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selvnet;

import Servicios.Datos;
import Servicios.ServiceScore;
import Servicios.Serviceuser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pauva
 */
@WebServlet(name = "TopYOnline", urlPatterns = {"/TopYOnline"})
public class TopYOnline extends HttpServlet {
String usuario;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TopYOnline</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TopYOnline at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   processRequest(request, response);
     // top 10
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("JuegolanzaderaPauVallsMorenoPU");
        EntityManager em = emf.createEntityManager();
        ServiceScore svs = new ServiceScore(em);
        ArrayList <Datos> array= svs.getranking();
        
      request.setAttribute("array", (ArrayList) array);
      RequestDispatcher a = request.getRequestDispatcher("TOP10.jsp");
                    a.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("JuegolanzaderaPauVallsMorenoPU");
        EntityManager em = emf.createEntityManager();
        ServiceScore svs = new ServiceScore(em);
        ArrayList <Datos> array= svs.getLastLogin();
      request.setAttribute("array", (ArrayList) array);
      RequestDispatcher a = request.getRequestDispatcher("LastLogin.jsp");
                    a.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
