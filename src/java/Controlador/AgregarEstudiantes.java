/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KRLOS
 */
public class AgregarEstudiantes extends HttpServlet {

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
        int am = Integer.parseInt(request.getParameter("am"));
        int codMat = Integer.parseInt(request.getParameter("codMat"));

        switch (am) {
            case 0:
                //Agrgar Estduadiante
                request.getSession().setAttribute("CodMateriaEstudiante", String.valueOf(codMat));
                request.getRequestDispatcher("./Vista/FormAgregarEstudiante.jsp").forward(request, response);
                break;
            case 1:
                //Listado Estudiante
                request.getSession().setAttribute("CodMateriaEstudianteL", String.valueOf(codMat));
                request.getRequestDispatcher("./Vista/FormAgregarEstudianteL.jsp").forward(request, response);
                break;
            case 2:
               String Notas= new Negocio.STN().ListarNotasEstudiante(codMat);
                 request.getSession().setAttribute("Notas", Notas);
              request.getRequestDispatcher("./Vista/FormNotas.jsp").forward(request, response);
                //Agregar Notas
                break;


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
        processRequest(request, response);
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
        processRequest(request, response);
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
