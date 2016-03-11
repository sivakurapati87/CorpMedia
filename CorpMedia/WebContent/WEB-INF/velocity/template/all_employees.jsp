

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
				<table class="table" border="0"
					style="width: 100%; background-color: white">



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
									<td><a ng-click="onClickNavigation(emp.employeeId,emp.displayName)" href="#">{{emp.email}}</a></td>
									<td>{{emp.strDateOfJoining}}</td>
									<td>{{emp.role}}</td>
								</tr>
							</table></td>
					</tr>
					<tr height="50px"></tr>




				</table></td>
		</tr>
	</table>
</div>
