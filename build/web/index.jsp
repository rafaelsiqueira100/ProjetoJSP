<%-- 
    Document   : index
    Created on : 21/02/2018, 09:24:39
    Author     : u16191
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="DBOs.Espetaculo"%>
<%@page import="DAOs.*"%>


<%

%>
<!DOCTYPE html>

<html>
    
<head>
        
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de ingressos online</title>
   
</head>
 <%
 	 Espetaculo espetaculos[] = null;
 	 int qtosEspetaculos = 0;

 %>   
<link href = "style.css" rel="stylesheet" type="text/css"/>
    
<body class="corpo">

<script>
	function verDetalhes(){
	var combobox = document.getElementById("cb_Espetaculo");
	
	document.getElementById("detalhes").value = combobox.options[combobox.selectedIndex].name;
        document.getElementById("Detalhes").style.display= 'block';
        
	}
</script>
        
<h1 id="grandeIngresso" id="grandeIngresso">Garanta seu ingresso!</h1>

<h2 id="medioIngresso">Selecione um Espetáculo:</h2>       
<div id="formularioDiv" class="form">
          
            


<form action="escolheData.jsp" method="post">
            
<%
    espetaculos = DAOs.getTabelaEspetaculos().getEspetaculosDisponiveis();
    qtosEspetaculos = espetaculos.length;


%>
    <select  id = "cb_Espetaculo" size="<%=qtosEspetaculos%>" required>
<%
for(int i=0; i< qtosEspetaculos;i++){
String s = espetaculos[i].getNome();
String print = espetaculos[i].toString();
%>
<option name='<%=print%>'>
<%= (s)%>
</option>

<%
}
%>
</select>
<p>
<input id="botao" type = "button" value = "Ver Detalhes" onclick="verDetalhes();">
<p>
    <div id="Detalhes" style='display:none;'>
        <!-- -->
        <textarea rows="30" cols="50" readonly id="detalhes" >
</textarea> 
<p>
<input id="botao" type = "submit" value = "Confirmar" >
</div>
</form>
        
</div>
    
</body>

</html>
