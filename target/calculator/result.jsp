<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
 <%
    PrintWriter printWriter = response.getWriter();
    Object result = request.getAttribute("result");
    printWriter.write("Result is " + result.toString());
%>
</body>
</html>
