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
									<li ng-class="{'active':(state==='legalentities')}"><a
										class="anchor-sm"
										ui-sref="company_legalentities.mainInfo({legEntity:'cmpInfo'})">Legal
											Entities</a></li>
									<li ng-class="{'active':(state==='general')}"><a
										class="anchor-sm" ui-sref="company_general">General Info</a></li>
									<li ng-class="{'active':(state==='locations')}"><a
										class="anchor-sm" ui-sref="company_locations">Locations</a></li>
									<li ng-class="{'active':(state==='department')}"><a
										class="anchor-sm" ui-sref="company_department">Departments</a>
									</li>
								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table mtable" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<th class="th"><h2>Departments</h2></th>
					</tr>
					<tr>
						<td>Departments are used to group the employees based on
							certain criteria.</td>
					</tr>
					<tr>
						<td><button type="button" class="btn btn-info"
								ng-click="isCollapse = !isCollapse">
								<span class="glyphicon glyphicon-plus"></span> Add New
							</button>

							<div class="row">
								<div class="col-lg-8" collapse="isCollapse">
									<form ng-submit="saveDepartment()">
										<table border="0">
											<tr height="10px"></tr>
											<tr>
												<td><label> Add Department</label></td>
											</tr>
											<tr height="30px"></tr>
											<tr>
												<td><label> Department Name</label></td>
											</tr>
											<tr>
												<td><input id="panNumber" style="width: 200%"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													type="text" required=""
													ng-model="department.departmentName" name="panNumber"></td>
											</tr>
											<tr height="30px"></tr>
											<tr>

												<td>

													<button class="btn btn-success" type="submit"
														style="width: 100px">Save</button>&nbsp;
													<button class="btn btn-cancel" style="width: 100px" ng-click="cancelCompanyDepartment()"
														type="button">Cancel</button>
												</td>
											</tr>
											<tr height="20px"></tr>
										</table>
									</form>
								</div>
								<div style="height: 20px"></div>
								<div class="col-lg-8">
									<table style="width: 80%;text-align: center" border="0" class="table table-bordered">
										
										<tr ng-repeat="department in companyDepartmentList"
											ng-class-odd="'odd'" ng-class-even="'even'" style="height: 30px">
											<td><b>{{department.departmentName}}</b></td>
											<td><a ng-click="editCompanyDepartment(department)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a
												ng-click="deleteCompanyDepartment(department.departmentId)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</table>
								</div>
							</div></td>
					</tr>
					<tr>
						<td class="bth"><h2></h2></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

