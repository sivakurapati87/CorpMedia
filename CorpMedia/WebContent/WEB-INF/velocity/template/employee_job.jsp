
<script>
	$(document).ready(function() {
		$(fader).click(function() {
			$(fade_out).fadeOut();
			$(fade_in).fadeIn();
		});
	});
</script>

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
						<td>



							<div id="fade_out">
								<p>
									<font size="4">Job Titles</font>
								</p>
								<p>
									<font size="2">You can specify employee job title here.</font>
								</p>


								<div class="row">
									<div class="col-md-2">
										<button id="fader" class="btn btn-primary">
											<i class="fa fa-plus-square">&nbsp;&nbsp;&nbsp;</i>Add New
										</button>
									</div>
									<div class="col-md-10"></div>

								</div>
								<br>
								<table class="table">
									<tr>
										<th>Name</th>
										<th>Applies To</th>
										<th>Actions</th>
									</tr>
								</table>

							</div>


							<div id="fade_in" style="display: none">
								<!-- -------------------- -->

								<h4 class="branded-heading">Job Info</h4>
								<hr>

								
									<div class="row" style="background:;">


										<div
											class="col-lg-5 col-md-5 col-sm-5 col-xs-11 clear-left-padding">
											<!-- left1  -->
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label>Location</label> <select type="select" tabindex=""
													ng-model="" ng-options=""
													class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
													name="location"
													
													required=""><option value="" class=""
														selected="selected">Select a location</option>
													<option label="madhapur"
														selected="selected">madhapur</option></select>
												<div data-validation-messages=""
													data-form-submit="submitted" class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<div
												class="form-group col-lg-12 col-md-12 col-sm-12 clear-side-padding">
												<div class="col-lg-9 col-md-9 col-sm-9 clear-side-padding">

													<label class="display-block"> Job Title <a
														class="add-link pull-right"
														>Add</a>
													</label> <select
														class="form-control ng-pristine ng-untouched ng-invalid ng-invalid-required"
														 name="jobTitle"
														id="jobTitle"
														required=""><option value="" class=""
															selected="selected">Select</option>
														<option  label="Accountant">Accountant</option>
														<option label="java developer">java
															developer</option></select>

													<div data-validation-messages=""
														data-required-error="Employee job title is required"
														data-form-submit="submitted" class="ng-isolate-scope">
														<div>
															<!-- ngRepeat: message in errorMessages -->
															<small class="error ng-binding ng-scope ng-hide"
																ng-repeat="message in errorMessages"
																>Employee
																job title is required</small>
															<!-- end ngRepeat: message in errorMessages -->
														</div>
													</div>
												</div>
											</div>
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding employee-search-typeahead ">
												<label>Reports to</label>
												<div class="full-width">
													<span class="icon-user3 input-group-icon"></span> <input
														type="text" tabindex="5"
														class="form-control input-group-field ng-pristine ng-untouched ng-invalid ng-invalid-required"
														name="reportingTo"
														placeholder="Start typing employee name" required=""
														
														>
													<ul class="dropdown-menu ng-isolate-scope ng-hide"
														
														style="display: block;; display: block;" role="listbox"
														
														position="position"
														template-url="employee-display-template">
														<!-- ngRepeat: match in matches track by $index -->
													</ul>
												</div>
												<div data-validation-messages=""
													data-required-error="Reporting to is required"
													data-form-submit="submitted" class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
														<small class="error ng-binding ng-scope ng-hide"
															ng-repeat="message in errorMessages"
															>Reporting
															to is required</small>
														<!-- end ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label>Leave Plan</label> <select
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													name="leavePlan" required=""><option value=""
														class="" selected="selected">Select Leave Plan</option>
													<option  label="Standard Leave Plan"
														selected="selected">Standard Leave Plan</option></select>
												<div data-validation-messages=""
													data-required-error="Leave plan is required"
													data-form-submit="submitted" class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label class="display-block"> Attendance Number <a
													class="add-link pull-right ng-scope"
													title="click here to change attendance number">change</a>
												<!-- end ngIf: model.attendanceNumber -->

												</label> <input type="number" tabindex="1"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-pattern"
													placeholder="Attendance number" name="attendanceNumber"
													readonly="readonly">
												<div data-validation-messages=""
													data-pattern-error="Not a valid number"
													data-duplicate-number-error="An employee with the given number already exists"
													data-form-submit="submitted" class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
										</div>
										<!-- left1 close -->

										<div
											class="col-lg-5 col-md-5 col-sm-5 col-xs-11 col-md-offset-1 col-sm-offset-1  clear-left-padding">
											<!-- right1 -->
											<div
												class="form-group col-lg-12 col-md-12 col-sm-12  clear-side-padding">
												<div class="col-lg-9 col-md-9 col-sm-9 clear-side-padding">

													<label class="display-block"> Department <a
														class="add-link pull-right">Add</a>
													</label> <select name="department" id="department"
														class="form-control ng-pristine ng-untouched ng-invalid ng-invalid-required"
														required=""><option value="" class=""
															selected="selected">Select Department</option>
														<option  label="Accounts">Accounts</option>
														<option  label="web development">web
															development</option></select>

													<div data-validation-messages=""
														data-required-error="Employee Department is required"
														data-form-submit="submitted" class="ng-isolate-scope">
														<div>
															<!-- ngRepeat: message in errorMessages -->
															<small class="error ng-binding ng-scope ng-hide"
																ng-repeat="message in errorMessages"
																>Employee
																Department is required</small>
															<!-- end ngRepeat: message in errorMessages -->
														</div>
													</div>
												</div>
											</div>
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label>Probation Period</label>
												<div
													class="col-lg-12 col-md-12 col-sm-12 clear-side-padding">
													<div class="col-lg-8 col-md-8 col-sm-8 clear-left-padding">
														<input type="number" tabindex="8"
															placeholder="Probation period" value="0" min="0"
															class="form-control ng-pristine ng-untouched ng-valid-min ng-invalid ng-invalid-required"
															name="probationPeriod" required="">
														<div data-validation-messages=""
															data-required-error="Probation period is required"
															data-form-submit="submitted" class="ng-isolate-scope">
															<div>
																<!-- ngRepeat: message in errorMessages -->
																<small class="error ng-binding ng-scope ng-hide"
																	ng-repeat="message in errorMessages">Probation
																	period is required</small>
																<!-- end ngRepeat: message in errorMessages -->
															</div>
														</div>
													</div>
													<div class="col-lg-4 col-md-4 col-sm-4 clear-side-padding">
														<select tabindex="9"
															class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
															name="timePeriod" required="">
															<option value="">Select</option>
															<option value="1" class="ng-binding">Hours</option>
															<option value="2" class="ng-binding">Days</option>
															<option value="3" class="ng-binding">Weeks</option>
															<option value="4" class="ng-binding">Months</option>
														</select>
														<div data-validation-messages=""
															data-required-error="Select Duration"
															data-form-submit="submitted" class="ng-isolate-scope">
															<div>
																<!-- ngRepeat: message in errorMessages -->
															</div>
														</div>
													</div>
												</div>
											</div>
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label>Date of joining</label>
												<div>
													<label class="input-group-icon icon-calendar3"
														for="dateJoined"></label> <input type="text" tabindex="6"
														class="input-group-field form-control datepicking ng-pristine ng-untouched ng-isolate-scope ng-invalid ng-invalid-required ng-valid-date"
														data-datepicker-popup="mediumDate" data-show-weeks="false"
														id="dateJoined" name="dateJoined"
														data-is-open="dateJoined" data-ng-click="dateJoined=true"
														date-only="" readonly="readonly" required="">
													<!-- ngIf: isOpen -->
												</div>
												<div data-validation-messages=""
													data-required-error="Date of Joining is required"
													data-doj-validation-error="Date of join should be greater than date of birth"
													data-form-submit="submitted" class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
														<small class="error ng-binding ng-scope ng-hide"
															ng-repeat="message in errorMessages">Date of
															Joining is required</small>
														<!-- end ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label class="display-block"> Employee Number <a
													class="add-link pull-right ng-scope"
													title="click here to change employee number">change</a>
												<!-- end ngIf: model.employeeNumber && vm.isemployeeNumberEditable -->

												</label> <input type="number" tabindex="1"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-pattern"
													placeholder="Enter employee number" name="employeeNumber"
													readonly="readonly">
												<div data-validation-messages=""
													data-pattern-error="Not a valid number"
													data-duplicate-number-error="An employee with the given number already exists"
													class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<div
												class="col-lg-2 col-md-2 col-sm-2 form-group-link ng-scope">

											</div>
											<!-- end ngIf: vm.isemployeeNumberEditable -->
										</div>
										<!--  right1 close -->


									</div>
									<!-- row1 close -->
									<h4 class="branded-heading">Time & Attendance</h4>
									<hr>
									<div class="row" style="background:;">
										<!--row 2  -->


										<div
											class="col-lg-5 col-md-5 col-sm-5 col-xs-11 clear-left-padding">
											<!-- left 2  -->
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label>Time type</label> <select type="select" tabindex="11"
													class="form-control ng-pristine ng-untouched ng-invalid ng-invalid-required"
													name="timeType" required=""><option value=""
														class="" selected="selected">Select a time type</option>
													<option  label="Full Time">Full
														Time</option>
													<option  label="Part Time">Part
														Time</option></select>
												<div data-validation-messages=""
													data-required-error="Time Type is required"
													class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
														<small class="error ng-binding ng-scope ng-hide">Time
															Type is required</small>
														<!-- end ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label>Shift type</label> <select type="select"
													tabindex="13"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													name="shiftPolicy" required=""><option value=""
														class="" selected="selected">Select a Shift</option>
													<option label="Regular Shift" selected="selected">Regular
														Shift</option></select>
												<div data-validation-messages=""
													data-required-error="Shift policy is required"
													class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<!-- xhrFeatureAuthorize:  -->
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding ng-scope"
												data-xhr-feature-authorize="" data-feature="ATTENDANCE">
												<label>WFH</label> <select type="select" tabindex="16"
													class="form-control ng-pristine ng-untouched ng-valid"
													name="allowWFH"
													><option
														 label="Use Global Settings"
														selected="selected">Use Global Settings</option>
													<option value="boolean:true" label="Allow WFH">Allow
														WFH</option>
													<option value="boolean:false" label="Do Not Allow WFH">Do
														Not Allow WFH</option></select>
											</div>
											<!-- end ngIf: function (){return f()} -->
											<!-- xhrFeatureAuthorize:  -->
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding ng-scope"
												data-xhr-feature-authorize="" data-feature="ATTENDANCE">
												<label>WFH Comment</label> <select type="select"
													tabindex="16"
													class="form-control ng-pristine ng-untouched ng-valid"
													name="requireWFHComment"
													ng-options="o.v as o.n for o in [{ n: 'Use Global Settings', v: null }, { n: 'Comment required', v: true }, { n: 'Comment not required', v: false }]"><option
														value="object:null" label="Use Global Settings"
														selected="selected">Use Global Settings</option>
													<option value="boolean:true" label="Comment required">Comment
														required</option>
													<option value="boolean:false" label="Comment not required">Comment
														not required</option></select>
											</div>
											<!-- end ngIf: function (){return f()} -->
											<!-- xhrFeatureAuthorize:  -->
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding ng-scope"
												data-xhr-feature-authorize="" data-feature="ATTENDANCE">
												<label>WFH Approval</label> <select type="select"
													tabindex="16"
													class="form-control ng-pristine ng-untouched ng-valid"
													name="requireWFHApproval"
													data-ng-model-options="vm.modelOptions"><option
														value="object:null" label="Use Global Settings"
														selected="selected">Use Global Settings</option>
													<option value="boolean:true" label="Approval required">Approval
														required</option>
													<option value="boolean:false" label="Approval not required">Approval
														not required</option></select>
											</div>
											<!-- end ngIf: function (){return f()} -->

										</div>
										<!-- left2 close -->

										<div
											class="col-lg-5 col-md-5 col-sm-5 col-xs-11 col-md-offset-1 col-sm-offset-1  clear-left-padding">
											<!-- right2 -->
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label>Worker type</label> <select type="select"
													tabindex="12" ng-model="model.workerType"
													ng-options="w.id as w.name for w in vm.workerType.getAll()"
													class="form-control ng-pristine ng-untouched ng-invalid ng-invalid-required"
													name="workerType" data-ng-model-options="vm.modelOptions"
													required=""><option value="" class=""
														selected="selected">Select a worker type</option>
													<option value="number:1" label="Permanent">Permanent</option>
													<option value="number:2" label="Contract">Contract</option></select>
												<div data-validation-messages=""
													data-model-controller="jobInfo.workerType"
													data-required-error="Worker Type is required"
													data-form-submit="submitted" class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
														<small class="error ng-binding ng-scope ng-hide"
															ng-repeat="message in errorMessages"
															ng-show="(!modelController.$pristine &amp;&amp; $first) || formSubmit">Worker
															Type is required</small>
														<!-- end ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding">
												<label>Weekly Off policy</label> <select type="select"
													tabindex="15" ng-model="model.weeklyOffPolicyId"
													ng-options="w.versionIdentifier  as w.name for w in vm.weeklyOffs | filter : { locationId : model.locationId }"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													name="weekOffPolicy"
													data-ng-model-options="vm.modelOptions" required=""><option
														value="" class="" selected="selected">Select a
														Weekoff policy</option>
													<option value="string:6c67e454-97a3-43ab-9d5b-66a1421d34f5"
														label="Saturday &amp; Sunday" selected="selected">Saturday
														&amp; Sunday</option></select>
												<div data-validation-messages=""
													data-model-controller="jobInfo.weekOffPolicy"
													data-required-error="Week off policy is required"
													data-form-submit="submitted" class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<!-- xhrFeatureAuthorize:  -->
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding ng-scope"
												data-xhr-feature-authorize="" data-feature="ATTENDANCE">
												<label>Web Clock In</label> <select type="select"
													tabindex="16" ng-model="model.allowWebClockIn"
													class="form-control ng-pristine ng-untouched ng-valid"
													name="allowWebClockIn"
													ng-options="o.v as o.n for o in [{ n: 'Use Global Settings', v: null }, { n: 'Allow Web Clock-In', v: true }, { n: 'Do Not Allow Web Clock-In', v: false }]"
													data-ng-model-options="vm.modelOptions"><option
														value="object:null" label="Use Global Settings"
														selected="selected">Use Global Settings</option>
													<option value="boolean:true" label="Allow Web Clock-In">Allow
														Web Clock-In</option>
													<option value="boolean:false"
														label="Do Not Allow Web Clock-In">Do Not Allow
														Web Clock-In</option></select>
											</div>
											<!-- end ngIf: function (){return f()} -->
											<!-- xhrFeatureAuthorize:  -->
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding ng-scope"
												data-xhr-feature-authorize="" data-feature="ATTENDANCE">
												<label>Web Clock-In Comment</label> <select type="select"
													tabindex="16"
													class="form-control ng-pristine ng-untouched ng-valid"
													name="requireWebClockInComment"><option
														label="Use Global Settings" selected="selected">Use
														Global Settings</option>
													<option label="Comment required">Comment required</option>
													<option label="Comment not required">Comment not
														required</option></select>
											</div>
											<!-- end ngIf: function (){return f()} -->
											<!-- xhrFeatureAuthorize:  -->
											<div
												class="form-group col-lg-9 col-md-9 col-sm-9 clear-side-padding ng-scope"
												data-xhr-feature-authorize="" data-feature="ATTENDANCE">
												<label>Timing Policy</label> <select type="select"
													tabindex="14"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													name="timingPolicy" required=""><option value=""
														class="" selected="selected">Select a Timing
														policy</option>
													<option label="Timing Policy" selected="selected">Timing
														Policy</option></select>
												<div data-validation-messages=""
													data-required-error="Timing policy is required"
													data-form-submit="submitted" class="ng-isolate-scope">
													<div>
														<!-- ngRepeat: message in errorMessages -->
													</div>
												</div>
											</div>
											<!-- end ngIf: function (){return f()} -->


										</div>
										<!--  right2 close -->

									</div>
									<!-- row close -->







									<p>
										<button class="btn btn-success" type="submit"
											style="width: 100px; margin: 0 auto;">Update</button>
										&nbsp;

									</p>




								</form>
							</div>

							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
















