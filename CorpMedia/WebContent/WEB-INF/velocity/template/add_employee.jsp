

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

				<table style="width: 100%" class="table mtable ">
					<tr>
						<th><h2>ADD EMPLOYEE</h2></th>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-md-2">
									<button type="button" class="btn btn-info"
										ng-click="isEmpCollapse=!isEmpCollapse">
										<span class="glyphicon glyphicon-plus"></span>Add New
									</button>
								</div>
								<div class="col-md-10"></div>

							</div>

						</td>
					</tr>
					<tr height="20px"></tr>
					<tr>
						<td>
							<form ng-submit="saveOrUpdateEmployee()">
								<div collapse="isEmpCollapse">
									<table class="table" border="0"
										style="width: 100%; background-color: white">
										<tr>
											<td><label class="lable16_Regular">First Name </label></td>
											<td><label class="lable16_Regular">Middle Name</label></td>
										</tr>
										<tr>
											<td><input style="width: 58%"
												ng-model="employeeJson.firstName"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>
											<td><input style="width: 58%"
												ng-model="employeeJson.middleName"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>

										</tr>
										<tr>
											<td><label class="lable16_Regular">Last Name </label></td>
											<td><label class="lable16_Regular">Display Name</label></td>
										</tr>
										<tr>
											<td><input style="width: 58%"
												ng-model="employeeJson.lastName"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>
											<td><input style="width: 58%"
												ng-model="employeeJson.displayName"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>

										</tr>

										<tr>
											<td><label class="lable16_Regular">Email </label></td>
											<td><label class="lable16_Regular">Location</label></td>
										</tr>
										<tr>
											<td><input style="width: 58%"
												ng-model="employeeJson.email"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>
											<td><select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required ng-model="employeeJson.locationId"
												ng-options="location.companyLocationId as location.locationName for location in  companyLocations">
													<option value="" disabled selected>Select</option>
											</select></td>

										</tr>
										<tr>
											<td><label class="lable16_Regular">Date of
													joining </label></td>
											<td><label class="lable16_Regular">Employee Role
											</label></td>
										</tr>
										<tr>
											<td><div class="input-group">
													<input type="text" class="form-control"
														ng-model="employeeJson.strDateOfJoining"
														datepicker-popup="dd-MMM-yyyy" is-open="Opened"
														ng-click="Opened=true"> <span
														class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="Opened=true;$event.stopPropagation();">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
												</div></td>
											<td><select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required ng-model="employeeJson.roleId"
												ng-options="role.roleId as role.roleName for role in  companyRolesJsonList">
													<option value="" disabled selected>Select</option>
											</select></td>


										</tr>

										<tr>
											<td><label class="lable16_Regular">Gender </label></td>
											<td></td>
										</tr>
										<tr>
											<td><select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required ng-model="employeeJson.genderId"
												ng-options="role.roleId as role.roleName for role in  lookup.genderList">
													<option value="" disabled selected>Select</option>
											</select></td>
											<td></td>

										</tr>
										<tr>
											<td colspan="2" align="right">


												<button class="btn btn-success" style="width: 100px"
													type="submit">Add</button>
												<button class="btn btn-cancel" style="width: 100px"
													type="button" ng-click="cancelEmployee()">Cancel</button>

											</td>
										</tr>

									</table>
								</div>
							</form>


						</td>
					</tr>

					<tr>
						<td colspan="2"><table style="width: 100%" border="0"
								class="table table-bordered">
								<tr>
									<th>Dispaly Name</th>
									<th>Email</th>
									<th>Location</th>
									<th>Date of Joining</th>
									<th>Employee Role</th>
									<th>Actions</th>
								</tr>
								<tr ng-repeat="emp in employeeJsonList" ng-class-odd="'odd'"
									ng-class-even="'even'" style="height: 30px">
									<td>{{emp.displayName}}</td>
									<td>{{emp.email}}</td>
									<td>{{emp.locationId}}</td>
									<td>{{emp.strDateOfJoining}}</td>
									<td>{{emp.roleId}}</td>
									<td><a ng-click="editEmployee(emp)" tooltip="edit"
										style="cursor: pointer; font-size: 12px"><i
											class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
										tooltip="delete" ng-click="deleteEmployee(emp.employeeId)"
										style="cursor: pointer; font-size: 12px"><i
											class="fa fa-trash"></i></a></td>
								</tr>
							</table></td>
					</tr>

				</table></td>
		</tr>


	</table>
</div>



















