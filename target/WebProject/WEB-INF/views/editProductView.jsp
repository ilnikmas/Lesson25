<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Редактировать запись</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty mobile}">
    <form method="POST" action="${pageContext.request.contextPath}/editProduct">
        <input type="hidden" name="id" value="${mobile.id}" />
        <table border="0">
            <tr>
                <td>id</td>
                <td style="color:red;">${mobile.id}</td>
            </tr>
            <tr>
                <td>Model</td>
                <td><input type="text" name="model" value="${mobile.model}" /></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" value="${mobile.price}" /></td>
            </tr>
            <tr>
                <td>Manufacturer</td>
                <td><input type="text" name="manufacturer" value="${mobile.manufacturer}" /></td>
            </tr>
            <tr>
                <td colspan = "2">
                    <input type="submit" value="Submit" />
                    <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>