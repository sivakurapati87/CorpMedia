<div class="container-fluid" style="width: 100%;">
	<form class="form-horizontal" ng-submit="saveOrUpdate()">
		<table class="table" border="0" width="100%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td><label class="lable16_Regular">PF Number </label></td>
				<td><label class="lable16_Regular">Registration Date</label></td>
			</tr>
			<tr>
				<td><input style="width: 58%"
					class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
					type="text" required="" data-ng-model="pfinfo.pfNumber" 
					name="pfNumber"></td>
				<td><input style="width: 58%"
					class="input-group-field form-control datepicking ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-required ng-valid-date"
					type="text" required="" date-only="" data-ng-click="pfRegDate=true"
					data-is-open="pfRegDate" data-show-weeks="false"
					data-datepicker-popup="dd/MM/yyyy"  maxlength="10"
					ng-model="pfinfo.strRegistrationDate"></td>
			</tr>
			<tr>
				<td><label class="lable16_Regular">Signatory </label></td>
				<td><label class="lable16_Regular">Signatory
						Designation</label></td>
			</tr>
			<tr>
				<td><select style="width: 58%"
					class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
					 ng-model="pfinfo.companySignatorId"
					ng-change="selectedSignatorInfo()"
					ng-options="signator.companySignatorId as signator.signatorName for signator in  pfinfo.companySignatorJsonList">
				</select> </td>
				<td><input style="width: 58%" readonly="readonly"
					class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
					type="text" required="" value="{{pfinfo.signator.designation}}"
					name="panNumber"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div class="controls">
						<label class="checkbox"> <input type="checkbox"
							ng-model="pfinfo.isSameForAll"> PF rules are same for all
							employees
						</label>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2"><label class="lable16_Regular">Signatory's
						Father's Name</label></td>
			</tr>
			<tr>
				<td colspan="2"><input id="panNumber" style="width: 23%"
					readonly="readonly"
					class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
					type="text" required="" value="{{pfinfo.signator.designation}}"
					name="panNumber"></td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<div class="col-sm-12 vertical-margin">
						<div
							class="col-sm-6 text-right pull-right vertical-margin clear-right-padding">
							<input type="submit" value="Submit" class="btn btn-success">
							<button class="btn btn-cancel">Clear</button>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
</div>