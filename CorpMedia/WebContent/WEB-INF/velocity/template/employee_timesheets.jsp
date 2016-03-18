
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
			<td valign="top"><employee-info-top></employee-info-top>
				<table class="table" style="width: 100%; background-color: white">
					<tr>
						<td>
							<div
								class="col-lg-4 col-md-4 col-sm-5 clear-side-padding ng-scope">
								<span class="fa fa-arrow-circle-left fa-2x"
									ng-click="previousWeek(weekDays[0])"></span> <span
									class="labelfont_16">{{week_StartAndEndDays}}</span> <span
									class="fa fa-arrow-circle-right fa-2x"
									ng-click="nextWeek(weekDays[6])"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td>

							<table style="width: 100%" class="table table-bordered">
								<tr style="height: 30px">
									<td ng-repeat="week in weekDays" align="center">{{week}}</td>
								</tr>
								<tr style="height: 30px">
									<td ng-repeat="timesheet in employeeTimeSheetJsonList"
										align="center"><ng-timepicker
											ng-if="(timesheet.totalTimeSpent == null && employeeLeaveJsonList[$index].leaveTime == null) ? true:false"
											init-time="{{timesheet.spendedTime}}" step="05"
											ng-model="timesheet.spendedTime"></ng-timepicker> <label
										ng-if="timesheet.totalTimeSpent != null">{{timesheet.totalTimeSpent}}</label>
										 <label style="background-color: #dea09a"
										ng-if="employeeLeaveJsonList[$index].leaveTime != null">Leave Applied</label>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>

							<table style="width: 100%" class="table table-bordered">
								<tr style="height: 30px">
									<td><div>
											<div style="float: left;">Leaves</div>
											<div style="float: right;">
												<a ui-sref="applyLeave">Apply Leave</a>
											</div>
										</div></td>
									<td ng-repeat="week in weekDays" align="center">{{week}}</td>
								</tr>
								<tr style="height: 30px">
									<td style="width: 20%"></td>
									<td ng-repeat="leave in employeeLeaveJsonList" align="center"><ng-timepicker
											ng-if="leave.strTotalLeaveTime == null"
											init-time="{{leave.leaveTime}}" step="05"
											ng-model="timesheet.spendedTime"></ng-timepicker> <label
										ng-if="leave.strTotalLeaveTime != null">{{leave.strTotalLeaveTime}}</label>
									</td>
								</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td align="right">
							<table>
								<tr>
									<td><button class="btn btn-success" type="button"
											ng-click="saveOrUpdateEmployeeTimesheetList()"
											style="width: 150px">Save Timesheet</button></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr style="height: 10px"></tr>
					<tr>
						<td align="right" style="padding-right: 200px;"><label
							class="lable16_Regular">Pick a project:</label></td>
					</tr>
					<tr>
						<td align="right"><select
							class="form-control ng-pristine ng-valid ng-valid-required ng-touched width30"
							required ng-model="projectId"
							ng-options="project.projectId as project.projectName for project in  employeeProjectsList">
								<option value="" disabled selected>Name of the Project</option>
						</select></td>
					</tr>
					<tr style="height: 10px"></tr>
					<tr>
						<td align="right">
							<table>
								<tr>
									<td><button class="btn btn-success" type="button"
											ng-disabled="employeeTimeSheetJsonList[0].projectId != null"
											ng-click="submitEmployeeTimesheetListForApproval()"
											style="width: 180px">Submit for Approval</button></td>
								</tr>
							</table>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</div>
