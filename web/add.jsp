<%-- 
    Document   : add
    Created on : 6 Jun, 2021, 5:25:28 PM
    Author     : 123
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="questions.questions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int qid = Integer.parseInt(request.getParameter("qid"));
            int marks = Integer.parseInt(request.getParameter("mark"));
            String stat = request.getParameter("stat");
            String corr = request.getParameter("corr");
            String question = request.getParameter("ques");

            questions quest = new questions();

            quest.setQuestion(question);
            quest.setQid(qid);
            quest.setStat(stat);
            quest.setMarks(marks);
            quest.setCorr(corr);

            ArrayList<questions> res = new ArrayList<questions>();

            res = (ArrayList<questions>) session.getAttribute("res");

            if (res == null) {
                res = new ArrayList<questions>();
                res.add(quest);
            } else {
                res.add(quest);
            }
            session.setAttribute("res", res);

            qid = qid + 1;

            String url = "intermediate.jsp?qid=" + qid;

            response.sendRedirect(url);
        %>

    </body>
</html>
