


<div class="container-fluid" style="width: 100%;">
	<table>
		<tr
			style="height: 120px; background-image: url('resources/images/bgimg3.png');">
			<td class="lable50_blue" align="center" colspan="3">{{companyName}}</td>
		</tr>
		<tr>
			<td width="20%" valign="top" bgcolor="white"><left-menu></left-menu>
			</td>
			<td width="1%"></td>
			<td valign="top"><payroll-info-top></payroll-info-top>
				<table class="table mtable " border="0"
					style="width: 100%; background-color: white">
					<tr>
						<th class="th"><h2>RUN PAYROLL</h2></th>
					</tr>
					<tr>
						<td>
							<button type="button" class="btn btn-info" ng-if="isDisabled"
								ng-click="viewEmployeesPayRollByCompanyId()">View
								Employee Salary Info to run it</button>
						</td>
					</tr>
					<tr style="height: 20px"></tr>
					<tr ng-if="!isDisabled">
						<td>
							<div style="width: 100%; overflow: auto;">
								<table style="width: 100%" border="0"
									class="table table-bordered">
									<tr>
										<th>Employee Name</th>
										<th>Basic</th>
										<th>PF</th>
										<th>HRA</th>
										<th>Tax Deduction</th>
										<th>Medical Allowance</th>
										<th>Professional Tax</th>
										<th>Transport Allowance</th>
										<th>Other Deductions</th>
										<th>Special Allowance</th>

										<th>Gross Earnings</th>
										<th>Gross Deductions</th>
										<th>Net Amount</th>
										<th>Applied Timesheets</th>
										<th>Applied Leaves</th>
										<th>Pending Leaves</th>
										<th>Rejected Leaves</th>
									</tr>
									<tr
										ng-repeat="employeeSalaryInfoJson in employeeSalaryInfoJsonList"
										ng-switch on="$index % 3" ng-class-odd="'odd'"
										ng-class-even="'even'" style="height: 30px">




										<td>{{employeeSalaryInfoJson.employeeJson.displayName}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.basic}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.pf}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.hra}}</td>
										<td>-</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.medicalReimbursement}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.professionalAllowance}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.transportAllowance}}</td>
										<td>-</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.specialAllowance}}</td>

										<td>{{employeeSalaryInfoJson.salaryComponentJson.grossEarningInMoney}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.grossDeductionsInMoney}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.netAmountInMoney}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.noOfTimeSheet}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.leavesApplied}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.pendingLeaveToGrant}}</td>
										<td>{{employeeSalaryInfoJson.salaryComponentJson.noOfRejectedLeaves}}</td>

									</tr>

									<!-- 								<tr ng-repeat="item in employeeSalaryInfoJsonList" ng-hide="$index%2"> -->
									<!-- 									<td><label>{{ employeeSalaryInfoJsonList[$index].employeeJson.displayName}}</label></td> -->
									<!-- 									<td ng-hide="!employeeSalaryInfoJsonList[$index+1]"><label>{{ -->
									<!-- 											employeeSalaryInfoJsonList[$index+1].employeeJson.displayName}}</label></td> -->
									<!-- 								</tr> -->
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td class="bth"><h2></h2></td>
					</tr>
				</table></td>
		</tr>
	</table>
</div>

<div class="main1" ng-show="isProcessing">
	<div class="div1">

		<i class="fa fa-spinner fa-spin " style="font-size: 60px"></i>
	</div>
</div>













