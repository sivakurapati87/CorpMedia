
<script>
	$(document).ready(function() {
		$("#btn1").click(function() {
			$("#fade_out").fadeOut();
			$("#fade_in").fadeIn();

		});
	});
</script>
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
							<div class="sub-page-navigation">
								<ul>
									<li ng-class="{'active':(state==='projects')}"><a
										class="anchor-sm" ui-sref="projects">Projects </a></li>
									<li ng-class="{'active':(state==='billing')}"><a
										class="anchor-sm" ui-sref="billing">Billing </a></li>
									<li ng-class="{'active':(state==='clients')}"><a
										class="anchor-sm" ui-sref="clients">Clients </a></li>
									<li ng-class="{'active':(state==='billing_rates')}"><a
										class="anchor-sm" ui-sref="billing_rates">Billing Rates </a></li>
									<li ng-class="{'active':(state==='reports')}"><a
										class="anchor-sm" ui-sref="reports">Reports </a></li>


								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table mtable" border="0"
					style="width: 100%; background-color: white;">
					<tr><th class="th"><h2>REPORTS</h2></th><td width="1%"></td>  <th class="th"><h2>Department Work Hours</h2></th> </tr>
						<tr>
						<td width="16%" style="background:#f9f9f9;  ">
							<div class="">
								<!--first part is for vertical navigation bar.-->
								<div class="subnavbar-static-side">
									<ul class="nav">
										<li ng-class="{'active':(state==='reports')}"><a
											class="anchor-sm" ui-sref="reports">Client Details </a></li>
										<li ng-class="{'active':(state==='project_details')}"><a
											class="anchor-sm" ui-sref="project_details">Project
												Details</a></li>
										<li ng-class="{'active':(state==='task_billing')}"><a
											class="anchor-sm" ui-sref="task_billing">Task Billing</a></li>
										<li ng-class="{'active':(state==='dpt_work_hrs')}"><a
											class="anchor-sm" ui-sref="dpt_work_hrs">Department Work
												Hours</a></li>
										<li ng-class="{'active':(state==='project_work_hrs')}"><a
											class="anchor-sm" ui-sref="project_work_hrs">Project Work
												Hours</a></li>
										<li ng-class="{'active':(state==='client_work_hrs')}"><a
											class="anchor-sm" ui-sref="client_work_hrs">Client Work
												Hours</a></li>
										<li ng-class="{'active':(state==='employee_timesheets')}"><a
											class="anchor-sm" ui-sref="employee_timesheets">Employee
												Timesheets</a></li>
									</ul>

								</div>
						</td>
						<td width="1%"></td>
						<td style="border:solid 1px #ccc; border-style: inset; background:#fefefe;">
							<!--rest of the page and data comes here-->
							<div class="col-md-12">


								<!--first row in the right part of the page-->
								<div class="row">

									<div class="col-md-4">
										<p>
											<b><font size="3"> Department Work Hours Summary</font></b>
										</p>
									</div>

									<div class="col-md-5"></div>

									<div class="col-md-3">
										<div class="form-group">
											<label for="sel1">EXPORT</label> <select class="form-control"
												id="sel1">
												<option>csv</option>
												<option>pdf</option>
											</select>
										</div>

									</div>

								</div>

								<br>


								<!--this is the second row-->
								<form ng-submit="saveDeptWorkHours()">
									<div class="row">

										<div class="col-md-3">

											<div class="form-group">
												<label for="sel1">Department</label> <select
													class="form-control" id="sel1"
													ng-model="deptWorkHours.clientsId" required=""
													ng-options=" opt.departmentId as opt.departmentName for opt in companyDepartmentList">
													<option>select a department</option>
													<!-- <option>All Departments</option>
												<option>Ungrouped Departments</option>
												<option>Accounts</option>
												<option>Web Development</option>
 -->
												</select>
											</div>
											<br>
											<div class="form-group">
												<label for="date_from">From</label> <input type="date"
													required="required" class="form-control" id=""
													ng-model="deptWorkHours.strFrom">
											</div>

										</div>

										<div class="col-md-1"></div>

										<div class="col-md-3">

											<div class="form-group">
												<label for="sel1">Group By</label> <select
													class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
													ng-model="deptWorkHours.groupById"
													ng-options="bank.lookupDetailId as bank.description for bank in  lookup.groupByList"
													required="required">
													<option value="" disabled selected>Select</option>
												</select>


											</div>
											<br>
											<div class="form-group">
												<label for="date_to">To</label> <input type="date"
													class="form-control" id="" ng-model="deptWorkHours.strTo">
											</div>

										</div>

										<!--this remains empty for the show-off purpose:for styling-->
										<div class="col-md-5"></div>

									</div>
									<!--this is the end of the row-->
									<div class="row">

										<div class="col-md-3">
											<p>
												<input type="checkbox"
													ng-model="deptWorkHours.includeNonbillableHours">&nbsp;&nbsp;Include
												non billable hours
											</p>
										</div>

										<div class="col-md-1"></div>

										<div class="col-md-3">
											<!-- <button type="submit" class="btn btn-success">Submit</button> -->
											<input type="submit" class="btn btn-submit ng-scope"
												value="Save">
										</div>

										<div class="col-md-2"></div>
										<div class="col-md-3">
											<input type="search" placeholder="search"
												class="form-control">
										</div>
									</div>
								</form>
								<br>
								<p>
									<b>No department work hours summary</b>
								</p>

								<!--  ---------------------------------- values grid talbe--------------  -->
								<div class="col-lg-8" style="margin-top: 30px;">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										<tbody>
											<tr>
												<th>Department</th>
												<th>Groupby</th>
												<th>From</th>
												<th>To</th>
												<th>Include non billable hours</th>
												<th>Actions</th>
											</tr>
											<tr ng-repeat="deptWHL in deptWorkHoursList"
												ng-class-odd="'odd'" ng-class-even="'even'"
												style="height: 30px">
												<td>{{deptWHL.department}}</td>
												<td>{{deptWHL.groupBy}}</td>
												<td>{{deptWHL.strFrom}}</td>
												<td>{{deptWHL.strTo}}</td>
												<td ng-if="deptWHL.includeNonbillableHours==true">YES</td>
												<td
													ng-if="deptWHL.includeNonbillableHours==NULL || deptWHL.includeNonbillableHours==false">NO</td>
												<td><a ng-click="editDeptWorkHours(deptWHL)"
													tooltip="edit" style="cursor: pointer; font-size: 12px">
														<i class="fa fa-pencil-square-o"></i>
												</a> &nbsp;&nbsp; <a tooltip="delete"
													style="cursor: pointer; font-size: 12px"
													ng-click="deleteDeptWorkHours(deptWHL.deptWorkHourId">
														<i class="fa fa-trash"></i>
												</a></td>
											</tr>

										</tbody>
									</table>
								</div>



								<!--  --------------------------------- values grid talbe--------------  -->
							</div>
							<!--this is the end of the main row-->


						</td>
					</tr>







				<tr>
						<td class="bth"><h2></h2></td>
						<td></td>
						<td class="bth"><h2></h2></td>
					</tr>

				</table>
			</td>
		</tr>

	</table>


</div>

































