<!doctype html>
<html lang="en" ng-app="myApp">
<head>

<meta charset="utf-8">
<title>Service App</title>
<!--   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->

  <!--jquery for image-->
<!-- <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script> -->
<!-- <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script> -->




<script src="webjars/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
    <script src="resources/js/typed.js" type="text/javascript"></script>
<link rel="stylesheet" href="resources/css/angucomplete-alt.css" />
<link rel="stylesheet" href="resources/css/nv.d3.min.css" />
<link rel="stylesheet"
	href="webjars/font-awesome/4.3.0/css/font-awesome.css">
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/app.css" />
<link rel="stylesheet" href="resources/css/ng-grid.css" />
<link rel="stylesheet" href="resources/css/image-crop-styles.css" />
<link rel="stylesheet" href="resources/css/corpo_media.css" />
<link rel="stylesheet" href="resources/css/ngTimepicker.css" />
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script> -->

<script
	src="webjars/angularjs/1.4.4/angular.js"></script>
<script src="resources/js/angucomplete-alt.js"></script>
<script src="resources/js/d3.min.js"></script>
<script src="resources/js/nv.d3.min.js"></script>
<script src="resources/js/angular-nvd3.js"></script>
<script src="resources/js/moment.js"></script>
<script src="resources/js/ngTimepicker.min.js"></script>

<!-- <script -->
<!-- 	src="http://angular-ui.github.io/ui-router/release/angular-ui-router.js"></script> -->
<script src="resources/js/angular-ui-router.js"></script>
<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- <script -->
<!-- 	src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.13.2/ui-bootstrap-tpls.js"></script> -->
	<script src="resources/js/ui-bootstrap-tpls.js"></script>
	<script src="resources/js/ng-grid.js"></script>
	 <script src="resources/js/image-crop.js"></script>
	 
	 
<script src="resources/js/app.js"></script>
<script src="resources/js/controller/HomeController.js"></script>
<script src="resources/js/controller/LeftMenu_Controller.js"></script>
<script src="resources/js/controller/CompanyInfoController.js"></script>
<script src="resources/js/controller/Company_General_Controller.js"></script>
<script src="resources/js/controller/Company_Legalentities_Controller.js"></script>
<script src="resources/js/controller/Company_Locations_Controller.js"></script>
<script src="resources/js/controller/Company_Department_Controller.js"></script>
<script src="resources/js/controller/Company_Designation_Controller.js"></script>
<script src="resources/js/controller/cmpInfo_Controller.js"></script>
<script src="resources/js/controller/itInfo_Controller.js"></script>
<script src="resources/js/controller/pfInfo_Controller.js"></script>
<script src="resources/js/controller/esiInfo_Controller.js"></script>
<script src="resources/js/controller/ptInfo_Controller.js"></script>
<script src="resources/js/controller/leave_plans_Controller.js"></script>
<script src="resources/js/controller/leave_types_Controller.js"></script>
<script src="resources/js/controller/timesheet_general_Controller.js"></script>
<script src="resources/js/controller/timesheet_approval_chain_Controller.js"></script>
<script src="resources/js/controller/weekly_offs_Controller.js"></script>
<script src="resources/js/controller/shifts_Controller.js"></script>
<script src="resources/js/controller/timing_policies_Controller.js"></script>
<script src="resources/js/controller/wfh_Controller.js"></script>
<script src="resources/js/controller/categories_Controller.js"></script>
<script src="resources/js/controller/tags_Controller.js"></script>
<script src="resources/js/controller/on_boarding_Controller.js"></script>
<script src="resources/js/controller/exit_settings_Controller.js"></script>
<script src="resources/js/controller/assign_roles_Controller.js"></script>
<script src="resources/js/controller/general_payroll_settings_Controller.js"></script>
<script src="resources/js/controller/adhoc_components_Controller.js"></script>
<script src="resources/js/controller/salary_component_structure_Controller.js"></script>
<script src="resources/js/controller/provident_fund_Controller.js"></script>
<script src="resources/js/controller/employee_loan_settings_Controller.js"></script>
<script src="resources/js/controller/job_titles_Controller.js"></script>
<script src="resources/js/controller/employee_defaults_Controller.js"></script>
<script src="resources/js/controller/add_employee_Controller.js"></script>
<script src="resources/js/controller/employee_professional_Controller.js"></script>
<script src="resources/js/controller/employee_personal_Controller.js"></script>
<script src="resources/js/controller/employee_projects_Controller.js"></script>
<script src="resources/js/controller/employee_job_Controller.js"></script>
<script src="resources/js/controller/projects_Controller.js"></script>
<script src="resources/js/controller/billing_Controller.js"></script>
<script src="resources/js/controller/clients_Controller.js"></script>
<script src="resources/js/controller/billing_rates_Controller.js"></script>
<script src="resources/js/controller/reports_Controller.js"></script>
<script src="resources/js/controller/project_details_Controller.js"></script>
<script src="resources/js/controller/task_billing_Controller.js"></script>
<script src="resources/js/controller/dpt_work_hrs_Controller.js"></script>
<script src="resources/js/controller/project_work_hrs_Controller.js"></script>
<script src="resources/js/controller/client_work_hrs_Controller.js"></script>
<script src="resources/js/controller/employee_timesheets_Controller.js"></script>
<script src="resources/js/controller/Add_Leave_Type_Controller.js"></script>
<script src="resources/js/controller/holidays_Controller.js"></script>
<script src="resources/js/controller/Notify_Controller.js"></script>
<script src="resources/js/controller/All_Employee_Controller.js"></script>
<script src="resources/js/controller/Employee_Info_Controller.js"></script>
<script src="resources/js/controller/Salary_component_Controller.js"></script>
<script src="resources/js/controller/employee_finance_Controller.js"></script>
<script src="resources/js/controller/applyLeave_Controller.js"></script>
<script src="resources/js/controller/leaveApproval_Controller.js"></script>
<script src="resources/js/controller/timesheetApproval_Controller.js"></script>
<script src="resources/js/controller/employeePaySlip_Controller.js"></script>
<script src="resources/js/controller/run_payroll_Controller.js"></script>


<script src="resources/js/service/constants.js"></script>
<script>
	$(document).ready(function() {
		// $(replacedwith).hide();
		$("#btn2").click(function() {
			// this is the culprit if your program breaks.
			var temp = 'hello';
			$(replacable).fadeOut("slow");
			$(replacewith).fadeIn("slow");
			// $(noexpense).remove();
		});
	});
</script>




   

</head>
<body>
	<div ui-view="content"></div>
<!-- 	<div ui-view="footer"></div> -->

       

</body>
</html>
