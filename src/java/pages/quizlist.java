/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
public class quizlist extends HttpServlet {

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
            throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
            String dt = request.getParameter("dt");
            int t = parseInt(request.getParameter("time"));
            String ap = request.getParameter("ap");

            String qname = request.getParameter("qname");
            String qtype = request.getParameter("qtype");
            String qtimer = request.getParameter("qtime");
            String res = request.getParameter("res");
            String sub = request.getParameter("sub");
            int tid = Integer.parseInt(request.getParameter("tid"));
            String grp = request.getParameter("grp");

            if (ap.equals("pm")) {
                t = t + 12;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = String.valueOf(t) + ":00:00";
            String dateTime = dt + " " + String.valueOf(t) + ":00:00";

            out.println("<b>Quiz name:</b>" + qname + "<br>");
            out.println("<b>Quiz Type:</b>" + qtype + "<br>");
            out.println("<b>Quiz Timer:</b>" + qtimer + "<br>");
            out.println("<b>Result:</b>" + res + "<br>");
            out.println("<b>Subject:</b>" + sub + "<br>");
            out.println("<b>Tid:</b>" + tid + "<br>");
            out.println("<b>Group:</b>" + grp + "<br>");
            out.println("<b>Date:</b>" + dateTime + "<br>");

            Date date = formatter.parse(dateTime);
            java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
            PreparedStatement ps = con.prepareStatement("insert into quizlist (qname, Topic, sub, grp, tid, deadline, quizType, showResult, timer) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, "Quiz");
            ps.setString(2, qname);
            ps.setString(3, sub);
            ps.setString(4, grp);
            ps.setInt(5, tid);
            ps.setTimestamp(6, sqlTime);
            ps.setString(7, qtype);
            ps.setString(8, res);
            ps.setString(9, qtimer);
            ps.executeUpdate();

            int qid = 1;
            int teacherId = 1;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM quizlist");
            while (rs.next()) {
                qid = rs.getInt("qid");
                teacherId = rs.getInt("tid");
            }

            String tb = String.valueOf(qid) + "Quiz" +String.valueOf(teacherId);
            out.println("<br>" +tb);
            String sql = "UPDATE quizlist set qname='" + tb + "' where qid="+ qid;
            stmt.executeUpdate(sql);
            session.setAttribute("tbname", tb);
            response.sendRedirect("createTable");
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
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
