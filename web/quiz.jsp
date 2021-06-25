<%-- 
    Document   : test
    Created on : 31 May, 2021, 8:44:43 PM
    Author     : 123
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    int qid = Integer.parseInt(request.getParameter("qid"));
    String ques = request.getParameter("ques");
    String a = request.getParameter("a");
    String b = request.getParameter("b");
    String c = request.getParameter("c");
    String d = request.getParameter("d");
    String corr = request.getParameter("corr");
    String last = request.getParameter("last");
    int mark = Integer.parseInt(request.getParameter("marks"));

    String[] quizDetails = (String[]) session.getAttribute("quizDetails");
    int timer = Integer.parseInt(quizDetails[5]);
    
    if(timer<30){
        timer = timer*60;
    }

%>
<!DOCTYPE html>
<html lang=en>
    <head>
        <meta charset=UTF-8>
        <style>
            .container {
                margin : 20px auto;
                background-color: white;
                height: 400px;
                width : 100%;
                border-radius: 5px;
                box-shadow: 0px 5px 15px 0px;
                position: relative;
                padding: 20px;
            }
            .tb{
                margin : 20px auto;
                background-color: white;
                height: 300px;
                width : 90%px;
                position: relative;
                padding: 10px;
            }
            #ques{
                font-weight : bold;
                background-color: white;
                align : left;
                position: relative;
                padding: 20px;
            }
            .ans{
                width: 338px;
                align: center;
                height: 100%;
                background-color: #fff;
                border-radius: 8px;
                border: 2px solid #9E77D6;
            }
            .ans:hover{
                background-color:#9E77D6;
            }
            
            .ans:active{
                background-color:#76CBDC;
                border: 2px solid #76CBDC;
            }
            .center {
                margin: 0;
                position: absolute;
                top: 50%;
                left: 50%;
                -ms-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
            }
            .next{
                margin: 0;
                position: absolute;
                top: 50%;
                right: 130px;
                font-size: 30px;
                height: 120px;
                width: 75px;
                border-radius: 5px;
                box-shadow: 0px 5px 15px 0px;
                text-align: center;
                font-weight: bold;
            }
            .prev{
                margin: 0;
                position: absolute;
                top: 50%;
                left: 170px;
                font-size: 30px;
                height: 120px;
                width: 75px;
                border-radius: 5px;
                box-shadow: 0px 5px 15px 0px;
                text-align: center;
                font-weight: bold;
            }
            #myProgress {
                width: 100%;
                background-color: #ddd;
            }

            #myBar {
                width: 1%;
                height: 10px;
                background-color: #9E77D6;
            }
            body{
                height: 100%;
                margin: 0;
                background-image: linear-gradient(to bottom right, #C22ED0, #5FFAE0);
                background-repeat: no-repeat;
                background-attachment: fixed;
            }
        </style>
    </head>
    <body onload="move()">
        <div class="center">
            <div class='container'>
                <table class='tb' width='100%' cellspacing>
                    <tr><td colspan='2'><div id="myProgress">
                                <div id="myBar"></div>
                            </div></td></tr>

                    <tr><td colspan='2'><div id='ques'><%= qid%>. <%= ques%></div></td></tr>

                    <tr align='center' height='25%'>
                        <td padding=20px;><button class='ans' id='A' onclick="check('A')"><%= a%></button></td>
                        <td padding=20px;><button class='ans' id='B' onclick="check('B')"><%= b%></button></td></tr>
                    <tr align='center' height='25%'>
                        <td padding=20px;><br><button class='ans' id='C' onclick="check('C')"><%= c%></button></td>
                        <td padding=20px;><br><button class='ans' id='D' onclick="check('D')"><%= d%></button></td></tr> 

                </table>
            </div>
        </div>
        <script>
            var i = 0;
            function move() {
                if (i == 0) {
                    i = 1;
                    var elem = document.getElementById("myBar");
                    var width = 1;
                    var id = setInterval(frame, <%= timer %>);
                    function frame() {
                        if (width >= 100) {
                            next();
                            clearInterval(id);
                            i = 0;
                        } else if (width >= 90) {
                            width++;
                            elem.style.width = width + "%";
                            elem.style.backgroundcolor = red;
                        } else {
                            width++;
                            elem.style.width = width + "%";

                        }
                    }
                }
            }

            function check(answer) {

                let ans = '<%= corr%>';

                if (answer === ans) {
                    correct();
                } else {
                    wrong();
                }
            }

            function correct() {
                var url = "add.jsp?qid=" + <%= qid%> + "&score=" + '<%= mark%>' + "&stat=correct" + "&ques=" + '<%= ques%>' + "&corr=" + '<%= corr%>' + "&mark=" + '<%= mark%>';
                window.location = url;
            }

            function wrong() {
                var url = "add.jsp?qid=" + <%= qid%> + "&score=" + '<%= 0%>' + "&stat=wrong" + "&ques=" + '<%= ques%>' + "&corr=" + '<%= corr%>' + "&mark=" + '<%= mark%>';
                window.location = url;
            }
            function next() {
                var url = "add.jsp?qid=" + <%= qid%> + "&score=" + '<%= 0%>' + "&stat=notAttended" + "&ques=" + '<%= ques%>' + "&corr=" + '<%= corr%>' + "&mark=" + '<%= mark%>';
                window.location = url;
            }
            function prev() {
            <%
                qid = qid - 2;
            %>
                var url = "intermediate.jsp?qid=" + <%= qid%>;
                window.location = url;
            }
        </script>
    </body>
</html>