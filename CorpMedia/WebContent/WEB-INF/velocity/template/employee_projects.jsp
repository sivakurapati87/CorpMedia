
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
				<form ng-submit="saveOrUpdateEmployeeProject()">
					<table class="table" border="0"
						style="width: 100%; background-color: white">
						<tr style="height: 20px"></tr>
						<tr>
							<td><label class="lable16_Regular">Project:</label></td>
						</tr>
						<tr>
							<td><select
								class="form-control ng-pristine ng-valid ng-valid-required ng-touched width30"
								required ng-model="employeeProjectJson.projectId"
								ng-options="project.projectId as project.projectName for project in  finalProjectsList">
									<option value="" disabled selected>Name of the Project</option>
							</select></td>
						</tr>
						<tr style="height: 10px"></tr>
						<tr>
							<td><label class="lable16_Regular">Role:</label></td>
						</tr>
						<tr>
							<td><select
								class="form-control ng-pristine ng-valid ng-valid-required ng-touched width30"
								required ng-model="employeeProjectJson.roleId"
								ng-options="role.roleId as role.roleName for role in  companyRolesJsonList">
									<option value="" disabled selected>Name of the Role	</option>
							</select></td>
						</tr>
						<tr style="height: 10px"></tr>
						<tr>
							<td>
								<button class="btn btn-success" type="submit"
									style="width: 100px">Save</button>
							</td>
						</tr>
						</form>
						<tr style="height: 10px"></tr>
						<tr>
							<td><table style="width: 40%" border="0"
									class="table table-bordered">
									<tr>
										<th>Project</th>
										<th>Role</th>
										<th>Actions</th>
									</tr>
									<tr ng-repeat="empProject in employeeProjectsList"
										ng-class-odd="'odd'" ng-class-even="'even'"
										style="height: 30px">
										<td>{{empProject.projectName}}</td>
										<td>{{empProject.role}}</td>
										<td><a ng-click="editEmployeeProject(empProject)"
											tooltip="edit" style="cursor: pointer; font-size: 12px"><i
												class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
											tooltip="delete"
											ng-click="deleteEmployeeProject(empProject.employeeProjectId)"
											style="cursor: pointer; font-size: 12px"><i
												class="fa fa-trash"></i></a></td>
									</tr>
								</table></td>
						</tr>
					</table>
				</form></td>
		</tr>
	</table>
</div>
