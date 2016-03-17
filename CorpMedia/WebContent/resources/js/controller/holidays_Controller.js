'use strict';

App.controller('holidays_Controller', ['$scope','$location','$rootScope','$http', function($scope,$location,$rootScope,$http) {
	 var self = this;
	 $scope.state="holidays";
		$scope.left_state = "leaves_&_holidays";
		
		
		//save Holiday
		$scope.saveOrUpdateHoliday = function(){
			if($rootScope.selectedCompanyObj){
				$scope.holidayJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.HolidayController+'/saveHoliday', $scope.holidayJson).success(function(data) {
				$scope.holidayJson = {};
				$scope.getAllHolidaysList();
			}).error(function() {
	      	  console.error('Could not saveHoliday');
	        });}
		};
	          
		// get all company holidays
		$scope.getAllHolidaysList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.HolidayController+'/getAllHolidaysList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.holidayJsonList = data;
			}).error(function() {
	      	  console.error('Could not getAllCompanyLeaveTypeList');
	        });}
		};
	          
		
		
		//delete delete holiday
		$scope.deleteHoliday = function(companyLeaveTypeId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.HolidayController+'/deleteHoliday/'+ companyLeaveTypeId).success(function(data) {
				$scope.getAllHolidaysList();
			}).error(function() {
	      	  console.error('Could not deleteCompanyDepartment');
	        });
		};
		
		 $scope.mySelections = [];		 
		 var ct_nocheck='<div class=\"ngSelectionCell\"><input style=\"display:none\" tabindex=\"-1\" class=\"ngSelectionCheckbox\" type=\"checkbox\" ng-checked=\"row.selected\" /></div>';                     

	        $scope.gridOptions = { 
	          data: 'holidayJsonList',
//	          enablePaging: true,
//              showFooter: true,
//              showFilter: true,
	          checkboxHeaderTemplate: '<input class="ngSelectionHeader" type="checkbox" ng-model="allSelected" ng-change="toggleSelectAll(allSelected)"/>',
	          showSelectionCheckbox: true,
	          selectWithCheckboxOnly: true,
	          checkboxCellTemplate:ct_nocheck,
	          selectedItems: $scope.mySelections,
	          columnDefs: 'myColumns',
	          multiSelect: true
	        };

	        var removeRowTemplate = '<span style="display:block; text-align:center;"><button ng-click="editRowIndex(row.entity)" ><i class="fa fa-pencil"></i></button>&nbsp;<button ng-click="removeRowIndex(row.entity)" ><i class="fa fa-times"></i></button></span>';
	        $scope.myColumns = [{ field: 'holidayName', displayName: 'Holiday Name' },
	                            { field: 'description', displayName: 'Description' },
	                            { field: 'strHolidayDate', displayName: 'Holiday Date'},
	                            { field: '', displayName: 'Actions', width: "20%", cellTemplate: removeRowTemplate }
	                            ];
	        
	        
	        $scope.removeRowIndex = function (row) {
	            $scope.deleteHoliday(row.holidaysId);
	        };
	        
	        $scope.editRowIndex = function (row) {
	            $scope.holidayJson = row;
	            $scope.isCollapse = false;
	        };
	        
	        $scope.cancel = function(){
	        	$scope.isCollapse = true;
	        }
	        
			//init
	        $scope.init = function(){
	        	$scope.isCollapse = true;
	        	$scope.holidayJson = {};
	        	$scope.getAllHolidaysList();
	        };
	        $scope.init();


          

          
}]);
