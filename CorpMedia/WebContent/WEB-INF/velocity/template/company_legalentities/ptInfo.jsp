<div class="container-fluid" style="width: 100%;">
	<table class="table" border="0" width="100%" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><label class="lable16_Regular">PT Number</label></td>
			<td><label class="lable16_Regular"> PT Registration Date</label></td>
			<td><label class="lable16_Regular"> PT Signatory</label></td>
		</tr>
		<tr>
			<td><input id="panNumber"
				class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
				type="text" required="" data-ng-model="model.panNumber"
				name="panNumber"></td>
			<td><input
				class="input-group-field form-control datepicking ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-required ng-valid-date"
				type="text" required="" date-only="" data-ng-click="ptRegDate=true"
				data-is-open="ptRegDate" data-show-weeks="false"
				data-datepicker-popup="mediumDate"
				data-ng-model="ptInfo.registrationDate" name="registrationDate0"></td>
			<td><input id="panNumber"
				class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
				type="text" required="" data-ng-model="model.panNumber"
				name="panNumber"></td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<div class="col-sm-12 vertical-margin">
					<div
						class="col-sm-6 text-right pull-right vertical-margin clear-right-padding">
						<button class="btn btn-success">Save</button>
						<button class="btn btn-cancel">Clear</button>
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>