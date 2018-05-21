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
    private String codEspetaculo = "";
    private String codSessao = "";
    private String data = "";
    private int[] qtdIngresso = new int[2];
if(request.getAttribute("codSetor")!= null){
    codSessao = request.getAttribute("codSessao");
    request.setAttribute("codSessao", codSessao);
    codEspetaculo = request.getAttribute("codEspetaculo");
    request.setAttribute("codEspetaculo", codEspetaculo);
}
else{
response.sendRedirect("index.jsp");
}
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
