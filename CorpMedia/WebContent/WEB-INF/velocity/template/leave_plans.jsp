<div class="container-fluid" style="width: 100%;">
	<table border="1">
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
									<li ng-class="{'active':(state==='leave_plans')}"><a
										class="anchor-sm" ui-sref="leave_plans">Leave Plans </a></li>
									<li ng-class="{'active':(state==='leave_types')}"><a
										class="anchor-sm" ui-sref="leave_types">Leave Types</a></li>
									<li ng-class="{'active':(state==='notify')}"><a
										class="anchor-sm" ui-sref="notify">Notify</a></li>
									<li ng-class="{'active':(state==='holidays')}"><a
										class="anchor-sm" ui-sref="holidays">Holidays</a></li>
								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white;">
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
								<form ng-submit="saveLeavePlan()">
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
												type="text" required="" ng-model="leavePlan.leavePlanName"></td>
										</tr>
										<tr height="30px"></tr>
										<tr>
											<td><label>Description</label></td>
										</tr>
										<tr>
											<td><textarea class="form-control" rows="5" id="comment"
													ng-model="leavePlan.description" style="width: 200%"></textarea></td>
										</tr>
										<tr height="30px"></tr>
										<tr>

											<td>

												<button class="btn btn-success" style="width: 100px"
													type="submit">Save</button>&nbsp;
												<button class="btn btn-cancel" style="width: 100px"
													type="button">Cancel</button>
											</td>
										</tr>
									</table>
								</form>
							</div></td>
					</tr>

					<tr>
						<td><div
								class="col-lg-12 col-md-12 col-sm-12 panel panel-default clear-side-padding ng-scope"
								ng-repeat="leavePlan in companyLeavePlansList">
								<div class="panel-heading col-lg-12 col-md-12 col-sm-12"
									ng-click="leavePlan.showGrid = !leavePlan.showGrid">
									<h4
										class="panel-title leave-plan-title col-lg-6 col-md-6 col-sm-6 clear-side-padding">
										<span class="fa fa-sort-asc"
											ng-class="!leavePlan.showGrid ? 'fa fa-sort-asc' : 'fa fa-sort-desc'"></span>
										<span class="heading ng-binding">{{leavePlan.leavePlanName}}</span>
										<br> <span data-ng-if="leavePlan.description != null">
											<small class="ng-binding">{{leavePlan.description}}</small>
										</span>
									</h4>
									<div class="col-lg-6 col-md-6 col-sm-6 clear-side-padding">
										<div class="inline-action-menu pull-right vertical-margin">
											<a class="anchor-sm pull-down"
												ng-click="editJobTitle(leavePlan)"> <span
												class="fa fa-pencil-square-o" tooltip-placement="left"
												tooltip="Edit"></span>
											</a> <a class="anchor-sm pull-down ng-scope"> <span
												class="fa fa-trash-o" tooltip-placement="top"
												tooltip="Delete"></span>
											</a>
										</div>
									</div>
								</div>
								<div
									class="panel-collapse ng-scope col-lg-12 col-md-12 col-sm-12"
									ng-if="leavePlan.showGrid">
									<table>
										<tr style="height: 10px"></tr>
										<tr>
											<td><button class="btn btn-success"
													ng-click="addLeaveType(leavePlan,leavePlan.companyLeavePlansId)">Add
													Leave Type</button></td>
										</tr>
										<tr style="height: 10px"></tr>
										<tr>
											<td><table style="width: 100%" border="0"
													class="table table-bordered">
													<tr>
														<th>Leave Type</th>
														<th>Allowance</th>
														<th>Accrual</th>
														<th>Carry Over</th>
														<th>Actions</th>
													</tr>
													<tr ng-repeat="leaveType in leavePlan.leaveTypeJsonList"
														ng-class-odd="'odd'" ng-class-even="'even'"
														style="height: 30px">
														<td>{{leaveType.leaveType}}</td>
														<td>{{leaveType.annualQuota}}</td>
														<td>{{leaveType.accruedRateOn}}</td>
														<td>{{leaveType.carryForwardMaxValue}}</td>
														<td><a ng-click="editLeaveType(leaveType,leavePlan)"
															tooltip="edit" style="cursor: pointer; font-size: 12px"><i
																class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
															tooltip="delete"
															ng-click="deleteJobTitle(leaveType.addLeaveTypeId)"
															style="cursor: pointer; font-size: 12px"><i
																class="fa fa-trash"></i></a></td>
													</tr>
												</table></td>
										</tr>
									</table>


								</div>
							</div></td>
					</tr>





				</table>
			</td>
		</tr>

	</table>


</div>


