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
						<td style="width: 30%"></td>
						<td style="width: 70%"><table class="table mtable "
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
										<table style="width: 100%">
											<tr>
												<td><label>Employee Name:</label></td>
												<td><label>{{empObj.firstName}}
														&nbsp;{{empObj.middleName}} &nbsp;{{empObj.lastName}} </label></td>
												<td width="10px"></td>
												<td><label>Designation:</label></td>
												<td><label>{{empObj.designation}}</label></td>
												<td width="10px"></td>
												<td><label>Gender:</label></td>
												<td><label>{{empObj.gender}}</label></td>
											</tr>
											<tr style="height: 10px"></tr>
											<tr>
												<td><label>DOJ:</label></td>
												<td><label>{{empObj.strDateOfJoining}}</label></td>
												<td width="10px"></td>
												<td colspan="5"></td>
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
										<table style="width: 100%">
											<tr>
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
