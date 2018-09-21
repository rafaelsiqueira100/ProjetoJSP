<%-- 
    Document   : escolherPoltronas
    Created on : 24/05/2018, 09:01:02
    Author     : u16191
--%>

<%@page import="DBOs.Poltrona"%>
<%@page import="DAOs.Poltronas"%>
<%@page import="DAOs.Assentos"%>
<%@page import="DBOs.Ingresso"%>
<%@page import="DAOs.DAOs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String codEspetaculo = "";
    String codSessao = "";
    String data = "";
    String codSetor ="";
    String inteira ="";
    String meia = "";
    String usuario = "";
    String senha = "";
    String precoInteira = "";
    if(request.getParameter("inteira")== null)
        response.sendRedirect("index.jsp");
    
        codSessao = request.getAttribute("codSessao").toString();
        request.setAttribute("codSessao", codSessao);

        codEspetaculo = request.getAttribute("codEspetaculo").toString();
        request.setAttribute("codEspetaculo", codEspetaculo);

        data = request.getAttribute("data").toString();
        request.setAttribute("data", data);

        codSetor = request.getAttribute("codSetor").toString();
        request.setAttribute("codSetor", codSetor);

        meia = request.getAttribute("meia").toString();
        request.setAttribute("meia",meia);

        inteira = request.getAttribute("inteira").toString();
        request.setAttribute("inteira",inteira);

        usuario = request.getParameter("usuario").toString();
        request.setAttribute("usuario", usuario);
        precoInteira = request.getParameter("precoInteira").toString();
        request.setAttribute("precoInteira", precoInteira);
        
        senha = request.getParameter("senha").toString();
        request.setAttribute("senha", senha);
        /*int qtdInteira = Integer.parseInt(inteira);
        int qtdMeia = Integer.parseInt(meia);
        for(int i=0;i<qtdInteira;i++){
            DAOs.getTabelaIngresso().insereIngresso(
            new Ingresso(
                    

            ))
        }
        for(int i=0;i<qtdMeia;i++){
            DAOs.getTabelaIngressos().insereIngresso(
            new Ingresso(


            ))
        }*/
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de ingressos online</title>
    </head>
    <body>
        <script>
            function PoltronaSelecionada(){
            var contagem = document.getElementById("contagem").value;
            document.getElementById("invisivel").style.display='block';
            if(contagem !=0){
            document.getElementById("Ingressos").value += arguments[0] +',';  
            contagem = contagem - 1;
            document.getElementById("contagem").value = contagem;            
            }   else{
                
                document.getElementById("invisivel2").style.display = 'block';
            }
            
            }
        </script>
        <h1>Garanta seu(s) ingressos já !</h1>
        <h2>Escolha as poltronas:</h2>
        <form action="finalizar.jsp">
            <%
                
            Poltrona[] total = DAOs.getTabelaPoltronas().getPoltronas(Integer.parseInt(codSessao), Integer.parseInt(codSetor));
            int colunaAnterior = total[0].getFileira();
            for(int i=0;i<total;i++){
            int codPoltrona = total[i].getCodPoltrona();
            int colunaAtual = total[i].getFileira();
            char letra = total[i].getLetra();
            boolean situacao = total[i].isSituacao()
            if(colunaAtual!=colunaAnterior){
            %><p><%
            }
            
            if(situacao){
                %>
                <input type="button" style= "background-color: green;"
                       id=""
                       onclick="PoltronaSelecionada(<%=codPoltrona%>)"
                       value="<%=colunaAtual + " - "+letra%>">
                <%
            }
            else{
                %>
                <input type="button" style="background-color: red;"
                       value="<%=colunaAtual + " - "+letra%>">
                <%
            
            }
            
            
            }
            %>
            <div style="display:none;" id="invisivel">
            <input value=""id="Poltronas">
            <input type="hidden" value="6"id="contagem">    
            <div style="display:none;" id="invisivel2">
            <input type="submit"value="Finalizar compra!">
             </div>
                </div>
        </form>
    </body>
</html>
