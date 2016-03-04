
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
				<table class="table" border="0"
					style="width: 100%; background-color: white;">
					<tr>
						<td>

							<div id="fade_out">
								<p>
									<b><font size="3">Projects</font></b>
								</p>
								<p>
									<font size="2">Here you can add / manage the projects
										for each client</font>
								</p>

								<div class="row">

									<div class="col-md-2">
										<button class="btn btn-default" name="add_new" id="btn1">
											<i class="fa fa-plus"></i> &nbsp;&nbsp;Add New
										</button>
									</div>

									<div class="col-md-6"></div>

									<div class="col-md-4">
										<p>
											<i class="fa fa-search" id="search_icon"></i> <input
												type="text" placeholder="search for projects"
												style="height: 40px; margin: 0; padding-right: 100px;">
										</p>
									</div>


								</div>
								<!--row ends here-->

								<br>

								<!--panel starts here-->
								<div class="panel panel-default">
									<div class="panel-heading" style="background-color: #DDE6F4">
										<table class="table">
											<tr>
												<th>PROJECT</th>
												<th>CLIENT</th>
												<th>STATUS</th>
												<th>BILLING</th>
												<th>START DATE</th>
												<th>ACTIONS</th>
											</tr>
											<tr>put some rows here
											</tr>
										</table>
									</div>

								</div>
								<!--table ends here-->





								<!--this is the first part which shall fade out-->

							</div> <!--following is the second part which shall fade in-->
							<div id="fade_in" style="display: none">
                                 <form ng-submit="saveOrUpdateProjects()">
								<br>
								<p>
									<b><font size="3">Create Project</b></font>
								</p>
								<p>
									<font size="2">Creating projects is very easy with
										Corpmedia. Choose from either of below of the step by step
										process to initiate the importing process.</font>
								</p>



								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="email">Project Name</label>
											<input 
												ng-model="projectsJson.projectName" placeholder="Project Name"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required="">
											
										</div>

										<br>

										<div class="form-group">
											<label for="start_date">Start Date</label>
											
											<input type="text" class="form-control"
														ng-model="projectsJson.strStartDate"
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
										<div class="form-group">
											<label for="sel1">Status</label> <select
												class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
												id="currency" ng-model="projectsJson.statusId"
												ng-options="bank.lookupDetailId as bank.description for bank in  lookup.statusList">
												<option value="" disabled selected>Select</option>
											</select>
										</div>
									</div>

									<div class="col-md-1"></div>

									<div class="col-md-4">
										<div class="form-group">
											<label for="client">Client</label> 
											<input 
												ng-model="projectsJson.client" placeholder="Client"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required="">
											
										</div>
										<br>
										<div class="form-group">
											<label for="start_date">End Date</label>
											
											<input type="text" class="form-control"
														ng-model="projectsJson.strEndDate"
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
									<div class="col-md-3"></div>

								</div>
								<!--first row ends here-->

								<br>
								<div class="row">
									<div class="col-md-9">
										<div class="form-group">
											<label for="comment">Description</label>
											<textarea ng-model="projectsJson.description" 
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required="" rows="5" ></textarea>
										</div>
									</div>


									<!--this is left empty-->
									<div class="col-md-3"></div>
								</div>

								<!--second row ends here-->

								<div class="row">
									<div class="col-md-3">
										
									</div>

									<!--this remains empty-->
									<div class="col-md-2"></div>
									<div class="col-md-7">
										<input type="checkbox"
											ng-model="projectsJson.isProjectAssignToAllEmployees">&nbsp;&nbsp; Assign this
										project to all employees
										</p>
									</div>
								</div>
								<!--this is the end of the third row-->

								<div class="row">

									<!--this remains empty-->
									<div class="col-md-8"></div>

									<div class="col-md-4">
										<p>
											<a><button type="button" class="btn btn-default">Cancel</button></a>
											<a>
												<button type="submit" class="btn btn-success">Save</button>
											</a>
										</p>
									</div>


								</div>
								</form>

							</div>



						</td>
					</tr>









				</table>
			</td>
		</tr>

	</table>


</div>




































