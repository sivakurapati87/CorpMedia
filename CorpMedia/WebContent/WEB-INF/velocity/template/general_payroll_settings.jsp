


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

									<li ng-class="{'active':(state==='general_payroll_settings')}"><a
										class="anchor-sm" ui-sref="general_payroll_settings">Payroll
											settings</a></li>
									<li ng-class="{'active':(state==='adhoc_components')}"><a
										class="anchor-sm" ui-sref="adhoc_components">Adhoc
											Components</a></li>
									<li
										ng-class="{'active':(state==='salary_component_structure')}"><a
										class="anchor-sm" ui-sref="salary_component_structure">Salary
											Structure</a></li>
									<li ng-class="{'active':(state==='provident_fund')}"><a
										class="anchor-sm" ui-sref="provident_fund">Provident Fund</a></li>

									<li ng-class="{'active':(state==='employee_loan_settings')}"><a
										class="anchor-sm" ui-sref="employee_loan_settings">Loan
											Settings</a></li>




								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table mtable " border="0"
					style="width: 100%; background-color: white">
					<tr><th class="th"><h2>PAYROLL CYCLE SETTINGS</h2></th></tr><tr>
						<td>



							<div class="row">
								<div class="col-md-7 ">
									
										
									
									<form ng-submit="savePayrollCycleSettings()">
										<div>
											<!-- this is our container for the first form -->


											<br>



											<div class="form-group">


												<!-- field 1 -->
												<div class="row">
													<div class="col-md-1">
														<!-- empty first column to make some room -->
													</div>
													<div class="col-md-5">
														<label><b>Pay Frequency</b></label>
													</div>
													<div class="col-md-5">
														<select class="form-control" id="sel1"
															ng-model="payrollcyclesettings.payFrequency">

															<option value="" disabled selected>Month</option>
														</select>
													</div>
												</div>
												<!-- this is the end of the internal row -->
												<br>


												<!-- field 2 -->
												<div class="row">
													<div class="col-md-1">
														<!-- empty first column to make some room -->
													</div>
													<div class="col-md-5">
														<label><b>Which pay cycle do you want to start
																using Corpmedia for Payroll</b></label>
													</div>
													<div class="col-md-5">
														<select
															class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
															required ng-model="payrollcyclesettings.payCycleMonthId" ng-change="onChangePayCycleMonth()"
															ng-options="bank.indexOfTheMonth as bank.description for bank in  payCycleJsonList">
															<option value="" disabled selected>Pick Pay
																Cycle</option>
														</select>
													</div>
												</div>
												<!-- this is the end of the internal row -->


												<br>

												<!-- field 3 -->
												<div class="row">
													<div class="col-md-1">
														<!-- empty first column to make some room -->
													</div>
													<div class="col-md-5">
														<label><b>Which day did the pay period end in {{selectedMonth}}</b></label>
													</div>
													<div class="col-md-5">
														<select
															class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
															ng-model="payrollcyclesettings.strPayPeriodEndDayId"
															ng-change="payPeriodEndComboAction()"
															ng-options="bank.description as bank.description for bank in  lookup.daysList">
															<option value="" disabled selected>Day</option>

														</select>
													</div>
												</div>
												<br>
												<div class="row">
													<div class="col-md-1">
														<!-- empty first column to make some room -->
													</div>
													<div class="col-md-5">
														<label><b>The pay day for the period
																{{payDayPeriod}} </b></label>
													</div>
													<div class="col-md-5">
														<select
															class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
															ng-model="payrollcyclesettings.payDay"
															ng-options="bank.description as bank.description for bank in  payDayList">
															<option value="" disabled selected>Pick Pay Day</option>

														</select>
													</div>
												</div>
												<!-- this is the end of the internal row -->
											</div>
											<br>
											<div style="text-align: center">
												<button type="submit" class="btn btn-primary active"
													style="align: center">Complete</button>
											</div>
											<br> <br>
										</div>
										<!-- this is the end of the first form -->
									</form>

									<div class="col-md-5">
										<!-- second half of the row -->
									</div>

								</div>
								<!-- end of first half of row. -->

								<div class="col-md-5"></div>

								<br> <br> <br>

							</div> <!--this the end of the first row(form)--> <br> <br> <!--this the the second row(form)-->
							<!-- <div class="row">
								<div class="col-md-7">
									<p>
										<font size="4"><b>PAYROLL PERIOD CALCULATION</b></font>
									</p>
									<form ng-submit="savePayrollPeriodCalculation()">
										<div style="background-color: #CECEF6">
											this is our container for the first form


											<br>



											<div class="form-group">


												field 1
												<div class="row">
													<div class="col-md-1">
														empty first column to make some room
													</div>
													<div class="col-md-5">
														<label><b>Pay Days in a month</b></label>
													</div>
													<div class="col-md-5">

														<select
															class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
															ng-model="payrollperiodcalculation.payDaysInAMonthId"
															ng-options="bank.lookupDetailId as bank.description for bank in  lookup.payDAYInAMonthList">
															<option value="" disabled selected>Select
																working days</option>

														</select>

													</div>
												</div>
												this is the end of the internal row
												<br>


												field 2
												<div class="row">
													<div class="col-md-1">
														empty first column to make some room
													</div>
													<div class="col-md-5">
														<label><b>Exclude Weekly offs</b></label>
													</div>
													<div class="col-md-5">
														<select class="form-control" id="sel1"
															ng-model="payrollperiodcalculation.excludeWeeklyOffsId"
															ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
															<option value="" disabled selected>Select</option>
														</select>
													</div>
												</div>
												this is the end of the internal row


												<br>

												field 3
												<div class="row">
													<div class="col-md-1">
														empty first column to make some room
													</div>
													<div class="col-md-5">
														<label><b>Exclude Holidays</b></label>
													</div>
													<div class="col-md-5">
														<select class="form-control" id="sel2"
															ng-model="payrollperiodcalculation.excludeHolidaysId"
															ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
															<option value="" disabled selected>Select</option>

														</select>
													</div>
												</div>
												this is the end of the internal row
											</div>
											<br>
											<div style="text-align: center">
												<button type="submit" class="btn btn-primary active"
													style="align: center">Complete</button>
											</div>
											<br> <br>
										</div>
										this is the end of the first form
									</form>

									<div class="col-md-5">
										second half of the row
									</div>

								</div>
								end of first half of row.

								<div class="col-md-5">
									<p>
										<b><font size="3">NOTE:</font></b>
									</p>
									<p>
										<font size="2">Calculation of number of days for a
											given pay period has significant impact when deducting salary
											for Loss of Pay due to Leave or other reason. Ex: Loss of Pay
											for 1 day for an employee whose salary is Rs.30,000/month is
											calculated as below</font>
									</p>
									<p>
										<font size="2">Loss of Pay when days = 30</font>
									</p>
									<p>
										<font size="2">-> Rs.30,000/30 = Rs.1000</font>
									</p>
									<p>
										<font size="2">Loss of Pay when days are calculated
											excluding Weekends. </font>
									</p>
									<p>
										<font size="2">Lets say there are 8 Saturday & Sundays
											in month. </font>
									</p>
									<p>
										<font size="2">Effective days = 30-8 = 22 days</font>
									</p>
									<p>
										<font size="2">Loss of Pay = Rs.30,000/22 = Rs.1364.</font>
									</p>
								</div>

								<br> <br> <br>

							</div> --> <!--end of second form-->




						</td>
					</tr>

























				<tr>
						<td class="bth"><h2></h2></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

<div class="main1" ng-show="isProcessing">
	<div class="div1">

		<i class="fa fa-spinner fa-spin " style="font-size: 60px"></i>
	</div>
</div>













