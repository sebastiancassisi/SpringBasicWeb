<%-- 
    Document   : about
    Created on : 25/03/2016, 12:03:24
    Author     : ANTI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="/WEB-INF/views/menu.jsp"></c:import>
        <h1>About.jsp</h1>
         Atributos del Model: <c:out value="${mensaje}" /> <br/>
	Atributos en Session <c:out value="${sessionScope.resultado}"/>
    </body>
</html>
