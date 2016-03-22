<div class=""
					style="float: left;min-height: 400px; height: auto; width: 100%; margin: 0.4%; background: #ddd; border-radius: 10px 10px 10px 10px;">
					<div class="">
						<div class="row background_color_LB"
							style="margin: 0 auto; height: 28px;">
							<div class="col-sm-6 lable16_Regular padding_top4">Details</div>
							<div class="col-sm-3 lable16_Regular padding_top4 text_align_right">Monthly</div>
							<div class="col-sm-3 lable16_Regular padding_top4 text_align_right">Annually</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.basic != 0">
							<div class="col-sm-6 labelfont_12 padding_top4">Basic</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.basic)}}</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.basic}}</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.pf != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">PF
								Employee</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.pf)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.pf}}</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.hra != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">HRA</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.hra)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.hra}}</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.medicalReimbursement != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">Medical
								Reimbursement</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.medicalReimbursement)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.medicalReimbursement}}</div>
						</div>

						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.transportAllowance != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">Transport
								Allowance</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.transportAllowance)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.transportAllowance}}</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.professionalAllowance != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">Professional
								Allowance</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.professionalAllowance)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.professionalAllowance}}</div>
						</div>

						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.travelReimbursement != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">Travel
								Reimbursement</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.travelReimbursement)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.travelReimbursement}}</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.foodCoupons != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">Food
								Coupons</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.foodCoupons)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.foodCoupons}}</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.cityCompensatoryAllowance != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">City
								Compensatory Allowance</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.cityCompensatoryAllowance)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.cityCompensatoryAllowance}}</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.dailyAllowance != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">Daily
								Allowance</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.dailyAllowance)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.dailyAllowance}}</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.gratuityContribution != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">Gratuity
								Contribution</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.gratuityContribution)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.gratuityContribution}}</div>
						</div>

						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-if="employeeSalaryInfoJson.salaryComponentJson.specialAllowance != 0">
							<div class="col-sm-6 labelfont_12 padding_top4 ">Special
								Allowance</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(employeeSalaryInfoJson.salaryComponentJson.specialAllowance)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{employeeSalaryInfoJson.salaryComponentJson.specialAllowance}}</div>
						</div>
						<div class="row background_color_LB"
							style="margin: 0 auto; height: 28px;">
							<div class="col-sm-12 lable16_Regular padding_top4"> ONE TIME COMPONENTS</div>
						</div>
						<div class="row background_color_WT"
							style="margin: 0 auto; height: 28px;"
							ng-repeat="component in employeeSalaryInfoJson.employeeOneTimeComponentJsonList">
							<div class="col-sm-6 labelfont_12 padding_top4 ">{{component.oneTimeComponentName}}({{component.strMonthPayable}})</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">
								{{findMonthlyAmount(component.amount)}}
							</div>
							<div class="col-sm-3 labelfont_12 padding_top4 text_align_right">{{component.amount}}</div>
						</div>
						
						
					</div>
				</div>