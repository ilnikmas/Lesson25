<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Домашняя страница</h3>

<b>Реализованы следующие функции:</b>
<ul>
    <li>Авторизация пользователя</li>
    <li>Получение списка телефонов</li>
    <li>Внесение в БД новой записи</li>
    <li>Редактирование существующей записи</li>
    <li>Удаление записи</li>
</ul>

<a href="createTableMobiles">Создать/пересоздать таблицу MOBILES</a>
<a href="createTableUsers">Создать/пересоздать таблицу USERS</a>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>