<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="menu.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Feed</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Description</th>
			<th>College</th>
			<th>Location</th>
			<th>Date</th>

		</tr>
		<c:forEach var="feed" items="${feedList}">
			<tr>
				<td><c:out value="${feed.getFeeddescription()}"></c:out></td>
				<td><c:out value="${feed.getFeedcollegeName()}"></c:out></td>
				<td><c:out value="${feed.getFeedLocation()}"></c:out></td>
				<td><c:out value="${feed.getFeedDate()}"></c:out></td>
		</c:forEach>
	</table>
</body>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</html>