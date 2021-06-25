<%-- 
    Document   : endOfQuiz
    Created on : 5 Jun, 2021, 8:44:54 PM
    Author     : 123
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@ page import ="questions.questions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String[] quizDetails = (String[]) session.getAttribute("quizDetails");
            String rest = quizDetails[6];
            String[] user1 = (String[]) session.getAttribute("user1");
            String user = user1[0];      
            
            if(rest.equals("no")){
                int marks = 0;
                ArrayList<questions> res = (ArrayList<questions>) session.getAttribute("res");
                if (res == null) {
                } else {

                    for (questions q : res) {
                        if (q.getStat().equals("correct")) {
                            marks = marks + q.getMarks();
                        }
                        else if (q.getStat().equals("wrong")) {
                        }
                        else{
                        }
                            
                    }
                }
                String sname = user1[0];
                String grp = user1[2];
                String sid = user1[3];

                quizDetails = (String[]) session.getAttribute("quizDetails");
                String qname = quizDetails[0];
                String Topic = quizDetails[1];
                String sub = quizDetails[2];
                int total = Integer.parseInt(quizDetails[3]);
                String date = quizDetails[4];

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d = formatter.parse(date);
                java.sql.Timestamp sqlTime = new java.sql.Timestamp(d.getTime());

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");

                PreparedStatement ps = connection.prepareStatement("insert into score (sid, sname, qname, Topic, sub, grp, marks, totalMarks, subOn) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, sid);
                ps.setString(2, sname);
                ps.setString(3, qname);
                ps.setString(4, Topic);
                ps.setString(5, sub);
                ps.setString(6, grp);
                ps.setInt(7, marks);
                ps.setInt(8, total);
                ps.setTimestamp(9, sqlTime);

                ps.executeUpdate();
                response.sendRedirect("student");
            }else{
            
        %>
        <meta name="viewport" content="width=device-width, initial-scale=1">     
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">     
        <style>
            .w3-theme {
                color:#fff !important;
                background-color:#660066; !important}         
            .w3-btn {
                background-color:#4CAF50;
                margin-bottom:4px}         
            .w3-code{
                border-left:4px solid #4CAF50}         
            .myMenu {
                margin-bottom:150px}          
            .grid-container {             
                display: grid;             
                grid-template-columns: auto auto auto auto;
                padding: 10px;
                margin-left: 20px;
                margin-right: 20px;
                margin-top: 20px;}
            .grid-item {
                background-color: #99003d;
                border: none;
                padding: 30px;
                font-size: 30px;
                text-align: center;
                color: white;
                margin: 20px;
                width: 300px;
                heigth: 300px;}
            .container{
                margin-left: 40px;
                margin-top: 40px;
                padding: 20px;}
            .tble{
                cell-spacing: 20px;}
            .tb {
                width: 70%;
                border-collapse: collapse;
                align: center;
                top: 50px;
                padding: 30px;
                cell-spacing: 20px;
                margin-left:40px;}
            th {
                border: 2px solid #660066;
                text-align: center;
                background-color: #660066;
                color: white;
                height: 45px;}
            .td1{
                text-align: center;
                padding: 30px;
                cell-spacing: 20px;
                bottom-border: 1px dotted black;
                background-color: white;
            }
            .td2{
                text-align: center;
                padding: 30px;
                cell-spacing: 20px;
                bottom-border: 1px dotted black;
                background-color: #fbc9a7
            }
            .td3{
                text-align: center;
                padding: 30px;
                cell-spacing: 20px;
                bottom-border: 1px dotted black;
                background-color: #dffdce
            }
            #del{
                background-color: #0099ff;
                padding: 5px;
                color:white;
                border-radius: 2px;
                text-decoration: none;}
            .box{
                background-color: white;
                padding: 5px;
                color:white;
                border: none;
                border-radius: 2px;
                text-decoration: none;
                margin-left: 250px;
                margin-right: 250px;
                height: 300px;}
            button {
                background-color: #04AA6D;
                color: #ffffff;
                border: none;
                padding: 10px 20px;
                font-size: 17px;
                font-family: Raleway;
                cursor: pointer;
            }
            .add{
                width: 150px;
                height: 150px;
                border-radius: 4px;
                margin-left: 170px;
                background-color: #660066;
            }
            .st{
                width: 150px;
                height: 150px;
                border-radius: 4px;
                margin-left: 40px;
                background-color: #660066;\n
            }
            .te{
                width: 150px;
                height: 150px;
                border-radius: 4px;
                margin-left: 40px;
                background-color: #660066;
            }
        </style>     
    <body>          
        <div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="margin-top:50px;  background-color: black; color: white; display:none" id="mySidebar">
            <button class="w3-bar-item w3-button w3-large"                     onclick="w3_close()">Close &times;</button>
            <a class="w3-bar-item w3-button" href="#">Settings</a>
            <a class="w3-bar-item w3-button" href="logout">Logout</a>
        </div>
        <div id="main">
            <div class="w3-bar w3-theme w3-large">
                <div class="w3-center  w3-padding" style="background-color: black; color: white;">
                    <div class=" w3-margin-top w3-wide w3-hide-medium w3-hide-small"><div class="w3-center">Quiz<b>Inc</b></div>
                    </div>                 
                </div>
                <button class="w3-bar-item w3-button w3-xlarge" onclick="w3_open()" id="openNav">&#9776;</button>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-small w3-hover-white w3-padding-16" href="student">Home</a>
                <a class="w3-bar-item w3-button w3-hide-medium w3-hover-white w3-padding-16 w3-right"></a>
                <a class="w3-bar-item w3-button w3-hide-medium w3-padding-16 w3-right" href="#"><b><%= user%></b></a>
            </div><br><br>

            <%
                int marks = 0;
                ArrayList<questions> res = (ArrayList<questions>) session.getAttribute("res");
                if (res == null) {
                    out.println("<h1>No questions attended</h1>");
                } else {

                    out.println("<div class='container'>"
                            + "<table>");
                    out.println("<tr>");
                    out.println("<th>Qno.</th>");
                    out.println("<th>Question</th>");
                    out.println("<th>Your Answer</th>");
                    out.println("<th>Correct Answer</th>");
                    out.println("<th>Marks</th>");
                    out.println("</tr>");
                    for (questions q : res) {
                        if (q.getStat().equals("correct")) {
                            marks = marks + q.getMarks();
                            out.println("<tr class='td3'>");
                            out.println("<td class='td3'>" + q.getQid() + "</td>");
                            out.println("<td>" + q.getQuestion() + "</td>");
                            out.println("<td>Correct</td>");
                            out.println("<td>" + q.getCorr() + "</td>");
                            out.println("<td>" + q.getMarks() + "</td>");
                            out.println("</tr>");
                        }
                        else if (q.getStat().equals("wrong")) {
                            out.println("<tr class='td2'>");
                            out.println("<td class='td2'>" + q.getQid() + "</td>");
                            out.println("<td>" + q.getQuestion() + "</td>");
                            out.println("<td>Wrong</td>");
                            out.println("<td>" + q.getCorr() + "</td>");
                            out.println("<td>" + q.getMarks() + "</td>");
                            out.println("</tr>");
                        }
                        else{
                            out.println("<tr class='td1'>");
                            out.println("<td class='td1'>" + q.getQid() + "</td>");
                            out.println("<td>" + q.getQuestion() + "</td>");
                            out.println("<td>Not Attended</td>");
                            out.println("<td>" + q.getCorr() + "</td>");
                            out.println("<td>" + q.getMarks() + "</td>");
                            out.println("</tr>");
                        }
                            
                    }
                    out.println("</table></div>");
                    out.println("<h1>Score = " + marks + " </h1>");
                }
                String sname = user1[0];
                String grp = user1[2];
                String sid = user1[3];

                quizDetails = (String[]) session.getAttribute("quizDetails");
                String qname = quizDetails[0];
                String Topic = quizDetails[1];
                String sub = quizDetails[2];
                int total = Integer.parseInt(quizDetails[3]);
                String date = quizDetails[4];

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d = formatter.parse(date);
                java.sql.Timestamp sqlTime = new java.sql.Timestamp(d.getTime());

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizinc", "root", "");

                PreparedStatement ps = connection.prepareStatement("insert into score (sid, sname, qname, Topic, sub, grp, marks, totalMarks, subOn) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, sid);
                ps.setString(2, sname);
                ps.setString(3, qname);
                ps.setString(4, Topic);
                ps.setString(5, sub);
                ps.setString(6, grp);
                ps.setInt(7, marks);
                ps.setInt(8, total);
                ps.setTimestamp(9, sqlTime);

                ps.executeUpdate();
                }
            %>

        </div>

        <script>
            function w3_open() {
                document.getElementById("main").style.marginLeft = "25%";
                document.getElementById("mySidebar").style.width = "25%";
                document.getElementById("mySidebar").style.display = "block";
                document.getElementById("openNav").style.display = 'none';
            }
            function w3_close() {
                document.getElementById("main").style.marginLeft = "0%";
                document.getElementById("mySidebar").style.display = "none";
                document.getElementById("openNav").style.display = "inline-block";
            }
        </script>



        <div id="main">
            <!-- Sidebar -->

            <!-- Overlay effect when opening sidebar on small screens -->
            <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

            <!-- Main content: shift it to the right by 270 pixels when the sidebar is visible -->
            <div class="w3-main w3-container" style="margin-left:300px;margin-top:50px;margin-right:300px;">


                <!-- END MAIN -->
            </div>

            <script>
                // Script to open and close the sidebar
                function w3_open() {
                    document.getElementById("mySidebar").style.display = "block";
                    document.getElementById("myOverlay").style.display = "block";
                }

                function w3_close() {
                    document.getElementById("mySidebar").style.display = "none";
                    document.getElementById("myOverlay").style.display = "none";
                }

                function w3_show_nav(name) {
                    document.getElementById("menuTut").style.display = "none";
                    document.getElementById("menuRef").style.display = "none";
                    document.getElementById(name).style.display = "block";
                    w3 - open();
                }
            </script>

            <script src="https://www.w3schools.com/lib/w3codecolor.js"></script>

            <script>
                w3CodeColor();
            </script>
    </body>
</html>
