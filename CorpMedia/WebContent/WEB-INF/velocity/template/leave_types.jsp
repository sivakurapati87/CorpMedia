


<div class="container-fluid" style="width: 100%;">
	<table border="2">
		<tr style="height: 120px;background-image:url('resources/images/bgimg3.png');">
			<td class="lable50_blue" align="center" colspan="3">{{companyName}}</td>
		</tr>
		<tr>
			<td width="20%" valign="top" bgcolor="white">
				<left-menu></left-menu>
			</td>
			<td width="1%"></td>
			<td valign="top">
				<table class="table" border="0" style="width: 100%;background-color: white">
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
									
								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0" style="width: 100%;">
					<tr>
						<td><h4>Leave Types</h4></td>
					</tr>
					<tr>
						<td><h5>Leave types can be defined here. Leave types
								that are defined here, can be assigned to any of the leave
								plans. We have already defined standard leave types for you. You
								can add your own leave types.</h5></td>
					</tr>
					<tr height="30px"></tr>
					<tr>
						<td>
								<button class="btn btn-info" ng-click="collapsed = !collapsed"
									>
									<span class="glyphicon glyphicon-plus"></span> Add Leave Type
								</button>

								<div collapse="collapsed">
									<table border="0" class="table">
												<tr>
													<td><label> Define a Leave Plan</label></td>
												</tr>
												<tr height="30px"></tr>
												<tr>
													<td><label>Name</label></td>
												</tr>
												<tr>
													<td><input id="panNumber" style="width: 50%"
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
														type="text" required="" data-ng-model="model.panNumber"
														name="panNumber"></td>
												</tr>
												<tr height="30px"></tr>
												<tr>
													<td><label>Description</label></td>
												</tr>
												<tr>
													<td><textarea class="form-control" rows="5"
															id="comment" style="width: 50%"></textarea></td>
												</tr>
												<tr>
													<td><div class="form-group">
															<label> <input
																class="ng-pristine ng-untouched ng-valid"
																type="checkbox"
																data-ng-disabled="model.isSystemGenerated"
																data-ng-model="model.isPaid"> <span
																class="check-overlay"></span> This leave does not incur
																loss of pay
															</label> <span class="icon-info information-tooltip tooltip-grey"
																tooltip-placement="right"
																tooltip="If this is checked, the leave will be considered as paid leave and employees will not suffer from loss of pay on deduction from this leave type"></span>
														</div></td>
												</tr>
												<tr>
													<td><div class="form-group">
															<label> <input
																class="ng-pristine ng-untouched ng-valid"
																type="checkbox"
																data-ng-disabled="model.isSystemGenerated"
																data-ng-model="model.isSick"> <span
																class="check-overlay"></span> This is a sick leave
															</label> <span class="icon-info information-tooltip tooltip-grey"
																tooltip-placement="right" tooltip="This is a Sick Leave"></span>
														</div></td>
												</tr>
												<tr>
													<td><div class="form-group">
															<label> <input
																class="ng-pristine ng-untouched ng-valid"
																type="checkbox"
																data-ng-disabled="model.isSystemGenerated"
																data-ng-model="model.isStatutory"> <span
																class="check-overlay"></span> This is statutory leave
															</label> <span class="icon-info information-tooltip tooltip-grey"
																tooltip-placement="right"
																tooltip="This is Statutory Leave"></span>
														</div></td>
												</tr>
												<tr>
													<td><div class="form-group">
															<label> <input
																class="ng-pristine ng-untouched ng-valid"
																type="checkbox" data-ng-model="model.isNoteRequired">
																<span class="check-overlay"></span> Require note/comment
															</label> <span class="icon-info information-tooltip tooltip-grey"
																tooltip-placement="right" tooltip="Require Note/Comment"></span>

														</div></td>
												</tr>
												<tr>
													<td><div class="form-group">
															<label class="clear-bottom"> <input
																class="ng-pristine ng-untouched ng-valid"
																type="checkbox" data-ng-change="resetType(model)"
																data-ng-model="model.isDocumentProofRequired"> <span
																class="check-overlay"></span> Require document proof
																when leaves exceed <input
																class="form-control days-count ng-pristine ng-untouched ng-valid ng-valid-min ng-valid-pattern ng-valid-required"
																type="number"
																data-ng-required="model.isDocumentProofRequired"
																data-ng-pattern="/^[0-9]\d*$/"
																data-ng-disabled="!model.isDocumentProofRequired"
																data-ng-model="model.documentProofLeaveExceedDays"
																data-ng-min="1" name="documentProofLeaveExceedDays"
																disabled="disabled"> calendar days
															</label> <span class="icon-info information-tooltip tooltip-grey"
																tooltip-placement="right"
																tooltip="Require Document Proof when leaves exceed days"></span>
															<div class="ng-isolate-scope"
																data-form-submit="submitted"
																data-min-error="Minimum allowed number is 1. "
																data-pattern-error="Enter valid number. "
																data-required-error="Document proof leave exceed days is required."
																data-model-controller="leaveType.documentProofLeaveExceedDays"
																data-validation-messages="">
																<div></div>


															</div></td>
												</tr>
												<tr>
													<td><div class="form-group">
															<label class="clear-bottom"> <input
																class="ng-pristine ng-untouched ng-valid"
																type="checkbox" data-ng-change="resetType(model)"
																data-ng-model="model.isPriorNoticeRequired"> <span
																class="check-overlay"></span> Require a prior notice of
																<input
																class="form-control days-count ng-pristine ng-untouched ng-valid ng-valid-min ng-valid-pattern ng-valid-required"
																type="number"
																data-ng-required="model.isPriorNoticeRequired"
																data-ng-disabled="!model.isPriorNoticeRequired"
																data-ng-pattern="/^[0-9]\d*$/" data-ng-min="1"
																data-ng-model="model.minPriorNoticeDays"
																name="noticeDays" disabled="disabled"> working
																days
															</label> <span class="icon-info information-tooltip tooltip-grey"
																tooltip-placement="right"
																tooltip="Require a prior notice of days"></span>

														</div></td>
												</tr>
												<tr>
													<td><div class="form-group">
															<label class="clear-bottom"> <input
																class="ng-pristine ng-untouched ng-valid"
																type="checkbox" data-ng-change="resetType(model)"
																data-ng-model="model.isRestrictedToGender"> <span
																class="check-overlay"></span> Restrict to <select
																class="gender-restrict ng-pristine ng-untouched ng-valid ng-valid-required"
																data-ng-required="model.isRestrictedToGender"
																data-ng-disabled="!model.isRestrictedToGender"
																data-ng-options="g.id as g.name for g in vm.gender"
																data-ng-model="model.restrictedGender"
																name="restrictGender" disabled="disabled">
																	<option class="" value="" selected="selected">select</option>
																	<option>Male</option>
																	<option value="number:2" label="Female">Female</option>
																	<option value="number:3" label="Other">Other</option>
															</select> Gender
															</label> <span class="icon-info information-tooltip tooltip-grey"
																tooltip-placement="right" tooltip="Restrict to Gender"></span>
															<div class="ng-isolate-scope"
																data-form-submit="submitted"
																data-required-error="Gender is required."
																data-model-controller="leaveType.restrictGender"
																data-validation-messages="">
																<div></div>

															</div></td>
												</tr>
												<tr>
													<td><div class="form-group">
															<label> <input
																class="ng-pristine ng-untouched ng-valid"
																type="checkbox" data-ng-model="model.isHalfDayAllowed">
																<span class="check-overlay"></span> Allow half day leave
															</label> <span class="icon-info information-tooltip tooltip-grey"
																tooltip-placement="right" tooltip="Allow half day Leave"></span>

														</div></td>
												</tr>
												<tr>
													<td><div class="form-group">
															<label> <input
																class="ng-pristine ng-untouched ng-valid"
																type="checkbox"
																data-ng-disabled="model.isSystemGenerated"
																data-ng-model="model.isStatutory"> <span
																class="check-overlay"></span> This is statutory leave
															</label> <span class="icon-info information-tooltip tooltip-grey"
																tooltip-placement="right"
																tooltip="This is Statutory Leave"></span>
														</div></td>
												</tr>
												<tr height="30px"></tr>
												<tr>

													<td align="center">

														<button class="btn btn-success" style="width: 100px">Save</button>&nbsp;
														<button class="btn btn-cancel" style="width: 100px">Cancel</button>
													</td>
												</tr>
											</table>

								</div>
							</td>
					</tr>
					<tr height="30px"></tr>
					<tr>
						<td><table class="table table-hover" style="width: 100%">
								<thead>
									<tr>
										<th>Leave Type</th>
										<th>Paid?</th>
										<th>Actions</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td width="60%">Sick Leave<br />
										<small>This is when an employee falls sick</small>
										</td>
										<td>Yes</td>
										<td><a ui-sref="add_leave_types" ng-click="addLeaveType()">
											<span
												class="glyphicon glyphicon-edit" ></span></a></td>
									</tr>
									<tr>
										<td width="60%">Paid Leave<br />
										<small>These Leaves will be when not used</small>
										</td>
										<td>Yes</td>
										<td><span class="glyphicon glyphicon-edit"></span></td>
									</tr>
									<tr>
										<td width="60%">Unpaid Leave<br />
										<small>Loss Of Pay</small>

										</td>
										<td>No</td>
										<td><span class="glyphicon glyphicon-edit"></span></td>
									</tr>
									<tr>
										<td width="60%">Floater Leave<br />
										<small>This is when an employee falls sick</small>
										</td>
										<td>Yes</td>
										<td><span class="glyphicon glyphicon-edit"></span></td>
									</tr>
									<tr>
										<td width="60%">Special Leave<br />
										<small>This is when an employee falls sick</small>
										</td>
										<td>Yes</td>
										<td><span class="glyphicon glyphicon-edit"></span></td>
									</tr>
									<tr>
										<td width="60%">Maternity Leave<br />
										<small>This is when an employee falls sick</small>
										</td>
										<td>Yes</td>
										<td><span class="glyphicon glyphicon-edit"></span></td>
									</tr>
									<tr>
										<td width="60%">Paternity Leave<br />
										<small>This is when an employee falls sick</small>
										</td>
										<td>Yes</td>
										<td><span class="glyphicon glyphicon-edit"></span></td>
									</tr>
									<tr>
										<td width="60%">Bereavement Leave<br />
										<small>This is when an employee falls sick</small>
										</td>
										<td>Yes</td>
										<td><span class="glyphicon glyphicon-edit"></span></td>
									</tr>
									<tr>
										<td width="60%">Casual Leave<br />
										<small>This is when an employee falls sick</small>
										</td>
										<td>Yes</td>
										<td><span class="glyphicon glyphicon-edit"></span></td>
									</tr>
									<tr>
										<td width="60%">Compoff<br />
										<small>This is when an employee falls sick</small>
										</td>
										<td>Yes</td>
										<td><span class="glyphicon glyphicon-edit"></span></td>
									</tr>
								</tbody>
							</table></td>
					</tr>
				</table>
			</td>
		</tr>

	</table>


</div>


