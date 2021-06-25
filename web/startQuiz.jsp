<%-- 
    Document   : startQuiz
    Created on : 4 Jun, 2021, 12:14:38 PM
    Author     : 123
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");
            Statement stmt = connection.createStatement();
            
            String qname = request.getParameter("tname");
            
            String sql = "select * from " + qname;
            ResultSet rs = stmt.executeQuery(sql);
            
            int total = 0; 
            while (rs.next()) {
                    int mark = rs.getInt("mark");
                    total = total + mark;
                }
            
            Date d = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
            String date = ft.format(d); 
            
            String Topic = request.getParameter("Topic");
            String sub = request.getParameter("subject");
            String timer = request.getParameter("timer");
            String sre = request.getParameter("sre");

            String[] quizdDetails = new String[7];
            quizdDetails[0] = qname;
            quizdDetails[1] = Topic;
            quizdDetails[2] = sub;
            quizdDetails[3] = String.valueOf(total);
            quizdDetails[4] = date;
            quizdDetails[5] = timer;
            quizdDetails[6] = sre;

            session.setAttribute("tname", qname);
            session.setAttribute("quizDetails", quizdDetails);
            out.print("<h1><a href='intermediate.jsp?qid=1&score=0'>Click to start Quiz</a></h1>");
        %>

    </body>
</html>