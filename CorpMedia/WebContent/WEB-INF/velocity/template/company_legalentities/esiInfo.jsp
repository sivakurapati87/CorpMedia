<div class="container-fluid" style="width: 100%;">
	<form class="form-horizontal" ng-submit="saveOrUpdate()">
		<table class="table" border="0" width="100%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td><label class="lable16_Regular"> ESI Number </label></td>
				<td><label class="lable16_Regular">Registration Date</label></td>
			</tr>
			<tr>
				<td><input style="width: 58%"
					class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
					type="text" required="" data-ng-model="esiinfo.esiNumber"></td>
				<td><input style="width: 58%"
					class="input-group-field form-control datepicking ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-required ng-valid-date"
					type="text" required="" date-only=""
					data-ng-click="esiRegDate=true" data-is-open="esiRegDate"
					data-show-weeks="false" data-datepicker-popup="dd/MM/yyyy"
					data-ng-model="esiinfo.strRegistrationDate"></td>
			</tr>
			<tr>
				<td><label class="lable16_Regular">Signatory </label></td>
				<td><label class="lable16_Regular">Signatory
						Designation</label></td>
			</tr>
			<tr>
				<td><select style="width: 58%"
					class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
					ng-model="esiinfo.companySignatorId"
					ng-change="selectedSignatorInfo()"
					ng-options="signator.companySignatorId as signator.signatorName for signator in  esiinfo.companySignatorJsonList">

				</select></td>
				<td><input style="width: 58%" readonly="readonly"
					class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
					type="text" required="" value="{{esiinfo.signator.designation}}"></td>
			</tr>
			<tr>
				<td colspan="2"><label class="lable16_Regular">Signatory's
						Father's Name</label></td>
			</tr>
			<tr>
				<td colspan="2"><input id="panNumber" style="width: 29%"
					readonly="readonly"
					class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
					type="text" required="" value="{{esiinfo.signator.designation}}"></td>
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
<div class="main1" ng-show="isProcessing">
	<div class="div1">

		<i class="fa fa-spinner fa-spin " style="font-size: 60px"></i>
	</div>
</div>