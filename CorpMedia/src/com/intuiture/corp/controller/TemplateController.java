package com.intuiture.corp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {// Serves Templates.

	@RequestMapping(value = "/home")
	public String getMainTemplate() {
		return "template/home";
	}

	@RequestMapping(value = "/companyInfo")
	public String getCompanyInfo() {
		return "template/companyInfo";
	}

	@RequestMapping(value = "/footer")
	public String footer() {
		return "template/footer";
	}

	@RequestMapping(value = "/leftMenu")
	public String leftMenu() {
		return "template/leftMenu";
	}

	@RequestMapping(value = "/company_general")
	public String company_General_Page() {
		return "template/company_general";
	}

	@RequestMapping(value = "/company_legalentities")
	public String company_LegalEntities_Page() {
		return "template/company_legalentities";
	}

	@RequestMapping(value = "/company_locations")
	public String company_Locations_Page() {
		return "template/company_locations";
	}

	@RequestMapping(value = "/company_department")
	public String company_Department_Page() {
		return "template/company_department";
	}

	@RequestMapping(value = "/company_legalentities/cmpInfo")
	public String company_LegalEntities_CmpInfo() {
		return "template/company_legalentities/cmpInfo";
		// return "template/companyInfo";
	}

	@RequestMapping(value = "/company_legalentities/itInfo")
	public String company_LegalEntities_ItInfo() {
		return "template/company_legalentities/itInfo";
	}

	@RequestMapping(value = "/company_legalentities/pfInfo")
	public String company_LegalEntities_PfInfo() {
		return "template/company_legalentities/pfInfo";
	}

	@RequestMapping(value = "/company_legalentities/esiInfo")
	public String company_LegalEntities_ESIInfo() {
		return "template/company_legalentities/esiInfo";
	}

	@RequestMapping(value = "/company_legalentities/ptInfo")
	public String company_LegalEntities_PtInfo() {
		return "template/company_legalentities/ptInfo";
	}

	@RequestMapping(value = "/leave_plans")
	public String leave_plans() {
		return "template/leave_plans";
	}

	@RequestMapping(value = "/leave_types")
	public String leave_types() {
		return "template/leave_types";
	}

	@RequestMapping(value = "/add_leave_types")
	public String add_leave_types() {
		return "template/add_leave_types";
	}

	@RequestMapping(value = "/left_menu")
	public String left_menu() {
		return "template/leftMenu";
	}

	@RequestMapping(value = "/timesheet_general")
	public String timesheet_general() {
		return "template/timesheet_general";
	}
	@RequestMapping(value = "/timesheet_approval_chain")
	public String timesheet_approval_chain() {
		return "template/timesheet_approval_chain";
	}
	@RequestMapping(value = "/weekly_offs")
	public String weekly_offs() {
		return "template/weekly_offs";
	}
	@RequestMapping(value = "/shifts")
	public String shifts() {
		return "template/shifts";
	}
	@RequestMapping(value = "/timing_policies")
	public String timing_policies() {
		return "template/timing_policies";
	}
	@RequestMapping(value = "/web_clock_in")
	public String web_clock_in() {
		return "template/web_clock_in";
	}
	@RequestMapping(value = "/wfh")
	public String wfh() {
		return "template/wfh";
	}
	@RequestMapping(value = "/categories")
	public String categories() {
		return "template/categories";
	}
	@RequestMapping(value = "/tags")
	public String tags() {
		return "template/tags";
	}
	
	@RequestMapping(value = "/welcome_screen")
	public String welcome_screen() {
		return "template/welcome_screen";
	}
	
	@RequestMapping(value = "/on_boarding")
	public String on_boarding() {
		return "template/on_boarding";
	}
	
	@RequestMapping(value = "/exit_settings")
	public String exit_settings() {
		return "template/exit_settings";
	}
	
	@RequestMapping(value = "/assign_roles")
	public String assign_roles() {
		return "template/assign_roles";
	}
	
	@RequestMapping(value = "/general_payroll_settings")
	public String general_payroll_settings() {
		return "template/general_payroll_settings";
	}
	
	@RequestMapping(value = "/adhoc_components")
	public String adhoc_components() {
		return "template/adhoc_components";
	}
	@RequestMapping(value = "/salary_component_structure")
	public String salary_component_structure() {
		return "template/salary_component_structure";
	}
	
	@RequestMapping(value = "/provident_fund")
	public String provident_fund() {
		return "template/provident_fund";
	}
	
	@RequestMapping(value = "/legal_and_bank")
	public String legal_and_bank() {
		return "template/legal_and_bank";
	}
	@RequestMapping(value = "/employee_loan_settings")
	public String employee_loan_settings() {
		return "template/employee_loan_settings";
	}
	@RequestMapping(value = "/job_titles")
	public String job_titles() {
		return "template/job_titles";
	}
	
	@RequestMapping(value = "/employee_defaults")
	public String employee_defaults() {
		return "template/employee_defaults";
	}
	@RequestMapping(value = "/add_employee")
	public String add_employee() {
		return "template/add_employee";
	}
	@RequestMapping(value = "/employee_professional")
	public String employee_professional() {
		return "template/employee_professional";
	}
	
	@RequestMapping(value = "/employee_personal")
	public String employee_personal() {
		return "template/employee_personal";
	}
	@RequestMapping(value = "/employee_job")
	public String employee_job() {
		return "template/employee_job";
	}
	
	

	//
	// @RequestMapping(value="/category/Phones")
	// public String getPhonesTemplate() {
	// return "template/category_phones";
	// }
	//
	// @RequestMapping(value="/category/Printers")
	// public String getPrintersTemplate() {
	// return "template/category_printers";
	// }
	//
	// @RequestMapping(value="/category/Computers/{id}")
	// public String getComputersDetailTemplate(@PathVariable("id") long id) {
	// return "template/category_computers_detail";
	// }
	//
	// @RequestMapping(value="/category/Phones/{id}")
	// public String getPhonesDetailTemplate(@PathVariable("id") long id) {
	// return "template/category_phones_detail";
	// }
	//
	// @RequestMapping(value="/category/Printers/{id}")
	// public String getPrintersDetailTemplate(@PathVariable("id") long id) {
	// return "template/category_printers_detail";
	// }

}
