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
					<tr><th class="th"><h4 class="page-heading"
														data-ng-class="{'clear-top-margin': vm.id }">Approval
														Chain</h4></th> </tr><tr>
						<td>

							<div class="panel-body">

								<div
									class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
									<div class="col-lg-12">


										<div class="ng-scope" data-ui-view="">

											<div class="row ng-scope">
												<div
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12 approver-hierarchy"
													data-ng-class="{'vertical-margin': vm.id }">

													
													<p class="page-description ng-scope" data-ng-if="!vm.id">This
														is the default timesheet approval chain. When a new
														project is created, then this approval chain is applied by
														default</p>
													<div class="row">
														<div class="col-md-4">


															<div class="add-new">
																<div
																	class="col-lg-12 col-md-12 col-sm-12 col-xs-12 clear-side-padding">
																	<div
																		class="col-lg-2 col-md-4 col-sm-4 col-xs-12 clear-side-padding"
																		>
																		<!--  -->
																		<button id="btn2" class="btn btn-info"
																			ng-click="addApproverLevel()">
																			<span class="glyphicon glyphicon-plus"></span>Add
																			Approver level
																		</button>


																		<br> <br>
																		<!-- here to append -->

																	</div>
																</div>
															</div>
														</div>
													</div>
													
													<!-- this is the end of row -->
													<form ng-submit="saveOrUpdateApproversList()">
														<div>
															<table style="width: 100%;">
																<tr height="20px"></tr>
																<tr>
																	<th width="40%"><i class="fa fa-users lrspace_10"></i>Role Based</th>
																	<th style="width:10%"></th>
																	<th width="40%"><i class="fa fa-user lrspace_10"></i>Employees</th>
																	<th style="width:10%"></th>
																</tr>
																<tr height="20px"></tr>
															</table>
															<table ng-repeat="approver in TimeSheetApproverJsonList"
																style="width: 100%;">
																
																<tr>
																	<td width="40%"><select
																		class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
																		required ng-model="approver.roleId" ng-change="onChangeRoleAction(approver.roleId,approver)"
																		ng-options="role.roleId as role.roleName for role in  companyRolesJsonList">
																			<option value="" disabled selected>Name of
																				the Role</option>
																	</select></td>
																	<td style="width:10%"></td>
																	<td  width="40%"><select
																		class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
																		required ng-model="approver.employeeId"
																		ng-options="employee.employeeId as employee.displayName for employee in  approver.employeeJsonList">
																			<option value="" disabled selected>Name of
																				the Employee</option>
																	</select></td>
																	<td style="width:10%"></td>
																</tr>
																<tr height="20px"></tr>
															</table>
														</div>
														<br> <input type="submit" class='btn btn-submit'
															value=Update> <br> <br> <br>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- this is plug and chug. -->
							</div>

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
