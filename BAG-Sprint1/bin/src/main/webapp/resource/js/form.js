

var ajaxApp = angular.module('myApp', ['ngRoute']);
ajaxApp.config(['$routeProvider',function($routeProvider){
	
	$routeProvider
	.when('sample',{
		templateUrl:'resource/js/views/UserDashboard.html'
	})
.when('home',{
templateUrl:'resource/js/views/UserDashboard.html'

}).otherwise({
redirectTo:'home'

});
}]);




ajaxApp.controller("EmployeeController", [ '$scope', '$http', function($scope, $http) {
	
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	$scope.getData = function() {
		$http({
			url : 'employeeServlet',
			method : "GET",			
		}).then(function(response) {
			if(response.data.myArrayList.length == 0) {
				$scope.noEmpRecord = "Yes";
			} else {
				$scope.empList = response.data.myArrayList;
			}
		}, function(response) {
			console.log("Failure -> " + response.data);
			$scope.empList = response.data.myArrayList;
		});
	};
	 $scope.count = 0;
    $scope.check = function() {
        redirectTo:'/home'
    };
} ]);