

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
			<td valign="top"><employee-module-top></employee-module-top>
				<table class="table mtable " border="0"
					style="width: 100%; background-color: white">


					<tr><th class="th"><h2>ALL EMPLOYEES</h2></th> </tr><tr>
					<tr>
						<td colspan="4" width="100%"></td>
					</tr>

					<tr height="50px"></tr>



					<tr>
						<td colspan="2"><table style="width: 100%" border="0"
								class="table table-bordered">
								<tr>
									<th>Employee No</th>
									<th>Employee Name</th>
									<th>Email</th>
									<th>Date of Joining</th>
									<th>Job Title</th>
								</tr>
								<tr ng-repeat="emp in employeeJsonList" ng-class-odd="'odd'"
									ng-class-even="'even'" style="height: 30px">
									<td>{{emp.employeeId}}</td>
									<td>{{emp.displayName}}</td>
									<td><a ng-click="onClickNavigation(emp)" href="#">{{emp.email}}</a></td>
									<td>{{emp.strDateOfJoining}}</td>
									<td>{{emp.role}}</td>
								</tr>
							</table></td>
					</tr>
					<tr height="50px"></tr>



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
