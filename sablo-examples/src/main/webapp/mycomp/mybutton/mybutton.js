angular.module('mybutton',[]).directive('mybutton', ['$window',function($window) {  
	function onClick(event) {
		$window.alert('Klik!');
	}
	
	return {
      restrict: 'E',
      transclude: true,
      scope: {
			model: "=buttonModel"
//			api: "=svyApi",
//	       	handlers: "=buttonHandlers",
		},
      controller: function($scope, $element, $attrs) {
			$scope.style = {width:'100%',height:'100%',overflow:'hidden'};
//			$scope.api.getSomething = function() {
//				return 15;
//			};
//			$scope.api.doAlert = function(msg) {
//				alert(msg);
//			};
			$scope.onClick = onClick;
		  },
      templateUrl: 'mycomp/mybutton/mybutton.html',
      replace: true
    };
  }]);
