<%-- 
    Document   : index
    Created on : 21/02/2018, 09:24:39
    Author     : u16191
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%@page import="Agenda.BD"%>

<%@page import="Agenda.Connect"%>


<%@page import="java.util.List"%>

<%@page import="java.util.Date"%>

<%
String nomeEspetaculo = null;
if(request.getParameter("cb_Espetaculo")!=null)
	nomeEspetaculo = request.getParameter("cb_Espetaculo");
//else{}

%>
<!DOCTYPE html>

<html>
    
<head>
        
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de ingressos online</title>
   
</head>
    
<link href = "style.css" rel="stylesheet" type="text/css"/>
    
<body>

        
<h1>Garanta seu ingresso já!</h1>
 
<h2>Selecione um Espetáculo:</h2>       
<div class="form">
          
            


<form action="escolheData.jsp" method="post">
            

<select name = "cb_Espetaculo">
<%
Connect conexao = new Connect();

List<Espetaculo> espetaculos = conexao.montaComboEspetaculos();
for(int i=1; i<= espetaculos.size();i++){
String s = espetaculos.get(i).toString();


%>
<option value = '<%=i %>'>
<%=s%>
</option>
<%
}
%>
</select>

<input type = "submit" value = "Selecionar">


</form>
        
</div>
    
</body>

</html>
