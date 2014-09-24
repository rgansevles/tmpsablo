angular.module('sampleApp').controller("mainForm", function($scope, $timeout, $window, $sabloApplication) {

	$scope.model = {
			thelabel: 	 { text : 'Initial value' },
			thebutton: 	 { text: 'push me'  },
			thetextfield: 	 { value : 'should be replaced with server data' }
	};
	
	function getExecutor(name, event, args) {
		return function(event, args) {
			return $sabloApplication.getExecutor('mainForm').on(name, event, args);
		};
	}
	
	$scope.handlers = {
			'thebutton': {callEvent:getExecutor('thebutton')}
	};
	
	$window.alert('RAGTEST mainForm');
	
	$sabloApplication.requestFormData('mainForm', $scope.model);
});
