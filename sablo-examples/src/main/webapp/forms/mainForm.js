angular.module('sampleApp').controller("mainForm", function($scope, $window, $sabloApplication) {

	
    var beans = {
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
			thebutton: {callEvent:getExecutor('thebutton')}
	};
	
	$window.alert('RAGTEST mainForm');

	var formProperties = { };

	var formState = $sabloApplication.initFormState('mainForm', beans, formProperties);
	$scope.model = formState.model;
	$scope.api = formState.api;
	$scope.layout = formState.layout;
	$scope.formStyle = formState.style;
	$scope.formProperties = formState.properties;
	$scope.formname = 'mainForm';
	
	var wrapper = function(beanName) {
		return function(newvalue,oldvalue) {
			if(oldvalue !== newvalue) $sabloApplication.sendChanges(newvalue,oldvalue, "mainForm", beanName);
		};
	};
	
	$sabloApplication.requestFormData('mainForm', $scope.model).then(
			   function() {
				   $window.alert('RAGTEST requestFormData resolved');
				   // initial data is loaded, install watches
				   $scope.$watch("model.thetextfield", wrapper('thetextfield'), true);
			   });
});
