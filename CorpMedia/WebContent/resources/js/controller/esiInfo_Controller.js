'use strict';

App.controller('esiInfo_Controller', ['$http','$scope','$location','$stateParams','$rootScope', function($http,$scope,$location,$stateParams,$rootScope) {
	 $scope.state="legalentities";
		$scope.left_state = "company_settings";
		$scope.state_info_name = $stateParams.legEntity;
		$scope.$parent.state_info_name = $stateParams.legEntity;
		$scope.isProcessing = true;
		
		 $scope.getESIInfo = function() {
			 $scope.isProcessing = true;
             $http.get(constants.localhost_port+'/CorpMediaService/ESIController/findAllCompanyESI/'+$rootScope.companyId).success(function(data){
           	  $scope.esiinfo = data;
           	$scope.isProcessing = false;
             });
         };
         
         
         $scope.saveOrUpdate = function() {
//           $scope.resetError();

           $http.post(constants.localhost_port+'/CorpMediaService/ESIController/saveOrUpdateESIInfo', $scope.esiinfo).success(function() {
               $scope.getESIInfo();
           }).error(function() {
         	  console.error('Could not save or update esi');
           });
       };
       
       $scope.selectedSignatorInfo = function() {
     	  angular.forEach($scope.esiinfo.companySignatorJsonList, function(obj, key){
     	   if(obj.companySignatorId == $scope.esiinfo.companySignatorId)
     		   {
     		   $scope.esiinfo.signator = obj;
     		}
     	     });
     	  
     	 $scope.esiinfo.companyId =$rootScope.companyId;
   	  console.error('Error selectedSignatorInfo');
     };
     
     $scope.getESIInfo();
       
       
		
}]);
