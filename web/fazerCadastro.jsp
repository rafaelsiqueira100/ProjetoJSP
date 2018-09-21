<%-- 
    Document   : fazerCadastro
    Created on : 23/05/2018, 07:06:50
    Author     : u16191
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DBOs.PerfilCliente"%>
<%@page import="DAOs.DAOs"%>
<%
     String codEspetaculo = "";
    String codSessao = "";
    String data = "";
    String codSetor = "";
    int[] qtdIngresso = new int[2];
if(request.getParameter("inteira")!= null){
    codSessao = request.getAttribute("codSessao").toString();
    request.setAttribute("codSessao", codSessao);

    codEspetaculo = request.getAttribute("codEspetaculo").toString();

    request.setAttribute("codEspetaculo", codEspetaculo);

    data = request.getAttribute("data").toString();
    
    request.setAttribute("data", data);

    codSetor = request.getAttribute("codSetor").toString();
    request.setAttribute("codSetor", codSetor);

    qtdIngresso[0] = Integer.parseInt(request.getParameter("meia"));
    request.setAttribute("meia",qtdIngresso[0]);

    qtdIngresso[1] = Integer.parseInt(request.getParameter("inteira"));
    request.setAttribute("inteira",qtdIngresso[1]);
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
    <body>
        <script>
            function MostrarDivPreco(){
                document.getElementById("precos").style.display = 'block';
                document.getElementById("cadastro").style.display = 'none';
                }
            function MostrarDivCadastro(){
                document.getElementById("precos").style.display = 'none';
                
                document.getElementById("cadastro").style.display = 'block';
                }
            function VerDetalhes(){
                document.getElementById("confCadastro").style.display = 'block';
                var combobox = document.getElementById("cb_Perfil");
                combobox.options[combobox.selectedIndex]
                document.getElementById("Detalhes").value = combobox.options[combobox.selectedIndex].id;
                document.getElementById("codPerfil").value = combobox.options[combobox.selectedIndex].value;
            }
        </script>
        <h1>Garanta seu(s) ingressos já !</h1>
        <h2>Já possui cadastro?</h2>
        <input type="button" value="Sim!" id="s" onclick="MostrarDivPreco();">
        <input type="button" value="Ainda Não!" id="n" onclick="MostrarDivCadastro();">
        <div id="cadastro" style="display:none;">
            <form action="confirmarCadastro.jsp">
                <h3>Faça o cadastro agora:</h3><BR>
                Usuário:<input required id="usuario"><br>
                CPF:<input required type="tel" id="cpf" 
                    pattern="^\d{3}.\d{3}.\d{3}-\d{2}$"><BR>
                RG:<input required type="tel" id="rg"
                    pattern="^\d{1}.\d{3}.\d{3}$"><BR>
                Nome Completo:<input required id="nome"><br>
                Data de Nascimento(formato DDMMAAAA, sem /):<input required id="dataNasc"
                    pattern="^\d{8}$"><br>
                Email:<input required type="email" id="email">
                Celular:<input required type="tel" id="cel">
                Perfil:
                <%
                PerfilCliente[] perfis = DAOs.getTabelaPerfisClientes().getPerfisClientes().clone();
                int qtosPerfis = perfis.length;
                %>
                <select required 
                    id ="cb_Perfil" size="<%=qtosPerfis%>" >
                    <%
                        for(int i=0;i<qtosPerfis;i++){
                            String s = perfis[i].getDescricao();
                            String print = perfis[i].toString();
                            String cod = ""+perfis[i].getCodPerfil();
                            
                    %>
                    <option id="<%=print%>" value='<%=cod%>'>
                    <%=s%>
                    </option>
                    <%
                        }
                    %>
                </select>
                Senha:<input type="password" id="senha"><br>
                Confirmar Senha:<input type="password" id="confSenha"><br> 
                <input type="button" value="Ver Detalhes" onclick="VerDetalhes();">
                <p>
                <div id="confCadastro" style="display:block;">
                <input id="Detalhes">
                <input type='hidden' id='codPerfil'>    
                <input type="submit" value="Cadastrar">
                </div>
            </form>
        </div>
        <div id="precos" style="display:none;">
            <form action="confirmarPrecos.java">
            <h3> Por favor, digite o usuário e a senha para confirmarmos a compra:</h3>
            Usuário:<input id="usuario" required>
            <br>
            Senha:<input id="senha" type="password" required>
            <input type = "submit" value="Log In">
            </form>
        </div>
    </body>
</html>
