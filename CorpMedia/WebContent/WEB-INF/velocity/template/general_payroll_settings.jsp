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
										class="anchor-sm" ui-sref="general_payroll_settings">General
											Payroll Settings </a></li>


								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0" style="width: 100%;">
					<tr>
						<td>
							<h2>Setup Payroll</h2>
						</td>
					</tr>
					<tr>
						<td>Payroll is going to take a little more patience, as we
							collect all of the information. Bear with us. We tried to make
							the process easier for you.</td>
					</tr>


					<tr height="40px"></tr>
					<tr>
										<td width="100%"><button class="btn btn-success" ng-click="genralpayrollsettingsbody()"  style="height: 110px">
										<h3>General Payroll Settings</h3><br/>Payroll settings and Payroll
										Period Settings.</button></td>
									</tr>
					
					
					
					<tr>
						<td class="setup-description success"><div
								data-ng-click="vm.steps.companyInfo.isEnabled && getCompanyInformation()"
								data-ng-class="complete">
								<div class="col-sm-1" align="center">
									<span class="glyphicon glyphicon-list-alt"
										style="font-size: 40px"></span>
								</div>
								<div class="col-sm-6">
									<h3>Company Information</h3>
									<div class="info text-bold">Company legal entity,
										authorized signatories and bank account information.</div>
								</div>
							</div></td>
					</tr>
					<tr height="20px"></tr>
					<tr>
						<td class="setup-description success"><div
								data-ng-click="vm.steps.companyInfo.isEnabled && getCompanyInformation()"
								data-ng-class="complete">
								<div class="col-sm-1" align="center">
									<span class="glyphicon glyphicon-cog" style="font-size: 40px"></span>
								</div>
								<div class="col-sm-6">
									<h3>General Payroll Settings</h3>
									<div class="info text-bold">Payroll settings and Payroll
										Period Settings.</div>
								</div>
							</div></td>
					</tr>
					<tr height="20px"></tr>
					<tr>
						<td class="setup-description success"><div
								data-ng-click="vm.steps.companyInfo.isEnabled && getCompanyInformation()"
								data-ng-class="complete">
								<div class="col-sm-1" align="center">
									<span class="glyphicon glyphicon-usd" style="font-size: 40px"></span>
								</div>
								<div class="col-sm-6">
									<h3>PF and ESI Settings</h3>
									<div class="info text-bold">Employee Provident Fund and
										ESI Settings.</div>
								</div>
							</div></td>
					</tr>
					<tr height="20px"></tr>
					<tr>
						<td class="setup-description success"><div
								data-ng-click="vm.steps.companyInfo.isEnabled && getCompanyInformation()"
								data-ng-class="complete">
								<div class="col-sm-1" align="center">
									<span class="glyphicon glyphicon-cog" style="font-size: 40px"></span>
								</div>
								<div class="col-sm-6">
									<h3>Salary Components and Structures</h3>
									<div class="info text-bold">Setup Salary Components And
										Salary Structures for Employees.</div>
								</div>
							</div></td>
					</tr>
					<tr height="20px"></tr>
					<tr>
						<td class="setup-description success"><div
								data-ng-click="vm.steps.companyInfo.isEnabled && getCompanyInformation()"
								data-ng-class="complete">
								<div class="col-sm-1" align="center">
									<span class="glyphicon glyphicon-cog" style="font-size: 40px"></span>
								</div>
								<div class="col-sm-6">
									<h3>Statutory Filing Information</h3>
									<div class="info text-bold">Information required for TDS
										Return,PF and ESI and Statutory body Filing.</div>
								</div>
							</div></td>
					</tr>
					<tr height="20px"></tr>
					<tr>
						<td class="setup-description success"><div
								data-ng-click="vm.steps.companyInfo.isEnabled && getCompanyInformation()"
								data-ng-class="complete">
								<div class="col-sm-1" align="center">
									<span class="glyphicon glyphicon-cog" style="font-size: 40px"></span>
								</div>
								<div class="col-sm-6">
									<h3>Loan Settings</h3>
									<div class="info text-bold">Employee Loan Settings.</div>
								</div>
							</div></td>
					</tr>





					<tr height="80px"></tr>

				</table>
			</td>
		</tr>

	</table>


</div>


