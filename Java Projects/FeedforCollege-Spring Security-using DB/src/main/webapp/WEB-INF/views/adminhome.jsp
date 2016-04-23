<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%@include file="menu.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="admin">
<head>
<script src="<c:url value="/resources/js/angular.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body ng-controller="admincontroller">
	<h3>
		Welcome
		<c:out value="${sessionScope.user.firstName}"></c:out>
	</h3>

	<a href="#" ng-click="showaddCollegeform()">Add College</a>
	<a href="#" ng-click="viewCollege()">View College</a>
	<form ng-show="addCollegeform">
		<input type="text" ng-model="collegename"> <input
			type="button" value="Submit" ng-click="addCollege()">
		</button>
	</form>


	<form id="college" ng-show="showCollege">
		<table>
			<thead>
				<tr>
					<th>College Id</th>
					<th>College Name</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="college in CollegeList | limitTo:test">
					<td><input ng-readonly="true" type="text"
						value="{{college.collegeId}}" /></td>
					<td><input ng-readonly="update"
						value="{{college.collegeName}}" /></td>
					<td ng-click="updateclick()" ng-show="updatebutton"><input
						type="button" value="Update Record"></td>
					<td ng-show="savebutton({{college.collegeId}})"><input
						type="button" value="Save Record"></td>
				</tr>
			</tbody>
			<td><input type="button" ng-click="showmore()"
				value="show 2 more"></td>

		</table>

	</form>


</body>
<script>
	var app = angular.module("admin", []);
	app.controller("admincontroller", function($scope, $http) {
		$scope.update = true;
		$scope.test = 2;
		$scope.savebutton = false;
		$scope.updatebutton = true;
		$scope.showCollege = false;
		$scope.addCollegeform = false;
		$scope.viewCollege = function() {
			$scope.addCollegeform = false;
			$http.get('returncollege').success(
					function(data, status, headers, config, response) {
						$scope.CollegeList = data;
						alert(data.length);
						$scope.showCollege = true;
					}).error(function(data, status, header, config) {
				$scope.ResponseDetails = "Data: " + data;
			});
		}

		$scope.showmore = function() {
			$scope.test = $scope.test + 2;
		}

		$scope.showaddCollegeform = function() {
			$scope.showCollege = false;
			$scope.addCollegeform = true;
		}

		$scope.updateclick = function() {
			$scope.update = false;
			$scope.savebutton = true;
			$scope.updatebutton = false;

		}

		$scope.addCollege = function() {
			$http.get('addcollege', {
				params : {
					"collegename" : $scope.collegename
				}
			}).success(function(data, status, headers, config, response) {
				$scope.Details = data;
				alert(data);
				$scope.collegename = "";
				$scope.showCollege = false;
				$scope.addCollegeform = false;
			}).error(function(data, status, header, config) {
				$scope.ResponseDetails = "Data: " + data;
			});
		}

	});
</script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</html>