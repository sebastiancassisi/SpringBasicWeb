
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin.jsp</h1>
         
         <sf:form action="${pageContext.request.contextPath}/admin/save" method="post" commandName="admin">
             <table>
                 <sf:input path="idAd" type="hidden"></sf:input>
                 <sf:input path="fechaCreacion" type="hidden"></sf:input>
                 <tr>
                     <td>Nombre:</td>
                     <td><sf:input path="nombre" type="text"></sf:input></td>                    
                 </tr>
                 <tr>
                     <td>Cargo:</td>
                     <td><sf:input path="cargo" type="text"></sf:input></td>                    
                 </tr>     
                 <tr>
                     <td></td>
                     <td><input type="submit" value="Guardar" /></td>                    
                 </tr>     
             </table>                            
         </sf:form>
         
        <h4><c:out value="${resultado}"></c:out></h4>
        
        <c:forEach items="${admins}" var="admin">
            <c:out value="${admin}"></c:out>
            <a href='<c:url value="/admin/${admin.idAd}/update"></c:url>'>Actualizar</a>
            <br/><br/>
            
        </c:forEach>
    </body>
</html>
