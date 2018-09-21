/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import DAOs.DAOs;
import DBOs.Cliente;
import DBOs.PerfilCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafae
 */
@WebServlet(name = "confirmaPrecos", urlPatterns = {"/confirmaPrecos"})
public class confirmaPrecos extends HttpServlet {


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
 try{
    double base = 100.0;
    String codEspetaculo = "";
    String codSessao = "";
    String data = "";
    String codSetor ="";
    String inteira ="";
    String meia = "";
    String usuario = "";
    String senha = "";
    double precoInteira = 0;
        codSessao = request.getAttribute("codSessao").toString();
        request.setAttribute("codSessao", codSessao);

        codEspetaculo = request.getAttribute("codEspetaculo").toString();
        request.setAttribute("codEspetaculo", codEspetaculo);

        data = request.getAttribute("data").toString();
        request.setAttribute("data", data);

        codSetor = request.getAttribute("codSetor").toString();
        request.setAttribute("codSetor", codSetor);

        meia = request.getAttribute("meia").toString();
        request.setAttribute("meia",meia);

        inteira = request.getAttribute("inteira").toString();
        request.setAttribute("inteira",inteira);

        usuario = request.getParameter("usuario").toString();
        request.setAttribute("usuario", usuario);
        
        senha = request.getParameter("senha").toString();
        request.setAttribute("senha", senha);
        
        //aqui temos certeza que o cliente já é cadastrado
        Cliente atual = DAOs.getTabelaClientes().getCliente(usuario);
        PerfilCliente perfil = (PerfilCliente)DAOs.getTabelaPerfisClientes().getPerfilCliente(atual.getCodPerfil());
        int percentual = perfil.getPercentualDesconto();
        //percentual máximo é 50%
        if(percentual > 50)
            percentual = 50;
        precoInteira = percentual * base / 100;
        request.setAttribute("precoInteira", precoInteira);
        request.getRequestDispatcher("confirmarPrecos.jsp").forward(request, response);
 }
 catch (Exception ex){
 ex.getMessage();
 }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
