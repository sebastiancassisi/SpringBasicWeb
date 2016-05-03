
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
            <c:import url="/WEB-INF/views/menu.jsp"></c:import>
            <h1>Usuario.jsp</h1>

        	<sf:form action="${pageContext.request.contextPath}/usuario/save" method="post" commandName="usuario">
		<table>
			<tr>
				<td>Usuario</td>
				<td> <sf:input path="nombre" type="text"/> </td>
			</tr>
			<tr>
				<td>Contraseña</td>
				<td> <sf:input path="clave" type="password"/> </td>
			</tr>
			<tr>
				<td>Permisos</td>
				<td> <sf:input path="permiso" type="text"/> </td>
			</tr>
			<tr>
				<td></td>
				<td> <input type="submit" value="Guardar cambios" /> </td>
			</tr>
		</table>
	</sf:form>

        <h4><c:out value="${resultado}"></c:out></h4>

	<c:forEach items="${usuarios}" var="usuario">
		<c:out value="${usuario}" /> 
		<br/>
	</c:forEach>
    </body>
</html>
