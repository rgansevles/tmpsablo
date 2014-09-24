angular.module('mybutton',[]).directive('mybutton', ['$window',function($window) {  
	
	return {
      restrict: 'E',
      transclude: true,
      scope: {
			name: "=name",
			model: "=buttonModel",
			handlers: "=sabloHandlers"
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
			$scope.onClick = function onClick(event) {
				$window.alert('Klik!');
				$scope.handlers.callEvent('pushed');
			};
		  },
      templateUrl: 'mycomp/mybutton/mybutton.html',
      replace: true
    };
  }]);
