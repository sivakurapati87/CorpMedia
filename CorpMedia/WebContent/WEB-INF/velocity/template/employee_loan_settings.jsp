



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
				<table class="table mtable  " border="0"
					style="width: 100%; background-color: white">
					<tr><th class="th"><h2>Loan Settings</h2></th> </tr><tr>
					
						<td>
							



								<div class="row">
									<div class="col-md-3">
										<p>
											<font size="4">Employee Loans</font>
										</p>

										<div class="checkbox">
											<label><font size="3"><input type="checkbox"
													value="" ng-model="enable_loan">&nbsp;Enable
													Employee Loan</font></label>
										</div>


									</div>

									<div class="col-md-7"></div>
									<div class="col-md-2">
										<button type="button" class="btn btn-primary">Complete</button>
									</div>

								</div>


								<br>
								<!--here following portion is controlled by angular js-->
								<div ng-show="enable_loan">

									<div class="row">
										<p>
											<font size="3"><b>LOAN ELIGIBILITY</b></font>
										</p>
										<div class="col-md-8" style="background-color: greenyellow">
											<br>
											<p>
												<input type="checkbox">&nbsp;Employees are eligible
												for loan
											</p>
											<p>
												&nbsp; &nbsp; &nbsp; &nbsp;<input type="checkbox">&nbsp;Probation
												period
											</p>
											<p>
												&nbsp; &nbsp; &nbsp; &nbsp;<input type="checkbox">&nbsp;&nbsp;<input
													type="number" style="width: 100px">
												&nbsp;&nbsp;days from joining
											</p>
											<br>
											<p>
												<input type="checkbox">&nbsp;Employees are eligible
												if annual gross salary is in the range of RS.&nbsp;&nbsp;<input
													type="number" style="width: 100px">&nbsp;-&nbsp;<input
													type="number" style="width: 100px">
											</p>
											<br>
											<p>
												<input type="checkbox">&nbsp;Employees in notice
												period are eligible
											</p>

											<br> <br>
										</div>




										<div class="col-md-3"></div>

									</div>

									<!--space between two boxes-->
									<br>


									<div class="row">
										<p>
											<font size="3"><b>LOAN APPROVAL PROCESS</b></font>
										</p>
										<div class="col-md-8" style="background-color: greenyellow">
											<br>
											<p>
												<input type="checkbox">
											</p>
											<p>
												Limit maximum loan amount to maximum of &nbsp;<input
													type="number" style="width: 100px">&nbsp; % of
												gross salary, or Rs. &nbsp;<input type="number"
													style="width: 100px"> &nbsp; Whichever is lower
											</p>


											<p>
												<input type="checkbox">&nbsp;&nbsp;Allow Overriding
												maximum limit if approved by &nbsp;<input type="text"
													style="width: 200px" placeholder="Search for Approvers">
											</p>


											<br> <br>
										</div>


										<div class="col-md-3"></div>

									</div>

									<!--lets give some space between boxes-->
									<br>

									<!--third box-->

									<div class="row">
										<p>
											<font size="3"><b>LOAN & EMI CALCULATIONS</b></font>
										</p>
										<div class="col-md-8" style="background-color: greenyellow">
											<br>
											<p>
												<font size="1"><i>These settings can be overriden
														in individual loan application </i></font>
											</p>

											<p>
												Standard interest rate &nbsp;<input type="number"
													style="width: 100px">&nbsp; %
											</p>
											<p>Interest calculation Method</p>


											<p>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox">&nbsp;&nbsp;Flat
												rate - Interest calculated upfront and spread across
												installments
											</p>
											<p>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox">&nbsp;&nbsp;Reducing
												rate - Interest on out standing balance
											</p>
											<p>
												Maximum installments&nbsp;<input type="number"
													style="width: 100px">
											</p>

											<br> <br>
										</div>


										<div class="col-md-3"></div>

									</div>




								</div>
								<!--this is the whole container for the boxes-->

								<br>
								<div class="row">
									<div class="col-md-10"></div>

									<div class="col-md-2">
										<button type="button" class="btn btn-primary">Complete</button>
									</div>
								</div>
								<br> <br>
							




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



























