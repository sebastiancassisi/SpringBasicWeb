
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src='<c:url value="/res/js/jquery-1.12.3.min.js"></c:url>' ></script>

        </head>
        <body>
            <c:import url="/WEB-INF/views/menu.jsp"></c:import>
            <h1>Direccion.jsp</h1>

        <sf:form action="${pageContext.request.contextPath}/direccion/save" method="post" commandName="direccion">
            <table>

                <tr>
                    <td>Calle</td>
                    <td><sf:input path="calle" type="text"></sf:input></td>                    
                    </tr>
                    <tr>
                        <td>Código Postal</td>
                        <td><sf:input path="cp" type="text"></sf:input></td>                    
                    </tr>     
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Guardar" /></td>                    
                    </tr>     
                </table>                            
        </sf:form>

        <h4><c:out value="${resultado}"></c:out></h4>

        <c:forEach items="${direcciones}" var="direccion">
            <c:out value="${direccion}"></c:out>
                <br/><br/>
        </c:forEach>
        
        
    </body>
</html>
