package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import perf.perf;

public class viewPerformance extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String[] user1 = (String[]) session.getAttribute("user1");
            String user = user1[0];
            String sub = user1[1];
            String grp = user1[2];
            String tid = user1[3];

            String qname = request.getParameter("qname");
            //out.println(grp);
            out.println("<!DOCTYPE html> "
                    + "<!DOCTYPE html> "
                    + "<html>     "
                    + "<title>Home</title>     "
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">     "
                    + "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">     "
                    + "<style>"
                    + "         .w3-theme {"
                    + "             color:#fff !important;"
                    + "             background-color:#009999; !important}         "
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
                    + "          .tb {"
                    + "             width: 70%;"
                    + "             border-collapse: collapse;"
                    + "             align: center;"
                    + "             top: 50px;"
                    + "             padding: 30px;"
                    + "             cell-spacing: 20px;"
                    + "             }"
                    + "          th {"
                    + "             border: 2px solid #009999;"
                    + "             text-align: center;"
                    + "             background-color: #009999;"
                    + "             color: white;"
                    + "             height: 45px;}"
                    + "          .td1{"
                    + "             text-align: center;"
                    + "             padding: 30px;"
                    + "             cell-spacing: 20px;"
                    + "             bottom-border: 1px dotted black;}"
                    + "          #ad{"
                    + "             background-color: #0099ff;"
                    + "             padding: 5px;"
                    + "             color:white;"
                    + "             border-radius: 2px;"
                    + "             text-decoration: none;}"
                    + "          #del{"
                    + "             background-color: #cc0000;"
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
                    + "             background-color: #009999;\n"
                    + "             }"
                    + "           .st{"
                    + "             width: 150px;"
                    + "             height: 150px;"
                    + "             border-radius: 4px;"
                    + "             margin-left: 40px;"
                    + "             background-color: #009999;\n"
                    + "             }"
                    + "           .te{"
                    + "             width: 150px;"
                    + "             height: 150px;"
                    + "             border-radius: 4px;"
                    + "             margin-left: 40px;"
                    + "             background-color: #009999;\n"
                    + "             }"
                    + "     </style>     "
                    + "<body>          "
                    + "<div class=\"w3-sidebar w3-bar-block w3-card w3-animate-left\" style=\"margin-top:50px;  background-color: black; color: white; display:none\" id=\"mySidebar\">"
                    + "             <button class=\"w3-bar-item w3-button w3-large\"                     onclick=\"w3_close()\">Close &times;</button>"
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
                    + " <div class='container'>");

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
            Statement stmt = connection.createStatement();
            String sql = "select * from score where qname='" + qname + "'";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<perf> stud = new ArrayList<perf>();
            ArrayList<Integer> q = new ArrayList<Integer>();
            
            int tm = 0;
            while (rs.next()) {
                perf st = new perf();
                tm = rs.getInt("totalMarks");
                q.add(rs.getInt("sid"));
                //out.println(rs.getString("sname")+", " + rs.getInt("marks"));
                int score = rs.getInt("marks");
                int id = rs.getInt("sid");
                String sname = rs.getString("sname");
                st.setSname(sname);
                st.setTMarks(tm);
                st.setScore(score);
                st.setSid(id);
                st.setStatus("Attended");
                stud.add(st);
            }
            
            

            
            sql = "select * from student where grp='" + grp + "'";
            rs = stmt.executeQuery(sql);

            int qno = 1;
            while (rs.next()) {

                if (q.contains(rs.getInt("sid"))) {
                   // out.println("Hello");
                    
                }
                else{
                    perf st = new perf();
                    int score = 0;
                    int id = rs.getInt("sid");
                    String sname = rs.getString("sname");
                    st.setSname(sname);
                    st.setTMarks(tm);
                    st.setScore(score);
                    st.setSid(id);
                    st.setStatus("Not Attended");
                    stud.add(st);
                }

                qno = qno + 1;
            }
            out.println("<table class='tb'>");
            out.println("<tr>");
            out.println("<th>Srno.</th>");
            out.println("<th>Student Name</th>");
            out.println("<th>Score</th>");
            out.println("<th>Total Marks</th>");
            out.println("<th>Satus</th>");
            out.println("</tr>");
            
            qno = 1;
            for(perf p:stud){
                out.println("<tr class='td1'>");
                out.println("<td class='td1'>"+ qno + "</td>");
                out.println("<td class='td1'>"+ p.getSname() + "</td>");
                out.println("<td class='td1'>"+ p.getScore() + "</td>");
                out.println("<td class='td1'>"+ p.getTMarks() + "</td>");
                out.println("<td class='td1'>"+ p.getStatus() + "</td>");
                out.println("</tr>");
                qno = qno + 1;
            }
            
            out.println("</table>");
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
