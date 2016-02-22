'use strict';

App.controller('salary_component_structure_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="salary_component_structure";
		$scope.left_state = "payroll";
		$scope.collapsed = false;
		$scope.medicalreimbursement = {};
		
		
		//Save medicalreimbursement
		$scope.saveMedicalReimbursement = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.medicalreimbursement.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.MedicalReimbursementController+'/saveMedicalReimbursement', $scope.medicalreimbursement).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update medicalreimbursement');
	        });}
		};
		
		

		
		
          


          

          
}]);
