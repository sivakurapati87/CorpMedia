'use strict';

App.controller('Salary_component_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams){
	
	$scope.options = {
            chart: {
                type: 'boxPlotChart',
                height: 450,
                margin : {
                    top: 40,
                    right: 40,
                    bottom: 60,
                    left: 80
                },
                color:['darkblue', 'darkorange', 'green', 'darkred', 'darkviolet'],
                x: function(d){return d.label;},
                // y: function(d){return d.values.Q3;},
                maxBoxWidth: 75,
                yDomain: [1, 2000000]
            }
        };

    $scope.data = [
            {
                label: "Class A",
                values: {
                    Q1: 1,
                    Q2: 200000,
                    Q3: 300000,
                    
                    whisker_low: 1,
                    whisker_high: 2000000,
                    outliers: [1,200000, 300000,400000,600000,800000,1000000,1200000,1400000,1600000,1800000, 2000000]
                }
            },
            {
                label: "Class B",
                values: {
                    Q1: 300001,
                    Q2: 400000,
                    Q3: 500000,
                    whisker_low: 1,
                    whisker_high: 2000000,
                    outliers: [1, 300000,500000, 2000000]
                }
            },
            {
                label: "Class C",
                values: {
                    Q1: 500001,
                    Q2: 800000,
                    Q3: 1000000,
                    whisker_low: 1,
                    whisker_high: 2000000,
                    outliers: [1, 500001,1000000,2000000]
                }
            },
            {
                label: "Class D",
                values: {
                    Q1: 1000001,
                    Q2: 1500000,
                    Q3: 2000000,
                    whisker_low: 10,
                    whisker_high: 2000000,
                    outliers: [1,1000001,2000000]
                }
            }
            
        ];	

    //init values
    $scope.isEdit = false;
    $scope.popupFieldName = '';
    $scope.popupTextAreaValue = null;
    
    
    //To enable edit mode
    $scope.onclickEdit = function(){
    	if($scope.isEdit){
    		$scope.isEdit = false;
    	}else{
    		$scope.isEdit = true;
    	}
    }
    
    //To open popup
    $scope.openPopup = function(fieldName,value){
    	$scope.popupTextAreaValue = value;
    	$scope.popupFieldName = fieldName;
    	angular.element('#salaryComponentPopupBtnId').trigger('click');

    }
    
    $scope.savePopupValue = function(){
    	if($scope.popupFieldName == constants.BASIC){
    		$scope.salaryComponent.basic = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.HRA){
    		$scope.salaryComponent.hra = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.PF){
    		$scope.salaryComponent.pf = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.Medical){
    		$scope.salaryComponent.medicalReimbursement = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.Transport){
    		$scope.salaryComponent.transportAllowance = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.Professional_Allowance){
    		$scope.salaryComponent.professionalAllowance = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.Travel_Reimbursement){
    		$scope.salaryComponent.travelReimbursement = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.Food_Coupons){
    		$scope.salaryComponent.foodCoupons = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.City_Compensatory_Allowance){
    		$scope.salaryComponent.cityCompensatoryAllowance = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.Daily_Allowance){
    		$scope.salaryComponent.dailyAllowance = $scope.popupTextAreaValue;
    	}
    	if($scope.popupFieldName == constants.Employee_Gratuity_contribution){
    		$scope.salaryComponent.gratuityContribution = $scope.popupTextAreaValue;
    	}
    	$scope.popupFieldName = '';
        $scope.popupTextAreaValue = null;
        $('#salaryComponentPopupId').modal('hide');
    }
    
    
  //modify Salary Component
	$scope.modifySalaryComponent = function(){
		if($rootScope.selectedCompanyObj){
			$scope.salaryComponent.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.SalaryComponentController+'/modifySalaryComponent', $scope.salaryComponent).success(function(data) {
			$scope.isEdit = false;
		}).error(function() {
      	  console.error('Could not modify Salary Component');
        });}
	};
    
 // get Company Salary Component
	$scope.getSalaryComponentJson = function(){
		if($rootScope.selectedCompanyObj){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.SalaryComponentController+'/getSalaryComponentJson/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
			$scope.salaryComponent = data;
		}).error(function() {
      	  console.error('Could not getSalaryComponentJson');
        });}
	};
	
	$scope.getSalaryComponentJson();
}]); 
	


