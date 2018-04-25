<%-- 
    Document   : index
    Created on : 21/02/2018, 09:24:39
    Author     : u16191
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


</%@page>
<!DOCTYPE html>

<html>
    
<head>
        
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de ingressos online</title>
   
</head>
 <%
 	private Espetaculo espetaculos[] = null;
 	private int qtosEspetaculos = 0;

 %>   
<link href = "style.css" rel="stylesheet" type="text/css"/>
    
<body>

<script>
	function verDetalhes(){
	var id = document.getElementById("cb_Espetaculo").selectedIndex;
	
	document.getElementById("Detalhes").value = document.getElementById(id).value;
	return 1;
	}
</script>
        
<h1>Garanta seu ingresso já!</h1>
 
<h2>Selecione um Espetáculo:</h2>       
<div class="form">
          
            


<form action="escolheData.jsp" method="post">
            

<select name = "cb_Espetaculo" onChange = "verDetalhes();">
<%
espetaculos = DAOs.getTabelaEspetaculos().getEspetaculosDisponiveis();



for(int i=0; i< espetaculos.size();i++){
String s = espetaculos[i].getNome();
String print = espetaculos[i].toString();
%>
<option value = '<%=s %>'>
<input type="hidden" id = '<%=i %>' value ='<%=print %>'>
</option>
<%
}
%>
</select>
<input id="Detalhes">
<input type = "submit" value = "Confirmar">
</form>
        
</div>
    
</body>

</html>
