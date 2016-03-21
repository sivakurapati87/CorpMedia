

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
			<td valign="top"><time-and-attendance-module-top></time-and-attendance-module-top>
				<table class="table" border="1"
					style="width: 100%; background-color: white">
					<tr style="height: 20px"></tr>
					<tr>
						<td><div ng-repeat="appliedLeave in appliedLeavesList"
								ng-class-odd="'odd'" ng-class-even="'even'">
								<div
									class="panel-heading col-lg-12 col-md-12 col-sm-12 btn-info"
									ng-click="appliedLeave.isShowBlock = !appliedLeave.isShowBlock">
									<h4
										class="panel-title leave-plan-title col-lg-6 col-md-6 col-sm-6 clear-side-padding">
										<span class="fa fa-sort-asc"
											ng-class="appliedLeave.isShowBlock ? 'fa fa-sort-asc' : 'fa fa-sort-desc'"></span>
										<span class="heading ng-binding">{{appliedLeave.employeeName}}</span>
										<br> <span> <small class="ng-binding">Leave
												Type:</small><small class="ng-binding">{{appliedLeave.leaveType}}</small>
										</span> <br> <span> <small class="ng-binding">Note:</small><small
											class="ng-binding">{{appliedLeave.note}}</small>
										</span>
									</h4>
									<div class="col-lg-6 col-md-6 col-sm-6 clear-side-padding">
										<div class="inline-action-menu pull-right vertical-margin">
											<div>Leave Applied On:</div>
											<div>{{appliedLeave.strLeaveDates}}</div>
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12 btn-info"
									ng-if="appliedLeave.isShowBlock">
									<table style="width: 100%">
										<tr style="height: 10px"></tr>
										<tr>
											<td><textarea rows="5" style="resize: none; width: 70%"
													class="form-control ng-pristine  ng-valid ng-valid-required width90"
													placeholder="Please enter reason for applying leave"
													ng-model="appliedLeave.comment"></textarea></td>
										</tr>
										<tr style="height: 20px"></tr>
										<tr>
											<td align="right">
												<button class="btn btn-success" type="button"
													ng-click="approveOrRejectAppliedLeaves('Approve',appliedLeave)"
													style="width: 100px">Approve</button> &nbsp;
												<button class="btn btn-danger" style="width: 100px"
													ng-click="approveOrRejectAppliedLeaves('Reject',appliedLeave)"
													type="button">Reject</button>
											</td>
										</tr>
										<tr style="height: 20px"></tr>
									</table>
								</div>
							</div></td>
					</tr>

				</table></td>
		</tr>
	</table>
</div>
