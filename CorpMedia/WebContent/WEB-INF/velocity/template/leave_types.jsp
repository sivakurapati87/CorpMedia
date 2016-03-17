<div class="container-fluid" style="width: 100%;">
	<form ng-submit="saveCompanyLeaveType()">
		<table border="0" >
			<tr
				style="height: 120px; background-image: url('resources/images/bgimg3.png');">
				<td class="lable50_blue" align="center" colspan="3">{{companyName}}</td>
			</tr>
			<tr>
				<td width="20%" valign="top" bgcolor="white"><left-menu></left-menu>
				</td>
				<td width="1%"></td>
				<td valign="top">
					<table class="table" border="0"
						style="width: 100%; background-color: white">
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
					<table class="table mtable table-hover table-striped" border="0" style="width: 100%;">
						<tr>
							<th><h4>Leave Types</h4></th>
						</tr>
						<tr>
							<td><h5>Leave types can be defined here. Leave types
									that are defined here, can be assigned to any of the leave
									plans. We have already defined standard leave types for you.
									You can add your own leave types.</h5></td>
						</tr>
						<tr height="30px"></tr>
						<tr>
							<td>
								<button class="btn btn-info" ng-click="collapsed = !collapsed">
									<span class="glyphicon glyphicon-plus"></span> Add Leave Type
								</button>

								<div collapse="collapsed">
									<table border="0" class="table stable table-striped">
										<tr>
											<td><label> Define a Leave Plan</label></td>
										</tr>
										<!-- <tr height="30px"></tr> -->
										<tr>
											<td><label>Name</label></td>
										</tr>
										<tr>
											<td><input id="panNumber" style="width: 50%"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""
												ng-model="companyLeaveTypeJson.leaveTypeName"></td>
										</tr>
										<!-- <tr height="30px"></tr> -->
										<tr>
											<td><label>Description</label></td>
										</tr>
										<tr>
											<td><textarea class="form-control" rows="5" id="comment"
													ng-model="companyLeaveTypeJson.leaveTypeDescription"
													style="width: 50%"></textarea></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label> <input
														class="ng-pristine ng-untouched ng-valid inputs_15  lrspace_10" type="checkbox"
														ng-model="companyLeaveTypeJson.isPaidLeave"> <span
														class="check-overlay"></span> This leave does not incur
														loss of pay
													</label> <span
														 class="sym lrspace_10"
														tooltip-placement="right"
														tooltip="If this is checked, the leave will be considered as paid leave and employees will not suffer from loss of pay on deduction from this leave type"><b>i</b></span>
												</div></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label> <input
														class="ng-pristine ng-untouched ng-valid inputs_15  lrspace_10" type="checkbox"
														ng-model="companyLeaveTypeJson.isSickLeave"> <span
														class="check-overlay"></span> This is a sick leave
													</label> <!-- <span
														class="sym lrspace_10"
														tooltip-placement="right" tooltip="This is a Sick Leave"></span>-->
 															<span tooltip="This is a Sick Leave" tooltip-placement="right" class="sym lrspace_10"> <b>i</b> </span>
												</div></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label> <input
														class="ng-pristine ng-untouched ng-valid inputs_15  lrspace_10" type="checkbox"
														ng-model="companyLeaveTypeJson.isStatutoryLeave">
														<span class="check-overlay"></span> This is statutory
														leave
													</label> <span
														class="sym lrspace_10"
														tooltip-placement="right"
														tooltip="This is Statutory Leave"><b>i</b> </span>
												</div></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label> <input
														class="ng-pristine ng-untouched ng-valid inputs_15  lrspace_10" type="checkbox"
														ng-model="companyLeaveTypeJson.isCommentRequired">
														<span class="check-overlay"></span> Require note/comment
													</label> <span
														class="sym lrspace_10"
														tooltip-placement="right" tooltip="Require Note/Comment"><b>i</b> </span>

												</div></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label class="clear-bottom"> <input
														class="ng-pristine ng-untouched ng-valid inputs_15  lrspace_10" type="checkbox"
														ng-model="companyLeaveTypeJson.isDocumentProofRequired">
														<span class="check-overlay"></span> Require document proof
														when leaves exceed <input
														class="in_height days-count ng-pristine ng-untouched ng-valid ng-valid-min ng-valid-pattern ng-valid-required"
														type="number"
														ng-required="companyLeaveTypeJson.isDocumentProofRequired"
														ng-pattern="/^[0-9]\d*$/"
														ng-disabled="!companyLeaveTypeJson.isDocumentProofRequired"
														ng-model="companyLeaveTypeJson.documentNeeded_After"
														ng-min="1" name="documentProofLeaveExceedDays">
														calendar days
													</label> <span
														class="sym lrspace_10"
														tooltip-placement="right"
														tooltip="Require Document Proof when leaves exceed days"><b>i</b> </span>
													<div class="ng-isolate-scope" data-form-submit="submitted"
														data-min-error="Minimum allowed number is 1. "
														data-pattern-error="Enter valid number. "
														data-required-error="Document proof leave exceed days is required."
														data-model-controller="leaveType.documentProofLeaveExceedDays"
														data-validation-messages="">
														<div></div>


													</div>
												</div></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label class="clear-bottom"> <input
														class="ng-pristine ng-untouched ng-valid inputs_15  lrspace_10" type="checkbox"
														ng-model="companyLeaveTypeJson.isPriorNoticeRequired">
														<span class="check-overlay"></span> Require a prior notice
														of <input
														class="in_height days-count ng-pristine ng-untouched ng-valid ng-valid-min ng-valid-pattern ng-valid-required"
														type="number"
														ng-required="companyLeaveTypeJson.isPriorNoticeRequired"
														ng-disabled="!companyLeaveTypeJson.isPriorNoticeRequired"
														ng-pattern="/^[0-9]\d*$/" ng-min="1"
														ng-model="companyLeaveTypeJson.priorNoticeRequered_After"
														name="noticeDays"> working days
													</label> <span
														class="sym lrspace_10"
														tooltip-placement="right"
														tooltip="Require a prior notice of days"><b>i</b> </span>

												</div></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label class="clear-bottom"> <input
														class="ng-pristine ng-untouched ng-valid inputs_15  lrspace_10" type="checkbox"
														ng-model="companyLeaveTypeJson.isRestricted"> <span
														class="check-overlay"></span> Restrict to <select style="width:120px;"
														class="in_height ng-pristine ng-valid ng-valid-required ng-touched"
														required ng-model="companyLeaveTypeJson.restrictToId"
														ng-options="bank.lookupDetailId as bank.description for bank in  lookup.genderList">
															<option value="" disabled selected>Restricted to</option>
													</select> Gender
													</label> <span
														class="sym lrspace_10 "
														tooltip-placement="right" tooltip="Restrict to Gender"><b>i</b> </span>
												</div></td>
										</tr>
										<tr>
											<td><div class="form-group">
													<label> <input
														class="ng-pristine ng-untouched ng-valid inputs_15  lrspace_10" type="checkbox"
														ng-model="companyLeaveTypeJson.isHalfDayLeaveAllowed">
														<span class="check-overlay"></span> Allow half day leave
													</label> <span
														class="sym lrspace_10"
														tooltip-placement="right" tooltip="Allow half day Leave"><b>i</b> </span>

												</div></td>
										</tr>
										<tr height="30px"></tr>
										<tr>

											<td align="center">

												<button class="btn btn-success" style="width: 100px"
													type="submit">Save</button>&nbsp;
												<button class="btn btn-cancel" style="width: 100px" ng-click="cancel()"
													type="button">Cancel</button>
											</td>
										</tr>
									</table>

								</div>
								<div class="col-lg-8">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										<tr>
											<th>Leave Type</th>
											<th>Paid</th>
											<th>Actions</th>
										</tr>
										<tr ng-repeat="leaveType in companyLeaveTypeJsonList"
											ng-class-odd="'odd'" ng-class-even="'even'"
											style="height: 30px">
											<td>{{leaveType.leaveTypeName}}<br>{{leaveType.leaveTypeDescription}}
											</td>
											<td><label
												ng-if="leaveType.isPaidLeave !=null && leaveType.isPaidLeave">Yes</label>
												<label
												ng-if="leaveType.isPaidLeave !=null && !leaveType.isPaidLeave">No</label></td>
											<td><a ng-click="editLeaveType(leaveType)"
												tooltip="edit" style="cursor: pointer; font-size: 12px"><i
													class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
												tooltip="delete"
												ng-click="deleteLeaveType(leaveType.companyLeaveTypeId)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>

		</table>
	</form>

</div>
