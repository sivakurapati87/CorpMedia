<div class="container-fluid" style="width: 100%;">
	<table border="1">
		<tr style="height: 120px;background-image:url('resources/images/bgimg3.png');">
			<td class="lable50_blue" align="center" colspan="3">{{companyName}}</td>
		</tr>
		<tr>
			<td width="20%" valign="top" bgcolor="white">
				<left-menu></left-menu>
			</td>
			<td width="1%"></td>
			<td valign="top">
				<table class="table" border="0" style="width: 100%;">
					<tr>
						<td>
							<div class="sub-page-navigation">
								<ul>
									<li ng-class="{'active':(state==='leave_plans')}"><a
										class="anchor-sm"
										ui-sref="leave_plans">Leave Plans
											</a></li>
									<li ng-class="{'active':(state==='leave_types')}"><a
										class="anchor-sm" ui-sref="leave_types">Leave Types</a></li>
									<li ng-class="{'active':(state==='holidays')}"><a
										class="anchor-sm" ui-sref="holidays">Holidays</a></li>		
									
								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0" style="width: 100%; background-color: white;">
					<tr>
						<td><h2>Leave Plans</h2></td>
					</tr>
					<tr>
						<td>Leave Plans allow you to define a package of different
							leave types that can be assigned to an employee. You can for
							example have a 'Standard Leave Plan' that is assigned by default
							to all employees. You can also define say an 'Executive Leave
							Plan' for your senior employees offering more leave allocations.</td>
					</tr>
					<tr>
						<td><button type="button" class="btn btn-info"
								data-toggle="collapse" data-target="#demo">
								<span class="glyphicon glyphicon-plus"></span> Add New
							</button>

							<div id="demo" class="collapse">
								<table border="0">
									<tr>
										<td><label> Add Leave Plan</label></td>
									</tr>
									<tr height="30px"></tr>
									<tr>
										<td><label>Name</label></td>
									</tr>
									<tr>
										<td><input id="panNumber" style="width: 200%"
											class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
											type="text" required="" data-ng-model="model.panNumber"
											name="panNumber"></td>
									</tr>
									<tr height="30px"></tr>
									<tr>
										<td><label>Description</label></td>
									</tr>
									<tr>
										<td><textarea class="form-control" rows="5" id="comment"
												style="width: 200%"></textarea></td>
									</tr>
									<tr height="30px"></tr>
									<tr>

										<td>

											<button class="btn btn-success" style="width: 100px">Save</button>&nbsp;
											<button class="btn btn-cancel" style="width: 100px">Cancel</button>
										</td>
									</tr>
								</table>

							</div></td>
					</tr>

					<tr>

						<td>
							<button type="button" class="button_bg"
								style="width: 1000px; height: 60px" data-toggle="collapse"
								data-target="#demo1">
								<table border="0" width="100%">
									<tr>
										<td align="left"><span
											class="glyphicon glyphicon-chevron-up"></span>&nbsp;Standard
											Leave Plan<br /> <small>This is a system generated
												leave plan for this location.</small></td>
										<td align="right"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;&nbsp;<span 
											class="glyphicon glyphicon-trash"></span></td>
									</tr>
								</table>
							</button>
							<div id="demo1" class="collapse">
								<table>
								<tr height="20px"></tr>
									<tr>
										<td><button class="btn btn-success" ng-click="addLeaveType()" >Add Leave Type</button></td>
									</tr>
									<tr>
										<td>
											<table class=" table table-hover table-striped">
												<tr>
													<td><h3>Leave Type</h3></td>
													<td><h3>Allowance</h3></td>
													<td><h3>Accrual</h3></td>
													<td><h3>Carry Over</h3></td>
													<td><h3>Actions</h3></td>

												</tr>
												<tr>
													<td>Paid Leave</td>
													<td></td>
													<td></td>
													<td></td>
													<td><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;&nbsp;<span
														class="glyphicon glyphicon-trash"></span></td>
												</tr>
												<tr>
													<td>Sick Leave</td>
													<td></td>
													<td></td>
													<td></td>
													<td><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;&nbsp;<span
														class="glyphicon glyphicon-trash"></span></td>
												</tr>
												<tr>
													<td>Unpaid Leave</td>
													<td></td>
													<td></td>
													<td></td>
													<td><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;&nbsp;<span
														class="glyphicon glyphicon-trash"></span></td>
												</tr>

											</table>
										</td>
									</tr>
								</table>


							</div>
						</td>



					</tr>




				</table>
			</td>
		</tr>

	</table>


</div>


