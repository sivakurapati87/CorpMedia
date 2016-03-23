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
						<td style="width: 20%"></td>
						<td style="width: 80%"><table class="table mtable "
								style="width: 100%;" border="1">


								<tr>
									<th class="th" colspan="3"><h2>My Payslip</h2></th>
								</tr>
								<tr style="height: 20px"></tr>
								<tr>
									<td colspan="2">{{companyName}}</td>
								</tr>
								<tr>
									<td style="width: 20%" align="center"><img
										ng-src="{{'data:image/png;base64,'+selectedCompanyObj.base64logo}}"
										width="100" height="100"></td>
									<td colspan="2">Pay Slip for the month of</td>
								</tr>
								<tr style="height: 10px"></tr>
								<tr>
									<td colspan="3">
										<table style="width: 100%" border="1">
											<tr>
												<td width="15%"><label>Employee Name:</label></td>
												<td width="20%"><label>{{empObj.firstName}}
														&nbsp;{{empObj.middleName}} &nbsp;{{empObj.lastName}} adsf</label></td>
												<td width="10px"></td>
												<td width="15%"><label>Designation:</label></td>
												<td width="20%"><label>{{empObj.designation}}adsf</label></td>
												<td width="10px"></td>
												<td width="15%"><label>Gender:</label></td>
												<td width="15%"><label>{{empObj.gender}}asdf</label></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr>
												<td><label>DOJ:</label></td>
												<td><label>{{empObj.strDateOfJoining}}</label></td>
												<td width="10px"></td>
												<td><label>Total Days:</label></td>
												<td><label>{{empObj.designation}}adsf</label></td>
												<td width="10px"></td>
												<td><label>Paid Days:</label></td>
												<td><label>{{empObj.gender}}asdf</label></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr>
												<td><label>Bank A/c No:</label></td>
												<td><label>{{empObj.strDateOfJoining}}</label></td>
												<td width="10px"></td>
												<td><label>Pan:</label></td>
												<td><label>{{empObj.strDateOfJoining}}</label></td>
												<td colspan="3"></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr>
												<td><label>Bank Name:</label></td>
												<td><label>{{empObj.strDateOfJoining}}</label></td>
												<td width="10px"></td>
												<td><label>PF Account No:</label></td>
												<td><label>{{empObj.strDateOfJoining}}</label></td>
												<td colspan="3"></td>
											</tr>
										</table>

									</td>
								</tr>
								<tr style="height: 10px"></tr>
								<tr>
									<td colspan="3">
										<table style="width: 100%" border="1">
											<tr>
												<td width="25%"><label>Earnings</label></td>
												<td width="25%" align="right"><label>Amount</label></td>
												<td width="5%"></td>
												<td width="25%"><label>Deductions</label></td>
												<td width="20%" align="right"><label>Amount</label></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr>
												<td colspan="2">
													<table style="width: 100%" border="1">
														<tr>
															<td width="50%"><label>Basic</label></td>
															<td width="50%" align="right"><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.basic)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr>
															<td width="50%"><label>House Rent Allowance</label></td>
															<td width="50%" align="right"><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.hra)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr>
															<td width="50%"><label>Medical Allowance</label></td>
															<td width="50%" align="right"><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.medicalReimbursement)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr>
															<td width="50%"><label>Transport Allowance</label></td>
															<td width="50%" align="right"><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.transportAllowance)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr>
															<td width="50%"><label>Special Allowance</label></td>
															<td width="50%" align="right"><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.specialAllowance)}}</label></td>
														</tr>
													</table>
												</td>
												<td width="5%"></td>
												<td colspan="2" valign="top">
													<table style="width: 100%" border="1">
														<tr>
															<td width="50%"><label>Provident Fund</label></td>
															<td width="50%" align="right"><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.pf)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr>
															<td width="50%"><label>Tax Deduction</label></td>
															<td width="50%" align="right"><label>-</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr>
															<td width="50%"><label>Professional Tax</label></td>
															<td width="50%" align="right"><label>{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.professionalAllowance)}}</label></td>
														</tr>
														<tr style="height: 10px"></tr>
														<tr>
															<td width="50%"><label>Other Deductions</label></td>
															<td width="50%" align="right"><label>-</label></td>
														</tr>
													</table>
												</td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr>
												<td width="25%"><label>Gross Earnings</label></td>
												<td width="25%" align="right"><label>{{employeeSalaryInfoJson.salaryComponentJson.grossEarningInMoney}}</label></td>
												<td width="5%"></td>
												<td width="25%"><label>Gross Deductions</label></td>
												<td width="20%" align="right"><label>{{employeeSalaryInfoJson.salaryComponentJson.grossDeductionsInMoney}}</label></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr>
												<td width="25%"><label>Net Amount</label></td>
												<td width="25%" align="right"><label>{{employeeSalaryInfoJson.salaryComponentJson.netAmountInMoney}}</label></td>
												<td width="5%" colspan="3"></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr>
												<td width="25%"><label>Net Pay in words: </label></td>
												<td width="25%" colspan="4"><label>{{employeeSalaryInfoJson.salaryComponentJson.netPayInWords}}</label></td>
											</tr>
										</table>
									</td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
	</table>
</div>
