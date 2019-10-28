<!DOCTYPE html>
<html>
<head>
<title>AngularJS Routing with Multiple Views Example</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>
<script src="resource/js/controller/Login.js"></script>
<script src="resource/js/controller/Hotel.js"></script>
<script type="text/javascript">
var app = angular.module("myApp", ['ngRoute']);
app.config(['$routeProvider',
function ($routeProvider) {
$routeProvider.when('/login', {
templateUrl: 'resource/js/views/Login.jsp',
controller: 'login_register_controller'
}).
when('/AddMyhotel', {
templateUrl: 'resource/js/views/AddMyhotel.html',
controller: 'hotelController'
}).
otherwise({
redirectTo: '/login'
});
}
]);
app.controller("hotelController", [ '$location','$scope', '$http', function($location,$scope, $http) {
	$scope.message='Testing if hotel controller works';
	}]);
app.controller('login_register_controller', function($location,$scope, $http){
	
   
	 $scope.closeMsg = function(){
	  $scope.alertMsg = false;
	 };

	 $scope.login_form = true;

	 $scope.showRegister = function(){
	  $scope.login_form = false;
	  $scope.register_form = true;
	  $scope.alertMsg = false;
	 };
	 

	 $scope.showLogin = function(){
	  $scope.register_form = false;
	  $scope.login_form = true;
	  $scope.alertMsg = false;
	 };
	 
	 $scope.showLogin= function(){
		 
	      
	 };
	 $scope.submitLogin= function(){
		 debugger
		var userId=$scope.loginData.email;
		var password=$scope.loginData.password;
		$http.get("http://localhost:8081/AngularJsSqlEx/rest/BookAndGo/Login/"+userId+"/"+password).then(
			      function successCallback(response) {
			    	$scope.response = response;
			    	alert($scope.response.data);
			    	$location.path('\AddMyhotel');
			      },
			      function errorCallback(response) {
			    	  debugger
			    	  $scope.response = response;
			    	  alert($scope.response.data);
			        console.log("Unable to perform get request");
			      }
			    );
	 };
	});
</script>
</head>
<body ng-app="myApp">
<h2>Book And Go</h2>
<div>
<ul>
<li>
<a href="#/login">Login</a>
</li>
<li>
<a href="#/AddMyhotel">Add my hotel</a>
</li>
</ul>
<div ng-view></div>
</div>
</body>
</html>