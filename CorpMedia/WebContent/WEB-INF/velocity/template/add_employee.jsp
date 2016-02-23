

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
			<td valign="top">

				<table class="table" border="0" style="width: 100%;">
					<tr>
						<td>
							<div class="sub-page-navigation">
								<ul>

									<li ng-class="{'active':(state==='job_titles')}"><a
										class="anchor-sm" ui-sref="job_titles">Job Titles</a></li>
									<li ng-class="{'active':(state==='employee_defaults')}"><a
										class="anchor-sm" ui-sref="employee_defaults">Employee
											Defaults</a></li>
									<li ng-class="{'active':(state==='add_employee')}"><a
										class="anchor-sm" ui-sref="add_employee">Add Employee</a></li>
									<li ng-class="{'active':(state==='employee_professional')}"><a
										class="anchor-sm" ui-sref="employee_professional">Professional</a></li>
									<li ng-class="{'active':(state==='employee_personal')}"><a
										class="anchor-sm" ui-sref="employee_personal">Personal</a></li>
									<li ng-class="{'active':(state==='employee_job')}"><a
										class="anchor-sm" ui-sref="employee_job">Job</a></li>





								</ul>
							</div>
						</td>
					</tr>
				</table>
				<form ng-submit="saveOrUpdateEmployee()">
					<table class="table" border="0"
						style="width: 100%; background-color: white">
						<tr>
							<td><label class="lable16_Regular">First Name </label></td>
							<td><label class="lable16_Regular">Middle Name</label></td>
						</tr>
						<tr>
							<td><input style="width: 58%"
								ng-model="EmployeeJson.firstName"
								class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
								type="text" required=""></td>
							<td><input style="width: 58%"
								ng-model="EmployeeJson.middleName"
								class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
								type="text" required=""></td>

						</tr>
						<tr>
							<td><label class="lable16_Regular">Last Name </label></td>
							<td><label class="lable16_Regular">Display Name</label></td>
						</tr>
						<tr>
							<td><input style="width: 58%"
								ng-model="EmployeeJson.lastName"
								class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
								type="text" required=""></td>
							<td><input style="width: 58%"
								ng-model="EmployeeJson.displayName"
								class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
								type="text" required=""></td>

						</tr>

						<tr>
							<td><label class="lable16_Regular">Email </label></td>
							<td><label class="lable16_Regular">Location</label></td>
						</tr>
						<tr>
							<td><input style="width: 58%" ng-model="EmployeeJson.email"
								class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
								type="text" required=""></td>
							<td><select
								class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
								required ng-model="EmployeeJson.locationId"
								ng-options="location.companyLocationId as location.locationName for location in  companyLocations">
									<option value="" disabled selected>Select</option>
							</select></td>

						</tr>
						<tr>
							<td><label class="lable16_Regular">Date of joining </label></td>
							<td><label class="lable16_Regular">Employee Role </label></td>
						</tr>
						<tr>
							<td><div class="input-group">
									<input type="text" class="form-control"
										ng-model="EmployeeJson.strDateOfJoining"
										datepicker-popup="dd-MMM-yyyy" is-open="Opened"
										ng-click="Opened=true"> <span class="input-group-btn">
										<button type="button" class="btn btn-default"
											ng-click="Opened=true;$event.stopPropagation();">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
								</div></td>
							<td><select
								class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
								required ng-model="EmployeeJson.roleId"
								ng-options="role.roleId as role.roleName for role in  companyRolesJsonList">
									<option value="" disabled selected>Select</option>
							</select></td>


						</tr>
						<td colspan="2" align="right">


							<button class="btn btn-success" style="width: 100px"
								type="submit">Add</button>
							<button class="btn btn-cancel" style="width: 100px" type="button">Cancel</button>

						</td>
						</tr>

					</table>
				</form>
			</td>
		</tr>
	</table>
</div>



















