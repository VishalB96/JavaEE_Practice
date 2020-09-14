<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ol>
<%=request.getAttribute("rollNo") %>
<c:forEach var="str" items='${rollno}'>
	<li>${str}</li>
</c:forEach>
</ol>
