
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
				<table class="table mtable" style="width: 100%; background-color: white">
					<tr><th class="th"> <h2>EMPLOYEE TIMESHEETS</h2></th> </tr>
					<tr>
						<td>
							<div class="  ng-scope def" style="text-align:center;" >
								<span class="fa fa-arrow-circle-left fa-2x" ng-click="previousWeek(weekDays[0])" style="float: left;position:;"></span>
								<h4 style="display: inline-block; "> <span class=""   style="color:#71690f;">{{week_StartAndEndDays}}</span></h4> 
								<span class="fa fa-arrow-circle-right fa-2x" ng-click="nextWeek(weekDays[6])" style="float: right; "></span>
							</div>
						</td>
					</tr>
					<tr>
						<td>

							<table style="width: 100%" class="table table-bordered hi">
								<tr style="height: 30px">
									<td ng-repeat="week in weekDays" align="center" class="tdh">{{week}}</td>
								</tr>
								<tr style="height: 30px">
									<td ng-repeat="timesheet in employeeTimeSheetJsonList"
										align="center" class="tdv"><ng-timepicker 
											ng-if="(timesheet.totalTimeSpent == null && employeeLeaveJsonList[$index].leaveTime == null) ? true:false"
											init-time="{{timesheet.spendedTime}}" step="05"
											ng-model="timesheet.spendedTime"></ng-timepicker> <label
										ng-if="timesheet.totalTimeSpent != null">{{timesheet.totalTimeSpent}}</label>
										 <label class="tdh l1" 
										ng-if="employeeLeaveJsonList[$index].leaveTime != null">Leave Applied</label>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>

							<table style="width: 100%" class="table table-bordered hi ">
								<tr style="height: 30px">
									<td class="tdh"><div >
											<div style="float: left;"class="lable16_Regular">Leaves</div>
											<div style="float: right; color:#fff; " class="btn btn-primary btn-sm">
												<a ui-sref="applyLeave" style="color:#fff;">Apply Leave</a>
											</div>
										</div></td>
									<td ng-repeat="week in weekDays" align="center" class="tdh">{{week}}</td>
								</tr>
								<tr style="height: 30px">
									<td style="width: 20%"></td>
									<td ng-repeat="leave in employeeLeaveJsonList" align="center" class="tdv" > <ng-timepicker 
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
						<td align="right">
						<label style="padding-right: 225px;" class="lable16_Regular">Pick a project:</label>
						<select
							class="form-control ng-pristine ng-valid ng-valid-required ng-touched width30"
							required ng-model="projectId"
							ng-options="project.projectId as project.projectName for project in  employeeProjectsList">
								<option value="" disabled selected>Name of the Project</option>
						</select></td>
					</tr>
					<tr style="height: 10px"></tr>
					<tr>
						<td align="right" >
							<table style="padding-right: 225px;">
								<tr>
									<td><button class="btn btn-success" type="button"
											ng-disabled="employeeTimeSheetJsonList[0].projectId != null"
											ng-click="submitEmployeeTimesheetListForApproval()"
											style="width: 180px; ">Submit for Approval</button></td>
								</tr>
							</table>
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