
package com.emergentes.controlador;

import com.emergentes.Modelo.Usuario;
import com.emergentes.Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Validar extends HttpServlet {


    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            int documento = Integer.parseInt(request.getParameter("txtusuario"));
            String pass = request.getParameter("txtpassword");
            usuario = usuarioDAO.Validar(documento, pass);
            System.out.print("dato"+usuario.getNombre());
            if(usuario.getNombre()!= null){
                System.out.print("dato1"+usuario.getNombre());
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                

            }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            

        }else{
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

  

}
