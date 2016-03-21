'use strict';

App.controller('itInfo_Controller', ['$rootScope','$scope','$http','$location','$stateParams', function($rootScope,$scope,$http,$location,$stateParams) {
	 $scope.state="legalentities";
		$scope.left_state = "company_settings";
		$scope.state_info_name = $stateParams.legEntity;
		$scope.$parent.state_info_name = $stateParams.legEntity;
		$scope.isProcessing = true;
		// it info main object

          $scope.getITInfo = function() {
        	  $scope.isProcessing = true;
              $http.get(constants.localhost_port+'/CorpMediaService/ITController/findAllCompanyIT/'+$rootScope.companyId).success(function(data){
            	  $scope.itinfo = data;
            	  $scope.isProcessing = false;
              });
          };
          
          $scope.saveOrUpdate = function() {
//              $scope.resetError();
        	 
              $http.post(constants.localhost_port+'/CorpMediaService/ITController/saveOrUpdateITInfo', $scope.itinfo).success(function() {
                  $scope.getITInfo();
                
              }).error(function() {
            	  console.error('Could not save or update it');
              });
          };

          $scope.selectedSignatorInfo = function() {
        	  angular.forEach($scope.itinfo.companySignatorJsonList, function(obj, key){
        	   if(obj.companySignatorId == $scope.itinfo.companySignatorId)
        		   {
        		   $scope.itinfo.signator = obj;
        		}
        	     });
        	  
        	  $scope.itinfo.companyId =$rootScope.companyId;
        	  console.error('Error selectedSignatorInfo');
          };
          
          $scope.getITInfo();
		
		
}]);
