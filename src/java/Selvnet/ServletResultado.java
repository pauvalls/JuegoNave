/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selvnet;

import Entidades.Pavallsuser;
import Servicios.ServiceScore;
import Servicios.Serviceuser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
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
@WebServlet(name = "ServletResultado", urlPatterns = {"/ServletResultado"})
public class ServletResultado extends HttpServlet {

    java.sql.Date fechaini;
    java.sql.Date fechafin;

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
            out.println("<title>Servlet ServletResultado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletResultado at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        Date f = new Date();
        fechaini = new java.sql.Date(f.getTime());
        RequestDispatcher a = request.getRequestDispatcher("juego.jsp");
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

        Date f = new Date();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JuegolanzaderaPauVallsMorenoPU");
        EntityManager em = emf.createEntityManager();
        Serviceuser sv = new Serviceuser(em);
        ServiceScore svs = new ServiceScore(em);
        int datos = sv.findUserbyname(request.getParameter("nombre"));
        Pavallsuser pa = new Pavallsuser();
        pa.setIduser(datos);

        fechafin = new java.sql.Date(f.getTime());
        String speed = request.getParameter("velocidad");
        if (speed.equals("Maybe next time...")) {
            RequestDispatcher a = request.getRequestDispatcher("juego.jsp");
            a.forward(request, response);
        } else {
            double i = getvelocidad(speed);

            svs.adduser(pa, fechaini, fechafin, i);//FUNCIONA
            fechaini = fechafin;//la siguiente ronda
            RequestDispatcher a = request.getRequestDispatcher("juego.jsp");
            a.forward(request, response);
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

    public Calendar fecha(int d, int m, int y, int h, int min, int s) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.DAY_OF_MONTH, d);
        calendar.set(Calendar.MONTH, m);
        calendar.set(Calendar.HOUR_OF_DAY, h);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, s);

        return calendar;
    }

    public double getvelocidad(String speed) {
        String velocidad = "";
        double run;

        for (int i = 0; i < speed.length(); i++) {
            if (i > 7 && i < 12) {

                velocidad += speed.charAt(i);
            }

        }

        run = Double.parseDouble("-" + velocidad);
        return run;
    }

}
