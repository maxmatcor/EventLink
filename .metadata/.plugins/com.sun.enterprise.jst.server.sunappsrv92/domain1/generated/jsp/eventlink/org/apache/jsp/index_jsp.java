package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setHeader("X-Powered-By", "JSP/2.1");
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \t               \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<title>Bienvenido</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form action=\"login\" method=\"POST\">\n");
      out.write("<div class=\"login-reg-panel\">\n");
      out.write("\t\t<div class=\"login-info-box\">\n");
      out.write("\t\t\t<h2>Estas registrado?</h2>\n");
      out.write("\t\t\t<label id=\"label-register\" for=\"log-reg-show\">Login</label>\n");
      out.write("\t\t\t<input type=\"radio\" name=\"active-log-panel\" id=\"log-reg-show\"  checked=\"checked\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t<div class=\"register-info-box\">\n");
      out.write("\t\t\t<h2>Don't have an account?</h2>\n");
      out.write("\t\t\t<p>Lorem ipsum dolor sit amet</p>\n");
      out.write("\t\t\t<label id=\"label-login\" for=\"log-login-show\">Register</label>\n");
      out.write("\t\t\t<input type=\"radio\" name=\"active-log-panel\" id=\"log-login-show\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t<div class=\"white-panel\">r\n");
      out.write("\t\t\t<div class=\"login-show\">\n");
      out.write("\t\t\t\t<h2>LOGIN</h2>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<input type=\"text\" placeholder=\"Email\" name=\"user\">\n");
      out.write("\t\t\t\t<input type=\"password\" placeholder=\"Password\" name=\"password\">\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"login-reg-panel\"  value=\"Ingresar\" >Ingresar</button>\n");
      out.write("    \t\t\t <button type=\"Reset\" class=\"login-reg-panel\"  value=\"Limpiar\" >Limpiar</button>\n");
      out.write("\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\t</form>\n");
      out.write("</body>\n");
      out.write("</html> \n");
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
