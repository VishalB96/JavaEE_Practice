<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DataServ" method="get">
	<input type="search" name="SearchQuery">
	<input type="submit" value="Search">
</form>

<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ol>
<c:forEach var="loc" items="${loclist}">
<li>
<ul>
<li>${loc.deptno}</li>
<li>${loc.dname}</li>
<li>${loc.loc}</li>
</ul>
</li>
</c:forEach>
</ol>
</body>
</html>