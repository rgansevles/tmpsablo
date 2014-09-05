angular.module('sampleApp').controller("mainForm", function($scope, $timeout, $window) {

	$scope.model = {
			thelabel: 	 { dataprovider : 'Hi', dataprovider1 : 'there' }
	};
	
	$window.alert('RAGTEST mainForm');
});
 
