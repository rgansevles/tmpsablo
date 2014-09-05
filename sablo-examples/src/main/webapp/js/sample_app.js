angular.module('sampleApp', []).config(function() {
}).controller("SampleController", function($scope, $rootScope) {
	$scope.windowTitle = 'Sample Aplication';
	$scope.currentPanel = 'forms/mainForm.html';
}).controller( ).controller( )
.run(function($window) {
	$window.alert('Sample Startup');
});
