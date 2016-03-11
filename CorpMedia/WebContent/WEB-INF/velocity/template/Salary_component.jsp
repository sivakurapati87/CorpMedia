

<div class="container-fluid" style="width: 100%;">
	<table border="0">
		<tr
			style="height: 120px; background-image: url('resources/images/bgimg3.png');">
			<td class="lable50_blue" align="center" colspan="3">{{companyName}}</td>
		</tr>
		<tr>
			<td width="20%" valign="top" bgcolor="white"><left-menu></left-menu>
			</td>
			<td width="1%"></td>
			<td valign="top">

				<table class="table" border="0" style="width: 100%;">
					<tr>
						<td>
							<div style="width: 80%; height: 500px;">
								<nvd3 options="options" data="data"
									class="with-3d-shadow with-transitions"></nvd3>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-sm-8 s" style="float: right;">

									<div class="col-sm-6" style="float: right; text-align: right;">
										<a style="float: right; cursor: pointer;" ng-if="!isEdit"
											ng-click="onclickEdit()">Edit Salary Structure</a>
										<button class="btn btn-success" type="button"
											style="width: 100px;" ng-if="isEdit" ng-click="modifySalaryComponent()">Save</button>
										&nbsp;&nbsp;
										<button class="btn btn-cancel" ng-if="isEdit"
											style="width: 100px;" ng-click="onclickEdit()"
											type="button">Cancel</button>
									</div>
								</div>
								<br />
							</div>
						</td>
					</tr>


					<tr>
						<td>
							<div class="row">
								<div class="col-sm-12 s" style="border-top: solid 3px #dde6f6;">
									<div class="col-sm-4 component-head compo_header">
										<h5>
											<b>Salary Component</b>
										</h5>
									</div>
									<div class="col-sm-4 component-head compo_header">
										<h5>
											<b>Calculation</b>
										</h5>
									</div>
									<div class="col-sm-4 component-value no-border-rt compo_header"></div>
								</div>

								<div class="col-sm-12 s" style="border-top: solid 3px #dde6f6;">
									<div class="col-sm-4 component-value compo_leftvalues">Basic</div>
									<div
										class="col-sm-4 component-value upper-case compo_rightvalues">
										<a ng-click="openPopup('Basic',salaryComponent.basic)"
											style="cursor: pointer;" ng-if="isEdit">[ctc]*{{salaryComponent.basic}}
										</a> <label ng-if="!isEdit">[ctc]*{{salaryComponent.basic}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>



								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;">
									<div class="col-sm-4 component-value compo_leftvalues">HRA</div>
									<div
										class="col-sm-4 component-value upper-case compo_rightvalues">
										<a style="cursor: pointer;"
											ng-click="openPopup('HRA',salaryComponent.hra)"
											ng-if="isEdit">[basic]*{{salaryComponent.hra}} </a> <label
											ng-if="!isEdit">[basic]*{{salaryComponent.hra}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>


								<div class="col-sm-12 " style="border-top: solid 3px #dde6f6;"
									ng-show="salaryComponent.medicalReimbursement != null">
									<div class="col-sm-4 component-value  compo_leftvalues">
										Medical Reimbursement</div>
									<div
										class="col-sm-4 component-value upper-case  compo_rightvalues">
										<a style="cursor: pointer;"
											ng-click="openPopup('Medical Reimbursement',salaryComponent.medicalReimbursement)"
											ng-if="isEdit">{{salaryComponent.medicalReimbursement}} </a>
										<label ng-if="!isEdit">{{salaryComponent.medicalReimbursement}}</label>


									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>

								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;"
									ng-show="salaryComponent.pf != null">
									<div
										class="col-sm-4 component-value ng-binding compo_leftvalues">PF
										Employee</div>
									<div
										class="col-sm-4 component-value upper-case ng-binding compo_rightvalues">

										<a style="cursor: pointer;"
											ng-click="openPopup('PF Employee',salaryComponent.pf)"
											ng-if="isEdit">[ctc]*{{salaryComponent.pf}} </a> <label
											ng-if="!isEdit">[ctc]*{{salaryComponent.pf}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>
								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;"
									ng-show="salaryComponent.transportAllowance != null">
									<div
										class="col-sm-4 component-value ng-binding compo_leftvalues">Transport
										Allowance</div>
									<div
										class="col-sm-4 component-value upper-case ng-binding compo_rightvalues">
										<a style="cursor: pointer;"
											ng-click="openPopup('Transport Allowance',salaryComponent.transportAllowance)"
											ng-if="isEdit">{{salaryComponent.transportAllowance}} </a> <label
											ng-if="!isEdit">{{salaryComponent.transportAllowance}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>
								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;">
									<div
										class="col-sm-4 component-value ng-binding compo_leftvalues">
										Special Allowance</div>
									<div
										class="col-sm-4 component-value upper-case ng-binding compo_rightvalues">0</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>
								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;"
									ng-show="salaryComponent.professionalAllowance != null">
									<div
										class="col-sm-4 component-value ng-binding compo_leftvalues">Professional
										Allowance</div>
									<div
										class="col-sm-4 component-value upper-case ng-binding compo_rightvalues">
										<a style="cursor: pointer;"
											ng-click="openPopup('Professional Allowance',salaryComponent.professionalAllowance)"
											ng-if="isEdit">{{salaryComponent.professionalAllowance}}
										</a> <label ng-if="!isEdit">{{salaryComponent.professionalAllowance}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>
								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;"
									ng-show="salaryComponent.travelReimbursement != null">
									<div
										class="col-sm-4 component-value ng-binding compo_leftvalues">Travel
										Reimbursement</div>
									<div
										class="col-sm-4 component-value upper-case ng-binding compo_rightvalues">
										<a style="cursor: pointer;"
											ng-click="openPopup('Travel Reimbursement',salaryComponent.travelReimbursement)"
											ng-if="isEdit">{{salaryComponent.travelReimbursement}} </a> <label
											ng-if="!isEdit">{{salaryComponent.travelReimbursement}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>
								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;"
									ng-show="salaryComponent.foodCoupons != null">
									<div
										class="col-sm-4 component-value ng-binding compo_leftvalues">Food
										Coupons</div>
									<div
										class="col-sm-4 component-value upper-case ng-binding compo_rightvalues">
										<a style="cursor: pointer;"
											ng-click="openPopup('Food Coupons',salaryComponent.foodCoupons)"
											ng-if="isEdit">{{salaryComponent.foodCoupons}} </a> <label
											ng-if="!isEdit">{{salaryComponent.foodCoupons}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>
								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;"
									ng-show="salaryComponent.cityCompensatoryAllowance != null">
									<div
										class="col-sm-4 component-value ng-binding compo_leftvalues">
										City Compensatory Allowance</div>
									<div
										class="col-sm-4 component-value upper-case ng-binding compo_rightvalues">
										<a style="cursor: pointer;"
											ng-click="openPopup('City Compensatory Allowance',salaryComponent.cityCompensatoryAllowance)"
											ng-if="isEdit">{{salaryComponent.cityCompensatoryAllowance}}
										</a> <label ng-if="!isEdit">{{salaryComponent.cityCompensatoryAllowance}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>
								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;"
									ng-show="salaryComponent.dailyAllowance != null">
									<div
										class="col-sm-4 component-value ng-binding compo_leftvalues">Daily
										Allowance</div>
									<div
										class="col-sm-4 component-value upper-case ng-binding compo_rightvalues">
										<a style="cursor: pointer;"
											ng-click="openPopup('Daily Allowance',salaryComponent.dailyAllowance)"
											ng-if="isEdit">{{salaryComponent.dailyAllowance}} </a> <label
											ng-if="!isEdit">{{salaryComponent.dailyAllowance}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>
								<div class="col-sm-12 ng-scope"
									style="border-top: solid 3px #dde6f6;"
									ng-show="salaryComponent.gratuityContribution != null">
									<div
										class="col-sm-4 component-value ng-binding compo_leftvalues">Employee
										Gratuity contribution</div>
									<div
										class="col-sm-4 component-value upper-case ng-binding compo_rightvalues">
										<a style="cursor: pointer;"
											ng-click="openPopup('Employee Gratuity contribution',salaryComponent.gratuityContribution)"
											ng-if="isEdit">{{salaryComponent.gratuityContribution}} </a>
										<label ng-if="!isEdit">{{salaryComponent.gratuityContribution}}</label>
									</div>
									<div
										class="col-sm-4 component-value no-border-rt compo_rightvalues"></div>
								</div>
							</div>

						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>
</div>

<button type="button" id="salaryComponentPopupBtnId"
	class="btn btn-info btn-lg" style="display: none;" data-toggle="modal"
	data-target="#salaryComponentPopupId">Open Modal</button>

<div class="modal fade" id="salaryComponentPopupId" role="dialog">
	<div class="modal-dialog">
		<div>

			<!-- Modal content-->
			<div class="modal-content" style="float: left;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">{{popupFieldName}}</h4>
				</div>
				<div class="modal-body popup_right">
					<div class="form-group">
						<div style="width: 100%; height: 85%;">
							<label class="form-group"> Formula</label>
							<textarea rows="5" cols="" style="resize: none;"
								class="form-control ng-pristine  ng-valid ng-valid-required width90"
								ng-model="popupTextAreaValue"></textarea>
						</div>
						<p style="display: block; margin-top: 60px; margin-left: 30px;">
							<button type="button" class="btn btn-success" style="width:100px;" ng-click="savePopupValue();">Save</button>
							<button type="button" class="btn btn-info" style="width:100px;"
								data-dismiss="modal">Close</button>
						</p>
					</div>
				</div>
				<div class="modal-body popup_left">
					<div class="form-group">

						<p style="display: block; font-weight: bold;">Available
							Variables</p>
						<p style="display: block">GROSS = Gross Salary (equivalent to
							CTC)</p>
						<p style="display: block">BASIC = Basic Component</p>
						<p style="display: block">HRA = House Rent Allowance</p>
						<p style="display: block">CONV = Conveyance Allowance</p>
						<p style="display: block">PF = Provident Fund</p>

					</div>
				</div>
				<div class="modal-footer"></div>
			</div>

		</div>
	</div>

</div>


<!-- Popup -->
<div class="modal fade" id="hramodelpopupid" role="dialog"
	style="width: 70%; margin: 0 auto;">
	<div class="modal-dialog" style="width: 90%; background: #fff;">
		<div>

			<!-- Modal content-->
			<div class="modal-content" style="background:;">
				<div class="modal-header" style="">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add Salary Details to</h4>
				</div>
				<div class="modal-body"
					style="float: left; height: 400px; width: 59%; margin: 0.4%; background:;">
					<!-- <div style="float: left; width:19%; height: 100%; background: #fff;"></div> -->
					<div class="form-group"
						style="float: left; width: 100%; height: 100%;">
						<div style="">
							<label class="control-label"> Annul Salary(Salary Payable
								Mothely.Excluding onetime paymets)</label> <input type="text"
								class="form-control" style="border-radius: 5px;"><br>
							<label class=" control-label"> Effective From</label> <input
								type="date" class="form-control" style="border-radius: 5px;">
						</div>
						<p style="display: block; margin-top: 4%; margin-left: 40%;">
							<button type="submit" class=" btn btn-success">Save &
								Continue</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancle</button>
						</p>
					</div>
				</div>
				<div class="modal-body"
					style="float: left; height: 400px; width: 39%; margin: 0.4%; background: #ddd; border-radius: 0px 0px 10px 10px;">
					<div class="form-group">Fill the salary detail to
						view/generate the salary structure</div>
				</div>
				<div class="modal-footer" style="background: #bbb;"></div>
			</div>

		</div>
	</div>

</div>
