<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.*" %>
	<ol>
	
	<c:forEach var="pro" items="${viewproduct}">
	<li>
	<ul>
	<li>${pro.pid}</li>
	<li>${pro.pname}</li>
	<li>${pro.qty}</li>
	<li>${pro.price}</li>
	</ul>
	</li>
	</c:forEach>
	
	</ol>
	
	<a href="Home.jsp">Home</a>
	