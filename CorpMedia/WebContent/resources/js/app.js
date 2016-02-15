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
	
	.state('web_clock_in', {
		url: "/web_clock_in",
			views: {
	            'content': {
	            	templateUrl: 'web_clock_in',
	        		controller : "web_clock_in_Controller"
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
	
	.state('welcome_screen', {
		url: "/welcome_screen",
			views: {
	            'content': {
	            	templateUrl: 'welcome_screen',
	        		controller : "welcome_screen_Controller"
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
	
	
	
}]);

