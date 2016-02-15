<div class="container-fluid" style="width: 100%;">
<form class="form-horizontal" ng-submit="saveOrUpdate()">
	<table class="table" border="0" width="100%" cellpadding="0"
		cellspacing="0">
		<tr>
			<td colspan="3"><label class="lable16_Regular">PAN</label></td>
		</tr>
		<tr>
			<td colspan="3"><input style="width: 32%"
				class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
				type="text" required="" data-ng-model="itinfo.pan"
				name="pan"></td>
		</tr>
		<tr>
			<td><label class="lable16_Regular">TAN</label></td>
			<td><label class="lable16_Regular">TAN Circle Number</label></td>
			<td><label class="lable16_Regular">CIT(TDS) Location</label></td>
		</tr>
		<tr>
			<td><input
				class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
				type="text" required="" data-ng-model="itinfo.tan"
				name="tan"></td>
			<td><input 
				class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
				type="text" required="" data-ng-model="itinfo.tanCircleNumber"
				name="tanCircleNumber"></td>
			<td><input
				class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
				type="text" required="" data-ng-model="itinfo.citLocation"
				name="citLocation"></td>
		</tr>
		<tr>
			<td colspan="3"><label class="lable16_Regular">Form 16
					Signatory</label></td>
		</tr>
		<tr>
			<td colspan="3"><select id="formSignatory" style="width: 32%"
				class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
				required="" data-ng-model="itinfo.companySignatorId"
				
				data-ng-options="signator.companySignatorId as signator.signatorName for signator in  itinfo.companySignatorJsonList">
					
			</select></td>
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