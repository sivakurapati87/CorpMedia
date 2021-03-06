'use strict';

App.controller('categories_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 $scope.state="categories";
		$scope.left_state = "expenses";
		$scope.isCollapse = true;
		$scope.categories = {};
		$scope.isProcessing = true;
		
		
		
		//Save categories
		$scope.saveCategories = function(){
			$scope.isProcessing = true;
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.categories.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CategoriesController+'/saveCategories', $scope.categories).success(function(data) {
				$scope.getAllCategoriesList();
				$scope.categories = {};
				$scope.isProcessing = false;
	        }).error(function() {
	      	  console.error('Could not save or update categories');
	        });}
		};
		
		// get all categories list
		$scope.getAllCategoriesList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CategoriesController+'/getAllCategoriesList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.categoriesList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getCategoriesList');
	        });}
		};
		
		
		//edit expenses
		$scope.editCategories = function(categories) {
			$scope.categories = categories;
			$scope.isCollapse = false;
			
		};
		
		
		//delete categories
		$scope.deleteCategories = function(categoriesId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CategoriesController+'/deleteCategories/'+ categoriesId).success(function(data) {
				$scope.getAllCategoriesList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not deleteCategories');
	        });
		};
		
		//init
		$scope.getAllCategoriesList();
		
		//cancel
		
		$scope.cancelCategories = function() {
			$scope.isCollapse = true;
		};
		
		
		
}]);
