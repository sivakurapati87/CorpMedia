'use strict';

App.controller('salary_component_structure_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="salary_component_structure";
		$scope.left_state = "payroll";
		$scope.medicalreimbursement = {};
		$scope.transportallowance = {};
		$scope.professionalallowance = {};
		$scope.travelreimbursement = {};
		$scope.citycompensatoryallowance = {};
		$scope.dailyallowance = {};
		$scope.foodcoupons = {};
		$scope.gratuitycontribution = {};
		$scope.customallowance = {};
		$scope.isCollapse = true;
		$scope.isProcessing = true;
		
		
		//Save medicalreimbursement
		$scope.saveMedicalReimbursement = function(){
			if($rootScope.selectedCompanyObj){
				$scope.medicalreimbursement.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.MedicalReimbursementController+'/saveMedicalReimbursement', $scope.medicalreimbursement).success(function(data) {
				 $('#medicalmodelpopupid').modal('hide');
			}).error(function() {
	      	  console.error('Could not save or update medicalreimbursement');
	        });}
		};
		
		
		// get medical reimbursement list
		$scope.getMedicalReimbursementList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.MedicalReimbursementController+'/getMedicalReimbursementList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.medicalreimbursement = data;
			}).error(function() {
	      	  console.error('Could not getMedicalReimbursementList');
	        });}
		};
		
		// init
		$scope.getMedicalReimbursementList();
		
		//Save transport allowance
		$scope.saveTransportAllowance = function(){
			if($rootScope.selectedCompanyObj){
				$scope.transportallowance.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.TransportAllowanceController+'/saveTransportAllowance', $scope.transportallowance).success(function(data) {
				 $('#transportmodelpopupid').modal('hide');
			}).error(function() {
	      	  console.error('Could not save or update transportallowance');
	        });}
		};
		
		// get transport allowance list
		$scope.getTransportAllowanceList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.TransportAllowanceController+'/getTransportAllowanceList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.transportallowance = data;
			}).error(function() {
	      	  console.error('Could not getTransportAllowanceList');
	        });}
		};
		
		// init 
		$scope.getTransportAllowanceList();
		
		
		//Save professional allowance
		$scope.saveProfessionalAllowance = function(){
			if($rootScope.selectedCompanyObj){
				$scope.professionalallowance.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ProfessionalAllowanceController+'/saveProfessionalAllowance', $scope.professionalallowance).success(function(data) {
				 $('#professionalmodelpopupid').modal('hide');
			}).error(function() {
	      	  console.error('Could not save or update professionalallowance');
	        });}
		};
		
		// get professional allowance list
		$scope.getProfessionalAllowanceList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ProfessionalAllowanceController+'/getProfessionalAllowanceList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.professionalallowance = data;
			}).error(function() {
	      	  console.error('Could not getProfessionalAllowanceList');
	        });}
		};
		
		// init 
		$scope.getProfessionalAllowanceList();
		
		//Save travel reimbursement
		$scope.saveTravelReimbursement = function(){
			if($rootScope.selectedCompanyObj){
				$scope.travelreimbursement.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.TravelReimbursementController+'/saveTravelReimbursement', $scope.travelreimbursement).success(function(data) {
				 $('#travelmodelpopupid').modal('hide');
			}).error(function() {
	      	  console.error('Could not save or update travelreimbursement');
	        });}
		};
		
		// get travel reimbursement list
		$scope.getTravelReimbursementList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.TravelReimbursementController+'/getTravelReimbursementList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.travelreimbursement = data;
			}).error(function() {
	      	  console.error('Could not getTravelReimbursementList');
	        });}
		};
		
		// init 
		$scope.getTravelReimbursementList();
		
