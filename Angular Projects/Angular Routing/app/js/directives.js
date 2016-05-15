// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/phones',{redirectTo: 'partial/view1.html'})
  .otherwise({redirectTo: '/index.html'});
}]);
