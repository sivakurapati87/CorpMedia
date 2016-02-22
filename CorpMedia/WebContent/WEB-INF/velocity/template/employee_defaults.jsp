
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





							<p>
								<font size="4">Employee Default Settings</font>
							</p>
							<p>
								<font size="3">These are the default settings which apply
									to new recruits</font>
							</p>

							<div id="fade_out">
								<div class="row">
									<div class="col-md-2">
										<button id="fader" class="btn btn-primary">
											<i class="fa fa-pencil-square fa-5"></i>&nbsp;&nbsp;&nbsp;
										</button>
									</div>
									<div class="col-md-10"></div>
								</div>


								<br>


								<div class="row">
									<div class="col-md-4">


										<div class="row">
											<div class="col-md-5">
												<p>
													<b><font size="3">Probation Period</font></b>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>
											<div class="col-md-6">
												<p>
													<b><font size="3">{{companyEmployeeDefaultsJson.probationPeriod}}&nbsp;{{companyEmployeeDefaultsJson.probationPeriodType}}</font></b>
												</p>
											</div>
										</div>

										<br>

										<div class="row">
											<div class="col-md-5">
												<p>
													<b><font size="3">Worker Type</font></b>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>
											<div class="col-md-6">
												<p>
													<b><font size="3">{{companyEmployeeDefaultsJson.workerType}}</font></b>
												</p>
											</div>
										</div>

										<br>

										<div class="row">
											<div class="col-md-5">
												<p>
													<b><font size="3">Time Type</font></b>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>

											<div class="col-md-6">
												<p>
													<b><font size="3">{{companyEmployeeDefaultsJson.timeType}}</font></b>
												</p>
											</div>
										</div>

										<br>

										<div class="row">
											<div class="col-md-5">
												<p>
													<b><font size="3">Notice Period</font></b>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>

											<div class="col-md-6">
												<p>
													<b><font size="3">
															{{companyEmployeeDefaultsJson.noticePeriod}}&nbsp;{{companyEmployeeDefaultsJson.noticePeriodType}}</font></b>
												</p>
											</div>
										</div>

										<br>

										<div class="row">
											<div class="col-md-5">
												<p>
													<b><font size="3">Allow employee to edit
															Personal Details</font></b>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>

											<div class="col-md-6">
												<p>
													<b><font size="3"> {{companyEmployeeDefaultsJson.isEmpAllowedToUpdate}}</font></b>
												</p>
											</div>
										</div>

										<div class="col-md-8"></div>

									</div>
									<div class="col-md-8"></div>

								</div>


							</div>

							<form ng-submit="saveCompanyEmpDefault()">
								<div id="fade_in" style="display: none">



									<!--this is the first row-->

									<div class="row">

										<div class="col-md-2">
											<p>
												<b>Probation Period</b>
											</p>
										</div>

										<div class="col-md-1"></div>

										<div class="col-md-2">
											<input type="number" style="width: 100px"
												class="form-control" required="required"
												ng-model="companyEmployeeDefaultsJson.probationPeriod">
										</div>

										<div class="col-md-3">
											<select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required
												ng-model="companyEmployeeDefaultsJson.probatioPeriodTypeId"
												ng-options="bank.lookupDetailId as bank.description for bank in  lookup.daysWeeksMonthsList">
												<option value="" disabled selected>Select</option>
											</select>
										</div>

										<div class="col-md-4"></div>

									</div>

									<br>

									<!--this is the second row-->

									<div class="row">

										<div class="col-md-2">
											<p>
												<b>Worker Type</b>
											</p>
										</div>

										<div class="col-md-1"></div>

										<div class="col-md-5">
											<select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required ng-model="companyEmployeeDefaultsJson.workerTypeId"
												ng-options="bank.lookupDetailId as bank.description for bank in  lookup.workerTypeList">
												<option value="" disabled selected>Select</option>
											</select>
										</div>

										<div class="col-md-4"></div>

									</div>

									<br>

									<!--this is the third row-->

									<div class="row">

										<div class="col-md-2">
											<p>
												<b>Time Type</b>
											</p>
										</div>

										<div class="col-md-1"></div>

										<div class="col-md-5">
											<select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required ng-model="companyEmployeeDefaultsJson.timeTypeId"
												ng-options="bank.lookupDetailId as bank.description for bank in  lookup.timeTypeList">
												<option value="" disabled selected>Select</option>
											</select>
										</div>

										<div class="col-md-4"></div>

									</div>


									<br>

									<!--this is the first row-->
									<div class="row">

										<div class="col-md-2">
											<p>
												<b>Notice Period</b>
											</p>
										</div>

										<div class="col-md-1"></div>
										<div class="col-md-2">
											<input type="number" style="width: 100px"
												class="form-control" required="required"
												ng-model="companyEmployeeDefaultsJson.noticePeriod">
										</div>
										<div class="col-md-3">
											<select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												required
												ng-model="companyEmployeeDefaultsJson.noticePeriodId"
												ng-options="bank.lookupDetailId as bank.description for bank in  lookup.daysWeeksMonthsList">
												<option value="" disabled selected>Select</option>
											</select>
										</div>

										<div class="col-md-4"></div>

									</div>

									<br>

									<p>
										<input type="checkbox"
											ng-model="companyEmployeeDefaultsJson.isEmpAllowedToUpdate">&nbsp;&nbsp;Allow
										Employees to update personal details
									</p>

									<p>
										<button type="submit" class="btn btn-success">Update</button>
										<button type="button" class="btn btn-default">Cancel</button>
									</p>

								</div>
							</form>








						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>














