

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
			<td valign="top"><employee-info-top></employee-info-top>
				<table class="table mtable " border="0" style="width: 100%;">
					<tr><th class="th"><h2>FINANCE</h2></th> </tr><tr>
					<tr>
						<td colspan="2"><a data-toggle="modal"
							data-target="#mySalaryModelPopupId"
							style="cursor: pointer; font-size: 20px"><i class="fa fa-inr"></i>&nbsp;My
								Salary </a></td>
					</tr>
				

					<tr>
						<td colspan="2"><a data-toggle="modal"
							data-target="#oneTimeComponentModelpopupid"
							style="cursor: pointer; font-size: 20px"><i class="fa fa-inr"></i>&nbsp;My
								One Time Components </a></td>
					</tr>
					<tr>
						<td class="bth"><h2></h2></td>
					</tr>
				</table></td>
		</tr>
	</table>
</div>
<div class="modal fade" id="mySalaryModelPopupId" role="dialog"
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
					style="float: left; height: 400px; width: 44%; margin: 0.4%; background:;">
					<form ng-submit="saveOrUpdateEmployeeSalaryInfo()">
						<div class="form-group"
							style="float: left; width: 100%; height: 100%;">
							<div style="">
								<label class="control-label"> Annul Salary(Salary
									Payable Mothely.Excluding onetime paymets)</label> <input type="text"
									ng-model="employeeSalaryInfoJson.annualSalary"
									class="form-control" style="border-radius: 5px;"><br>
								<label class=" control-label"> Effective From</label>
								<div class="input-group">
									<input type="text" class="form-control"
										ng-model="employeeSalaryInfoJson.strEffectiveFrom"
										datepicker-popup="dd-MMM-yyyy" is-open="Opened"
										ng-click="Opened=true"> <span class="input-group-btn">
										<button type="button" class="btn btn-default"
											ng-click="Opened=true;$event.stopPropagation();">
											<i class="glyphicon glyphicon-calendar"></i>
										</button>
									</span>
								</div>
							</div>
							<p style="display: block; margin-top: 4%; margin-left: 20%;">
								<button type="submit" class=" btn btn-success">Save &
									Continue</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancle</button>
							</p>
						</div>
					</form>
				</div>
				<employee-salary-structure></employee-salary-structure>
				<div class="modal-footer" style="background: #bbb;"></div>
			</div>

		</div>
	</div>
</div>
<div class="modal fade" id="oneTimeComponentModelpopupid" role="dialog"
	style="width: 76%; margin: 0 auto;">
	<div class="modal-dialog" style="width: 90%; background: #fff;">
		<div>

			<!-- Modal content-->
			<div class="modal-content" style="background: #fff;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add Salary Details to</h4>
				</div>
				<div class="modal-body"
					style="float: left; min-height: 430px; height: auto; width: 44%; margin: 0.4%; background: #eee; border-radius: 5px;">

					<form ng-submit="saveOrUpdateEmployeeOneTimeComponent()">
						<div class="form-group"
							style="float: left; width: 100%; height: 100%;">
							<div style="width: 98%; min-height: 20px; height: auto;">
								<table style="width: 100%" border="0"
									class="table table-bordered">
									<tr>
										<th>One Time Component Name</th>
										<th>Amount</th>
										<th>Month Payable</th>
										<th>Status</th>
										<th>Note</th>
										<th></th>
									</tr>
									<tr
										ng-repeat="component in employeeSalaryInfoJson.employeeOneTimeComponentJsonList"
										ng-class-odd="'odd'" ng-class-even="'even'"
										style="height: 30px">
										<td>{{component.oneTimeComponentName}}</td>
										<td>{{component.amount}}</td>
										<td>{{component.strMonthPayable}}</td>
										<td>{{component.status}}</td>
										<td>{{component.note}}</td>
										<td><a ng-click="editOneTimeComponent(component)" tooltip="edit"
											style="cursor: pointer; font-size: 12px"><i
												class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
											tooltip="delete"
											ng-click="deleteOneTimeComponent(component.employeeOneTimeComponentId)"
											style="cursor: pointer; font-size: 12px"><i
												class="fa fa-trash"></i></a></td>
									</tr>
								</table>
							</div>
							<div
								style="width: 98%; height: 300px; border: solid 1px #888; border-radius: 5px; padding:; margin: 1%; background:;">
								<div class="col-sm-12" style="margin-top: 5px;">
									<label class="control-label"> ONE TIME COMPONENT</label> <input
										ng-model="employeeOneTimeComponentJson.oneTimeComponentName"
										type="text" class="form-control" style="border-radius: 5px;">
								</div>
								<div class="col-sm-12" style="margin-top: 5px;">
									<label class="control-label"> AMOUNT</label> <input type="text"
										ng-model="employeeOneTimeComponentJson.amount"
										class="form-control" style="border-radius: 5px;">
								</div>
								<div class="col-sm-12" style="margin-top: 5px;">
									<div style="width: 48%; margin: 0px; float: left;">
										<label class="control-label"> MONTH PAYABLE</label>
										<div class="input-group">
											<input type="text" class="form-control"
												ng-model="employeeOneTimeComponentJson.strMonthPayable"
												datepicker-popup="dd-MMM-yyyy" is-open="Opened"
												ng-click="Opened=true"> <span
												class="input-group-btn">
												<button type="button" class="btn btn-default"
													ng-click="Opened=true;$event.stopPropagation();">
													<i class="glyphicon glyphicon-calendar"></i>
												</button>
											</span>
										</div>
										<br>
									</div>
									<div style="width: 48%; margin-left: 2%; float: right;">
										<label class="control-label"> STATUS</label> <select
											class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
											required ng-model="employeeOneTimeComponentJson.statusId"
											ng-options="pStatus.lookupDetailId as pStatus.description for pStatus in  lookup.paymentStatusList">
											<option value="" disabled selected>Name of the Bank</option>
										</select>
									</div>
								</div>
								<div class="col-sm-12" style="margin-top: 5px;">
									<input type="text" class="form-control"
										ng-model="employeeOneTimeComponentJson.note"
										style="border-radius: 5px;" placeholder="Note"><br>
								</div>
								<!-- 								<div class="col-sm-12" style="margin-left: 37%;"> -->
								<!-- 									<button type="submit" class=" btn btn-info">Save</button> -->
								<!-- 								</div> -->
							</div>
							<div class="col-sm-12" style="margin-left: 20%;">
								<button type="submit" class=" btn btn-success">Save &
									Continue</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancle</button>
							</div>

						</div>
					</form>
				</div>
				<employee-salary-structure></employee-salary-structure>
				<div class="modal-footer" style="background: #bbb;"></div>
			</div>

		</div>
	</div>

</div>