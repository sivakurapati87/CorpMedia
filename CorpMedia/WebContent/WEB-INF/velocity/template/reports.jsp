
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
				<table class="table" border="1"
					style="width: 100%; background-color: white;">
					<tr>
						<td width="20%">
							<div class="row">
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
						<td>
							<!--rest of the page and data comes here-->
							<div class="col-md-12">


								<!--first row in the right part of the page-->
								<div class="row">
									<div class="col-md-3">
										<p>
											<b><font size="3">Client Details</b></font>
										</p>
									</div>
                               
									<div class="col-md-6"></div>
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
                                   <form ng-submit="saveOrUpdateReports()">
								<div class="row">

									<div class="col-md-4">

										<div class="form-group">
											<label for="date_from">From</label>
											
											 <input type="text" class="form-control"
														ng-model="reportsJson.strFromDate"
														datepicker-popup="dd-MMM-yyyy" is-open="Opened"
														ng-click="Opened=true"> <span
														class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="Opened=true;$event.stopPropagation();">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
										</div>

									</div>

									<div class="col-md-4">

										<div class="form-group">
											<label for="date_from">To</label>
											 <input type="text" class="form-control"
														ng-model="reportsJson.strToDate"
														datepicker-popup="dd-MMM-yyyy" is-open="ExpToOpened"
														ng-click="ExpToOpened=true"> <span
														class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="ExpToOpened=true;$event.stopPropagation();">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
										</div>

									</div>

									<div class="col-md-3">
										<br>
										<button class="btn btn-success" type="submit">Submit</button>
									</div>

									<div class="col-md-3">
										<br> <input type="search" style="width: 150px"
											class="form-control">
									</div>

								</div>
								<!--this is the end of the row-->
								</form>
								

								<p>
									<b>NO billing summary</b>
								</p>
							</div>

							</div> <!--this is the end of the main row-->


						</td>
					</tr>









				</table>
			</td>
		</tr>

	</table>


</div>






























