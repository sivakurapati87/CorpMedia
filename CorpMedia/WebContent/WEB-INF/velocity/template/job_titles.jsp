

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
			<td valign="top"><employee-module-top></employee-module-top>
				<table class="table mtable " border="0"
					style="width: 100%; background-color: white">
					<tr><th class="th"><h2>Job Titles</h2></th> </tr><tr>
						<td>



							<div>
								
								<p>
									<font size="2">You can specify employee job title here.</font>
								</p>


								<div class="row">
									<div class="col-md-2">
										<button type="button" class="btn btn-info"
											ng-click="isCollapse = !isCollapse">
											<span class="glyphicon glyphicon-plus"></span>Add New
										</button>
									</div>
									<div class="col-md-10"></div>

								</div>
								<br>

								<div collapse="isCollapse">

									<h4 class="branded-heading">Add Job title</h4>

									<form ng-submit="saveJobTitles()">
										<div class="row">
											<div class="col-md-5">

												<div class="form-group">
													<label for="job_title">Job Title</label> <input
														class="form-control" type="text" id="job_title"
														ng-model="jobtitles.jobtitle">
												</div>

												<br>

												<div class="form-group">
													<label for="description">Description</label>
													<textarea class="form-control" id="description"
														ng-model="jobtitles.description"></textarea>
												</div>

												<p>
													<button class="btn btn-success" type="submit"
														style="width: 100px">Save</button>
													&nbsp;
													<button class="btn btn-cancel" style="width: 100px"
														ng-click="cancelJobTitle()" type="button">Cancel</button>
												</p>
											</div>

											<div class="col-md-7"></div>
									</form>
								</div>

							</div>
							<div class="col-lg-8">
								<table style="width: 100%" border="0"
									class="table table-bordered">
									<tr>
										<th >Name</th>
										<th >Description</th>
										<th >Actions</th>
									</tr>
									<tr ng-repeat="jobTitle in jobtitlesList" ng-class-odd="'odd'"
										ng-class-even="'even'" style="height: 30px">
										<td>{{jobTitle.jobtitle}}</td>
										<td>{{jobTitle.description}}</td>
										<td><a ng-click="editJobTitle(jobTitle)" tooltip="edit"
											style="cursor: pointer; font-size: 12px"><i
												class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
											tooltip="delete"
											ng-click="deleteJobTitle(jobTitle.jobtitlesId)"
											style="cursor: pointer; font-size: 12px"><i
												class="fa fa-trash"></i></a></td>
									</tr>
								</table>
							</div>




						</td>
					</tr>

























				<tr>
						<td class="bth"><h2></h2></td>
					</tr>
				</table></td>
		</tr>
	</table>
</div>
<div class="main1" ng-show="isProcessing">
	<div class="div1">

		<i class="fa fa-spinner fa-spin " style="font-size: 60px"></i>
	</div>
</div>



















