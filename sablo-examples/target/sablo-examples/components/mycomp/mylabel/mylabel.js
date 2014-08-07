angular.module('mylabel',['servoy']).directive('mylabel', ["formatFilterFilter",'$utils', function(formatFilter,$utils) {  
    return {
		restrict: 'E',
		transclude: true,
		scope: {
			model: "=svyModel",
			api: "=svyApi",
	       	handlers: "=svyHandlers"
		},
		controller: function($scope, $element, $attrs) {
			$scope.style = {width:'100%',height:'100%',overflow:'hidden'};
			$scope.api.getSomething = function() {
				return 15;
			};
			$scope.api.doAlert = function(msg) {
				alert(msg);
			};
		  },
		templateUrl: 'mycomp/mylabel/mylabel.html',
		replace: true
    };
}]);
