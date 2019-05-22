<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <c:url value="/css/styles.css" var="css_url"/>
    <link href="${css_url}" type="text/css" rel="stylesheet"/>
    <c:url value="/js/tasks.js" var="js_url"/>
    <script type="text/javascript" src="${js_url}"></script>
    <c:url value="/images/trash.png" var="trash_img"/>
</head>
<h1>Task list page</h1>
<br>
<form>
    <input id="taskTitle" type="text" style="width: 200px" placeholder="enter new task title...">
    <input id="submit" type="button" value="Add task">
</form>
<span id="error_screen"></span>
<br>
<br>
<table id="table">
    <th>ID</th>
    <th>Task Title</th>
    <th>Task status</th>
    <th></th>
    <tbody id="table_body">
    <c:forEach items="${taskData}" var="taskDTO">
        <tr id=${taskDTO.id}>
            <td>${taskDTO.id}</td>
            <td>${taskDTO.taskTitle}</td>
            <td>${taskDTO.statusEnum}</td>
            <td><a onClick="DeleteRow(${taskDTO.id})"><img src="${trash_img}" width="25"/></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<div>
    Click on this <strong><a href="/">link</a></strong> to visit previous page.
</div>
</body>
</html>
