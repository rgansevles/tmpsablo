angular.module('mytextfield',[]).directive('mytextfield', function() {  
    return {
      restrict: 'E',
      transclude: true,
      scope: {
			model: "=fieldModel"
		},
      controller: function($scope, $element, $attrs) {
//			$scope.style = {width:'100%',height:'100%',overflow:'hidden'};
//			$scope.api.getSomething = function() {
//				return 15;
//			};
//			$scope.api.doAlert = function(msg) {
//				alert(msg);
//			};
		  },
      templateUrl: 'mycomp/mytextfield/mytextfield.html',
      replace: true
    };
  });
