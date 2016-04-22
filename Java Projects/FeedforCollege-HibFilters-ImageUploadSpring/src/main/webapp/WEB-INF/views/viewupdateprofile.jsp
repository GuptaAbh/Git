<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Details</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<center>
		<form:form class="form-group" action="picpic" method="post"
			modelAttribute="fileObj" enctype="multipart/form-data">
			<img class="img-circle" alt="140x140"
				style="width: 150px; height: 150px;"
				src="<c:url value="/images/${sessionScope.user.profilepicName }"/>"
				data-holder-rendered="true">
			<table>
				<tr>
					<td><div>
							<label>Change Profile Photo(Max 5MB): </label>
							<form:input path="fileabc" name="fileabc" type="file" /></td>
				</tr>
			</table>
			<div>
				<input style="padding-right: 10px;" id="bigbutton" type="submit"
					value="Upload" /> <br> <br>
			</div>
		</form:form>
	</center>
	<form:form class="form-horizontal" modelAttribute="registereduser"
		method="post" action="updateuser" enctype="multipart/form-data">
		<fieldset>
			<legend align="center">Update Details</legend>
			
			<form:input style="display:none;" readonly="true" type="text" id="userId"
				placeholder="userId" path="userId" class="form-control" />
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="fname">First Name</label>
				<div class="col-md-4">
					<form:input type="text" id="firstName" placeholder="First Name"
						path="firstName" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="lname">Last Name</label>
				<div class="col-md-4">
					<form:input type="text" id="laseName" placeholder="Last Name"
						path="lastName" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="username">User
					Name</label>
				<div class="col-md-4">
					<form:input readonly="true" type="text" id="firstName"
						placeholder="User Name" ng-model="username" path="userName"
						class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="email">Email</label>
				<div class="col-md-4">
					<form:input readonly="true" type="text" id="email"
						placeholder="Email Addresss" ng-model="email" path="email"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="conNum">Contact
					Number</label>
				<div class="col-md-4">
					<form:input type="text" id="conNum" placeholder="Contact Number"
						path="contactNum" class="form-control" />
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-3">
					<button type="submit" class="btn btn-primary btn-block">Update</button>
				</div>
			</div>
			<fieldset>
	</form:form>
	<footer>
	<div style="background-color: white;">
		<%@include file="footer.jsp"%>
	</div>
	</footer>
</body>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</html>