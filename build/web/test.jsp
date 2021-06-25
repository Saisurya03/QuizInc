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
                margin: 0;
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
                    <div id="myProgress">
                                <div id="myBar"></div>
                            </div>
                    <tr><td colspan='2'><div id='ques'>What does HTML stand for?</div></td></tr>

                    <tr align='center' height='25%'>
                        <td padding=20px;><button class='ans' id='A' onclick="check('A')">hgvdshgsdv</button></td>
                        <td padding=20px;><button class='ans' id='B' onclick="check('B')">mzsvbdbehf</button></td></tr>
                    <tr align='center' height='25%'>
                        <td padding=20px;><br><button class='ans' id='C' onclick="check('C')">jshgdkjefh</button></td>
                        <td padding=20px;><br><button class='ans' id='D' onclick="check('D')">jasgdkjsf</button></td></tr> 

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
                    var id = setInterval(frame, 10);
                    function frame() {
                        if (width >= 100) {
                            next();
                            clearInterval(id);
                            i = 0;
                        } else if (width >= 90) {
                            width++;
                            elem.style.width = width + "%";
                            elem.style.backgroundcolor = "#e60000";
                        } else {
                            width++;
                            elem.style.width = width + "%";

                        }
                    }
                }
            }


        </script>
    </body>
</html>