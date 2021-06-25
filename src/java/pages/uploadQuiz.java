/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class uploadQuiz extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String[] user1 = (String[]) session.getAttribute("user1");
            String user = user1[0];
            String sub = user1[1];
            String grp = user1[2];
            String tid = user1[3];
            String tb = (String) session.getAttribute("tbname");
            String page;
            if (user == null) {
                page = "login.html";
            }
            out.println("<!DOCTYPE html> "
                    + "<html>     "
                    + "<title>Home</title>     "
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">     "
                    + "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">     "
                    + "<style>"
                    + "         .w3-theme {"
                    + "             color:#fff !important;"
                    + "             background-color:#009999; !important}         "
                    + "         .w3-btn {"
                    + "             background-color:#009999;"
                    + "             margin-bottom:4px}         "
                    + "         .w3-code{"
                    + "             border-left:4px solid #4CAF50}         "
                    + "         .myMenu {"
                    + "             margin-bottom:150px}          "
                    + "         .grid-container {             "
                    + "             display: grid;             "
                    + "             grid-template-columns: auto auto auto auto;"
                    + "             padding: 10px;"
                    + "             margin-left: 20px;"
                    + "             margin-right: 20px;"
                    + "             margin-top: 20px;}"
                    + "         .grid-item {"
                    + "             background-color: #99003d;"
                    + "             border: none;"
                    + "             padding: 30px;"
                    + "             font-size: 30px;"
                    + "             text-align: center;"
                    + "             color: white;"
                    + "             margin: 20px;"
                    + "             width: 300px;"
                    + "             heigth: 300px;}"
                    + "          .container{"
                    + "             margin-left: 40px;"
                    + "             margin-top: 40px;"
                    + "             padding: 20px;}"
                    + "          .tble{"
                    + "             cell-spacing: 20px;}"
                    + "          .tb {"
                    + "             width: 70%;"
                    + "             border-collapse: collapse;"
                    + "             align: center;"
                    + "             top: 50px;"
                    + "             padding: 30px;"
                    + "             cell-spacing: 20px;"
                    + "             margin-left:40px;}"
                    + "          th {"
                    + "             border: 2px solid #04AA6D;"
                    + "             text-align: center;"
                    + "             background-color: #04AA6D;"
                    + "             color: white;"
                    + "             height: 45px;}"
                    + "          .td1{"
                    + "             text-align: center;"
                    + "             padding: 30px;"
                    + "             cell-spacing: 20px;"
                    + "             bottom-border: 1px dotted black;}"
                    + "          .box{"
                    + "             background-color: white;"
                    + "             padding: 5px;"
                    + "             color:white;"
                    + "             border: none;"
                    + "             border-radius: 2px;"
                    + "             text-decoration: none;"
                    + "             margin-left: 250px;"
                    + "             margin-right: 250px;"
                    + "             height: 300px;}"
                    + "           button {\n"
                    + "             background-color: #04AA6D;\n"
                    + "             color: #ffffff;\n"
                    + "             border: none;\n"
                    + "             padding: 10px 20px;\n"
                    + "             font-size: 17px;\n"
                    + "             font-family: Raleway;\n"
                    + "             cursor: pointer;\n"
                    + "             }"
                    + "           .add{"
                    + "             width: 150px;"
                    + "             height: 150px;"
                    + "             border-radius: 4px;"
                    + "             margin-left: 170px;"
                    + "             background-color: #04AA6D;\n"
                    + "             }"
                    + "           .hide {\n"
                    + "             display: none;\n"
                    + "             }"
                    + "           .myDIV:hover + .hide {\n"
                    + "             display: block;\n"
                    + "             color: red;\n"
                    + "             }"
                    + "           .myDIV:active + .hide {\n"
                    + "             display: block;\n"
                    + "             color: red;\n"
                    + "             }"
                    + "     </style>     "
                    + "<body>          "
                    + "<div class=\"w3-sidebar w3-bar-block w3-card w3-animate-left\" style=\"margin-top:50px;  background-color: black; color: white; display:none\" id=\"mySidebar\">"
                    + "             <button class=\"w3-bar-item w3-button w3-large\"                     onclick=\"w3_close()\">Close &times;</button>"
                    + "             <a class=\"w3-bar-item w3-button\" href=\"viewUsers\">View Users</a>"
                    + "             <a class=\"w3-bar-item w3-button\" href=\"viewQuiz\">View Quiz List</a>"
                    + "             <a class=\"w3-bar-item w3-button\" href=\"#\">Settings</a>"
                    + "             <a class=\"w3-bar-item w3-button\" href=\"logout\">Logout</a>"
                    + "         </div>"
                    + "          <div id=\"main\">"
                    + "             <div class=\"w3-bar w3-theme w3-large\">"
                    + "                 <div class=\"w3-center  w3-padding\" style=\"background-color: black; color: white;\">"
                    + "                     <div class=\" w3-margin-top w3-wide w3-hide-medium w3-hide-small\"><div class=\"w3-center\">Quiz<b>Inc</b></div>"
                    + "</div>                 "
                    + "</div>"
                    + "                  <button class=\"w3-bar-item w3-button w3-xlarge\" onclick=\"w3_open()\" id=\"openNav\">&#9776;</button>"
                    + "                 <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-small w3-hover-white w3-padding-16\" href=\"teacher\">Home</a>"
                    + "                 <a class=\"w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right\"></a>"
                    + "                 <a class=\"w3-bar-item w3-button w3-hide-medium w3-padding-16 w3-right\" href=\"#\"><b>" + user + "</b></a>"
                    + "             </div><br><br>"
                    + "<div class='container'>");

            out.println("\n"
                    + "<p class=\"myDIV\">! Click to see format&nbsp&nbsp<img src='quesIcon.png' height=10px width=10px class=\"myDIV\">"
                    + "<img src='ques.PNG' height=95% width=95% class=\"hide\"></p>"
                    + "<form action=\"uploadQuizFilename\" method=\"post\" enctype=\"multipart/form-data\">  \n"
                    + "Select File:<input type=\"file\" name=\"fname\"/><br/><br/>\n"
                    + "<br><input class='w3-btn' type=\"submit\">\n"
                    + "</form></div>");

            out.println("</div>\n"
                    + "\n"
                    + "        <script>\n"
                    + "            function w3_open() {\n"
                    + "                document.getElementById(\"main\").style.marginLeft = \"25%\";\n"
                    + "                document.getElementById(\"mySidebar\").style.width = \"25%\";\n"
                    + "                document.getElementById(\"mySidebar\").style.display = \"block\";\n"
                    + "                document.getElementById(\"openNav\").style.display = 'none';\n"
                    + "            }\n"
                    + "            function w3_close() {\n"
                    + "                document.getElementById(\"main\").style.marginLeft = \"0%\";\n"
                    + "                document.getElementById(\"mySidebar\").style.display = \"none\";\n"
                    + "                document.getElementById(\"openNav\").style.display = \"inline-block\";\n"
                    + "            }\n"
                    + "        </script>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "        <div id=\"main\">\n"
                    + "            <!-- Sidebar -->\n"
                    + "\n"
                    + "            <!-- Overlay effect when opening sidebar on small screens -->\n"
                    + "            <div class=\"w3-overlay w3-hide-large\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n"
                    + "\n"
                    + "            <!-- Main content: shift it to the right by 270 pixels when the sidebar is visible -->\n"
                    + "            <div class=\"w3-main w3-container\" style=\"margin-left:300px;margin-top:50px;margin-right:300px;\">\n"
                    + "\n"
                    + "\n"
                    + "                <!-- END MAIN -->\n"
                    + "            </div>\n"
                    + "\n"
                    + "            <script>\n"
                    + "                // Script to open and close the sidebar\n"
                    + "                function w3_open() {\n"
                    + "                    document.getElementById(\"mySidebar\").style.display = \"block\";\n"
                    + "                    document.getElementById(\"myOverlay\").style.display = \"block\";\n"
                    + "                }\n"
                    + "\n"
                    + "                function w3_close() {\n"
                    + "                    document.getElementById(\"mySidebar\").style.display = \"none\";\n"
                    + "                    document.getElementById(\"myOverlay\").style.display = \"none\";\n"
                    + "                }\n"
                    + "\n"
                    + "                function w3_show_nav(name) {\n"
                    + "                    document.getElementById(\"menuTut\").style.display = \"none\";\n"
                    + "                    document.getElementById(\"menuRef\").style.display = \"none\";\n"
                    + "                    document.getElementById(name).style.display = \"block\";\n"
                    + "                    w3 - open();\n"
                    + "                }\n"
                    + "            </script>\n"
                    + "\n"
                    + "            <script src=\"https://www.w3schools.com/lib/w3codecolor.js\"></script>\n"
                    + "\n"
                    + "            <script>\n"
                    + "                w3CodeColor();\n"
                    + "            </script>\n"
                    + "\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(uploadUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(uploadUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
