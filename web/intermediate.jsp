<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <body onload="submitForm()">
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
            Statement stmt = connection.createStatement();

            String qname = null;
            qname = (String) session.getAttribute("tname");
            
            String sql = "select * from " + qname;
            ResultSet rs1 = stmt.executeQuery(sql);
            rs1.last();
            int last = rs1.getRow() + 1;

            String qid = request.getParameter("qid");
            
            int q = Integer.parseInt(qid);
            String action = "quiz.jsp";
            if (last == q) {
                  
                  response.sendRedirect("endOfQuiz.jsp"); 
                 
                  
            } else {
                sql = "select * from " + qname + " where qid = " + qid;
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String ques = rs.getString("question");
                    String a = rs.getString("a");
                    String b = rs.getString("b");
                    String c = rs.getString("c");
                    String d = rs.getString("d");
                    String corr = rs.getString("corr");
                    int mark = rs.getInt("mark");
                    out.println(""
                            + "<form id='myform' action='" + action + "' method='post'>"
                            + "<input type='hidden' name='ques' value='" + ques + "'>"
                            + "<input type='hidden' name='a' value='" + a + "'>"
                            + "<input type='hidden' name='b' value='" + b + "'>"
                            + "<input type='hidden' name='c' value='" + c + "'>"
                            + "<input type='hidden' name='d' value='" + d + "'>"
                            + "<input type='hidden' name='qid' value='" + qid + "'>"
                            + "<input type='hidden' name='corr' value='" + corr + "'>"
                            + "<input type='hidden' name='marks' value='" + mark + "'>"
                            + "<input type='hidden' name='last' value='" + last + "'>"
                            + "</form>"
                            + "<script>"
                            + "function submitForm(){"
                            + "document.getElementById('myform').submit();"
                            + "}"
                            + "</script>"
                            + "</body>"
                            + "</html>"
                            + "");
                }
            }

        %>

