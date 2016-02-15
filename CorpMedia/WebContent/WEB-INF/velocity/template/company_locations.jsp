

<div class="container-fluid" style="width: 100%;">
	<table>
		<tr style="height: 120px;background-image:url('resources/images/bgimg3.png');">
			<td class="lable50_blue" align="center" colspan="3">{{companyName}}</td>
		</tr>
		<tr>
			<td width="20%" valign="top" bgcolor="white">
				<left-menu></left-menu>
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
				<table class="table" border="0" style="width: 100%;background-color: white">
					<tr>
						<td><h2>Locations</h2></td>
					</tr>
					<tr>
						<td>Locations can be branches or subsidiaries in other
							geographies whose employees are also part of organization.
							Locations allow you to specify separate policy settings specific
							to that geography.</td>
					</tr>
					<tr>
						<td><button type="button" class="btn btn-info"
								data-toggle="collapse" data-target="#demo">
								<span class="glyphicon glyphicon-plus"></span> Add New
							</button>

							<div id="demo" class="collapse">
								<table border="0">
									<tr height="10px"></tr>
									<tr>
										<td><label> Add Location</label></td>
									</tr>
									<tr height="30px"></tr>
									<tr>
										<td><label> Location Name</label></td>
									</tr>
									<tr>
										<td><input id="panNumber" style="width: 200%"
											placeholder="Location Name"
											class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
											type="text" required="" data-ng-model="model.panNumber"
											name="panNumber"></td>
									</tr>

									<tr height="30px"></tr>

									<tr>
										<td><label>Country</label></td>
										<td>State</td>
									</tr>
									<tr>
										<td width="50%"><select class="form-control"
											id="exampleInputEmail1">
												<option>Select Country</option>
										</select></td>
										<td><select class="form-control" id="exampleInputEmail1">
												<option>Select State</option>
										</select></td>
									</tr>
									<tr height="30px"></tr>
									<tr>
										<td><label>Time Zone</label></td>
									</tr>
									<tr>
										<td><select class="form-control" id="exampleInputEmail1" style="width: 200%">
												<option>Select Time Zone</option>
										</select></td>
									</tr>
									<tr height="30px"></tr>
									<tr>
										<td><label> Address Line 1</label></td>
									</tr>
									<tr>
										<td><input id="panNumber" style="width: 200%"
											placeholder="Address Line 1"
											class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
											type="text" required="" data-ng-model="model.panNumber"
											name="panNumber"></td>
									</tr>
									<tr height="30px"></tr>
									<tr>
										<td><label>Address Line 2</label></td>
									</tr>
									<tr>
										<td><input id="panNumber" style="width: 200%"
											placeholder="Address Line 2"
											class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
											type="text" required="" data-ng-model="model.panNumber"
											name="panNumber"></td>
									</tr>
									<tr height="30px"></tr>

									<tr>
										<td><label>City</label></td>
										<td>ZipCode</td>
									</tr>
									<tr>
										<td width="50%"><input id="panNumber" 
											placeholder="City"
											class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
											type="text" required="" data-ng-model="model.panNumber"
											name="panNumber"></td>
										<td width="50%"><input id="panNumber"
											placeholder="ZipCode"
											class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
											type="text" required="" data-ng-model="model.panNumber"
											name="panNumber"></td>
									</tr>


									<tr height="30px"></tr>
									<tr>

										<td>

											<button class="btn btn-success" style="width: 100px">Save</button>&nbsp;
											<button class="btn btn-cancel" style="width: 100px">Cancel</button>
										</td>
									</tr>
								</table>

							</div></td>
					</tr>

				</table>
			</td>
		</tr>
	</table>
</div>


