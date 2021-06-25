package pages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class login extends HttpServlet {

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
            String email = request.getParameter("email");
            String psw = request.getParameter("password");
            String ut = request.getParameter("ut");
            String page = "login1.html";
            HttpSession session = request.getSession();
            String name = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
            Statement stmt = connection.createStatement();
            if (ut.equals("admin")) {
                ResultSet rs = stmt.executeQuery("select * from admin");

                while (rs.next()) {

                    String eml = rs.getString("email");
                    String pswd = rs.getString("password");
                    String username = rs.getString("aname");
                    out.println(username);
                    if (email.equals(eml) & psw.equals(pswd)) {
                        page = "Admin";
                        out.println(username);
                        session.setAttribute("user1", username);
                    }

                }
            }
            if (ut.equals("student")) {
                ResultSet rs = stmt.executeQuery("select * from student");
                
                while (rs.next()) {

                    String eml = rs.getString("email");
                    String pswd = rs.getString("password");
                    String sub = rs.getString("sub");
                    String grp = rs.getString("grp");
                    String username = rs.getString("sname");
                    String sid = String.valueOf(rs.getInt("sid"));
                    out.println(username);
                    if (email.equals(eml) & psw.equals(pswd)) {
                        String [] user = new String[4];
                        user[0] = username;
                        user[1] = sub;
                        user[2] = grp;
                        user[3] = sid;
                        page = "student";
                        session.setAttribute("user1", user);
                    }

                }
            }
            if (ut.equals("teacher")) {
                ResultSet rs = stmt.executeQuery("select * from teacher");

                while (rs.next()) {

                    String eml = rs.getString("email");
                    String pswd = rs.getString("password");
                    String grp = rs.getString("grp");
                    String sub = rs.getString("sub");
                    String username = rs.getString("tname");
                    String tid = String.valueOf(rs.getInt("tid"));
                    out.println(username);
                    if (email.equals(eml) & psw.equals(pswd)) {
                        String [] user = new String[4];
                        user[0] = username;
                        user[1] = sub;
                        user[2] = grp;
                        user[3] = tid;
                        page = "teacher";
                        session.setAttribute("user1", user);
                    }

                }
            }

            response.sendRedirect(page);
        }
    }

    /*if(eml.equals(email) & pswd.equals(psw)){
                        page = "Admin.jsp";
                        name = username;
                        
                }
            }
            session.setAttribute("user", name);
            out.println(name);
            response.sendRedirect(page);
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
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
