var ajaxApp = angular.module("myApp", []);

ajaxApp.controller("searchController", [ '$scope', '$http', function($scope, $http) {
	
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	$scope.getData = function() {
		$http({
			url : 'searchServlet',
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
} ]);