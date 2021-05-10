<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Редактировать запись</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty user}">
    <form method="POST" action="${pageContext.request.contextPath}/editUser">
        <input type="hidden" name="id" value="${user.id}" />
        <table border="0">
            <tr>
                <td>id</td>
                <td style="color:red;">${user.id}</td>
            </tr>
            <tr>
                <td>UserName</td>
                <td><input type="text" name="username" value="${user.username}" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" value="${user.password}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/userList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>