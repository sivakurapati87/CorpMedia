

<div class="container-fluid" style="width: 100%;">
	<table >
		<tr
			style="height: 120px; background-image: url('resources/images/bgimg3.png');">
			<td class="lable50_blue" align="center" colspan="3">{{companyName}}</td>
		</tr>
		<tr>
			<td width="20%" valign="top" bgcolor="white"><left-menu></left-menu>
			</td>
			<td width="1%"></td>
			<td valign="top">
				<form ng-submit="saveOrUpdateEmployeeLeaves()">
					<table class="table mtable " border="0"
						style="width: 100%; background-color: white; margin-top:15px;">
						
						<tr>
							<td class="th"><h2></h2><label class="lable36">Applying : Paid/Unpaid
									Leave</label></td>
						</tr> 
						<tr style="height: 10px"></tr>
						
						<tr>
							<td >
							<label 
								class="lable16_Regular">Pick a project</label>
							<select
								class="form-control ng-pristine ng-valid ng-valid-required ng-touched width30"
								required ng-model="employeeLeaveJson.projectId"
								ng-options="project.projectId as project.projectName for project in  employeeProjectsList">
									<option value="" disabled selected>Name of the Project</option>
							</select></td>
						</tr>
						<tr style="height: 10px"></tr>
						
						<tr>
							<td>
							<label class="lable16_Regular">Select leave type</label>
							<select
								class="form-control ng-pristine ng-valid ng-valid-required ng-touched width30"
								required ng-model="employeeLeaveJson.leaveTypeId"
								ng-options="leaveType.companyLeaveTypeId as leaveType.leaveTypeName for leaveType in  companyLeaveTypeJsonList">
									<option value="" disabled selected>Select leave type</option>
							</select></td>
						</tr>
						<tr style="height: 10px"></tr>
						<tr>
							<td style="width: 100%">
								<table style="width: 100%" border="0 ">
									<tr>
										<td style="width: 50%"><label class="lable16_Regular">From</label></td>
										<td style="width: 50%"><label class="lable16_Regular">To</label></td>
									</tr>
									<tr>
										<td><div class="input-group" style="width: 60%">
												<input type="text" class="form-control" required
													ng-model="employeeLeaveJson.strLeaveStartDate"
													datepicker-popup="dd-MMM-yyyy" is-open="Opened"
													ng-click="Opened=true"> <span
													class="input-group-btn">
													<button type="button" class="btn btn-info"
														ng-click="Opened=true;$event.stopPropagation();">
														<i class="glyphicon glyphicon-calendar"></i>
													</button>
												</span>
											</div></td>
										<td><div class="input-group" style="width: 60%">
												<input type="text" class="form-control" required
													ng-model="employeeLeaveJson.strLeaveEndDate"
													datepicker-popup="dd-MMM-yyyy" is-open="toOpened"
													ng-click="toOpened=true"> <span
													class="input-group-btn">
													<button type="button" class="btn btn-info"
														ng-click="toOpened=true;$event.stopPropagation();">
														<i class="glyphicon glyphicon-calendar"></i>
													</button>
												</span>
											</div></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr style="height: 10px"></tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td>
							<label class="lable16_Regular">Note</label>
							<textarea rows="5" style="resize: none; width: 70%"
									class="form-control ng-pristine  ng-valid ng-valid-required width90"
									placeholder="Please enter reason for applying leave"
									ng-model="employeeLeaveJson.note"></textarea></td>
						</tr>
						<tr style="height: 10px"></tr>
						<tr>
							<td align="center">
								<button class="btn btn-success" type="submit"
									style="width: 100px">Request</button> &nbsp;
								<button class="btn btn-cancel" style="width: 100px"
									ui-sref="employee_timesheets" type="button">Cancel</button>
							</td>
						</tr>
					<tr>
						<td class="bth"><h2></h2></td>
					</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</div>
<div class="main1" ng-show="isProcessing">
	<div class="div1">

		<i class="fa fa-spinner fa-spin " style="font-size: 60px"></i>
	</div>
</div>
