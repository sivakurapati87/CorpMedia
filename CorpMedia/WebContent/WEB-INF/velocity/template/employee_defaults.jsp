
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

				<employee-module-top></employee-module-top>
				<table class="table mtable " border="0"
					style="width: 100%; background-color: white">
					<tr><th><h2>Employee Default Settings</h2></th> </tr><tr>
						<td>





							
							<p>
								<font size="3">These are the default settings which apply
									to new recruits</font>
							</p>

							<div id="fade_out">
								<div class="row">
									<div class="col-md-2">
										<button id="fader" class="btn btn-primary" ng-click="isCollapse=!isCollapse">
											<i class="fa fa-pencil-square fa-2x"></i>&nbsp;&nbsp;&nbsp;
										</button>
									</div>
									<div class="col-md-10"></div>
								</div>


								<br>


								<div class="row" collapse="!isCollapse">
									<div class="col-md-8">


										<div class="row">
											<div class="col-md-8">
												<p>
													<font size="3">Probation Period</font>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>
											<div class="col-md-3">
												<p>
													<b><font size="3">{{companyEmployeeDefaultsJson.probationPeriod}}&nbsp;{{companyEmployeeDefaultsJson.probationPeriodType}}</font></b>
												</p>
											</div>
										</div>

										<br>

										<div class="row">
											<div class="col-md-8">
												<p>
													<font size="3">Worker Type</font>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>
											<div class="col-md-3">
												<p>
													<b><font size="3">{{companyEmployeeDefaultsJson.workerType}}</font></b>
												</p>
											</div>
										</div>

										<br>

										<div class="row">
											<div class="col-md-8">
												<p>
													<font size="3">Time Type</font>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>

											<div class="col-md-3">
												<p>
													<b><font size="3">{{companyEmployeeDefaultsJson.timeType}}</font></b>
												</p>
											</div>
										</div>

										<br>

										<div class="row">
											<div class="col-md-8">
												<p>
												<font size="3">Notice Period</font>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>

											<div class="col-md-3">
												<p>
													<b><font size="3">
															{{companyEmployeeDefaultsJson.noticePeriod}}&nbsp;{{companyEmployeeDefaultsJson.noticePeriodType}}</font></b>
												</p>
											</div>
										</div>

										<br>

										<div class="row">
											<div class="col-md-8">
												<p>
													<font size="3">Allow employee to edit
															Personal Details</font>
												</p>
											</div>
											<div class="col-md-1">
												<p>-</p>
											</div>

											<div class="col-md-3">
												<p>
													<b><font size="3" ng-if="companyEmployeeDefaultsJson.isEmpAllowedToUpdate"> Yes</font>
													<font size="3" ng-if="companyEmployeeDefaultsJson.isEmpAllowedToUpdate == null || !companyEmployeeDefaultsJson.isEmpAllowedToUpdate">No</font>
													</b>
												</p>
											</div>
										</div>

										<div class="col-md-8"></div>

									</div>
									<div class="col-md-8"></div>
 ;
								</div>


							</div>

							<form ng-submit="saveCompanyEmpDefault()">
								<div collapse="isCollapse">



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
										<button type="button" class="btn btn-default" ng-click="cancel()">Cancel</button>
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