//		//Save travelreimbursement
//		$scope.saveTravelReimbursement = function(){
//			alert($rootScope.selectedCompanyObj.companyId);
//			if($rootScope.selectedCompanyObj){
//				$scope.travelreimbursement.companyId = $rootScope.selectedCompanyObj.companyId;
//			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.TravelReimbursementController+'/saveTravelReimbursement', $scope.travelreimbursement).success(function(data) {
//	        }).error(function() {
//	      	  console.error('Could not save or update travelreimbursement');
//	        });}
//		};
		
		//Save city compensatory allowance
		$scope.saveCityCompensatoryAllowance = function(){
			if($rootScope.selectedCompanyObj){
				$scope.citycompensatoryallowance.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CityCompensatoryAllowanceController+'/saveCityCompensatoryAllowance', $scope.citycompensatoryallowance).success(function(data) {
				$('#citymodelpopupid').modal('hide');
			}).error(function() {
	      	  console.error('Could not save or update citycompensatoryallowance');
	        });}
		};
		
		// get city compensatory allowance list
		$scope.getCityCompensatoryAllowanceList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CityCompensatoryAllowanceController+'/getCityCompensatoryAllowanceList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.citycompensatoryallowance = data;
			}).error(function() {
	      	  console.error('Could not getCityCompensatoryAllowanceList');
	        });}
		};
		
		// init 
		$scope.getCityCompensatoryAllowanceList();
		
		//Save daily allowance
		$scope.saveDailyAllowance = function(){
			if($rootScope.selectedCompanyObj){
				$scope.dailyallowance.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.DailyAllowanceController+'/saveDailyAllowance', $scope.dailyallowance).success(function(data) {
				$('#dailymodelpopupid').modal('hide');
			}).error(function() {
	      	  console.error('Could not save or update dailyallowance');
	        });}
		};
		
		// get daily allowance list
		$scope.getDailyAllowanceList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DailyAllowanceController+'/getDailyAllowanceList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.dailyallowance = data;
			}).error(function() {
	      	  console.error('Could not getDailyAllowanceList');
	        });}
		};
		
		// init 
		$scope.getDailyAllowanceList();
		
		
		//Save food coupons
		$scope.saveFoodCoupons = function(){
			if($rootScope.selectedCompanyObj){
				$scope.foodcoupons.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.FoodCouponsController+'/saveFoodCoupons', $scope.foodcoupons).success(function(data) {
				$('#foodmodelpopupid').modal('hide');
			}).error(function() {
	      	  console.error('Could not save or update foodcoupons');
	        });}
		};
		
		// get food coupons list
		$scope.getFoodCouponsList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.FoodCouponsController+'/getFoodCouponsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.foodcoupons = data;
			}).error(function() {
	      	  console.error('Could not getFoodCouponsList');
	        });}
		};
		
		// init 
		$scope.getFoodCouponsList();
		
		
		//Save gratuitycontribution
		$scope.saveGratuityContribution = function(){
			if($rootScope.selectedCompanyObj){
				$scope.gratuitycontribution.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.GratuityContributionController+'/saveGratuityContribution', $scope.gratuitycontribution).success(function(data) {
				$('#myModal_gratuity').modal('hide');
			}).error(function() {
	      	  console.error('Could not save or update gratuitycontribution');
	        });}
		};
		
		//get gratuity of a company
		$scope.getGratuityContributionJson = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.GratuityContributionController+'/getGratuityContributionJson/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.gratuitycontribution = data;
			}).error(function() {
	      	  console.error('Could not getGratuityContributionJson');
	        });}
		};
		$scope.getGratuityContributionJson();
		//Save custom allowance
		$scope.saveCustomAllowance = function(){
			if($rootScope.selectedCompanyObj){
				$scope.customallowance.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CustomAllowanceController+'/saveCustomAllowance', $scope.customallowance).success(function(data) {
				$('#custommodelpopupid').modal('hide');
				$scope.getAllCustomAllowanceList();
			}).error(function() {
	      	  console.error('Could not save or update customallowance');
	        });}
		};
		
		// get custom allowance list
		$scope.getAllCustomAllowanceList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CustomAllowanceController+'/getAllCustomAllowanceList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.customAllowanceList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getAllCustomAllowanceList');
	        });}
		};
		
		// init 
		$scope.getAllCustomAllowanceList();
		

		//edit  custom allowance
		$scope.editCustomAllowance = function(customallowance) {
			$scope.customallowance = customallowance;
			
			
		};
		
		//delete  custom allowance
		$scope.deleteCustomAllowance = function(customAllowanceId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CustomAllowanceController+'/deleteCustomAllowance/'+ customAllowanceId).success(function(data) {
				$scope.getAllCustomAllowanceList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not deleteCustomAllowance');
	        });
		};
		
		

		
		
          


          

          
}]);
