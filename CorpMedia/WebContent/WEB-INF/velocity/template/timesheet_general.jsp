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

									<li ng-class="{'active':(state==='timesheet_general')}"><a
										class="anchor-sm" ui-sref="timesheet_general">General</a></li>
									<li ng-class="{'active':(state==='timesheet_approval_chain')}"><a
										class="anchor-sm" ui-sref="timesheet_approval_chain">Approval
											Chain</a></li>

								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table mtable  " border="0"
					style="width: 100%; background-color: white">
					<tr><th class="th"><h2>General</h2></th> </tr><tr>
						<td><div class="panel-body">

								<div
									class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
									<div class="col-lg-12">
										<h4 class="page-heading">General settings</h4>
										<p class="page-description">The information about general
											company working hours.</p>
									</div>
								</div>


								<form
									ng-submit="saveTimeSheet_GeneralInfo();">
									<div class="col-lg-12 clear-left-padding">
										<div class="form-group">
											<div class="col-md-6 col-sm-6">
												<label>Hours Per Week</label> <input
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													placeholder="Hours Per Week" 
													ng-model="generalSettingsJson.hoursPerWeek" 
													required="">
													<br>
											</div>
										</div>
									</div>
									<div class="col-lg-12 clear-left-padding">
										<div class="form-group">
											<div class="col-md-6 col-sm-6">
												<label>Hours Per Month</label> <input
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													placeholder="Hours Per Month" 
													ng-model="generalSettingsJson.hoursPerMonth" 
													required="">
													<br>
											</div>
										</div>
									</div>
									<div class="col-lg-12 clear-left-padding">
										<div class="form-group">
											<div class="col-md-6">

												<button class="btn btn-success" type="submit" style="width: 100px">Submit</button>&nbsp;

											</div>
										</div>
									</div>
								</form>
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





















