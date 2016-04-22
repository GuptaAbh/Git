<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Share Feed</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<form:form action="successfeed" method="post" modelAttribute="feed">
		<div class="form-group">
			<label class="col-md-4 control-label" for="conNum"> Location</label>
			<form:input type="text" id="feedLocation" placeholder="Location"
				path="feedLocation" class="form-control" />
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="conNum"> College
				Name</label>
			<form:input type="text" id="feedcollegeName"
				placeholder="College Name" path="feedcollegeName"
				class="form-control" />
		</div>




		<div class="form-group">
			<label class="col-md-4 control-label" for="conNum">Description
			</label>

			<form:input type="text" placeholder="Description"
				path="feeddescription" class="form-control" />

		</div>
		<div class="form-group">
			<div class="col-sm-4 col-sm-offset-3">
				<button type="submit" class="btn btn-primary btn-block">Update
				</button>
			</div>
		</div>
	</form:form>

	<footer>
	<div style="background-color: white;">
		<%@include file="footer.jsp"%>
	</div>
	</footer>
</body>
<script src="<c:url value="/resources/js/angular.js" />"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html>