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
			<td valign="top"><employee-info-top></employee-info-top>
				<table class="table mtable " border="0" style="width: 100%;">
				<tr>
									<th class="th" colspan="3"><h2>My Payslip</h2></th>
								</tr>
					<tr>
						<td style="width: 20%; border-right: dashed 2px #ccc;">
							<table style="width: 100%;background:#ecebcc;  border-radius:10px; padding:5px; box-shadow: 2px 3px 4px #d1bf56; -moz-box-shadow: 2px 3px 0px #d1bf56; "
						>
								<tr style="height: 20px"></tr>
								<tr>
									<td style="width: 5px;"></td>
									<td width="90%" align="center"><label>Month</label>
										<select
										class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
										required ng-model="companyBank.bankId"
										ng-options="bank.lookupDetailId as bank.description for bank in  lookup.monthList">
											<option value="" disabled selected>Select Month</option>
									</select>
									</td>
									<td style="width: 5px;"></td>
								</tr>
									
								<tr style="height: 10px"></tr>
								<tr>
								<td style="width: 5px;"></td>
									<td width="90%" align="center"><label>Year</label>
										<select
										class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
										required ng-model="companyBank.bankId"
										ng-options="bank.lookupDetailId as bank.description for bank in  lookup.yearList">
											<option value="" disabled selected>Select Year</option>
									</select>
									</td>
									<td style="width: 5px;"></td>
								</tr>
								<tr style="height: 30px"></tr>
								
								
							</table>

						</td>
						<td style="width: 80%;"  >
							<table class="table "
								style="width: 100%; /* box-shadow: -2px -2px 10px #ccc; -moz-box-shadow:inset 0px 0px 5px #d1bf56; border-radius:10px; */" border="0">


								
								<tr style="height: 20px"></tr>
								<tr class="row2" style="width: 80%;">
									<td colspan="2"><h5>{{companyName}}</h5></td>
								</tr>
								<tr>
									<td style="width: 20%" align="center"><img
										ng-src="{{'data:image/png;base64,'+selectedCompanyObj.base64logo}}"
										width="100" height="100"></td>
									<td colspan="2"><b>Pay Slip for the month of</b></td>
								</tr>
								<tr style="height: 15px"></tr>
								<tr>
									<td colspan="3" style="border-bottom: dashed 2px #ccc; border-top:dashed 2px #ccc; ">
										<table style="width: 100%" border="0">
											<tr class="row2">
												<td class="tdh1" width="15%"><label>Employee Name:</label></td>
												<td class="tdv1"width="20%"><label>{{empObj.firstName}}
														&nbsp;{{empObj.middleName}} &nbsp;{{empObj.lastName}} </label></td>
												<td width="10px"></td>
												<td class="tdh1"width="15%"><label>Designation:</label></td>
												<td class="tdv1"width="20%"><label>{{empObj.designation}}</label></td>
												<td width="10px"></td>
												<td class="tdh1"width="15%"><label>Gender:</label></td>
												<td  class="tdv1"width="15%"><label>{{empObj.gender}}</label></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr class="row2">
												<td class="tdh1"><label>DOJ:</label></td>
												<td class="tdv1"><label>{{empObj.strDateOfJoining}}</label></td>
												<td  style="width: 10px;"><div style="width: 25px;"></div> </td>
												<td class="tdh1"><label>Total Days:</label></td>
												<td class="tdv1"><label>{{empObj.designation}}</label></td>
												<td  style="width: 10px;"><div style="width: 25px;"></div> </td>
												<td class="tdh1"><label>Paid Days:</label></td>
												<td class="tdv1"><label>{{empObj.gender}}</label></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr class="row2">
												<td class="tdh1"><label>Bank A/c No:</label></td>
												<td class="tdv1"><label>{{empObj.strDateOfJoining}}</label></td>
												<td  style="width: 10px;"> </td>
												<td class="tdh1"><label>Pan:</label></td>
												<td class="tdv1"><label>{{empObj.strDateOfJoining}}</label></td>
												<td colspan="3"></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr class="row2">
												<td class="tdh1"><label>Bank Name:</label></td>
												<td class="tdv1"><label>{{empObj.strDateOfJoining}}</label></td>
												<td width="10px"></td>
												<td class="tdh1"><label>PF Account No:</label></td>
												<td class="tdv1"><label>{{empObj.strDateOfJoining}}</label></td>
												<td colspan="3"></td>
											</tr>
										</table>

									</td>
								</tr>
								<tr style="height: 10px"></tr>
								<tr>
									<td colspan="3">
										<table style="width: 100%" border="0">
											<tr class="row2">
												<td class="tdh1" width="25%"><label>Earnings</label></td>
												<td class="tdh1"width="25%" style="text-align: right;" ><label>Amount</label></td>
												<td  width="5%"></td>
												<td class="tdh1"width="25%"><label>Deductions</label></td>
												<td  class="tdh1"width="20%" style="text-align: right;"><label>Amount</label></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr >
												<td colspan="2">
													<table style="width: 100%" border="0">
														<tr class="row2">
															<td class="tdh1" width="50%"><label>Basic</label></td>
															<td class="tdv1" width="50%" ><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.basic)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr class="row2">
															<td class="tdh1" width="50%"><label>House Rent Allowance</label></td>
															<td class="tdv1" width="50%" ><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.hra)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr class="row2">
															<td class="tdh1" width="50%"><label>Medical Allowance</label></td>
															<td class="tdv1" width="50%" ><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.medicalReimbursement)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr class="row2">
															<td class="tdh1" width="50%"><label>Transport Allowance</label></td>
															<td class="tdv1" width="50%" ><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.transportAllowance)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr class="row2">
															<td class="tdh1" width="50%"><label>Special Allowance</label></td>
															<td class="tdv1" width="50%" align="right" ><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.specialAllowance)}}</label></td>
														</tr>
													</table>
												</td>
												<td width="5%"></td>
												<td colspan="2" valign="top">
													<table style="width: 100%" border="0">
														<tr class="row2">
															<td class="tdh1" width="50%"><label>Provident Fund</label></td>
															<td class="tdv1" width="50%" align="right"><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.pf)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr class="row2">
															<td class="tdh1" width="50%"><label>Tax Deduction</label></td>
															<td class="tdv1" width="50%" align="right"><label>-</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr class="row2">
															<td class="tdh1" width="50%"><label>Professional Tax</label></td>
															<td class="tdv1" width="50%" align="right"><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.professionalAllowance)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr class="row2">
															<td class="tdh1" width="50%"><label>Other Deductions</label></td>
															<td class="tdv1" width="50%" align="right"><label>-</label></td>
														</tr>
													</table>
												</td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr class="row2">
												<td class="tdh1" width="25%"><label>Gross Earnings</label></td>
												<td class="tdv1" width="25%" align="right"><label>{{employeeSalaryInfoJson.salaryComponentJson.grossEarningInMoney}}</label></td>
												<td  width="5%"></td>
												<td class="tdh1" width="25%"><label>Gross Deductions</label></td>
												<td class="tdv1" width="20%" align="right"><label>{{employeeSalaryInfoJson.salaryComponentJson.grossDeductionsInMoney}}</label></td>
											</tr>
											<tr style="height: 30px"></tr>
											<tr class="row2">
												<td class="tdh1" width="25%"><label>Net Amount</label></td>
												<td class="tdv1" width="25%" align="right"><label>{{employeeSalaryInfoJson.salaryComponentJson.netAmountInMoney}}</label></td>
												<td  width="5%" colspan="3"></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr class="row2">
												<td class="tdh1" width="25%"><label>Net Pay in words: </label></td>
												<td class="tdv1" width="25%" colspan="4" style="text-align: left;"><label>{{employeeSalaryInfoJson.salaryComponentJson.netPayInWords}}</label></td>
											</tr>
										</table>
									</td>
								</tr>
							</table></td>
					</tr>
				<tr ><td class="bth" colspan="2" ><h2></h2> </td> </tr>	
				</table></td>
		</tr>
		
	</table>
</div>
