angular.module('sampleApp').controller("mainForm", function($scope, $timeout, $window, $sabloApplication) {

	$scope.model = {
			thelabel: 	 { somestring : 'Hi', somenumber : 42 }
	};
	
	$window.alert('RAGTEST mainForm');
	
	$sabloApplication.requestFormData('mainForm', $scope.model);
});
