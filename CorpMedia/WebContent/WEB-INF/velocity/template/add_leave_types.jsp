


<div class="container-fluid" style="width: 100%;">
	<form ng-submit="addLeaveType()">
		<table class="table table-hover table-striped" border="0"
			style="width: 100%;">
			<tr>
				<td colspan="2"><h2>Edit Paid Leave Configuration For
						Standard Leave Plan</h2></td>
			</tr>
			<tr>
				<td colspan="2">Edit leave type configuration for leave plan</td>
			</tr>
			<tr height="30px"></tr>
			<tr>
				<td width="40%" class="leaves">Leave type</td>
				<td><select
					class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
					required ng-model="addLeaveTypeJson.leaveTypeId"
					ng-options="leaveType.companyLeaveTypeId as leaveType.leaveTypeName for leaveType in  companyRemainingLeaveTypesList">
						<option value="" disabled selected>Leave Type</option>
				</select></td>
			</tr>
			<tr height="10px"></tr>
			<tr>
				<td width="30%" class="leaves">Annual Quota</td>
				<td><label><input type="radio" name="anual_Quota"
						value="0" ng-model="addLeaveTypeJson.annualQuotaTypeId"></label>&nbsp;<input
					type="number" style="width: 60px"
					ng-disabled="addLeaveTypeJson.annualQuotaTypeId == 1"
					ng-model="addLeaveTypeJson.annualQuota">&nbsp;days <br />
					<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>Prorate</label><br />
					<div class="input-group">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="checkbox"
							ng-disabled="addLeaveTypeJson.annualQuotaTypeId == 1"
							ng-model="addLeaveTypeJson.isProrate">&nbsp;Prorate based
						on joining date. Prorate from<input type="number"
							ng-disabled="(!addLeaveTypeJson.isProrate || addLeaveTypeJson.annualQuotaTypeId == 1)?true:false"
							ng-model="addLeaveTypeJson.prorateFrom" style="width: 60px">&nbsp;
						st day of joining month
					</div> <br /> <label> <input type="radio" name="anual_Quota"
						value="1" ng-model="addLeaveTypeJson.annualQuotaTypeId"></label>Unlimited</td>



			</tr>
			<tr height="15px"></tr>
			<tr>
				<td class="leaves">Leaves can be Availed after</td>
				<td><label><input type="radio" name="availed_From"
						value="0" ng-model="addLeaveTypeJson.leavesAvailedFromTypeId"></label>&nbsp;Employee
					Probation Period <br /> <label><input type="radio"
						name="availed_From" value="1"
						ng-model="addLeaveTypeJson.leavesAvailedFromTypeId"></label> <input
					ng-disabled="addLeaveTypeJson.leavesAvailedFromTypeId == 0"
					ng-model="addLeaveTypeJson.leavesAvailedFrom" type="number"
					style="width: 60px">&nbsp; days from joining date</td>
			</tr>
			<tr height="15px"></tr>
			<tr>
				<td class="leaves">Leave Availability</td>
				<td><label> <input type="radio" name="available_From"
						value="0" ng-model="addLeaveTypeJson.leaveAvailabilityTypeId"></label>All
					of the annual quota leaves are available. <br /> <label> <input
						type="radio" name="available_From" value="1"
						ng-model="addLeaveTypeJson.leaveAvailabilityTypeId">
				</label>Accrued balance<br /> <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>
						Accrual rate</label><br /> <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
					ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
					style="width: 180px"
					class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
					required ng-model="addLeaveTypeJson.accruedRateId"
					ng-options="bank.lookupDetailId as bank.description for bank in  lookup.monthQuerertyList">
						<option value="" disabled selected>Accrual rate</option>
				</select>on <input type="number" style="width: 60px"
					ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
					ng-model="addLeaveTypeJson.accruedRateOn">&nbsp;day of the
					month<br /> <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>
						Accrual Starts</label><br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>
						<input type="radio" name="accrual_Start" value="0"
						ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
						ng-model="addLeaveTypeJson.accrualStartFromTypeId">

				</label>From joining date<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>
						<input type="radio" name="accrual_Start" value="1"
						ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
						ng-model="addLeaveTypeJson.accrualStartFromTypeId">
				</label>After completion of employee probation period<br /> <br />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label> Accrue leave lapse
						behaviour</label><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label><input
						type="radio" name="accrual_Leave_Lapse" value="0"
						ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
						ng-model="addLeaveTypeJson.accruedLeaveLapseTypeId"> </label> Does
					not lapse<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
						type="radio" name="accrual_Leave_Lapse" value="1"
						ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
						ng-model="addLeaveTypeJson.accruedLeaveLapseTypeId">
				</label>Lapses after <input
					ng-disabled="(addLeaveTypeJson.leaveAvailabilityTypeId == 0 || addLeaveTypeJson.accruedLeaveLapseTypeId == 0)?true:false"
					ng-model="addLeaveTypeJson.accruedLeaveLapseAfter" type="number"
					style="width: 60px"> days from the date of accrual <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline"> <input type="checkbox"
						ng-disabled="addLeaveTypeJson.leaveAvailabilityTypeId == 0"
						ng-model="addLeaveTypeJson.isAllowUtilizationOfLeaves"
						value="option1"> Allow utilization of leaves beyond
						accrued balance
				</label></td>
			</tr>
			<tr height="15px"></tr>
			<tr>
				<td class="leaves">Frequency of Leaves</td>
				<td><label class="checkbox-inline"> Limit to <input
						type="number" ng-model="addLeaveTypeJson.frequencyOfLeaves"
						style="width: 60px">Consecutive days
				</label><br /></td>
			</tr>
			<tr height="15px"></tr>
			<tr>
				<td class="leaves">Holidays & Week Offs</td>
				<td><label> Holiday between two consecutive paid leave
						dates is considered as</label><br /> <label> <input type="radio"
						name="consecutiveBtPaidLeavesHoliday" value="0"
						ng-model="addLeaveTypeJson.consecutiveBtPaidLeavesHoliday">
				</label>Leave<br /> <label><input type="radio"
						name="consecutiveBtPaidLeavesHoliday" value="1"
						ng-model="addLeaveTypeJson.consecutiveBtPaidLeavesHoliday">

				</label>Holiday<br /> <br /> <label> Weekoff days between two
						consecutive paid leave dates is considered as</label><br /> <label>
						<input type="radio" name="consecutiveBtPaidLeavesWeekOff"
						value="0"
						ng-model="addLeaveTypeJson.consecutiveBtPaidLeavesWeekOff">
				</label>Leave<br /> <label> <input type="radio"
						name="consecutiveBtPaidLeavesWeekOff" value="1"
						ng-model="addLeaveTypeJson.consecutiveBtPaidLeavesWeekOff">

				</label> Holiday</td>
			</tr>
			<tr height="15px"></tr>
			<tr>
				<td class="leaves">End of Leave Calendar</td>
				<td><label><input type="radio"
						name="endOfLeaveCalenderTypeId" value="0"
						ng-model="addLeaveTypeJson.endOfLeaveCalenderTypeId"> </label> All
					Leave Balance Expires<br /> <label> <input type="radio"
						name="endOfLeaveCalenderTypeId" value="1"
						ng-model="addLeaveTypeJson.endOfLeaveCalenderTypeId"></label>
					Carry forward a maximum of <input type="number" style="width: 60px"
					ng-model="addLeaveTypeJson.carryForwardMaxValue"
					ng-disabled="addLeaveTypeJson.endOfLeaveCalenderTypeId ==0">
					days first and then pay maximum of <input type="number"
					ng-model="addLeaveTypeJson.payMaximumValue"
					ng-disabled="addLeaveTypeJson.endOfLeaveCalenderTypeId ==0"
					style="width: 60px">days</td>
			</tr>
			<tr height="10px"></tr>
			<tr>
				<td></td>
				<td align="center">

					<button class="btn btn-success" style="width: 100px" type="submit">Update</button>&nbsp;
					<button class="btn btn-cancel" style="width: 100px" type="button" ng-click="cancel()">Cancel</button>
				</td>
			</tr>

		</table>
	</form>
</div>




































