<%-- 
    Document   : index
    Created on : 21/02/2018, 09:24:39
    Author     : u16191
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>




<%@page import="java.sql.Timestamp"%>

<%@page import="java.util.Date"%>
<%@page import="DBOs.Setor"%>

<%

private Setor setores[] = null;
private int qtosSetores = 0;
private String codEspetaculo = "";
private String codSessao = "";
if(request.getParameter("cb_Datas")!=null)
	codSessao = request.getParameter("codSessao");
	request.setAttribute("codSessao", codSessao);
	codEspetaculo = request.getAttribute("codEspetaculo");
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
	var valor = document.getElementById("cb_Setores").selectedValue;
	
	document.getElementById("Detalhes").value = valor;
	return 1;
	}
</script>
<h1>Garanta seu ingresso já!</h1>
 
<h2>Selecione o Setor do Teatro:</h2>       
<div class="form">
          
<form action="y.jsp" method="post">
            
<select name = "cb_Setores" onChange = "verDetalhes();">
<%
	int codTeatro = DAOs.getTabelaSessoes.getSessao(Integer.parseInt(codSessao)).getCodTeatro();
   	setores = DAOs.getTabelaSetores().getSetoresDisponiveis(
   	codTeatro);

	for(int i=0; i<setores.size();i++){
	String nome = setores[i].getNome();
	String print = setores[i].ToString();
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

<input id="Detalhes">
<input type="hidden" id = 'codSetor'>
<input type = "submit" value = "Confirmar">


</form>
        
</div>
    
</body>

</html>
