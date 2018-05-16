<%-- 
    Document   : index
    Created on : 21/02/2018, 09:24:39
    Author     : u16191
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>




<%@page import="java.sql.TimeSpan"%>

<%@page import="java.util.Date"%>

<%
private String nomeEspetaculo = null;
private Sessao sessoes[] = null;
private int qtasSessoes = 0;
if(request.getParameter("cb_Espetaculo")!=null)
	nomeEspetaculo = request.getParameter("cb_Espetaculo");
//else{}redirect para index.jsp

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
 
<h2>Selecione uma Data para o Espetáculo:</h2>       
<div class="form">
          
<form action="y.jsp" method="post">
            
<select name = "cb_Datas">
<%
   sessoes = DAOs.getTabelaSessoes().getSessoesDisponiveis(
   DAOS.getTabelaEspetaculos().getEspetaculo(nomeEspetaculo).getCodEspetaculo());

for(int i=0; i<sessoes.size();i++){
String data = sessoes[i].getDataHorario().toString();
String print = sessoes[i].ToString();

%>
<option value = '<%=i %>'>
<%=data%>
    
<input type="hidden" id = '<%=i %>'value ='<%=print %>'>
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
