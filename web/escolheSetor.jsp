<%-- 
    Document   : index
    Created on : 21/02/2018, 09:24:39
    Author     : u16191
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>




<%@page import="java.sql.Timestamp"%>

<%@page import="java.util.Date"%>
<%@page import="DBOs.Setor"%>
<%@page import="DAOs.DAOs"%>
<%

Setor setores[] = null;
int qtosSetores = 0;
String codEspetaculo = "";
String codSessao = "";
String data = "";
if(request.getParameter("cb_Datas")!=null){
	codSessao = request.getParameter("codSessao");
	request.setAttribute("codSessao", codSessao);
	codEspetaculo = request.getAttribute("codEspetaculo").toString();
        
        data = request.getParameter("cb_Datas");
        request.setAttribute("data", data);
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
    
<link href = "style.css" rel="stylesheet" type="text/css"/>
    
<body>
<script>
	function verDetalhes(){	
        var id = document.getElementById("cb_Setores").selectedIndex;
	
        document.getElementById("codSetor").value = document.getElementById("a"+id).value;
	
	
        document.getElementById("detalhes").value = document.getElementById(id).value;
	document.getElementById("Detalhes").style.display = 'block';
	}
</script>
<h1>Garanta seu ingresso já!</h1>
 
<h2>Selecione o Setor do Teatro:</h2>       
<div class="form">
          
<form action="escolheIngresso.jsp" method="post">
            
<select name = "cb_Setores" >
<%
	int codTeatro = DAOs.getTabelaSessoes().getSessao(Integer.parseInt(codSessao)).getCodTeatro();
   	setores = DAOs.getTabelaSetores().getSetoresDisponiveis(codTeatro);

	for(int i=0; i<setores.size();i++){
	String nome = setores[i].getNome();
	String print = setores[i].toString();
	int codSetor = setores[i].getCodSetor();
%>
<option value = '<%=i.toString() + " - "+ data.toString()%>'>

 <input type = "hidden" id= 'a<%=i %>' value = '<%=codSetor %>'>
<input type="hidden" id = '<%=i %>' value ='<%=print %>'>
</option>
<%
}
%>
</select>
<input type = "button" value = "Ver Detalhes" onclick="verDetalhes();">
<div id="Detalhes" style="display: none;">
<input id="detalhes">
<input type="hidden" id = 'codSetor'>
<input type = "submit" value = "Confirmar">

</div>
</form>
        
</div>
    
</body>

</html>
