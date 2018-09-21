<%-- 
    Document   : index
    Created on : 21/02/2018, 09:24:39
    Author     : u16191
--%>


<%@page import="DAOs.DAOs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="DBOs.Sessao"%>


<%@page import="java.sql.Timestamp"%>

<%@page import="java.util.Date"%>

<%
 String nomeEspetaculo = null; 
 Sessao[] sessoes = new Sessao[DAOs.getTabelaSessoes().qtosSessoesDisponiveis(DAOs.getTabelaEspetaculos().getEspetaculo(request.getParameter("cb_espetaculo")).getCodEspetaculo())];
 int qtasSessoes = 0;
if(request.getParameter("cb_Espetaculo")!=null){
     nomeEspetaculo = request.getParameter("cb_Espetaculo");
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
        var combobox = document.getElementById(cb_Datas);
        document.getElementById("detalhes").value = 
                combobox.options[combobox.selectedIndex])
        document.getElementById("Detalhes").style.display = 'block';
    }
    
    </script>
        
<h1>Garanta seu ingresso já!</h1>
 
<h2>Selecione uma Data para o Espetáculo:</h2>       
<div class="form">
          
<form action="escolheSetor.jsp" method="post">
            
<select name = "cb_Datas">
<%
   sessoes = DAOs.getTabelaSessoes().getSessoesDisponiveis(
   DAOs.getTabelaEspetaculos().getEspetaculo(nomeEspetaculo).getCodEspetaculo()).clone();

for(int i=0; i < sessoes.length ;i++){
String data = sessoes[i].getDataHorario().toString();
String print = sessoes[i].toString();

%>
<option value = '<%=data %>' name='<%=print %>'>
    
</option>
<%
}
%>
</select>
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
