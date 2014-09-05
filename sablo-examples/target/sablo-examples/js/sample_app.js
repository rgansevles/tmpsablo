angular.module('sampleApp', ['sablo', 'mylabel']).config(function() {
}).controller("SampleController", function($scope, $rootScope, $window, $sabloApplication) {
	$scope.windowTitle = 'Sample Aplication';
	$scope.currentPanel = 'forms/mainForm.html';
	
	$window.alert('Connecting...');
	$sabloApplication.connect();
})
.run(function($window) {
	$window.alert('Sample Startup');
});
