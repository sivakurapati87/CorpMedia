'use strict';

App.controller('Employee_Info_Controller', ['$scope','$state','$rootScope','$http','$stateParams', function($scope,$state,$rootScope,$http,$stateParams) {

	$scope.left_state = "employee";
	
	$scope.fileChanged = function(e) {		
		
		var files = e.target.files;
	
 		var fileReader = new FileReader();
		fileReader.readAsDataURL(files[0]);		
		
		fileReader.onload = function(e) {
			$scope.imgSrc = this.result;
			$scope.$apply();
		};
	};
   
	  $scope.upload = function(){
//		  alert($scope.result);
		  var fd = new FormData();
		  fd.append("imageValue", $scope.result);
		  $http.post(constants.localhost_port+"/"+constants.web_context+'/LoginController/upload', fd, {
              withCredentials : false,
              transformRequest: angular.identity,
              headers: {'Content-Type': undefined}
          })
      };
      
	
	$scope.clear = function() {
		 $scope.imageCropStep = 1;
		 delete $scope.imgSrc;
		 delete $scope.result;
		 delete $scope.resultBlob;
	};

	// get all getBase64EncdedImage
	$scope.getBase64EncdedImage = function(){
		$http.get(constants.localhost_port+"/"+constants.web_context+'/LoginController/previewFile').success(function(data) {
			$scope.baseEncodedObj = data.strInputStream;
//			alert($scope.baseEncodedObj);
		}).error(function() {
      	  console.error('Could not getBase64EncdedImage');
        });
	};
	$scope.getBase64EncdedImage();
}]);
