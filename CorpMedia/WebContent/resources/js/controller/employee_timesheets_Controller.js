'use strict';

App.controller('employee_timesheets_Controller', ['$scope','$http','$rootScope','$stateParams', function($scope,$http,$rootScope,$stateParams) {
	$scope.state="employee_timesheets";
	$scope.left_state = "employee";
	
	
	 var currentDate = moment();
     var fnWeekDays = function(dt) {

        var currentDate = dt;
        var weekStart = currentDate.clone().startOf('week');
        var weekEnd = currentDate.clone().endOf('week');

        var days = [],i;
        for (i = 0; i <= 6; i++) {

            days.push(moment(weekStart).add(i, 'days').format("MMMM Do,dddd"));
//        	days.push(moment(weekStart).add(i, 'days').format("ddd Do"));
//            var currentDate = formatteddate(moment(weekStart).add(i, 'days'));
//            dates.push(currentDate);
        };
        var currentDate = new Date();
        $scope.week_StartAndEndDays = days[0]+" <--> "+days[6];
        if($rootScope.empId){
        getEmployeeTimesheetOfTheWeek($rootScope.empId, formatteddate(moment(weekStart).add(0, 'days')));
        getEmployeeLeavesOfTheWeek($rootScope.empId, formatteddate(moment(weekStart).add(0, 'days')));
        }
        days.push('Total');
        return days;
    }
    
    $scope.weekDays = fnWeekDays(currentDate);
    $scope.nextWeek = function(dt) {
        $scope.weekDays = fnWeekDays(moment(dt, "MMMM Do,dddd").add(1, 'days'));
    };
    $scope.previousWeek = function(dt) {
        $scope.weekDays = fnWeekDays(moment(dt, "MMMM Do,dddd").subtract(1, 'days'));
    };
	
    //This is to get the employee Timesheet of the week
   function getEmployeeTimesheetOfTheWeek(employeeId,startingWeekDate){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeTimeSheetController+'/getEmployeeTimesheetOfTheWeek?employeeId='+employeeId+"&startingWeekDate="+startingWeekDate).success(function(data) {
			$scope.employeeTimeSheetJsonList = data;
		}).error(function() {
      	  console.error('Could not getEmployeeTimesheetOfTheWeek');
        });
	};
    
	//This is to get the employee leaves of the week
	function getEmployeeLeavesOfTheWeek(employeeId,startingWeekDate){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeLeaveController+'/getEmployeeLeavesOfTheWeek?employeeId='+employeeId+"&startingWeekDate="+startingWeekDate).success(function(data) {
			$scope.employeeLeaveJsonList = data;
		}).error(function() {
      	  console.error('Could not getEmployeeLeavesOfTheWeek');
        });
	};
    
	
    //This is to formate dates
	function formatteddate(inputDate){
      var inDate = new Date(inputDate);
      var month = '' + (inDate.getMonth() + 1);
      var day = '' + inDate.getDate();
      var  year = inDate.getFullYear();
    	 if (month.length < 2) month = '0' + month;
    	  if (day.length < 2) day = '0' + day;
      return [year, month, day].join('-');
      };
		
      //Save Time Sheet of an employee
	$scope.saveOrUpdateEmployeeTimesheetList = function(){
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeTimeSheetController+'/saveOrUpdateEmployeeTimesheetList', $scope.employeeTimeSheetJsonList).success(function(data) {
		}).error(function() {
	       console.error('Could not save Or Update Employee Timesheet List');
	    });
		};
		
		  //submit Employee Time Sheet list for approval
		$scope.submitEmployeeTimesheetListForApproval = function(){
			angular.forEach($scope.employeeTimeSheetJsonList, function(o, k)
  				  {
						o.projectId = $scope.projectId;
		           });
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeTimeSheetController+'/saveOrUpdateEmployeeTimesheetList', $scope.employeeTimeSheetJsonList).success(function(data) {
			}).error(function() {
		       console.error('Could not save Or Update Employee Timesheet List for approval');
		    });
			};
		
		
		
		// get all the projects assigned to an employee
		$scope.getEmployeeProjects = function(){
			if($rootScope.empId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeProjects/'+  $rootScope.empId).success(function(data) {
				$scope.employeeProjectsList = data;
			}).error(function() {
	      	  console.error('Could not get Employee Projects');
	        });}
		};
          


          
		$scope.getEmployeeProjects();
          
}]);
