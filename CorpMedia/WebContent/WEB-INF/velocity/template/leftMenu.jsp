<table class="table " border="0" style="width: 100%; background:#fff; padding:0; margin: 0;" >
	<tr>
		<td>
			<div class="subnavbar-static-side">
				<ul class="nav">
					<li ng-class="{'active':(left_state==='company_settings')}">
						<a class="" ui-sref="company_legalentities.mainInfo({legEntity:'cmpInfo'})" href="#"> 
							
							<lable class="subnav-item-title dis_block">Company Settings</lable> 
							 <span class="subnav-item-description dis_block" > Company settings, Legal Entities, Locations and Department settings 
							  <i class="glyphicon glyphicon-menu-right dis_block float_right dis_block float_right" ></i> 
							 </span>
							
						</a>
					</li>
					
					<li ng-class="{'active':(left_state==='payroll')}">
					<a class="anchor-sm" ui-sref="general_payroll_settings" href="#"> 
					<span class="subnav-item-title">Payroll</span>  <span class="subnav-item-description"> Payroll cycle,salary
								components etc <span class="glyphicon glyphicon-menu-right dis_block float_right " ></span>
						</span>
					</a></li>					
					<li ng-class="{'active':(left_state==='leaves_&_holidays')}"><a
						class="anchor-sm" ui-sref="leave_plans" href="#"> <span
							class="subnav-item-title">Leaves & Holidays</span>  <span
							class="subnav-item-description"> Leave plans,types,Holidays and Policies
								 <span class="glyphicon glyphicon-menu-right dis_block float_right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='timesheet')}"><a
						class="anchor-sm" ui-sref="timesheet_general" href="#"> <span
							class="subnav-item-title">Timesheet</span>  <span
							class="subnav-item-description"> Manage the employee timesheet approval chain settings.
								 <span class="glyphicon glyphicon-menu-right dis_block float_right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='time_And_attendance')}"><a
						class="anchor-sm" ui-sref="leaveApproval" href="#"> <span
							class="subnav-item-title">Time & Attendance</span> <br> <span
							class="subnav-item-description">Time and Attendance settings.
								 <i class="glyphicon glyphicon-menu-right dis_block float_right" style=" margin-left:30px;  "></i>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='expenses')}"><a
						class="anchor-sm" ui-sref="categories" href="#"> <span
							class="subnav-item-title">Expenses</span> <br> <span
							class="subnav-item-description">Employee Expense Claims,Claim approvers,.......
								 <span class="glyphicon glyphicon-menu-right dis_block float_right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='onboarding_&_exit')}"><a
						class="anchor-sm" ui-sref="on_boarding" href="#"> <span
							class="subnav-item-title">Onboarding & Exit</span> <br> <span
							class="subnav-item-description">Employee Onboarding and exit process and checklist
								 <span class="glyphicon glyphicon-menu-right dis_block float_right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='roles_&_permissions')}"><a
						class="anchor-sm" ui-sref="assign_roles" href="#"> <span
							class="subnav-item-title">Roles & Permissions</span> <br> <span
							class="subnav-item-description">Manage roles and permissions.
								 <span class="glyphicon glyphicon-menu-right dis_block float_right" style=" margin-left:25px;  "></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='employee')}"><a
						class="anchor-sm" ui-sref="job_titles" href="#"> <span
							class="subnav-item-title">Employee</span> <br> <span
							class="subnav-item-description">Manage the employee settings likejob titles, probation period etc...,.
								 <span class="glyphicon glyphicon-menu-right dis_block float_right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='project')}"><a
						class="anchor-sm" ui-sref="projects" href="#"> <span
							class="subnav-item-title">Project</span> <br> <span
							class="subnav-item-description">projects Billing Clients Billing Rates Reports
							<span class="glyphicon glyphicon-menu-right dis_block float_right"></span>	 
					</span>
					</a></li>
					
				</ul>
			</div>

		</td>
	</tr>
</table>
