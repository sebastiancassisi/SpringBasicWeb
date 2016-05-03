
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login de usuarios</title>
    </head>
    <body>
        <h1>Login</h1>
        <c:if test="${param.error != null}">
            <span style="color:red;">¡Error de credenciales!</span>
        </c:if>
        <form name='f' action="j_spring_security_check" method='POST'>
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type='text' name='usuario' value=''></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type='password' name='clave' /></td>
                </tr>
                <tr>
                    <td>Recordarme</td>
                    <td><input type='checkbox' name='_spring_security_remember_me' checked="checked" /></td>
                </tr>
                <tr>
                    <td><input name="submit" type="submit" value="Accesar" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
