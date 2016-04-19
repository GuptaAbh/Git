<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Insert title here</title>
</head>
<body ng-controller="myCTRL">


	<form:form class="form-horizontal" modelAttribute="registereduser"
		method="post" action="registeruser">
		<legand align="center">Registration Form</legand>
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
				<form:input type="text" id="firstName" placeholder="User Name"
					path="userName" class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-4 control-label" for="email">Email</label>
			<div class="col-md-4">
				<form:input type="text" id="email" placeholder="Email Addresss"
					path="email" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label" for="name">College</label>
			<div class="col-md-4">
				<form:select path="collegename" class="form-control">
					<div class="col-md-4">
						<form:option ng-repeat="college in Details" class="form-control"
							value="{{college.collegeName}}">{{college.collegeName}}</form:option>
					</div>
				</form:select>
				</br>
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
			<label class="col-md-4 control-label" for="secQ">Security
				Quesion</label>
			<div class="col-md-4">
				<form:input type="text" id="secQ"
					placeholder="Enter Security Question" path="secQuestion"
					class="form-control" />
			</div>
		</div>


		<div class="form-group">
			<label class="col-md-4 control-label" for="secA">Enter Answer</label>
			<div class="col-md-4">
				<form:input type="text" id="secA" placeholder="Enter Answer"
					path="secAnswer" class="form-control" />
			</div>
		</div>


		<div class="form-group">
			<label class="col-md-4 control-label" for="name">Password</label>
			<div class="col-md-4">
				<form:input type="text" id="password" placeholder="Password"
					path="password" class="form-control" />
			</div>
		</div>


		<div class="form-group">
			<label class="col-md-4 control-label" for="name">Confirm
				Password</label>
			<div class="col-md-4">
				<form:input type="text" id="firstName"
					placeholder="Confirm Password" path="confirmPassword"
					class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-4 col-sm-offset-3">
				<button type="submit" class="btn btn-primary btn-block">Register</button>
			</div>
		</div>
	</form:form>
</body>
<script src="<c:url value="/resources/js/angular.js" />"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	var myApp = angular.module("myApp", []);
	myApp.controller("myCTRL", function($scope, $http) {
		$http.get('returncollege').success(
				function(data, status, headers, config, response) {
					$scope.Details = data;
				}).error(function(data, status, header, config) {
			$scope.ResponseDetails = "Data: " + data;
		});
	});
</script>
</html>