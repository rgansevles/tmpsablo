angular.module('sampleApp').controller("mainForm", function($scope, $timeout, $window, $sabloApplication) {

	$scope.model = {
			thelabel: 	 { dataprovider : 'Hi', dataprovider1 : 'there' }
	};
	
	$window.alert('RAGTEST mainForm');
	
	$sabloApplication.requestFormData('mainForm', $scope.model);
});
