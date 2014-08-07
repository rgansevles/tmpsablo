angular.module('sampleApp', ['webSocketModule']).config(function() {
}).controller("MainController", function($scope, $rootScope) {
	$scope.winowTitle = 'Sample Aplication';
	$scope.currentPanel = 'HelloWorld.html';
}).controller( ).controller( )
.run(function($window) {
	$window.alert('Startup')
})
