/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 123
 */
public class student extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String[] user1 = (String[]) session.getAttribute("user1");
            String user = user1[0];
            String sub = user1[1];
            String grp = user1[2];
            String sid = user1[3];

            Class.forName("com.mysql.jdbc.Driver");
            Connection conSt = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
            Statement stmt1 = conSt.createStatement();
            Connection conTe = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
            Statement stmt2 = conTe.createStatement();
            int row = 0;
            

            out.println("<!DOCTYPE html> "
                    + "<html>     "
                    + "<title>Home</title>     "
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">     "
                    + "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">     "
                    + "<style>"
                    + "         .w3-theme {"
                    + "             color:#fff !important;"
                    + "             background-color:#660066; !important}         "
                    + "         .w3-btn {"
                    + "             background-color:#4CAF50;"
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
                    + "             border: 2px solid #660066;"
                    + "             text-align: center;"
                    + "             background-color: #660066;"
                    + "             color: white;"
                    + "             height: 45px;}"
                    + "          .td1{"
                    + "             text-align: center;"
                    + "             padding: 30px;"
                    + "             cell-spacing: 20px;"
                    + "             bottom-border: 1px dotted black;"
                    + "             background-color: white;"
                    + "             }"
                    + "          .td2{"
                    + "             text-align: center;"
                    + "             padding: 30px;"
                    + "             cell-spacing: 20px;"
                    + "             bottom-border: 1px dotted black;"
                    + "             background-color: #fbc9a7"
                    + "             }"
                    + "          .td3{"
                    + "             text-align: center;"
                    + "             padding: 30px;"
                    + "             cell-spacing: 20px;"
                    + "             bottom-border: 1px dotted black;"
                    + "             background-color: #dffdce"
                    + "             }"
                    + "          #del{"
                    + "             background-color: #0099ff;"
                    + "             padding: 5px;"
                    + "             color:white;"
                    + "             border-radius: 2px;"
                    + "             text-decoration: none;}"
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
                    + "             background-color: #660066;\n"
                    + "             }"
                    + "           .st{"
                    + "             width: 150px;"
                    + "             height: 150px;"
                    + "             border-radius: 4px;"
                    + "             margin-left: 40px;"
                    + "             background-color: #660066;\n"
                    + "             }"
                    + "           .te{"
                    + "             width: 150px;"
                    + "             height: 150px;"
                    + "             border-radius: 4px;"
                    + "             margin-left: 40px;"
                    + "             background-color: #660066;\n"
                    + "             }"
                    + "     </style>     "
                    + "<body>          "
                    + "<div class=\"w3-sidebar w3-bar-block w3-card w3-animate-left\" style=\"margin-top:50px;  background-color: black; color: white; display:none\" id=\"mySidebar\">"
                    + "             <button class=\"w3-bar-item w3-button w3-large\"                     onclick=\"w3_close()\">Close &times;</button>"
                    + "             <a class=\"w3-bar-item w3-button\" href=\"sSettings\">Settings</a>"
                    + "             <a class=\"w3-bar-item w3-button\" href=\"logout\">Logout</a>"
                    + "         </div>"
                    + "          <div id=\"main\">"
                    + "             <div class=\"w3-bar w3-theme w3-large\">"
                    + "                 <div class=\"w3-center  w3-padding\" style=\"background-color: black; color: white;\">"
                    + "                     <div class=\" w3-margin-top w3-wide w3-hide-medium w3-hide-small\"><div class=\"w3-center\">Quiz<b>Inc</b></div>"
                    + "</div>                 "
                    + "</div>"
                    + "                  <button class=\"w3-bar-item w3-button w3-xlarge\" onclick=\"w3_open()\" id=\"openNav\">&#9776;</button>"
                    + "                 <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-small w3-hover-white w3-padding-16\" href=\"student\">Home</a>"
                    + "                 <a class=\"w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right\"></a>"
                    + "                 <a class=\"w3-bar-item w3-button w3-hide-medium w3-padding-16 w3-right\" href=\"#\"><b>" + user + "</b></a>"
                    + "             </div><br><br>"
                    + "");

            Date d = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = ft.format(d);

            Timestamp timestamp = Timestamp.valueOf(date);
            Date da = timestamp;
            String sql = "select * from score where sid='" + sid + "'";
            ResultSet rs = stmt1.executeQuery(sql);
            ArrayList<String> q = new ArrayList<String>();
            
            while (rs.next()) {
                q.add(rs.getString("qname"));
            }
            
            sql = "select * from quizlist where grp='" + grp + "'";
            rs = stmt1.executeQuery(sql);
            out.println("<table style='align: center;' class='tb'>");

            out.println("<tr>");
            out.println("<th>");
            out.println("Srno.");
            out.println("</th>");
            out.println("<th>");
            out.println("Quiz");
            out.println("</th>");
            out.println("<th>");
            out.println("Subject");
            out.println("</th>");
            out.println("<th>");
            out.println("Deadline");
            out.println("</th>");
            out.println("<th>");
            out.println("Status");
            out.println("</th>");
            out.println("</tr>");

            int srno = 1;
            
            while (rs.next()) {
                Date subOn = rs.getTimestamp("deadline");
                int status = da.compareTo(subOn);
                if (q.contains(rs.getString("qname"))) {
                    out.println("<tr class='td3'><td class='td3'>" + srno + "</td>");
                    out.print("<td>" + rs.getString("Topic") + "</td>");
                    out.print("<td>" + rs.getString("sub") + "</td>");
                    out.print("<td>" + rs.getTimestamp("deadline") + "</td>");

                    out.print("<td>Attended</td></tr>");
                    
                }
                else if (status <= 0) {
                    String qname = rs.getString("qname");
                    String sre = rs.getString("showResult");
                    String Topic = rs.getString("Topic");
                    String timer = rs.getString("timer");
                    out.println("<tr class='td1'><td class='td1'>" + srno + "</td>");
                    out.print("<td>" + rs.getString("Topic") + "</td>");
                    out.print("<td>" + rs.getString("sub") + "</td>");
                    out.print("<td>" + rs.getTimestamp("deadline") + "</td>");

                    out.print("<td><a id='del' href='startQuiz.jsp?tname=" + qname + "&Topic=" + Topic + "&subject=" + rs.getString("sub") + "&timer=" + timer + "&sre="+ sre+ "'>Attend</a></td></tr>");
                    
                } else {
                    out.println("<tr class='td2'><td class='td2'>" + srno + "</td>");
                    out.print("<td>" + rs.getString("Topic") + "</td>");
                    out.print("<td>" + rs.getString("sub") + "</td>");
                    out.print("<td>" + rs.getTimestamp("deadline") + "</td>");

                    out.print("<td>Past Due Date</td></tr>");
                }

                srno = srno + 1;
            }
            out.println("</table></div>");

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
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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
