// app.js
// create angular app

var validationApp = angular.module('validationApp', []);

// create angular controller
validationApp.controller('payment_controller', function($scope, $http) {
	$scope.submitForm=function(){		
   var name=$scope.name;
		
		$http.get("http://localhost:8080/AngularJsSqlEx/rest/BookAndGo/PaymentDetails/"+name).then(
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
  
  it('should check ng-bind', function() {
  var nameInput = element(by.model('bookid'));

  expect(element(by.binding('bookid')).getText()).toBe('Whirled');
  nameInput.clear();
  nameInput.sendKeys('world');
  expect(element(by.binding('bookid')).getText()).toBe('world');
});

it('should check ng-bind', function() {
  var nameInput = element(by.model('paymentid'));

  expect(element(by.binding('paymentid')).getText()).toBe('Whirled');
  nameInput.clear();
  nameInput.sendKeys('world');
  expect(element(by.binding('paymentid')).getText()).toBe('world');
});

it('should check ng-bind', function() {
  var nameInput = element(by.model('roomprice'));

  expect(element(by.binding('roomprice')).getText()).toBe('Whirled');
  nameInput.clear();
  nameInput.sendKeys('world');
  expect(element(by.binding('roomprice')).getText()).toBe('world');
});
  

});
