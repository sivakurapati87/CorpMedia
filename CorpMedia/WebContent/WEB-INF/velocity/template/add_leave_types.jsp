<script>
	(function($) {
		$('.spinner .btn:first-of-type').on(
				'click',
				function() {
					$('.spinner input').val(
							parseInt($('.spinner input').val(), 10) + 1);
				});
		$('.spinner .btn:last-of-type').on(
				'click',
				function() {
					$('.spinner input').val(
							parseInt($('.spinner input').val(), 10) - 1);
				});
	})(jQuery);
</script>


<div class="container-fluid" style="width: 100%;">
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
			<td><select id="formSignatory" style="width: 30%"
				class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
				required="" data-ng-model="model.form16SignatoryId"
				name="formSignatory"
				data-ng-options="s.employeeId as s.name for s in vm.authorizedSignatories">
					<option class="" value="" selected="selected">Select a leave plan</option>

					<option>Floater Leave</option>
					<option>Special Leave</option>
					<option>Maternity Leave</option>
					<option>Paternity Leave</option>
					<option>Bereavement Leave</option>
					<option>Casual Leave</option>
					<option>Compoff</option>

			</select> </td>
		</tr>
		<tr height="10px"></tr>
		<tr>
			<td width="30%" class="leaves">Annual Quota</td>
			<td> <input type="radio"
					name="optradio"> <label class="input-group spinner">
					<input type="text" class="form-control" value="42"> <label
					class="input-group-btn-vertical">
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-up"></i>
						</button>
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-down"></i>
						</button>
				</label>
			</label> days <br /> <br /> <label>Prorate</label><br /> <br /> <label
				class="checkbox-inline"> <input type="checkbox"
					id="inlineCheckbox1" value="option1">Prorate based on
					joining date. Prorate from
					<div class="input-group spinner">
						<input type="text" class="form-control" value="42">
						<div class="input-group-btn-vertical">
							<button class="btn btn-default" type="button">
								<i class="fa fa-caret-up"></i>
							</button>
							<button class="btn btn-default" type="button">
								<i class="fa fa-caret-down"></i>
							</button>
						</div>
					</div> day of joining month<br /> <br /> <label class="radio">
						<input type="radio" name="optradio">
				</label>Unlimited</td>
		</tr>
		<tr height="15px"></tr>
		<tr>
			<td class="leaves">Leaves can be Availed after</td>
			<td><label class="radio"> <input type="radio"
					name="optradio">
			</label>Employee Probation Period<br /> <label class="radio"> <input
					type="radio" name="optradio"></label>
				<div class="input-group spinner">
					<input type="text" class="form-control" value="42">
					<div class="input-group-btn-vertical">
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-up"></i>
						</button>
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-down"></i>
						</button>
					</div>
				</div> days from joining date</td>
		</tr>
		<tr height="15px"></tr>
		<tr>
			<td class="leaves">Leave Availability</td>
			<td><label class="radio"> <input type="radio"
					name="optradio">
			</label>All of the annual quota leaves are available.<br /> <label
				class="radio"> <input type="radio" name="optradio">
			</label>Accrued balance<br /> <br /> <label> Accrual rate</label><br /> <br />
				<select style="width: 100px; height: 30px"><option>monthly</option></select>on
				<div class="input-group spinner">
					<input type="text" class="form-control" value="42">
					<div class="input-group-btn-vertical">
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-up"></i>
						</button>
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-down"></i>
						</button>
					</div>
				</div>day of the month<br /> <br /> <label> Accrual Starts</label><br />
				<label class="radio"> <input type="radio" name="optradio">

			</label>From joining date<br /> <label class="radio"> <input
					type="radio" name="optradio">
			</label>After completion of employee probation period<br /> <br /> <label>
					Accrue leave lapse behaviour</label><br /> <label class="radio"> <input
					type="radio" name="optradio">
			</label> Does not lapse<br /> <label class="radio"> <input
					type="radio" name="optradio">
			</label>Lapses after
				<div class="input-group spinner">
					<input type="text" class="form-control" value="42">
					<div class="input-group-btn-vertical">
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-up"></i>
						</button>
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-down"></i>
						</button>
					</div>
				</div> days from the date of accrual <br /> <label
				class="checkbox-inline"> <input type="checkbox"
					id="inlineCheckbox1" value="option1"> Allow utilization of
					leaves beyond accrued balance
			</label></td>
		</tr>
		<tr height="15px"></tr>
		<tr>
			<td class="leaves">Frequency of Leaves</td>
			<td><label class="checkbox-inline"> <input
					type="checkbox" id="inlineCheckbox1" value="option1">Limit
					to
					<div class="input-group spinner">
						<input type="text" class="form-control" value="42">
						<div class="input-group-btn-vertical">
							<button class="btn btn-default" type="button">
								<i class="fa fa-caret-up"></i>
							</button>
							<button class="btn btn-default" type="button">
								<i class="fa fa-caret-down"></i>
							</button>
						</div>
					</div>Consecutive days
			</label><br /> <label class="checkbox-inline"> <input
					type="checkbox" id="inlineCheckbox1" value="option1">Limit
					to
					<div class="input-group spinner">
						<input type="text" class="form-control" value="42">
						<div class="input-group-btn-vertical">
							<button class="btn btn-default" type="button">
								<i class="fa fa-caret-up"></i>
							</button>
							<button class="btn btn-default" type="button">
								<i class="fa fa-caret-down"></i>
							</button>
						</div>
					</div>Occurances in
					<div class="input-group spinner">
						<input type="text" class="form-control" value="42">
						<div class="input-group-btn-vertical">
							<button class="btn btn-default" type="button">
								<i class="fa fa-caret-up"></i>
							</button>
							<button class="btn btn-default" type="button">
								<i class="fa fa-caret-down"></i>
							</button>
						</div>
					</div> <select style="width: 100px; height: 30px"><option>Select</option></select>
			</label></td>
		</tr>
		<tr height="15px"></tr>
		<tr>
			<td class="leaves">Holidays & Week Offs</td>
			<td><label> Holiday between two consecutive paid leave
					dates is considered as</label><br /> <label class="radio"> <input
					type="radio" name="optradio">
			</label>Leave<br /> <label class="radio"> <input type="radio"
					name="optradio">
			</label>Holiday<br /> <br /> <label> Weekoff days between two
					consecutive paid leave dates is considered as</label><br /> <label
				class="radio"> <input type="radio" name="optradio">
			</label>Leave<br /> <label class="radio"> <input type="radio"
					name="optradio">
			</label> Holiday</td>
		</tr>
		<tr height="15px"></tr>
		<tr>
			<td class="leaves">End of Leave Calendar</td>
			<td><label class="radio"> <input type="radio"
					name="optradio">
			</label> All Leave Balance Expires<br /> <label class="radio"> <input
					type="radio" name="optradio"></label> Pay maximum of

				<div class="input-group spinner">
					<input type="text" class="form-control" value="42">
					<div class="input-group-btn-vertical">
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-up"></i>
						</button>
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-down"></i>
						</button>
					</div>
				</div> days first and then carry forward a maximum of
				<div class="input-group spinner">
					<input type="text" class="form-control" value="42">
					<div class="input-group-btn-vertical">
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-up"></i>
						</button>
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-down"></i>
						</button>
					</div>
				</div>days <br /> <label class="radio"> <input type="radio"
					name="optradio"></label> Carry forward a maximum of

				<div class="input-group spinner">
					<input type="text" class="form-control" value="42">
					<div class="input-group-btn-vertical">
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-up"></i>
						</button>
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-down"></i>
						</button>
					</div>
				</div> days first and then pay maximum of
				<div class="input-group spinner">
					<input type="text" class="form-control" value="42">
					<div class="input-group-btn-vertical">
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-up"></i>
						</button>
						<button class="btn btn-default" type="button">
							<i class="fa fa-caret-down"></i>
						</button>
					</div>
				</div>days</td>
		</tr>
		<tr height="10px"></tr>
		<tr>
			<td></td>
			<td align="center">

				<button class="btn btn-success" style="width: 100px">Update</button>&nbsp;
				<button class="btn btn-cancel" style="width: 100px">Cancel</button>
			</td>
		</tr>

	</table>
</div>









