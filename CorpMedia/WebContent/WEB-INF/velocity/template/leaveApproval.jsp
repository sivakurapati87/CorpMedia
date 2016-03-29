

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
				<table class="table mtable" border="0"
					style="width: 100%; background-color: white">
					<tr ><td class="th"><h2>Leave Approval</h2></td> </tr>
					<tr ng-repeat="appliedLeave in appliedLeavesList" >
						<td >
								<div class="mdiv" ng-click="appliedLeave.isShowBlock = !appliedLeave.isShowBlock">
									<div class="dl ldiv">
											<label class="lable16" >
											<span class="fa fa-sort-asc" ng-class="appliedLeave.isShowBlock ? 'fa fa-sort-asc' : 'fa fa-sort-desc'"></span>
											<span class="heading ng-binding">{{appliedLeave.employeeName}}</span></label>
											<br> <span> <small class="ng-binding">Leave Type:</small><small class="ng-binding">{{appliedLeave.leaveType}}</small>
												</span> 
											<br> <span> <small class="ng-binding">Note:</small><small class="ng-binding">{{appliedLeave.note}}</small>
												</span>
										
									</div>
									<div class="dr rdiv">
										<div class="cal">
											<div class="calh">Leave Applied On:</div>
											<div class="cald" style="">{{appliedLeave.strLeaveDates}}</div>
										</div>
									</div>
								</div>
								<div class="subdiv " style=" padding-top: 20px; margin-top:-10px; border-top: none;"
									ng-if="appliedLeave.isShowBlock">
									<table style="width: 100%" >
										<tr style="height: 10px"></tr>
										<tr>
											<td><textarea rows="5" style="resize: none; width: 70%"
													class="form-control ng-pristine  ng-valid ng-valid-required width90"
													placeholder="Please enter reason for approving leave"
													ng-model="appliedLeave.comment"></textarea></td>
										</tr>
										<tr style="height: 20px"></tr>
										<tr>
											<td align="center">
												<button class="btn btn-success" type="button"
													ng-click="approveOrRejectAppliedLeaves('Approve',appliedLeave)"
													style="width: 100px">Approve</button> &nbsp;
												<button class="btn btn-danger" style="width: 100px"
													ng-click="approveOrRejectAppliedLeaves('Reject',appliedLeave)"
													type="button">Reject</button>
											</td>
										</tr>
										<tr style="height: 10px"></tr>
									</table>
								</div>
								
							</td>
					</tr>
					<tr>
						<td class="bth"><h2></h2></td>
					</tr>
				</table></td>
		</tr>
	</table>
</div>
