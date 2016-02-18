
<script>
	$(document).ready(function() {
		$(fader).click(function() {
			$(fade_out).fadeOut();
			$(fade_in).fadeIn();
		});
	});
</script>


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

									<li ng-class="{'active':(state==='job_titles')}"><a
										class="anchor-sm" ui-sref="job_titles">Job Titles</a></li>
									<li ng-class="{'active':(state==='employee_defaults')}"><a
										class="anchor-sm" ui-sref="employee_defaults">Employee
											Defaults</a></li>
									<li ng-class="{'active':(state==='add_employee')}"><a
										class="anchor-sm" ui-sref="add_employee">Add Employee</a></li>





								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>



							<div id="fade_out">
								<p>
									<font size="4">Job Titles</font>
								</p>
								<p>
									<font size="2">You can specify employee job title here.</font>
								</p>


								<div class="row">
									<div class="col-md-2">
										<button id="fader" class="btn btn-primary">
											<i class="fa fa-plus-square">&nbsp;&nbsp;&nbsp;</i>Add New
										</button>
									</div>
									<div class="col-md-10"></div>

								</div>
								<br>
								<table class="table">
									<tr>
										<th>Name</th>
										<th>Applies To</th>
										<th>Actions</th>
									</tr>
								</table>

							</div>


							<div id="fade_in" style="display: none">

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
													type="button">Cancel</button>
											</p>
										</div>

										<div class="col-md-7"></div>
								</form>
							</div>

							</div>




						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>



















