<!DOCTYPE html>
<html>
<head>
<title>AngularJS Routing with Multiple Views Example</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>
<script src="resource/js/controller/Login.js"></script>
<script src="resource/js/controller/Hotel.js"></script>
<script src="resource/js/controller/PaymentDetails.js"></script>
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
when('/Register', {
	templateUrl: 'resource/js/views/Register.jsp',
	controller: 'registerController'
	}).
	when('/PaymentDetails', {
		templateUrl: 'resource/js/views/PaymentDetails.jsp',
		controller: 'payment_controller'
		}).
otherwise({
redirectTo: '/login'
});
}
]);
//Registration controller
app.controller("registerController",function($location,$scope,$http){
	
});
app.controller("hotelController", function($location,$scope, $http) {
	
	$scope.hotel_form=true;
	$scope.message={
			hotel_name:'',
			hotel_address:'',
			hotel_contact:'',
			hotel_emailid:''
			
	};
	 $scope.hotelData = angular.copy($scope.message);
	$scope.submitHotel= function(){
		debugger
	
		var onSuccess = function (data, status, headers, config) {
            alert('Hotel Details saved successfully.');
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        }
      //Hotel post request
     // $http.post('http://localhost:8081/AngularJsSqlEx/rest/BookAndGo/AddHotelDetails', JSON.stringify($scope.hotelData)).then(function (response) {
	//if(response.data=="Added"){
		//alert('Hotel Details saved successfully.');
	//}else{
		//alert('Error occured.');
	//}
      //});
        
	}
	
	});
app.controller('login_register_controller', function($location,$scope, $http){
	
   
	 $scope.closeMsg = function(){
	  $scope.alertMsg = false;
	 };

	 $scope.login_form = true;

	 $scope.showRegister = function(){
	  $scope.login_form = false;
	  $scope.register_form = true;
	  $location.path('\Register');
	 };
	 

	 $scope.showLogin = function(){
	  $scope.register_form = false;
	  $scope.login_form = true;
	  $scope.alertMsg = false;
	   };
	 
	 $scope.showLogin= function(){
		 
	      
	 };
	 $scope.submitLogin= function(){
		 
		var userId=$scope.loginData.email;
		var password=$scope.loginData.password;
		$http.get("http://localhost:8080/AngularJsSqlEx/rest/BookAndGo/Login/"+userId+"/"+password).then(
			      function successCallback(response) {
			    	$scope.response = response;
			    	alert($scope.response.data);
			    	$location.path('\AddMyhotel');
			      },
			      function errorCallback(response) {
			    	 
			    	  $scope.response = response;
			    	  alert($scope.response.data);
			        console.log("Unable to perform get request");
			      }
			    );
	 };
	});
app.controller("payment_controller",function($location,$scope,$http){
	$scope.submitLogin= function(){
		  $scope.register_form = false;
		  $scope.login_form = false;
		  $scope.alertMsg = true;
		  $scope.paymentForm=true;
		 // $location.path('\PaymentDetails');
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
<li>
<a href="#/PaymentDetails">PaymentDetails</a>
</li>
</ul>
<div ng-view></div>
</div>
</body>
</html>