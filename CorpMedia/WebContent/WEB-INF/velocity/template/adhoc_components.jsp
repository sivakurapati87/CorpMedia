


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
				<table class="table mtable    " border="0"
					style="width: 100%; background-color: white">
					<tr><th><h2>Adhoc components</h2>
						<p>
										Adhoc components are salary components
											that are added to an employee for a given payroll month and
											are typically not paid as regular monthly components.
											Examples are - Joining bonus, Performance Bonus,
											Reimbursements, Leave Encashment at the end of an year,
											Penalty for late arrival etc. 
									</p>
					</th></tr><tr>
						<td>



							<div class="row">


								<div class="col-md-8">
									
									

								</div>


								<!--these two columns are empty because we want to make some space-->
								<div class="col-md-2"></div>

								<!--third part of the row-->
								

							</div> <br> <!--second row-->
							<div class="row">

								<div class="col-md-4">
									<p>
										<b><font size="3">ADHOC ALLOWANCES</b></font>
									</p>
									<p>
										<font size="2">These are components that can be
											configured to be taxable or tax-exempt </font>
									</p>
									<a href="" data-toggle="modal" data-target="#myModal_adhoc"><p>
											<font size="3"><i class="fa fa-plus"></i>&nbsp;Add
												Allowances</font>
										</p></a>
								</div>
								
								
								






								<div class="col-md-2"></div>


								<div class="col-md-4">

									<p>
										<b><font size="3">DEDUCTIONS</font></b>
									</p>
									<p>
										<font size="2">Deductions are components used to deduct
											from net salary of an employee in a month. Ex: Laptop Damage
											charges etc. </font>
									</p>

									<a href="" data-toggle="modal" data-target="#myModal_deduction"><p>
											<font size="3"><i class="fa fa-plus"></i>&nbsp;Add
												Deduction</font>
										</p></a>
								</div>


								<div class="col-md-2"></div>

							</div> <!-- Modal for adhoc allowances -->
							<div class="modal fade" id="myModal_adhoc" role="dialog">
								<div class="modal-dialog">
                                     <form ng-submit="saveAllowances()">
									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Create Adhoc Allowance</h4>
										</div>
										<div class="modal-body">

											
												<div class="form-group">
													<label for="name">Name</label> <input type="text"
														class="form-control" id="name" maxlength="50" ng-model="allowances.allowancesName" />
												</div>
												<br>
												<div class="form-group">
													<label for="description">Description</label>
													<textarea id="name" rows="3" class="form-control" ng-model="allowances.allowancesDescription">  </textarea>
												</div>
												<br>
												<div class="form-group">
													<label for="tax">Has Tax Benefits</label> <select
														class="form-control" id="tax" ng-model="allowances.hasTaxBenefits">
														<option>Yes</option>
														<option>No</option>
													</select>
												</div>
											


										</div>
										<div class="modal-footer">
											<p>
												<button type="submit" class="btn btn-primary">Save</button>
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
											</p>
										</div>
									</div>
									</form>
									
									
									
									

								</div>
							</div> <!--modal for deductions-->
							
							
							
							
							<div class="modal fade" id="myModal_deduction" role="dialog">
								<div class="modal-dialog">
									<form ng-submit="saveDeductions()">
										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Create Deduction</h4>
											</div>
											<div class="modal-body">


												<div class="form-group">
													<label for="name">Name</label> <input type="text"
														class="form-control" id="name" maxlength="50"
														ng-model="deductions.deductionName" />
												</div>
												<br>
												<div class="form-group">
													<label for="description">Description</label>
													<textarea id="name" rows="3" class="form-control"
														ng-model="deductions.deductionDescription">  </textarea>
												</div>
												<br>




											</div>
											<div class="modal-footer">
												<p>
													<button type="submit" class="btn btn-primary">Save</button>
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</p>
											</div>
										</div>
									</form>

								</div>
							</div>
							<div class="row">
							<div class="col-lg-4">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										<tr>
											<th>Name</th>
											<th>Actions</th>
										</tr>
										<tr ng-repeat="allowances in allowancesList" ng-class-odd="'odd'" 
											ng-class-even="'even'" style="height: 30px">
											<td>{{allowances.allowancesName}}</td>
											<td><a  data-toggle="modal" data-target="#myModal_adhoc" ng-click="editAllowances(allowances)" tooltip="edit"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
												tooltip="delete" ng-click="deleteAllowances(allowances.allowancesId)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</table>
								</div>
								<div  class="col-md-2"></div>
								
								<div class="col-lg-4">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										<tr>
											<th>Name</th>
											<th>Actions</th>
										</tr>
										<tr ng-repeat="deductions in deductionsList" ng-class-odd="'odd'" 
											ng-class-even="'even'" style="height: 30px">
											<td>{{deductions.deductionName}}</td>
											<td><a   data-toggle="modal" data-target="#myModal_deduction" ng-click="editDeductions(deductions)" tooltip="edit"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
												tooltip="delete" ng-click="deleteDeductions(deductions.deductionId)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</table>
								</div>
							</div>
							
							 <br> <br> <!--third row-->
							<div class="row">
							

								<div class="col-md-4">
									<p>
										<b><font size="3">REIMBURSEMENTS</font></b>
									</p>
									<p>
										<font size="2">Reimbursements are expense claim
											payments and are not taxed, as they are reimbursements
											against employeer's expenses. </font>
									</p>
									<a href="" data-toggle="modal" data-target="#myModal_reimburse"><p>
											<font size="3"><i class="fa fa-plus"></i>&nbsp;Add
												Reimbursement</font>
										</p></a>
								</div>


								<div class="col-md-2"></div>


								<div class="col-md-4">

									<p>
										<b><font size="3">BONUSES</font></b>
									</p>
									<p>
										<font size="2">Bonuses are one time payments made to an
											employee and are taxable. </font>
									</p>
									<a href="" data-toggle="modal" data-target="#myModal_bonus"><p>
											<font size="3"><i class="fa fa-plus"></i>&nbsp;Add
												Bonuses</font>
										</p></a>
								</div>

								<div class="col-md-2"></div>
							</div> <!--bootstrap for reimbursement-->
							<div class="modal fade" id="myModal_reimburse" role="dialog">
								<div class="modal-dialog">
									<form ng-submit="saveReimbursement()">
										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Create Reimbursement</h4>
											</div>
											<div class="modal-body">


												<div class="form-group">
													<label for="name">Name</label> <input type="text"
														class="form-control" id="name" maxlength="50"
														ng-model="reimbursement.reimbursementName" />
												</div>
												<br>
												<div class="form-group">
													<label for="description">Description</label>
													<textarea id="name" rows="3" class="form-control"
														ng-model="reimbursement.reimbursementDescription">  </textarea>
												</div>
												<br>




											</div>
											<div class="modal-footer">
												<p>
													<button type="submit" class="btn btn-primary">Save</button>
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</p>
											</div>
										</div>
									</form>

								</div>
							</div> <!--bootstrap modal for bonuses-->
							<div class="modal fade" id="myModal_bonus" role="dialog">
								<div class="modal-dialog">
									<form ng-submit="saveBonuses()">
										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Create Bonus</h4>
											</div>
											<div class="modal-body">


												<div class="form-group">
													<label for="name">Name</label> <input type="text"
														class="form-control" id="name" maxlength="50"
														ng-model="bonuses.bonusesName" />
												</div>
												<br>
												<div class="form-group">
													<label for="description">Description</label>
													<textarea id="name" rows="3" class="form-control"
														ng-model="bonuses.bonusesDescription">  </textarea>
												</div>
												<br>




											</div>
											<div class="modal-footer">
												<p>
													<button type="submit" class="btn btn-primary">Save</button>
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</p>
											</div>
										</div>
									</form>

								</div>
							</div> <!--fourth row-->
							
							<div class="row">
							<div class="col-lg-4">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										<tr>
											<th>Name</th>
											<th>Actions</th>
										</tr>
										<tr ng-repeat="reimbursement in reimbursementList" ng-class-odd="'odd'" 
											ng-class-even="'even'" style="height: 30px">
											<td>{{reimbursement.reimbursementName}}</td>
											<td><a  data-toggle="modal" data-target="#myModal_reimburse" ng-click="editReimbursement(reimbursement)" tooltip="edit"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
												tooltip="delete" ng-click="deleteReimbursement(reimbursement.reimbursementId)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</table>
								</div>
								<div  class="col-md-2"></div>
								
								<div class="col-lg-4">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										<tr>
											<th>Name</th>
											<th>Actions</th>
										</tr>
										<tr ng-repeat="bonuses in bonusesList" ng-class-odd="'odd'" 
											ng-class-even="'even'" style="height: 30px">
											<td>{{bonuses.bonusesName}}</td>
											<td><a   data-toggle="modal" data-target="#myModal_bonus" ng-click="editBonuses(bonuses)" tooltip="edit"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
												tooltip="delete" ng-click="deleteBonuses(bonuses.bonusesId)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</table>
								</div>
							</div>
							
							
							
							



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>
























