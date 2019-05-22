<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <c:url value="/css/styles.css" var="css_url"/>
    <link href="${css_url}" type="text/css" rel="stylesheet"/>
</head>
<body>
<div>
    <div>
        <h1>Dummy page</h1>
        <h2>${message}</h2>
        <h3 id="dummy_h3">${messageBack}</h3>
        Click on this <strong><a href="/">link</a></strong> to visit previous page.
    </div>
</div>
</body>
</html>
