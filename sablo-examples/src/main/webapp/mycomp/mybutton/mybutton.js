angular.module('mybutton',[]).directive('mybutton', ['$window',function($window) {  

	return {
		restrict: 'E',
		transclude: true,
		scope: {
			name: "=name",
			model: "=buttonModel",
			handlers: "=sabloHandlers"
		},
		controller: function($scope, $element, $attrs) {
			$scope.style = {width:'100%',height:'100%',overflow:'hidden'};

			// onclick implementation
			$scope.onClick = function onClick(event) {
				$scope.handlers.callEvent('pushed');
			};
		},
		templateUrl: 'mycomp/mybutton/mybutton.html',
		replace: true
	};
}]);
