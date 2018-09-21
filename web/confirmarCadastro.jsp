<%-- 
    Document   : confirmarCadastro
    Created on : 24/05/2018, 09:25:47
    Author     : u16191
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="DBOs.Cliente"%>
<%@page import="DBOs.PerfilCliente"%>
<%@page import="DAOs.DAOs"%>
<%@page import="java.sql.Date"%>

<%
    String codEspetaculo = "";
    String codSessao = "";
    String data = "";
    String codSetor ="";
    String inteira ="";
    String meia = "";
    
    String codPerfil = "";
    String usuario = "";
    String senha = "";
    String cpf = "";
    String rg = "";
    String nome = "";
    String dataNasc = "";
    String email = "";
    String celular = "";
    
     if(request.getParameter("cpf")!=null){
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
        
        cpf = request.getParameter("cpf").toString();
        request.setAttribute("cpf", cpf);
        
        rg = request.getParameter("rg").toString();
        request.setAttribute("rg", rg);
        
        nome = request.getParameter("nome").toString();
        request.setAttribute("nome", nome);
        
        dataNasc = request.getParameter("dataNasc").toString();
        request.setAttribute("dataNasc", dataNasc);
        
        email = request.getParameter("email").toString();
        request.setAttribute("email", email);
        
        celular = request.getParameter("celular").toString();
        request.setAttribute("celular", celular);
        
        codPerfil = request.getParameter("codPerfil").toString();
        request.setAttribute("codPerfil", codPerfil);
        
        //aqui temos certeza que o cliente já é cadastrado
        if(!DAOs.getTabelaClientes().insertCliente(
        new Cliente(
        usuario,
        senha,
        Integer.parseInt(codPerfil),
        cpf,
        rg,
        nome,
        dataNasc,
        email,
        celular))){
            response.sendRedirect("fazerCadastro.jsp");
        }
        else{
            response.sendRedirect("confirmarPrecos.java);
        }
        //Não tem nada nessa página porque ela nunca será 
        //visualizada pelo cliente, somente é uma página de 
        //redirecionamento
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
