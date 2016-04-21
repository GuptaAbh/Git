<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<c:url value="/resources/js/angular.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="col-md-4">
		<form class="form-horizontal" method="post" action="signin">
			<div class="form-group">
				<label class="col-md-4 control-label" for="fname">User Name</label>
				<div class="col-md-4">
					<input type="text" name="userName" id="userName"
						placeholder="User Name" class="form-control" required= />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="fname">Password</label>
				<div class="col-md-4">
					<input type="text" required name="password" id="password"
						placeholder="Password" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-1">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</form>
	</div>
	<div style="background-color: white;">
		<%@include file="footer.jsp"%>
	</div>

</body>

<script src="<c:url value="/resources/js/angular.js" />"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	</html>
