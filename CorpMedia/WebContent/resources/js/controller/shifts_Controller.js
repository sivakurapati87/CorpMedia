		
		'use strict';

		App.controller('shifts_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
			 var self = this;
			 $scope.state="shifts";
				$scope.left_state = "time_&_attendance";
				$scope.EndTimeMaridian = "PM";
				$scope.isProcessing = true;
				
				$scope.changeEndTimeMeridian = function(){
					if($scope.EndTimeMaridian == "AM"){
						$scope.EndTimeMaridian = "PM";
					}else{
						$scope.EndTimeMaridian = "AM";
					}
				};
				
				$scope.StartTimeMaridian = "AM";
				
				$scope.changeStartTimeMeridian = function(){
					if($scope.StartTimeMaridian == "AM"){
						$scope.StartTimeMaridian = "PM";
					}else{
						$scope.StartTimeMaridian = "AM";
					}
				};
				
				$scope.init=function(){
					$scope.isProcessing = true;
					$scope.shifts = {};
					$scope.isProcessing = false;
				}
				
				$scope.init();
				
				//$scope.shifts.startTimeType=$scope.StartTimeMaridian;
				//$scope.shifts.toTimeType=$scope.EndTimeMaridian ;
				
				$scope.saveShift = function(){
					$scope.isProcessing = true;
					$scope.shifts.startTimeType=$scope.StartTimeMaridian;
					$scope.shifts.toTimeType=$scope.EndTimeMaridian ;
					if($rootScope.selectedCompanyObj){
						$scope.shifts.companyId = $rootScope.selectedCompanyObj.companyId;
					$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ShiftsController+'/saveShift', $scope.shifts).success(function(data) {
						$scope.shifts = {};
						$scope.isProcessing = false;
					}).error(function() {
			      	  console.error('Could not save or update shifts');
			        });}
				};
				
				
				
		          


		          

		          
		}]);

          


          

          

