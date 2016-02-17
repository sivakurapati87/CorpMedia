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
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td><h2>Departments</h2></td>
					</tr>
					<tr>
						<td>Departments are used to group the employees based on
							certain criteria.</td>
					</tr>
					<tr>
						<td><button type="button" class="btn btn-info"
								data-toggle="collapse" data-target="#demo">
								<span class="glyphicon glyphicon-plus"></span> Add New
							</button>

							<div id="demo" class="collapse">
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
												type="text" required="" ng-model="department.departmentName"
												name="panNumber"></td>
										</tr>
										<tr height="30px"></tr>
										<tr>

											<td>

												<button class="btn btn-success" type="submit" style="width: 100px">Save</button>&nbsp;
												<button class="btn btn-cancel" style="width: 100px">Cancel</button>
											</td>
										</tr>
									</table>
								</form>
							</div></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
<div class="snaker animated fadeIn high-index loading">
            <div class="circle1"></div>
            <div class="circle2"></div>
            <div class="circle3"></div>
            <div class="circle4"></div>
            <div class="circle5"></div>
            <div class="circle6"></div>
            <h6>LOADING</h6>
</div>

