

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
								ng-click="isCollapse = !isCollapse">
								<span class="glyphicon glyphicon-plus"></span> Add New
							</button>
							<div class="row">
								<div  class="col-lg-8" collapse="isCollapse">
									<form ng-submit="saveLocation()">
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
												<td><input style="width: 200%"
													placeholder="Location Name"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													type="text" required=""
													ng-model="companyLocationJson.locationName"></td>
											</tr>

											<tr height="30px"></tr>

											<tr>
												<td><label>Country</label></td>
												<td>State</td>
											</tr>
											<tr>
												<td width="50%"><select class="form-control"
													disabled="disabled">
														<option value="" disabled selected>India</option>
												</select></td>
												<td><select
													class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
													required ng-model="companyLocationJson.stateId"
													ng-options="bank.lookupDetailId as bank.description for bank in  lookup.statesList">
														<option value="" disabled selected>Name of the
															State</option>
												</select></td>
											</tr>
											<tr height="30px"></tr>
											<tr>
												<td><label>Time Zone</label></td>
											</tr>
											<tr>
												<td><select
													class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
													disabled="disabled">
														<option value="" disabled selected>(UTC+05:30)
															Chennai, Kolkata, Mumbai, New Delhi</option>
												</select></td>
											</tr>
											<tr height="30px"></tr>
											<tr>
												<td><label> Address</label></td>
											</tr>
											<tr>
												<td><input style="width: 200%" placeholder="Address"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													type="text" required=""
													ng-model="companyLocationJson.address"></td>
											</tr>
											<tr height="30px"></tr>

											<tr>
												<td><label>City</label></td>
												<td>ZipCode</td>
											</tr>
											<tr>
												<td width="50%"><input placeholder="City"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													type="text" required="" ng-model="companyLocationJson.city"></td>
												<td width="50%"><input placeholder="ZipCode"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													type="text" required=""
													ng-model="companyLocationJson.zipcode"></td>
											</tr>


											<tr height="30px"></tr>
											<tr>

												<td>

													<button class="btn btn-success" style="width: 100px"
														type="submit">Save</button>&nbsp;
													<button class="btn btn-cancel" style="width: 100px" type="button">Cancel</button>
												</td>
											</tr>
										</table>
									</form>
								</div>
								<div class="col-lg-8">
									<table style="width: 100%" border="0">
										<tr style="height: 20px"></tr>
										<tr ng-repeat="location in companyLocationsList"
											ng-class-odd="'odd'" ng-class-even="'even'">
											<td><div>{{location.locationName}}</div>
												<div>{{location.city}}, {{location.state}}</div></td>
											<td><a ng-click="editCompanyLocation(location)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-pencil-square-o"></i></a></td>
											<td><a
												ng-click="deleteCompanyLocation(location.companyLocationId)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</table>
								</div>
							</div></td>
					</tr>

				</table>
			</td>
		</tr>
	</table>
</div>


