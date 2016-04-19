<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="admin">
<head>
<script src="<c:url value="/resources/js/angular.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-controller="admincontroller">
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
				<tr ng-repeat="college in CollegeList">
					<td>{{college.collegeId}}</td>
					<td>{{college.collegeName}}</td>
				</tr>
			</tbody>

		</table>
	</form>



</body>
<script>
	var app = angular.module("admin", []);
	app.controller("admincontroller", function($scope, $http) {
		alert("page load");
		$scope.showCollege = false;
		$scope.addCollegeform = false;
		$scope.viewCollege = function() {
			$scope.addCollegeform = false;
			$http.get('returncollege').success(
					function(data, status, headers, config, response) {
						$scope.CollegeList = data;
						$scope.showCollege = true;
					}).error(function(data, status, header, config) {
				$scope.ResponseDetails = "Data: " + data;
			});
		}

		$scope.showaddCollegeform = function() {
			$scope.showCollege = false;
			$scope.addCollegeform = true;
		}

		$scope.addCollege = function() {
			$http.get('addcollege', {
				params : {
					"collegename" : $scope.collegename
				}
			}).success(function(data, status, headers, config, response) {
				$scope.Details = data;
				alert(data);
				$scope.collegename ="";
				$scope.showCollege = false;
				$scope.addCollegeform = false;
			}).error(function(data, status, header, config) {
				$scope.ResponseDetails = "Data: " + data;
			});
		}

	});
</script>


</html>