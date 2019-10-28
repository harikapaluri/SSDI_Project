'use strict';

var ajaxApp = angular.module('myApp', ['ngRoute']);
ajaxApp.config(function($routeProvider){
	
	$routeProvider
	.when('/Login',{
		templateUrl:'resource/js/views/Login.jsp',
		controller:'login_register_controller'
	})
	.when('/hotel',{
templateUrl:'resource/js/views/AddMyhotel.html',


}).when('/search',{
		templateUrl:'resource/js/views/UserDashboard.html',
		

		
	})
.when('/home',{
templateUrl:'index.jsp',
controller:'searchController'

}).otherwise({
redirectTo:'/home'

});
});



