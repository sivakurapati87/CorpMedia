<table class="table" border="0" style="width: 100%;">
	<tr>
		<td>
			<div class="subnavbar-static-side">
				<ul class="nav">
					<li ng-class="{'active':(left_state==='company_settings')}"><a
						class="anchor-sm" ng-click="leftMenuAction('company_legalentities','company_legalentities')" href="#"> <span class="subnav-item-title">Company
								Settings</span> <br> <span class="subnav-item-description">
								Company settings, Legal Entities, Locations and Department
								settings <span class="glyphicon glyphicon-menu-right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='payroll')}"><a
						class="anchor-sm" ng-click="leftMenuAction('general_payroll_settings','payroll')" href="#"> <span
							class="subnav-item-title">Payroll</span> <br> <span
							class="subnav-item-description"> Payroll cycle,salary
								components etc <span class="glyphicon glyphicon-menu-right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='leaves_&_holidays')}"><a
						class="anchor-sm" ng-click="leftMenuAction('leave_plans','leaves_&_holidays')" href="#"> <span
							class="subnav-item-title">Leaves & Holidays</span> <br> <span
							class="subnav-item-description"> Leave plans,types,Holidays and Policies
								 <span class="glyphicon glyphicon-menu-right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='timesheet')}"><a
						class="anchor-sm" ui-sref="timesheet_general" href="#"> <span
							class="subnav-item-title">Timesheet</span> <br> <span
							class="subnav-item-description"> Manage the employee timesheet approval chain settings.
								 <span class="glyphicon glyphicon-menu-right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='time_&_attendance')}"><a
						class="anchor-sm" ui-sref="weekly_offs" href="#"> <span
							class="subnav-item-title">Time & Attendance</span> <br> <span
							class="subnav-item-description">Time and Attendance settings.
								 <span class="glyphicon glyphicon-menu-right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='expenses')}"><a
						class="anchor-sm" ui-sref="categories" href="#"> <span
							class="subnav-item-title">Expenses</span> <br> <span
							class="subnav-item-description">Employee Expense Claims,Claim approvers,.......
								 <span class="glyphicon glyphicon-menu-right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='onboarding_&_exit')}"><a
						class="anchor-sm" ui-sref="welcome_screen" href="#"> <span
							class="subnav-item-title">Onboarding & Exit</span> <br> <span
							class="subnav-item-description">Employee Onboarding and exit process and checklist
								 <span class="glyphicon glyphicon-menu-right"></span>
						</span>
					</a></li>
					<li ng-class="{'active':(left_state==='roles_&_permissions')}"><a
						class="anchor-sm" ui-sref="assign_roles" href="#"> <span
							class="subnav-item-title">Roles & Permissions</span> <br> <span
							class="subnav-item-description">Manage roles and permissions.
								 <span class="glyphicon glyphicon-menu-right"></span>
						</span>
					</a></li>
					
				</ul>
			</div>

		</td>
	</tr>
</table>