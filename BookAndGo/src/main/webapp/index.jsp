<!DOCTYPE html>
<html>
<head>
<title>AngularJS Routing with Multiple Views Example</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.min.js"></script>


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
	when('/homepage', {
        templateUrl: 'resource/js/views/UserDashboard.jsp',
        controller:'SearchController'
        
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
		var onSuccess = function (data, status, headers, config) {
            alert('Hotel Details saved successfully.');
        };

        var onError = function (data, status, headers, config) {
            alert('Error occured.');
        }
           
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
		$http.get("http://localhost:8080/BnG/rest/BookAndGo/Login/"+userId+"/"+password).then(
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
	//Search Controller
	app.controller('SearchController', function($location,$scope, $http){
		$scope.roomavailable="Room Types available";
		//Loading initial data
		// The data model. These items would normally be requested via AJAX,
			// but are hardcoded here for simplicity. See the next example for
			// tips on using AJAX.
        debugger
		$scope.items = [
			{
				url: 'http://tutorialzine.com/2013/07/50-must-have-plugins-for-extending-twitter-bootstrap/',
				hotel_name: 'Marriot Hotel',
				image:'resource/js/images/marriot.png',
				hotel_address:'2832 Charlotte,NC',
				event_name:'Ladies night',
				room_type:'203,204,205'
			},
			{
				url: 'http://tutorialzine.com/2013/08/simple-registration-system-php-mysql/',
				hotel_name:'',
				image:'resource/js/images/marriot.png',
				hotel_address:'2832 Charlotte,NC',
				event_name:'Ladies night',
					room_type:'203,204,205'
			},
			{
				url: 'http://tutorialzine.com/2013/08/simple-registration-system-php-mysql/',
				hotel_name:'',
				image:'resource/js/images/marriot.png',
				hotel_address:'2832 Charlotte,NC',
				event_name:'Ladies night',
					room_type:'203,204,205'
			}
		];
		
		$scope.onSearch= function(){
			//Search by name
			var searchBy=$scope.searchString;
			$http.get("http://localhost:8080/BnG/rest/BookAndGo/Search/"+searchBy).then(
					function successCallback(response){
						$scope.response = response;
						$scope.items =$scope.response.data;
						if($scope.response.data.length==0){
							$scope.items=[
								{
									hotel_name:"Check your spelling .No details are available."
								}
						];
							$scope.roomavailable='';                  
						}
						
					},function errorCallback(response){
						$scope.response = response;
						$scope.roomavailable='';
						
						
					}	
			
			
			
			);		
			
			
		}
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
