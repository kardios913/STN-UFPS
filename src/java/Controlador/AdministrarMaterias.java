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
public class AdministrarMaterias extends HttpServlet {

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
                //editar
                request.getSession().setAttribute("CodMateriaEditar", String.valueOf(codMat));
                request.getRequestDispatcher("./Vista/FormEditarMateria.jsp").forward(request, response);
                break;
            case 1:
                //cancelar
                boolean eliminar = new Negocio.STN().ELiminarMateriaCascada(codMat);
                if (eliminar) {
                    request.getRequestDispatcher("./Vista/FormProfesor.jsp").forward(request, response);
                    System.out.println("Materia Eliminada!!");
                } else {
                    request.getRequestDispatcher("./Vista/FormListarMateria.jsp").forward(request, response);
                    System.out.println("No Se Elimino!!");

                }
                break;
            case 2:
                //Gestionar
                String GMateria= new Negocio.STN().ListarEstudiantesMateria(codMat);
                 request.getSession().setAttribute("CodMateriaGestionar", GMateria);
              request.getRequestDispatcher("./Vista/FormGestionarMateria.jsp").forward(request, response);
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
