// Declare app level module which depends on views, and components
angular.module("myApp").controller("homeController",function($scope){
	$scope.message="Home Controller Called";
})

.controller("coursesController",function($scope){
	$scope.courses=[{name:'A',id:1},{name:'B',id:2},{name:'C',id:3},{name:'D',id:4},{name:'E',id:5}];
})

.controller("studentController",function($scope){
	$scope.message="Home Controller Called";
})
.controller("coursedetailController",function($scope,$routeParams){
	$scope.courses=$routeParams.course;
});
