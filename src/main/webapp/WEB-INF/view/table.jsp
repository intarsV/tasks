<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <c:url value="/css/styles.css" var="css_url"/>
    <link href="${css_url}" type="text/css" rel="stylesheet"/>
    <c:url value="/js/getTasksMocked.js" var="js_url"/>
    <script type="text/javascript" src="${js_url}"></script>
</head>
<h1>Table page</h1>
<br>
<p id="showData"></p>
<div>
    Click on this <strong><a href="/">link</a></strong> to visit previous page.
</div>
</body>
</html>
