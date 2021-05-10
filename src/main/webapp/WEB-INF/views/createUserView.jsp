<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Добавить пользователя</h3>

<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/createUser">
    <table border="0">
        <tr>
            <td>Id</td>
            <td><input type="text" name="id" value="${user.id}" /></td>
        </tr>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="model" value="${user.name}" /></td>
        </tr>
        <tr>
            <td>UserPassword</td>
            <td><input type="text" name="price" value="${user.password}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="userList">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>