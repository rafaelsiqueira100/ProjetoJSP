package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fazerCadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

     String codEspetaculo = "";
    String codSessao = "";
    String data = "";
    String codSetor = "";
    int[] qtdIngresso = new int[2];
if(request.getAttribute("inteira")!= null){
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Venda de ingressos online</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script>\n");
      out.write("            function MostrarDivPreco(){\n");
      out.write("                document.getElementById(\"precos\").visible = true;\n");
      out.write("                document.getElementById(\"cadastro\").visible = false;\n");
      out.write("            }\n");
      out.write("            function MostrarDivCadastro(){\n");
      out.write("                document.getElementById(\"precos\").visible = false;\n");
      out.write("                document.getElementById(\"cadastro\").visible = true;                \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <h1>Garanta seu(s) ingressos já !</h1>\n");
      out.write("        <h2>Já possui cadastro?</h2>\n");
      out.write("        <input type=\"button\" value=\"Sim!\" id=\"s\" onclick=\"MostrarDivPreco();\">\n");
      out.write("        <input type=\"button\" value=\"Ainda Não!\" id=\"n\" onclick=\"MostrarDivCadastro();\">\n");
      out.write("        <div id=\"cadastro\" visible = \"false\">\n");
      out.write("            <form action=\"confirmarCadastro.jsp\">\n");
      out.write("                <h3>Faça o cadastro agora:</h3><BR>\n");
      out.write("                Usuário:<input id=\"usuario\"><br>\n");
      out.write("                CPF:<input type=\"tel\" id=\"cpf\" \n");
      out.write("                    pattern=\"^\\d{3}.\\d{3}.\\d{3}-\\d{2}$\"><BR>\n");
      out.write("                RG:<input type=\"tel\" id=\"rg\"\n");
      out.write("                    pattern=\"^\\d{1}.\\d{3}.\\d{3}$\"><BR>\n");
      out.write("                Nome Completo:<input id=\"nome\"><br>\n");
      out.write("                Data de Nascimento:<input type = \"date\" id=\"dataNasc\"><br>\n");
      out.write("                Email:<input type=\"email\" id=\"email\">\n");
      out.write("                Celular:<input type=\"tel\" id=\"cel\">\n");
      out.write("                Perfil:\n");
      out.write("                Senha:<input type=\"password\" id=\"senha\"><br>\n");
      out.write("                Confirmar Senha:<input type=\"password\" id=\"confSenha\"><br>                \n");
      out.write("                <input type=\"submit\" value=\"Cadastro\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"precos\" visible=\"false\">\n");
      out.write("            <form action=\"confirmarPrecos.jsp\">\n");
      out.write("            <h3> Por favor, digite o usuário e a senha para confirmarmos a compra:</h3>\n");
      out.write("            Usuário:<input id=\"usuario\">\n");
      out.write("            Senha:<input id=\"senha\" type=\"password\">\n");
      out.write("            <input type = \"submit\" value=\"Log In\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
