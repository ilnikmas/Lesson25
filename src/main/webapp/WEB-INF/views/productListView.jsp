<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список телефонов</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Список телефонов</h3>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Id</th>
        <th>Model</th>
        <th>Price</th>
        <th>Manufacturer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${productList}" var="mobile" >
        <tr>
            <td>${mobile.id}</td>
            <td>${mobile.model}</td>
            <td>${mobile.price}</td>
            <td>${mobile.manufacturer}</td>
            <td>
                <a href="editProduct?id=${mobile.id}">Edit</a>
            </td>
            <td>
                <a href="deleteProduct?id=${mobile.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="createProduct" >Добавить запись</a>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>