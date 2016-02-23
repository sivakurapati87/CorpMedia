
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
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td><p>
								<font size="5">Basic Info</font>
							</p>
							<hr>
							<form ng-submit="saveOrUpdateEmployeePersonalInfo()">

								<!--first part of the form-->
								<div class="row">
									<div class="col-md-12" align="center">
										<select
											class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
											required ng-model="employeePersonalInfoJson.employeeId"
											ng-options="emp.employeeId as emp.displayName for emp in  EmployeeJsonList">
											<option value="" disabled selected>Select</option>
										</select>
									</div>

									<!--this is the first half of the form-->
									<div class="col-md-4">


										<div class="form-group">
											<label for="first_name">First Name</label> <input type="text"
												class="form-control" id="first_name"
												placeholder="First name">
										</div>


										<br>


										<div class="form-group">
											<label for="middle_name">Middle Name</label> <input
												type="text" class="form-control" id="middle_name"
												placeholder="Middle Name">
										</div>
										<br>


										<div class="form-group">
											<label for="last_name">Last Name</label> <input type="text"
												class="form-control" id="last_name" placeholder="Last Name">
										</div>


									</div>



									<!--this remains empty-->
									<div class="col-md-2"></div>


									<!--this is the second half of the form and this parallel to the first half(means right side)-->
									<div class="col-md-4">

										<div class="form-group">
											<label for="display_name">Display Name</label> <input
												type="text" class="form-control" id="display_name">
										</div>

										<br>

										<div class="form-group">
											<label for="email">Email</label> <input type="email"
												class="form-control" id="email" placeholder="Email">
										</div>


									</div>


									<!--this remains empty-->
									<div class="col-md-2"></div>

								</div>
								<!--this is the end of the row-->

								<br>

								<!--here first part of the information is completed-->
								<!--second half starts here-->
								<p>
									<font size="5">Personal Info</font>
								</p>
								<hr>

								<div class="row">

									<!--this is the first half of the form's second part-->
									<div class="col-md-4">

										<div class="form-group">
											<label for="sel1">Gender</label> <select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required ng-model="employeePersonalInfoJson.genderId"
												ng-options="gender.lookupDetailId as gender.description for gender in  lookup.genderList">
												<option value="" disabled selected>Select</option>
											</select>
										</div>

										<br>




										<div class="form-group">
											<label for="sel1">Marital Status</label> <select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required ng-model="employeePersonalInfoJson.maritalStatusId"
												ng-options="ms.lookupDetailId as ms.description for ms in  lookup.maritalStatusList">
												<option value="" disabled selected>Select</option>
											</select>
										</div>


									</div>

									<div class="col-md-2"></div>

									<div class="col-md-4">

										<div class="form-group">
											<label for="date_of_birth">Date Of Birth</label>
											<div class="input-group">
												<input type="text" class="form-control"
													ng-model="employeePersonalInfoJson.strDateOfBirth"
													datepicker-popup="dd-MMM-yyyy" is-open="Opened"
													ng-click="Opened=true"> <span
													class="input-group-btn">
													<button type="button" class="btn btn-default"
														ng-click="Opened=true;$event.stopPropagation();">
														<i class="glyphicon glyphicon-calendar"></i>
													</button>
												</span>
											</div>
										</div>
										<br>

										<div class="form-group">
											<label for="sel3">Blood Group</label> <select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required ng-model="employeePersonalInfoJson.bloodGroupId"
												ng-options="bg.lookupDetailId as bg.description for bg in  lookup.bloodGroupList">
												<option value="" disabled selected>Select</option>
											</select>
										</div>



									</div>

									<div class="col-md-2"></div>




								</div>
								<!--this is the end of the second row-->

								<br>

								<!--here second part of the information is completed-->
								<!--Third part starts here-->
								<p>
									<font size="5">Contact Info</font>
								</p>
								<hr>

								<div class="row">

									<!--this is the first half of the form's second part-->
									<div class="col-md-4">

										<div class="form-group">
											<label for="mobile">Mobile Number</label> <input type='tel'
												ng-model="employeePersonalInfoJson.mobileNumber"
												class="form-control" id='mobile'>
										</div>

										<br>

										<div class="form-group">
											<label for="residence_number">Residence Number</label> <input
												ng-model="employeePersonalInfoJson.residenceNumber"
												type='tel' class="form-control" id='residence_number'>
										</div>

										<br>

										<div class="form-group">
											<label for="skype_id">Skype ID</label> <input type='email'
												ng-model="employeePersonalInfoJson.skypeId"
												class="form-control" id='skype_id'>
										</div>





									</div>

									<div class="col-md-2"></div>

									<div class="col-md-4">

										<div class="form-group">
											<label for="work_mumber">Work Number</label> <input
												type='tel' ng-model="employeePersonalInfoJson.workNumber"
												class="form-control" id='work_number'>
										</div>

										<br>

										<div class="form-group">
											<label for="personal_email">Personal Email</label> <input
												ng-model="employeePersonalInfoJson.personalEmail" type='tel'
												class="form-control" id='personal_email'>
										</div>





									</div>

									<!--this remains empty-->
									<div class="col-md-2"></div>




								</div>
								<!--this is the end of the second row-->

								<br> <br>

								<!--third part ends here-->
								<!--fourth and final part starts here-->

								<div class='row'>
									<!--first half of the row-->
									<div class='col-md-4'>
										<p>
											<font size="3"><b>Current Address</b></font>
										</p>
										<br>

										<div class="form-group">
											<label for="address1">Address Line </label> <input
												type='text' class="form-control"
												ng-model="employeePersonalInfoJson.currAddress"
												placeholder="Address Line 1">
										</div>
										<br>
										<div class="form-group">
											<label for="city">City</label> <input type='text'
												ng-model="employeePersonalInfoJson.currCity"
												class="form-control" id='city' placeholder="City">
										</div>
										<br>
										<div class="form-group">
											<label for="state">State</label> <input type='text'
												ng-model="employeePersonalInfoJson.currState"
												class="form-control" id='state' placeholder="State">
										</div>
										<br>
										<div class="form-group">
											<label for="country">Country</label> <input type='text'
												ng-model="employeePersonalInfoJson.currCountry"
												class="form-control" id='state' placeholder="Country">
										</div>

									</div>


									<!--this remains empty-->
									<div class='col-md-2'></div>

									<!--this is the second half of the form-->
									<div class='col-md-4'>
										<p>
											<font size="3"><b>Permanent Address &nbsp;&nbsp;<input
													ng-click="isPermanentSameAsCurrent()"
													ng-model="employeePersonalInfoJson.isPermSameAsCurr"
													type='checkbox'> &nbsp;&nbsp;Same as Current
											</b></font>
										</p>
										<br>

										<div class="form-group">
											<label for="address1">Address Line </label> <input
												type='text' class="form-control" id='address'
												ng-model="employeePersonalInfoJson.permAddress"
												placeholder="Address Line 1">
										</div>
										<br>
										<div class="form-group">
											<label for="city">City</label> <input type='text'
												ng-model="employeePersonalInfoJson.permCity"
												class="form-control" id='city' placeholder="City">
										</div>
										<br>
										<div class="form-group">
											<label for="state">State</label> <input type='text'
												ng-model="employeePersonalInfoJson.permState"
												class="form-control" id='state' placeholder="State">
										</div>
										<br>
										<div class="form-group">
											<label for="country">Country</label> <input type='text'
												ng-model="employeePersonalInfoJson.permCountry"
												class="form-control" id='state' placeholder="Country">
										</div>

									</div>

									<div class='col-md-2'></div>




								</div>


								<!--this is the end of the fourth part-->
								<!--only button is remaining to come-->
								<br>
								<div class='row'>
									<!--this remains empty-->
									<div class='col-md-10'></div>

									<div class='col-md-2'>
										<button type="submit" class="btn btn-success">UPDATE</button>
									</div>


								</div>
								<br>


								<!--personal detail form ends here-->
								<br> <br>
							</form></td>
					</tr>
					<tr>
						<td>
							<!--family form starts here-->
							<p>
								<font size="5">Family</font>
							</p>
							<hr> <br>

							<div id="fade_out">
								<p>
									<font size="3">Add Relation</font>&nbsp;&nbsp;
									<button class="btn btn-primary" id="family">ADD FAMILY</button>
								</p>
								<hr>
								<br>
								<p>
									<b>No data available.</b>
								</p>
								<br>
							</div>


							<div id='fade_in' style="display: none">
								<br>
								<p>
									<font size="5">Add Relation</font>
								</p>
								<hr>
								<br>

								<form role='form'>

									<div class='row'>
										<!--this remains empty-->
										<div class='col-md-4'>
											<div class="form-group">
												<label for="select_relation">Relation</label> <select
													class="form-control" id="select_relation">
													<option>Select Relation</option>
													<option>Spouse</option>
													<option>Mother</option>
													<option>Father</option>
													<option>Child</option>
													<option>Sibling</option>
													<option>Other</option>
												</select>
											</div>

											<br>

											<div class="form-group">
												<label for="first_name">First Name</label> <input
													type="text" class="form-control" id="first_name">
											</div>
											<br>

											<div class="form-group">
												<label for="last_name">Last Name</label> <input type="text"
													class="form-control" id="Last_name">
											</div>

										</div>

										<div class='col-md-2'></div>

										<div class='col-md-4'>
											<div class="form-group">
												<label for="email">Email</label> <input type="email"
													class="form-control" id="email" placeholder="Email">
											</div>
											<br>
											<div class="form-group">
												<label for="mobile_number">Mobile Number</label> <input
													type="text" class="form-control" id="mobile_number">
											</div>

										</div>

										<div class='col-md-2'></div>
									</div>

									<!--OK fields end here so input button follows now-->
									<div class='row'>
										<div class='col-md-10'></div>
										<div class='col-md-2'>
											<p>
												<button type="button" class="btn btn-success">Save</button>
												<button type="button" class="btn btn-default">Cancel</button>
											</p>
										</div>

									</div>


								</form>

								<!--relation form ends here-->

								<br> <br>
							</div>
						</td>
					</tr>
























				</table>
			</td>
		</tr>
	</table>
</div>




















