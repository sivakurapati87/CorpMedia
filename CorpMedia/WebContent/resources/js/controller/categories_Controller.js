'use strict';

App.controller('categories_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 $scope.state="categories";
		$scope.left_state = "expenses";
		$scope.collapsed = false;
		$scope.categories = {};
		
		
		
		//Save categories
		$scope.saveCategories = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.categories.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CategoriesController+'/saveCategories', $scope.categories).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update categories');
	        });}
		};
}]);
