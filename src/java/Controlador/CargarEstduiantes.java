/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.DataInputStream;
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
public class CargarEstduiantes extends HttpServlet {

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
      
        int codMateria = Integer.parseInt(request.getParameter("codMateriaL"));
        String contentType = request.getContentType();
        
        if ((contentType != null) ) {
            DataInputStream in = new DataInputStream(request.getInputStream());
            
            /**
             * Obtenermos la longitud y el contenido del tipo de datos (Content type)
             */
            int formDataLength = request.getContentLength(); //Longitud de datos desde el formulario
            byte dataBytes[] = new byte[formDataLength]; //Guardar los bytes obtenidos
            int byteRead = 0; //Contador
            int totalBytesRead = 0; //Contador
            
            /**
             * Convertir el archivo cargado a bytes
             */
            while (totalBytesRead < formDataLength) {
                byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
                totalBytesRead += byteRead;
            }
            
            String file = new String(dataBytes); //Convertir los bytes leidos a cadena
            String txt = file.substring(file.indexOf("text/plain") + 12); //Obtener el contenido sin cabeceras
         boolean lista = new Negocio.STN().insertarListaEstudiantes(codMateria, txt);
              if (lista) {
            request.getRequestDispatcher("./Vista/FormListarMateria.jsp").forward(request, response);
            System.out.println("Registro Exitoso!!");
        } else {
            request.getRequestDispatcher("./Vista/FormAgregarEstudianteL.jsp").forward(request, response);
            System.out.println("No se registro el Estudiante");

        }
 
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
