angular.module('sampleApp').controller("mainForm", function($scope, $timeout, $window, $sabloApplication) {

	$scope.model = {
			thelabel: 	 { text : 'Initial value' },
			thebutton: 	 { text: 'push me'  },
			thetextfield: 	 { value : 'should be replaced with server data' }
	};
	
	$window.alert('RAGTEST mainForm');
	
	$sabloApplication.requestFormData('mainForm', $scope.model);
});
