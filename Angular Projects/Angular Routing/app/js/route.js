angular.module("myApp").config(function($routeProvider,$locationProvider){
	$routeProvider
	.when("/home",{
		templateUrl: "templates/Home.html",
			controller: "homeController"
		
	})
	.when("/courses",{
		templateUrl: "templates/Courses.html",
		controller: "coursesController"
	})
	.when("/courses/:course",{
		templateUrl: "templates/CoursesDetail.html",
		controller: "coursedetailController"
	})
	.when("/students",{
		templateUrl: "templates/Student.html",
		controller: "studentController"
	})
	.otherwise({redirectTo: "/home"});
});