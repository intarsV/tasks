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
<body>
<h1>Task list page</h1>
<br>
<form>
    <input id="taskTitle" type="text" style="width: 200px" placeholder="enter new task title...">
    <input id="submit" type="button" value="Add task">
</form>
<span id="message_screen"></span>
<br>
<br>
<table id="table">
    <th>ID</th>
    <th>Task Title</th>
    <th>Task status</th>
    <th></th>
    <tbody id="table_body">
    <tr id="tmp_row" hidden>
        <td id="rawId">0</td>
        <td id="rawTitle">...</td>
        <td>
            <select selected="ACTIVE" onchange="updateValue(this)">
                <c:forEach items="${statusOptions}" var="rawStatusOptions">
                    <option value="${rawStatusOptions.key}">${rawStatusOptions.value}</option>
                </c:forEach>
            </select></td>
        <td id="rawDelete"><a id="delClick" onClick="deleteTask(0)"><img src="${trash_img}" width="25"/></a></td>
    </tr>
    <c:forEach items="${taskData}" var="taskDTO">
        <tr id=${taskDTO.id}>
            <td>${taskDTO.id}</td>
            <td id="activeTaskTitle">${taskDTO.taskTitle}</td>
            <td>
                <select id="selector" onchange="updateValue(this)">
                    <c:forEach items="${statusOptions}" var="statusOptions">
                        <c:choose>
                            <c:when test="${statusOptions.value.equals(taskDTO.statusEnum.toString())}">
                                <option value="${statusOptions.key}" selected>${statusOptions.value}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${statusOptions.key}">${statusOptions.value}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
            <td><a onClick="deleteTask(${taskDTO.id})"><img src="${trash_img}" width="25"/></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<div>
    <strong><a href="/">link</a></strong> back to home.
</div>
</body>
</html>
