<%-- 
    Document   : confirmarPrecos
    Created on : 24/05/2018, 07:36:17
    Author     : u16191
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DBOs.Cliente"%>
<%@page import="DAOs.DAOs"%>
<%@page import="DBOs.PerfilCliente"%>
<!DOCTYPE html>
<%
    String usuario = request.getAttribute("usuario").toString();
    int precoInteira  = Integer.parseInt(request.getAttribute("precoInteira").toString());
    String senha = request.getAttribute("usuario").toString();
    if(request.getParameter("usuario")==null)
        response.sendRedirect("index.jsp");
     if(!DAOs.getTabelaClientes().bate(usuario, senha))
            response.sendRedirect("fazerCadastro.jsp");
       
%>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de ingressos online</title>
    </head>
    <body>
        <script>
        function CalcularPreco(){
            var precoInteira  = document.getElementById("precoInteira").value;
            var qtdInteira    = document.getElementById("inteira").value;
            var qtdMeia       = document.getElementById("meia").value;
            var total         = precoInteira* qtdInteira + 50*precoMeia;
            document.getElementById("total").value = document.getElementById("total").value + total+ ;
            document.getElementById("total").style.display = 'block';
        }
          </script>
        <h1>Confirme seu(s) ingressos:</h1>
        <form action="escolherPoltronas.jsp">
            <h2>Preço da inteira: R$ <%=precoInteira%></h2>
            <br>
            <h2>Preço da meia:    R$ 50.0</h2>
            <input type="hidden" value="<%=precoInteira%> id="<%=precoInteira%>">
            
            <br>Quantidade de Inteiras: 
            <input required type="number" id = "inteira" step="1" min="0" value="<%=inteira%>">
            
            <br>Quantidade de Meias   : 
            <input required type="number" id = "meia" step="1" min="0" value="<%=meia%>">
            
            <input type="button" value="Calcular Total a Pagar" onclick="CalcularPreco();">
            <div id="precos" style="display:none;">
                <input id="total" value="Total = R$ ">
                <input type ="submit" value = "Escolher Assento">
            </div>
        </form>    
        
    </body>
</html>
