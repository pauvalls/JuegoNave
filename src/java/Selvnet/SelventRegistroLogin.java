/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selvnet;

import Servicios.Serviceuser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pauva
 */
@WebServlet(name = "SelventRegistroLogin", urlPatterns = {"/SelventRegistroLogin"})
public class SelventRegistroLogin extends HttpServlet {

    int numerocookies;

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
            out.println("<title>Servlet SelventRegistroLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SelventRegistroLogin at " + request.getContextPath() + "</h1>");
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

        //processRequest(request, response);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JuegolanzaderaPauVallsMorenoPU");
        EntityManager em = emf.createEntityManager();
        Serviceuser sv = new Serviceuser(em);

        if (request.getParameter("usuario").isEmpty() || request.getParameter("pass").isEmpty()) {
            RequestDispatcher a = request.getRequestDispatcher("Error.jsp");
            a.forward(request, response);
        } else if (comprobarUsuario(request.getParameter("usuario"), request.getParameter("pass"), sv)) {
            Cookie name = new Cookie("name", request.getParameter("usuario"));
            Cookie pass = new Cookie("pass", request.getParameter("pass"));
            response.addCookie(name);
            response.addCookie(pass);

            request.setAttribute("nombre", (String) request.getParameter("usuario"));
            RequestDispatcher a = request.getRequestDispatcher("Menujuego.jsp");
            a.forward(request, response);

        } else {
            RequestDispatcher a = request.getRequestDispatcher("Error.jsp");
            a.forward(request, response);
        }
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
        // processRequest(request, response);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JuegolanzaderaPauVallsMorenoPU");
        EntityManager em = emf.createEntityManager();
        Serviceuser sv = new Serviceuser(em);
        try {
            if (!comprobarUsuario(request.getParameter("usuario"), sv)) {
                sv.adduser(request.getParameter("usuario"), request.getParameter("pass"));
                RequestDispatcher a = request.getRequestDispatcher("RegistroLogin.jsp");
                a.forward(request, response);
            } else {
                RequestDispatcher a = request.getRequestDispatcher("Error.jsp");
                a.forward(request, response);
            }
        } catch (Exception e) {
            sv.adduser(request.getParameter("usuario"), request.getParameter("pass"));

        }

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

    public boolean comprobarUsuario(String nombre, Serviceuser sv) {
        boolean semaforo = false;
        Serviceuser serviceuser = sv;
        for (int i = 0; i < serviceuser.findAllusuarios().size(); i++) {
            if (serviceuser.findAllusuarios().get(i).getNameuser().equals(nombre)) {
                semaforo = true;
            }
        }

        return semaforo;
    }

    public boolean comprobarUsuario(String nombre, String pass, Serviceuser sv) {
        boolean semaforo = false;
        Serviceuser serviceuser = sv;
        for (int i = 0; i < serviceuser.findAllusuarios().size(); i++) {
            if (serviceuser.findAllusuarios().get(i).getNameuser().equals(nombre)) {
                if (serviceuser.findAllusuarios().get(i).getPassuser().equals(pass)) {
                    semaforo = true;
                    numerocookies = i;
                }

            }
        }

        return semaforo;
    }
}
