<%--
  Created by IntelliJ IDEA.
  User: RLuchinsky
  Date: 24.05.2018
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>HELLO RESTVOTE</h1>

<h2>На данном этапе - приложение не подразумевает наличие графического интерфеса.</h2>
<p>Через адресную строку бразуера доступны только get запросы возращающие данные в формате JSON</p>
<p>Можно получить список всех пользователей:</p>
<a href="users">/users</a>
<p>Или конкретного пользователя:</p>
<a href="users/100004">/users/100004</a>

<p>Рестораны:</p>
<a href="restaurants">/restaurants</a>
<p>Или конкретный ресторан:</p>
<a href="restaurants/100000">reataurants/100000</a>

<p>меню ресторана:</p>
<a href="menu/100000">/menu/100000</a>
<p>Или конкретное блюдо:</p>
<a href="menu/100000/100005">menu/100000/100005</a>

<h2>Тест put, delete, post запросов - можно осуществить с помощи <a href="https://www.soapui.org/" target="_blank" a>SoupUi</a></h2>
<h2>Так же можно использованть curl команды, из командной строки (примеры команд вы найдете в файле curl.md в папке config проекта)</h2>
</body>
</html>
