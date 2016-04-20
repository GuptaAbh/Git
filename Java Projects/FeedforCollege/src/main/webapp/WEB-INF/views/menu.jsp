<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="height: 50px;"> 
	<c:choose>
		<c:when test="${not empty sessionScope.user.firstName}">
			<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<a class="navbar-brand" href="home">Feed Share</a> <a
					class="navbar-brand" href="sharefeed">Share</a> <a
					class="navbar-brand" href="viewfeed">View Feed</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="viewupdateprofile"><span
						class="glyphicon glyphicon-edit"></span> Edit Profile</a></li>
				<li><a href="logout"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
				<c:if test="${not empty sessionScope.user.profilepicName}">
					<li><a href="viewupdateprofile" ><img class="img-circle" alt="user" style="width: 70px; height: 50px;"
						src="<c:url value="/images/${sessionScope.user.profilepicName }"/>"
						data-holder-rendered="true" ></a>
						</li>
				</c:if>

			</ul>

			</nav>
		</c:when>
		<c:otherwise>
			<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<a class="navbar-brand" href="home">Feed Share</a> <a
					class="navbar-brand" href="sharefeed">Share</a> <a
					class="navbar-brand" href="viewfeed">View Feed</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="signup"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="signin"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
			</nav>
		</c:otherwise>
	</c:choose>
</body>
</html>