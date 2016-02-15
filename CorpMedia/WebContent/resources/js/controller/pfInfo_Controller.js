'use strict';

App.controller('pfInfo_Controller', ['$http','$scope','$rootScope','PFInfoService','$stateParams', function($http,$scope,$rootScope,PFInfoService,$stateParams) {
	
	//common 
		$scope.state="legalentities";
		$scope.left_state = "company_settings";
		$scope.state_info_name = $stateParams.legEntity;
		$scope.$parent.state_info_name = $stateParams.legEntity;
		
		// pf info main object
//		$scope.pfinfo={};
          
          $scope.getPFInfo = function() {
              $http.get(constants.localhost_port+'/CorpMediaService/PFController/findAllCompanyPF/'+$rootScope.companyId).success(function(data){
            	  $scope.pfinfo = data;
              });
          };
          
          $scope.saveOrUpdate = function() {
//              $scope.resetError();

              $http.post(constants.localhost_port+'/CorpMediaService/PFController/saveOrUpdatePFInfo', $scope.pfinfo).success(function() {
                  $scope.getPFInfo();
              }).error(function() {
            	  console.error('Could not save or update pf');
              });
          };

          $scope.selectedSignatorInfo = function() {
        	  angular.forEach($scope.pfinfo.companySignatorJsonList, function(obj, key){
        	   if(obj.companySignatorId == $scope.pfinfo.companySignatorId)
        		   {
        		   $scope.pfinfo.signator = obj;
        		}
        	     });
        	  
        	  $scope.pfinfo.companyId =$rootScope.companyId;
        	  console.error('Error selectedSignatorInfo');
          };
          
          $scope.getPFInfo();
		
}]);
