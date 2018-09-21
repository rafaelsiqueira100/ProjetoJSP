<%-- 
    Document   : escolheIngresso
    Created on : 21/05/2018, 09:18:10
    Author     : u16191
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp"%>

<%@page import="java.util.Date"%>
<%@page import="DBOs.Ingresso"%>
<%@page import="DAOs.DAOs"%>
<%
    String codEspetaculo = "";
    String codSessao = "";
    String data = "";
    String codSetor = "";
    int[] qtdIngresso = new int[2];
if(request.getAttribute("codSetor")!= null){
    codSessao = request.getAttribute("codSessao").toString();
    request.setAttribute("codSessao", codSessao);

    codEspetaculo = request.getAttribute("codEspetaculo").toString();

    request.setAttribute("codEspetaculo", codEspetaculo);

    data = request.getAttribute("data").toString();
    
    request.setAttribute("data", data);

    codSetor = request.getParameter("codSetor");
    request.setAttribute("codSetor", codSetor);

}
else{
response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de ingressos online</title>
    </head>
    <body>
    <script>
    function verDetalhes(){
    var qtdMeias = document.getElementById("meia").value;
    var qtdInts = document.getElementById("inteira").value;
    if(qtdMeias == null || qtdMeias==""
    ||qtdInts  == null || qtdInts == ""){
        alert("Preencha os campos de meia e inteira!!");}
    else{
    if(qtdMeias == qtdInteiras && qtdMeias == 0)
        alert("Compre um ingresso, no mínimo !");

    }

    }
    </script>
        <h1>Garanta seu(s) ingresso(s) já!</h1>
        <h2>Escolha a quantidade de cada ingresso:</h2>
        <div class = "form">
        <form action = "fazerCadastro.jsp">
        Quantidade de Meias:<input type="number" id = "meia" step="1" min="0" required>
        Quantidade de Inteiras:<input type="number" id = "inteira" step="1" min="0" required>
        <input type = "button" value = "Ver Detalhes" onclick="verDetalhes();">
        <input id="Detalhes">
        <input type="submit" value="Confirmar">
        </form>

        </div>
    </body>
</html>
