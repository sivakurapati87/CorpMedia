

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
			<td valign="top"><time-and-attendance-module-top></time-and-attendance-module-top>
				<form ng-submit="saveOrUpdateEmployeeLeaves()">
					<table class="table mtable" border="0"
						style="width: 100%; ">
						<tr><th class="th" colspan="2"><h2>TIMESHEET APPROVAL</h2></th></tr>
						<tr>
							<td><b>Applied timesheets count:<i> {{getLength()}}</i></b></td>
							<td><b><i>{{value}}</i></b></td>
						</tr>
						<tr ng-repeat="(key,value) in empTimesheetMap">
							<td colspan="2">
								<table class="table" border="0">
									<tr class="row1">
										<td><b>Employee Name:<i> {{value[0].displayName}}</i></b></td>
										
										<td><b>Email:<i>{{value[0].email}}</i></b></td>
										
									</tr>
								</table>
								<div style="height: 10px;"></div>
								<table style="width: 100%" border="0"
									class="table table-bordered">
									<tr class="tdh">
										<th >Date</th>
										<th>Spended Time</th>
									</tr>
									<tr ng-repeat="emptimesheet in value" ng-class-odd="'odd'"
										ng-class-even="'even'" style="height: 30px">
										<td>{{emptimesheet.strTimeSheetDate}}</td>
										<td>{{emptimesheet.spendedTime}}</td>
									</tr>
								</table>
								<table style="width: 100%">
									<tr>
										<td>Comment:</td>
									</tr>
									<tr style="height: 10px"></tr>
									<tr> 
										<td><textarea rows="5" style="resize: none; width: 70%"
												class="form-control ng-pristine  ng-valid ng-valid-required width90"
												placeholder="Please enter reason for applying leave"
												ng-model="comment"></textarea></td>
									</tr>
									<tr style="height: 20px"></tr>
									<tr>
										<td align="center">
											<button class="btn btn-success" type="button"
												ng-click="approveOrRejectEmpTimeSheet('Approve',value)"
												style="width: 100px">Approve</button> &nbsp;
											<button class="btn btn-danger" style="width: 100px"
												ng-click="approveOrRejectEmpTimeSheet('Reject',value)"
												type="button">Reject</button>
										</td>
									</tr>
								</table>
							<DIV style="height:20px; width: 100% ; border-bottom: dashed 2px #aaa;  "></DIV>
							</td>
							
						</tr>
					<tr><td class="bth" colspan="2"><h2></h2></td></tr>
					</table>
				</form></td>
		</tr>
	</table>
</div>
