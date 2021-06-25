package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=en>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=UTF-8>\n");
      out.write("        <style>\n");
      out.write("            .container {\n");
      out.write("                margin : 20px auto;\n");
      out.write("                background-color: white;\n");
      out.write("                height: 400px;\n");
      out.write("                width : 100%;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow: 0px 5px 15px 0px;\n");
      out.write("                position: relative;\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("            .tb{\n");
      out.write("                margin : 20px auto;\n");
      out.write("                background-color: white;\n");
      out.write("                height: 300px;\n");
      out.write("                width : 90%px;\n");
      out.write("                position: relative;\n");
      out.write("                padding: 10px;\n");
      out.write("            }\n");
      out.write("            #ques{\n");
      out.write("                font-weight : bold;\n");
      out.write("                background-color: white;\n");
      out.write("                align : left;\n");
      out.write("                position: relative;\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("            .ans{\n");
      out.write("                width: 338px;\n");
      out.write("                align: center;\n");
      out.write("                height: 100%;\n");
      out.write("                background-color: #fff;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                border: 2px solid #D1C6F3;\n");
      out.write("            }\n");
      out.write("            .ans :hover{\n");
      out.write("                background-color:#005c99;\n");
      out.write("            }\n");
      out.write("            .center {\n");
      out.write("                margin: 0;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50%;\n");
      out.write("                left: 50%;\n");
      out.write("                -ms-transform: translate(-50%, -50%);\n");
      out.write("                transform: translate(-50%, -50%);\n");
      out.write("            }\n");
      out.write("            .next{\n");
      out.write("                margin: 0;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50%;\n");
      out.write("                right: 130px;\n");
      out.write("                font-size: 30px;\n");
      out.write("                height: 120px;\n");
      out.write("                width: 75px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow: 0px 5px 15px 0px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .prev{\n");
      out.write("                margin: 0;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 50%;\n");
      out.write("                left: 170px;\n");
      out.write("                font-size: 30px;\n");
      out.write("                height: 120px;\n");
      out.write("                width: 75px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-shadow: 0px 5px 15px 0px;\n");
      out.write("                text-align: center;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            #myProgress {\n");
      out.write("                width: 100%;\n");
      out.write("                background-color: #ddd;\n");
      out.write("                margin: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #myBar {\n");
      out.write("                width: 1%;\n");
      out.write("                height: 10px;\n");
      out.write("                background-color: #04AA6D;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                height: 100%;\n");
      out.write("                margin: 0;\n");
      out.write("                background-image: linear-gradient(to bottom right, #D1C6F3, #FDBDD4);\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-attachment: fixed;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"move()\">\n");
      out.write("        <div class=\"center\">\n");
      out.write("            <div class='container'>\n");
      out.write("                <table class='tb' width='100%' cellspacing>\n");
      out.write("                    <tr><td colspan='2'><div id=\"myProgress\">\n");
      out.write("                                <div id=\"myBar\"></div>\n");
      out.write("                            </div></td></tr>\n");
      out.write("\n");
      out.write("                    <tr><td colspan='2'><div id='ques'>What does HTML stand for?</div></td></tr>\n");
      out.write("\n");
      out.write("                    <tr align='center' height='25%'><br><br><br>\n");
      out.write("                        <td padding=20px;><button class='ans' id='A' onclick=\"check('A')\">hgvdshgsdv</button></td>\n");
      out.write("                        <td padding=20px;><button class='ans' id='B' onclick=\"check('B')\">mzsvbdbehf</button></td></tr>\n");
      out.write("                    <tr align='center' height='25%'>\n");
      out.write("                        <td padding=20px;><button class='ans' id='C' onclick=\"check('C')\">jshgdkjefh</button></td>\n");
      out.write("                        <td padding=20px;><button class='ans' id='D' onclick=\"check('D')\">jasgdkjsf</button></td></tr> \n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            var i = 0;\n");
      out.write("            function move() {\n");
      out.write("                if (i == 0) {\n");
      out.write("                    i = 1;\n");
      out.write("                    var elem = document.getElementById(\"myBar\");\n");
      out.write("                    var width = 1;\n");
      out.write("                    var id = setInterval(frame, 10);\n");
      out.write("                    function frame() {\n");
      out.write("                        if (width >= 100) {\n");
      out.write("                            next();\n");
      out.write("                            clearInterval(id);\n");
      out.write("                            i = 0;\n");
      out.write("                        } else if (width >= 90) {\n");
      out.write("                            width++;\n");
      out.write("                            elem.style.width = width + \"%\";\n");
      out.write("                            elem.style.backgroundcolor = \"#e60000\";\n");
      out.write("                        } else {\n");
      out.write("                            width++;\n");
      out.write("                            elem.style.width = width + \"%\";\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
