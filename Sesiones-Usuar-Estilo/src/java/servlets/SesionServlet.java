/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miguel Aguilar
 */
public class SesionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String usr;
        String contra;
        int tipoUsr;
        String page = "";
        Conexion Conectar = new Conexion();
        
        //Obtener datos del formulario.
        usr = request.getParameter("usuar");
        contra = request.getParameter("pass");
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuarUsr", usr);
        sesion.setAttribute("contraUsr", contra);
        
        tipoUsr = Conectar.Conecta(usr, contra);
        sesion.setAttribute("tipoUsr", tipoUsr);
        response.setContentType("text/html");

        
        switch(Conectar.Conecta(usr, contra))
        {
            case 0:
                response.sendRedirect("index.jsp");
            break;
            case 1:
                response.sendRedirect("Administrador.html");
            break;
            case 2:
                response.sendRedirect("Profesor.html");
            break;
            case 3:
                response.sendRedirect("Normal.html");
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

}
