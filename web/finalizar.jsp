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
    String poltronas = "";
    String precoInteira = "";
    int vetPoltronas[];
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

        usuario = request.getAttribute("usuario").toString();
        request.setAttribute("usuario", usuario);
        
        senha = request.getAttribute("senha").toString();
        request.setAttribute("senha", senha);
        precoInteira = request.getParameter("precoInteira").toString();
        request.setAttribute("precoInteira", precoInteira);
        
        poltronas = request.getAttribute("poltronas").toString();
        request.setAttribute("poltronas", poltronas);
        vetPoltronas = new int[inteira+meia];
        int indAtual = 0;
        String numAtual = "";
        for(int i=0;i<poltronas.length;i++){
            if(poltronas[i]==','){
                numAtual="";
                vetPoltronas[indAtual] = Integer.parseInt(numAtual);
                indAtual++;
            }
            else{
                numAtual+=poltronas[i];
            }
            
        }
        
        int qtdInteira = Integer.parseInt(inteira);
        int qtdMeia = Integer.parseInt(meia);
        for(int i=0;i<qtdInteira;i++){
            DAOs.getTabelaIngresso().insereIngresso(
            new Ingresso(vetPoltronas[i],
                    usuario,
                    precoInteira,
                        true
            ))
        }
        for(int i=0;i<qtdMeia;i++){
            DAOs.getTabelaIngressos().insereIngresso(
            new Ingresso(vetPoltronas[i+qtdInteira],
                       usuario,
                    50.0,
                    false
            ))
        }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de ingressos online</title>
    </head>
    <body>
        <script>
        </script>
        <h1>Compra finalizada!</h1>
        <h2>Obrigado por comprar!!</h2>
        <form action="finalizar.jsp">
            
        </form>
    </body>
</html>
