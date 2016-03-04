


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
			<td valign="top">

				<table class="table" border="0" style="width: 100%;">
					<tr>
						<td>
							<div class="sub-page-navigation">
								<ul>

									
									<li ng-class="{'active':(state==='on_boarding')}"><a
										class="anchor-sm" ui-sref="on_boarding">Onboarding</a></li>
									<li ng-class="{'active':(state==='exit_settings')}"><a
										class="anchor-sm" ui-sref="exit_settings">Exit Settings</a></li>


								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>



							<div class="panel panel-default">
								<div class="panel-body">

									<div
										class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
										<div class="col-lg-12">

											<h4>Onboarding</h4>
											<p class="page-description ng-scope">Here you can define
												employee onboarding tasks for both HR and Employee.</p>




											<form ng-submit="saveTaskAssignToHr()">
												<!-- This is our container 1-->
												<div class="w3-container w3-light-grey">
													<h6>Onboarding Task List for HR</h6>
													<p>These tasks are assigned to the HR person who
														invites a new employee to Cormmedia.</p>

													<div class="row">
														<div class="col-md-8">
															<input type="text"
																class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
																ng-model="taskassigntohr.taskName"
																placeholder="Task Name">
														</div>
														<div class="col-md-4">
															<button class="btn btn-success" type="submit"
																style="width: 100px">Add</button>
														</div>
													</div>
													<!-- this is the end of row -->


													</br> </br>
												</div>
												<!-- this is the end of the container1 -->
											</form>
											
											
											<div class="col-lg-8">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										
										<tr ng-repeat="taskassigntohr in taskAssignToHrList" ng-class-odd="'odd'"
											ng-class-even="'even'" style="height: 30px">
											<td>{{taskassigntohr.taskName}}</td>
											<td><a
												tooltip="delete" ng-click="deleteTaskAssignToHr(taskassigntohr.taskAssignToHrId)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</table>
								</div>
								<div style="height: 20px"></div>




											</br>
											<form ng-submit="saveTaskAssignToEmployee()">
											<!-- This is our container 2-->
											<div class="w3-container w3-light-grey">
												<h6 style="padding-right: 250px">Onboarding Task List for Employee</h6>
												<p>These tasks are assigned to the employee.</p>

												<div class="row">
													<div class="col-md-8">
														<input type="text"
																class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
																ng-model="taskassigntoemployee.taskName"
																placeholder="Task Name">
													</div>
													<div class="col-md-4">
														<button class="btn btn-success" type="submit"
																style="width: 100px">Add</button>
													</div>
												</div>
												<!-- this is the end of row -->
												
												</br> </br>
											</div>
											<!-- this is the end of the container -->
											</form>
											
											<div class="col-lg-8">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										
										<tr ng-repeat="taskassigntoemployee in taskAssignToEmployeeList" ng-class-odd="'odd'"
											ng-class-even="'even'" style="height: 30px">
											<td>{{taskassigntoemployee.taskName}}</td>
											<td><a
												tooltip="delete" ng-click="deleteTaskAssignToEmployee(taskassigntoemployee.taskAssignToEmployeeId)"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</table>
								</div>



										</div>
									</div>
								</div>
							</div>




						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>
































