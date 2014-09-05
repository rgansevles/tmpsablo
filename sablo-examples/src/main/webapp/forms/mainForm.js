angular.module('sampleApp').controller("mainForm", function($scope, $timeout, $window) {

	$scope.model = {' dataprovider': 'Hi there' };
	
	$window.alert('RAGTEST mainForm');
});
 
