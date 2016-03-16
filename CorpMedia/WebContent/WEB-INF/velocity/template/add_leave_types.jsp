<div class="container-fluid" style="width: 100%;">
	<form ng-submit="addLeaveType()">
		<table class="table mtable table-striped  " border="1">
			<tr>
				<th colspan="2"><h2>Edit Paid Leave Configuration For
						Standard Leave Plan</h2></th>
			</tr>
			<tr>
				<td colspan="2">Edit leave type configuration for leave plan</td>
			</tr>
			<!-- <tr height="30px" style=" border:solid 1px #000 ;"></tr> -->
			<tr>
				<td width="40%" class="leaves">Leave type</td>
				<td><select
					class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
					required ng-model="addLeaveTypeJson.leaveTypeId"
					ng-options="leaveType.companyLeaveTypeId as leaveType.leaveTypeName for leaveType in  companyRemainingLeaveTypesList">
						<option value="" disabled selected>Leave Type</option>
				</select></td>
			</tr>
			<!-- <tr height="10px"></tr> -->
			<tr>
				<td width="30%" class="leaves">Annual Quota</td>
				<td>
					<table class="table   table-striped stable" border="0">
						<tr>
							<td colspan="2"><span><input type="radio"
									name="anual_Quota" value="0"
									ng-model="addLeaveTypeJson.annualQuotaTypeId"
									class="lrspace_10 inputs_15 "> <input type="number"
									ng-disabled="addLeaveTypeJson.annualQuotaTypeId == 1"
									ng-model="addLeaveTypeJson.annualQuota"
									class="lrspace_10  dis_inline in_height"> days</span></td>
						</tr>
						<tr>
							<td width="50px"></td>
							<td><label class="dis_block">Prorate</label> <input
								type="checkbox"
								ng-disabled="addLeaveTypeJson.annualQuotaTypeId == 1"
								ng-model="addLeaveTypeJson.isProrate"
								class="lrspace_10 inputs_15"> Prorate based on joining
								date. Prorate from <input type="number"
								ng-disabled="(!addLeaveTypeJson.isProrate || addLeaveTypeJson.annualQuotaTypeId == 1)?true:false"
								ng-model="addLeaveTypeJson.prorateFrom" class="in_height">
								<sup>st</sup>day of joining month</td>
						</tr>
						<tr>
							<td colspan="2"><input type="radio" name="anual_Quota"
								value="1" ng-model="addLeaveTypeJson.annualQuotaTypeId"
								class="lrspace_10 inputs_15"> Unlimited</td>
						</tr>
					</table>
				</td>



			</tr>
			<!-- <tr height="15px"></tr> -->
			<tr>
				<td class="leaves">Leaves can be Availed after</td>
				<td>
					<table class="table   table-striped stable" border="0">
						<tr>
							<td><input type="radio" name="availed_From" value="0"
								ng-model="addLeaveTypeJson.leavesAvailedFromTypeId"
								class="lrspace_10 inputs_15"> Employee Probation Period
							</td>
						</tr>
						<tr>
							<td><input type="radio" name="availed_From" value="1"
								ng-model="addLeaveTypeJson.leavesAvailedFromTypeId"
								class="lrspace_10 inputs_15"> <input
								class="lrspace_10 in_height "
								ng-disabled="addLeaveTypeJson.leavesAvailedFromTypeId == 0"
								ng-model="addLeaveTypeJson.leavesAvailedFrom" type="number">
								days from joining date</td>
						</tr>
					</table>
				</td>
			</tr>
			<!-- <tr height="15px"></tr> -->
			<tr>
				<td class="leaves">Leave Availability</td>
				<td>
					<table class="table   table-striped stable" border="0">
						<tr>
							<td colspan="2"><input type="radio" name="available_From"
								class="lrspace_10 inputs_15" value="0"
								ng-model="addLeaveTypeJson.leaveAvailabilityTypeId"> All
								of the annual quota leaves are available.</td>
						</tr>
						<tr>
							<td colspan="2"><input type="radio" name="available_From"
								value="1" class="lrspace_10 inputs_15"
								ng-model="addLeaveTypeJson.leaveAvailabilityTypeId">
								Accrued balance</td>
						</tr>
						<tr>
							<td width="50px"></td>
							<td><label class="dis_block">Accrual rate</label> <select
								ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
								style="width: 180px"
								class="in_height lrspace_10 ng-pristine ng-valid ng-valid-required ng-touched"
								required ng-model="addLeaveTypeJson.accruedRateId"
								ng-options="bank.lookupDetailId as bank.description for bank in  lookup.monthQuerertyList">
									<option value="" disabled selected>Accrual rate</option>
							</select> on <input type="number" class="in_height lrspace_10"
								ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
								ng-model="addLeaveTypeJson.accruedRateOn"> day of the
								month<br /> <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td width="50px"></td>
							<td><label class="dis_block"> Accrual Starts</label> <span
								class="dis_block"> <input type="radio"
									name="accrual_Start" value="0" class="lrspace_10 inputs_15"
									ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
									ng-model="addLeaveTypeJson.accrualStartFromTypeId">
									From joining date
							</span> <span class="dis_block"> <input type="radio"
									name="accrual_Start" value="1" class="lrspace_10 inputs_15"
									ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
									ng-model="addLeaveTypeJson.accrualStartFromTypeId">
									After completion of employee probation period
							</span></td>
						</tr>
						<tr>
							<td width="50px"></td>
							<td><label class="dis_block"> Accrue leave lapse
									behaviour</label> <span class="dis_block"><input type="radio"
									name="accrual_Leave_Lapse" value="0"
									class="lrspace_10 inputs_15"
									ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
									ng-model="addLeaveTypeJson.accruedLeaveLapseTypeId">
									Does not lapse</span> <span class="dis_block"> <input
									type="radio" name="accrual_Leave_Lapse" value="1"
									class="lrspace_10 inputs_15"
									ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
									ng-model="addLeaveTypeJson.accruedLeaveLapseTypeId">
									Lapses after <input class=" in_height"
									ng-disabled="(addLeaveTypeJson.leaveAvailabilityTypeId == 0 || addLeaveTypeJson.accruedLeaveLapseTypeId == 0)?true:false"
									ng-model="addLeaveTypeJson.accruedLeaveLapseAfter"
									type="number"> days from the date of
									accrual
							</span> <span class="dis_block"> <input type="checkbox"
									class="lrspace_10 inputs_15"
									ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
									ng-model="addLeaveTypeJson.isAllowUtilizationOfLeaves"
									value="option1"> Allow utilization of leaves beyond
									accrued balance
							</span></td>
						</tr>
					</table>
				</td>
			</tr>
			<!-- <tr height="15px"></tr> -->
			<tr>
				<td class="leaves">Frequency of Leaves</td>
				<td><span class="dis_block stable"> Limit to <input
						class="in_height lrspace_10 " type="number"
						ng-model="addLeaveTypeJson.frequencyOfLeaves">Consecutive
						days
				</span></td>
			</tr>
			<!-- <tr height="15px"></tr> -->
			<tr>
				<td class="leaves">Holidays & Week Offs</td>
				<td>
					<table class="table   table-striped stable" border="0">
						<tr>
							<td><label class="dis_block"> Holiday between two
									consecutive paid leave dates is considered as</label> <span
								class="dis_block "> <input type="radio"
									class="inputs_15 lrspace_10 "
									name="consecutiveBtPaidLeavesHoliday" value="0"
									ng-model="addLeaveTypeJson.consecutiveBtPaidLeavesHoliday">
									Leave
							</span> <span class="dis_block "> <input type="radio"
									name="consecutiveBtPaidLeavesHoliday" value="1"
									class="inputs_15 lrspace_10 "
									ng-model="addLeaveTypeJson.consecutiveBtPaidLeavesHoliday">

									Holiday
							</span></td>
						</tr>
						<tr>
							<td><label> Weekoff days between two consecutive
									paid leave dates is considered as</label> <span class="dis_block ">
									<input type="radio" name="consecutiveBtPaidLeavesWeekOff"
									value="0" class="inputs_15 lrspace_10 "
									ng-model="addLeaveTypeJson.consecutiveBtPaidLeavesWeekOff">
									Leave
							</span> <span class="dis_block "> <input type="radio"
									class="inputs_15 lrspace_10 "
									name="consecutiveBtPaidLeavesWeekOff" value="1"
									ng-model="addLeaveTypeJson.consecutiveBtPaidLeavesWeekOff">

									Holiday
							</span></td>
						</tr>
					</table>
				</td>
			</tr>
			<!-- <tr height="15px"></tr> -->
			<tr>
				<td class="leaves">End of Leave Calendar</td>
				<td>
					<table class="table   table-striped stable" border="0">
						<tr>
							<td><lspan class="dis_block ">
								<input type="radio" name="endOfLeaveCalenderTypeId" value="0"
									class="inputs_15 lrspace_10 "
									ng-model="addLeaveTypeJson.endOfLeaveCalenderTypeId">
								All Leave Balance Expires</label></td>
						</tr>
						<tr>
							<td><label> <input type="radio"
									name="endOfLeaveCalenderTypeId" value="1"
									class="inputs_15 lrspace_10 "
									ng-model="addLeaveTypeJson.endOfLeaveCalenderTypeId"></label>
								Carry forward a maximum of <input type="number"
								class="in_height lrspace_10 "
								ng-model="addLeaveTypeJson.carryForwardMaxValue"
								ng-disabled="addLeaveTypeJson.endOfLeaveCalenderTypeId ==0">
								days first and then pay maximum of <input type="number"
								ng-model="addLeaveTypeJson.payMaximumValue"
								ng-disabled="addLeaveTypeJson.endOfLeaveCalenderTypeId ==0"
								class="in_height lrspace_10 ">days</td>
						</tr>
					</table>
				</td>
			</tr>
			<!-- <tr height="10px"></tr> -->
			<tr>
				<td></td>
				<td align="center">

					<button class="btn btn-success" style="width: 100px" type="submit">Update</button>&nbsp;
					<button class="btn btn-cancel" style="width: 100px" type="button"
						ng-click="cancel()">Cancel</button>
				</td>
			</tr>

		</table>
	</form>
</div>
