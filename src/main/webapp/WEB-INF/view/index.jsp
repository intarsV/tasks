<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
	<%--   /<link rel="stylesheet" href="/css/styles.css">--%>

		<c:url value="/css/styles.css" var="css_url"/>
		<link href="${css_url}" type="text/css" rel="stylesheet" />
</head>
<body>
		<div>
			<h1>Task scheduling</h1>
			<h2> ${message}</h2>
			Click on this <strong><a href="next">link</a></strong> to visit dummy page.
			Click on this <strong><a href="table">link</a></strong> to visit task table page.
		</div>
</body>
</html>
