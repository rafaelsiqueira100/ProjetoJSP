<%-- 
    Document   : index
    Created on : 21/02/2018, 09:24:39
    Author     : u16191
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>




<%@page import="java.sql.Timestamp"%>

<%@page import="java.util.Date"%>

<%
private String nomeEspetaculo = null;
private Sessao sessoes[] = null;
private int qtasSessoes = 0;
if(request.getParameter("cb_Espetaculo")!=null){
	nomeEspetaculo = request.getParameter("nomeEspetaculo");
}

else{
	
	response.sendRedirect("index.jsp");
}
request.setAttribute("");
%>
<!DOCTYPE html>

<html>
    
<head>
        
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de ingressos online</title>
   
</head>
    
<link href = "style.css" rel="stylesheet" type="text/css"/>
    
<body>
<script>
	function verDetalhes(){
	var id = document.getElementById("cb_Datas").selectedIndex;
	
	document.getElementById("Detalhes").value = document.getElementById(id).value;
	document.getElementById("codSessao").value = document.getElementById(a+id).value;
	return 1;
	}
</script>
<h1>Garanta seu ingresso já!</h1>
 
<h2>Selecione uma Data para o Espetáculo:</h2>       
<div class="form">
          
<form action="escolheSetor.jsp" method="post">
            
<select name = "cb_Datas" onChange = "verDetalhes();">
<%
	int codEspetaculo = DAOS.getTabelaEspetaculos().getEspetaculo(nomeEspetaculo).getCodEspetaculo());
   	sessoes = DAOs.getTabelaSessoes().getSessoesDisponiveis(
   	codEspetaculo);
   	session.setAttribute("codEspetaculo", codEspetaculo.toString());
	for(int i=0; i<sessoes.size();i++){
	String data = sessoes[i].getDataHorario().toString();
	String print = sessoes[i].ToString();
	String codSessao = sessoes[i].getCodSessao().toString();
%>
<option value = '<%=data.toString()%>'>

    
<input type="hidden" id = '<%=i %>' value ='<%=print %>'>
<input type ="hidden" id='a<%=i %>>' value ='<%=codSessao %>' >
</option>
<%
}
%>
</select>

<input id="Detalhes">
<input type="hidden " id= "codSessao">
<input type = "submit" value = "Confirmar">


</form>
        
</div>
    
</body>

</html>
