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

									<li ng-class="{'active':(state==='assign_roles')}"><a
										class="anchor-sm" ui-sref="assign_roles">Company Roles</a></li>



								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td><div class="panel-body">

								<div
									class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
									<div class="col-lg-12">
										<h4 class="page-heading">Company Roles</h4>
									</div>
								</div>


								<form ng-submit="saveOrUpdateRole()">
									<div class="col-lg-12 clear-left-padding">
										<div class="form-group">
											<div class="col-md-6 col-sm-6">
												<label>Role</label> <input
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													placeholder="Role" ng-model="companyRolesJson.roleName"
													required=""> <br>
											</div>
										</div>
									</div>
									<div class="col-lg-12 clear-left-padding">
										<div class="form-group">
											<div class="col-md-6">

												<button class="btn btn-success" type="submit"
													style="width: 100px">Submit</button>
												 <br/>
											</div>

										</div>
									</div>
								</form>
								<div ng-show="companyRolesJsonList"
									class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container"
									style="width: 40%">
									<div class="col-lg-12" style="width: 100%">
										<table style="width: 100%" border="0">
										<tr style="height: 20px"></tr>
											<tr>
												<th  width="35%">Edit</th>
												<th>Role</th>
											</tr>
											<tr ng-repeat="role in companyRolesJsonList"
												ng-class-odd="'odd'" ng-class-even="'even'">
												<td>
													<button type="button" class="btn btn-danger"
														ng-click="editRole(role)">Edit</button>
												</td>
												<td>{{role.roleName}}</td>
											</tr>
										</table>
									</div>
								</div>
							</div></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>



























