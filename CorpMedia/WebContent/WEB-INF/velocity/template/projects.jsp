
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
				<table class="table mtable " border="0"
					style="width: 100%; background-color: white;">
					<tr><th><h2>Projects</h2></th> </tr><tr>
						<td>

							<div id="fade_out">
								<p>
									<b><font size="3"></font></b>
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
												type="text" placeholder="search for projects" ng-model="search.projectName"
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
											<tr ng-repeat="projects in projectsList | filter:{projectName:search.projectName}"" ng-class-odd="'odd'"
												ng-class-even="'even'" style="height: 30px">
												<td>{{projects.projectName}}</td>
												<td>{{projects.client}}</td>
												<td>{{projects.status}}</td>
												<td>---</td>
												<td>{{projects.strStartDate}}</td>

												<td><a ng-click="editProjects(projects)" tooltip="edit"
													style="cursor: pointer; font-size: 12px"><i
														class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp; <a
													tooltip="delete" style="cursor: pointer; font-size: 12px"
													ng-click="deleteProjects(projects.projectsId)"><i
														class="fa fa-trash"></i></a></td>
											</tr>
											<tr>

												<!-- put some rows here -->
											</tr>
										</table>
									</div>

								</div>
								<!--table ends here-->





								<!--this is the first part which shall fade out-->

							</div> <!--following is the second part which shall fade in-->
							<div id="fade_in" style="display: none">

								<br>
								<p>
									<b><font size="3">Create Project</b></font>
								</p>
								<p>
									<font size="2">Creating projects is very easy with
										Corpmedia. Choose from either of below of the step by step
										process to initiate the importing process.</font>
								</p>


								<form ng-submit="saveOrUpdateProjects()">
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label for="email">Project Name</label> <input
													ng-model="projects.projectName" placeholder="Project Name"
													class="form-control " type="text" required="">

											</div>

											<br>

											<div class="form-group">
												<label for="date">Start Date</label>
												<div class="input-group">
													<input type="text" class="form-control"
														ng-model="projects.strStartDate"
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

											<br>
											<div class="form-group">
												<label for="sel1">Status</label> <select
													class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
													id="currency" ng-model="projects.statusId"
													ng-options="bank.lookupDetailId as bank.description for bank in  lookup.statusList">
													<option value="" disabled selected>Select</option>
												</select>
											</div>
										</div>

										<div class="col-md-1"></div>

										<div class="col-md-4">
											<div class="form-group">
												<label for="sel1">Clients</label> <select
													ng-model="projects.clientsId"
													ng-options=" options.clientsId as options.clientName for options in clientsList"
													class="form-control" id="sel1">
													<option>All Clients</option>
												</select>
											</div>
											<br>

											<div class="form-group">
												<label for="date">End 	Date</label>
												<div class="input-group">
													<input type="text" class="form-control"
														ng-model="projects.strEndDate"
														datepicker-popup="dd-MMM-yyyy" is-open="endOpened"
														ng-click="endOpened=true"> <span
														class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="endOpened=true;$event.stopPropagation();">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
												</div>
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
												<textarea ng-model="projects.description"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													required="" rows="5"></textarea>
											</div>
										</div>


										<!--this is left empty-->
										<div class="col-md-3"></div>
									</div>

									<!--second row ends here-->

									<div class="row">
										<div class="col-md-3"></div>

										<!--this remains empty-->
										<div class="col-md-2"></div>
										<div class="col-md-7">
											<input type="checkbox"
												ng-model="projects.isProjectAssignToAllEmployees">&nbsp;&nbsp;
											Assign this project to all employees
										</div>
									</div>
									<!--this is the end of the third row-->

									<div class="row">

										<!--this remains empty-->
										<div class="col-md-8"></div>

										<div class="col-md-4">
											<button type="button" class="btn btn-default"
												ng-click="cancelProjects()">Cancel</button>
											<button type="submit" class="btn btn-success">Save</button>
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




































