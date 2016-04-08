
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src='<c:url value="/res/js/jquery-1.12.3.min.js"></c:url>' ></script>
 <script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery(".confirm").on("click", function(){
			return confirm("Si eliminas este elemento no se podrá recuperar. ¿Continuar?");
		});
	});
</script>
        </head>
        <body>
            <h1>Admin.jsp</h1>

        <sf:form action="${pageContext.request.contextPath}/admin/save" method="post" commandName="admin">
            <table>

                <c:if test="${admin.idAd ne 0}">
                    <sf:input path="idAd" type="hidden"></sf:input>
                    <sf:input path="fechaCreacion" type="hidden"></sf:input>    
                </c:if>

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
            <a class="confirm" href='<c:url value="/admin/${admin.idAd}/delete"></c:url>'>Eliminar</a>
                <br/><br/>

        </c:forEach>
    </body>
</html>
