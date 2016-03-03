'use strict';

var App = angular.module('myApp',['ui.router','ui.bootstrap',"angucomplete-alt"]);
App.directive("autoSubmit", function($timeout) {
    return {
        link: function(scope, element, attrs) {
            scope.$watch("valid", function() {
                if (scope.valid == 1) {
                    console.log("send form");
                    $timeout(function() {
                        element.triggerHandler('submit');
                    })
                }
            });
        }
    }
});

App.directive('leftMenu', function() {
	  return {
	      restrict: 'E',
	      templateUrl: 'leftMenu',
	      controller : "LeftMenu_Controller"
	    };
	});

App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise("/")
	
	$stateProvider
	.state('home', {
		url: "/",
			views: {
	            'content': {
	            	templateUrl: 'home',
	        		controller : "HomeController as hc"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})

	.state('companyInfo', {
		url: "/companyInfo",
			views: {
	            'content': {
	            	templateUrl: 'companyInfo',
	        		controller : "CompanyInfoController"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('company_general', {
		url: "/company_general",
			views: {
	            'content': {
	            	templateUrl: 'company_general',
	        		controller : "Company_General_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('company_legalentities', {
		url: "/company_legalentities",
			views: {
	            'content': {
	            	templateUrl: 'company_legalentities',
	        		controller : "Company_Legalentities_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('company_legalentities.mainInfo', {
		url: '/{legEntity:[A-Za-z]{0,9}}',
		views: {
            'company_legal_entities_info': {
            	templateUrl: function(params){ return 'company_legalentities/' + params.legEntity; },
//        		controller : "Company_Legalentities_Info_Controller"
            	controllerProvider : function($stateParams) {
            	      var ctrlName = $stateParams.legEntity + "_Controller";
            	      return ctrlName;
            	  }
            },
            'footer': {
                templateUrl: 'footer'
            }
        }
	})
	.state('company_locations', {
		url: "/company_locations",
			views: {
	            'content': {
	            	templateUrl: 'company_locations',
	        		controller : "Company_Locations_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('company_department', {
		url: "/company_department",
			views: {
	            'content': {
	            	templateUrl: 'company_department',
	        		controller : "Company_Department_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
		.state('leave_plans', {
		url: "/leave_plans",
			views: {
	            'content': {
	            	templateUrl: 'leave_plans',
	        		controller : "leave_plans_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('leave_types', {
		url: "/leave_types",
			views: {
	            'content': {
	            	templateUrl: 'leave_types',
	        		controller : "leave_types_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('add_leave_types', {
		url: "/add_leave_types",
			views: {
	            'content': {
	            	templateUrl: 'add_leave_types',
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('timesheet_general', {
		url: "/timesheet_general",
			views: {
	            'content': {
	            	templateUrl: 'timesheet_general',
	        		controller : "timesheet_general_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('timesheet_approval_chain', {
		url: "/timesheet_approval_chain",
			views: {
	            'content': {
	            	templateUrl: 'timesheet_approval_chain',
	        		controller : "timesheet_approval_chain_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	
	.state('weekly_offs', {
		url: "/weekly_offs",
			views: {
	            'content': {
	            	templateUrl: 'weekly_offs',
	        		controller : "weekly_offs_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('shifts', {
		url: "/shifts",
			views: {
	            'content': {
	            	templateUrl: 'shifts',
	        		controller : "shifts_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('timing_policies', {
		url: "/timing_policies",
			views: {
	            'content': {
	            	templateUrl: 'timing_policies',
	        		controller : "timing_policies_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	
	
	.state('wfh', {
		url: "/wfh",
			views: {
	            'content': {
	            	templateUrl: 'wfh',
	        		controller : "wfh_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('categories', {
		url: "/categories",
			views: {
	            'content': {
	            	templateUrl: 'categories',
	        		controller : "categories_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('tags', {
		url: "/tags",
			views: {
	            'content': {
	            	templateUrl: 'tags',
	        		controller : "tags_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	
	
	
	
	.state('on_boarding', {
		url: "/on_boarding",
			views: {
	            'content': {
	            	templateUrl: 'on_boarding',
	        		controller : "on_boarding_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('exit_settings', {
		url: "/exit_settings",
			views: {
	            'content': {
	            	templateUrl: 'exit_settings',
	        		controller : "exit_settings_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('assign_roles', {
		url: "/assign_roles",
			views: {
	            'content': {
	            	templateUrl: 'assign_roles',
	        		controller : "assign_roles_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('general_payroll_settings', {
		url: "/general_payroll_settings",
			views: {
	            'content': {
	            	templateUrl: 'general_payroll_settings',
	        		controller : "general_payroll_settings_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('adhoc_components', {
		url: "/adhoc_components",
			views: {
	            'content': {
	            	templateUrl: 'adhoc_components',
	        		controller : "adhoc_components_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('salary_component_structure', {
		url: "/salary_component_structure",
			views: {
	            'content': {
	            	templateUrl: 'salary_component_structure',
	        		controller : "salary_component_structure_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('provident_fund', {
		url: "/provident_fund",
			views: {
	            'content': {
	            	templateUrl: 'provident_fund',
	        		controller : "provident_fund_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	
	
	.state('employee_loan_settings', {
		url: "/employee_loan_settings",
			views: {
	            'content': {
	            	templateUrl: 'employee_loan_settings',
	        		controller : "employee_loan_settings_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('job_titles', {
		url: "/job_titles",
			views: {
	            'content': {
	            	templateUrl: 'job_titles',
	        		controller : "job_titles_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('employee_defaults', {
		url: "/employee_defaults",
			views: {
	            'content': {
	            	templateUrl: 'employee_defaults',
	        		controller : "employee_defaults_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('add_employee', {
		url: "/add_employee",
			views: {
	            'content': {
	            	templateUrl: 'add_employee',
	        		controller : "add_employee_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('employee_professional', {
		url: "/employee_professional",
			views: {
	            'content': {
	            	templateUrl: 'employee_professional',
	        		controller : "employee_professional_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('employee_personal', {
		url: "/employee_personal",
			views: {
	            'content': {
	            	templateUrl: 'employee_personal',
	        		controller : "employee_personal_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('employee_job', {
		url: "/employee_job",
			views: {
	            'content': {
	            	templateUrl: 'employee_job',
	        		controller : "employee_job_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('projects', {
		url: "/projects",
			views: {
	            'content': {
	            	templateUrl: 'projects',
	        		controller : "projects_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('billing', {
		url: "/billing",
			views: {
	            'content': {
	            	templateUrl: 'billing',
	        		controller : "billing_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('clients', {
		url: "/clients",
			views: {
	            'content': {
	            	templateUrl: 'clients',
	        		controller : "clients_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('billing_rates', {
		url: "/billing_rates",
			views: {
	            'content': {
	            	templateUrl: 'billing_rates',
	        		controller : "billing_rates_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('reports', {
		url: "/reports",
			views: {
	            'content': {
	            	templateUrl: 'reports',
	        		controller : "reports_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('project_details', {
		url: "/project_details",
			views: {
	            'content': {
	            	templateUrl: 'project_details',
	        		controller : "project_details_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('task_billing', {
		url: "/task_billing",
			views: {
	            'content': {
	            	templateUrl: 'task_billing',
	        		controller : "task_billing_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('dpt_work_hrs', {
		url: "/dpt_work_hrs",
			views: {
	            'content': {
	            	templateUrl: 'dpt_work_hrs',
	        		controller : "dpt_work_hrs_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('project_work_hrs', {
		url: "/project_work_hrs",
			views: {
	            'content': {
	            	templateUrl: 'project_work_hrs',
	        		controller : "project_work_hrs_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('client_work_hrs', {
		url: "/client_work_hrs",
			views: {
	            'content': {
	            	templateUrl: 'client_work_hrs',
	        		controller : "client_work_hrs_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	.state('employee_timesheets', {
		url: "/employee_timesheets",
			views: {
	            'content': {
	            	templateUrl: 'employee_timesheets',
	        		controller : "employee_timesheets_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	.state('holidays', {
		url: "/holidays",
			views: {
	            'content': {
	            	templateUrl: 'holidays',
	        		controller : "holidays_Controller"
	            },
	            'footer': {
	                templateUrl: 'footer'
	            }
	        }
	})
	
	
	
	
	
	
	
}]);

