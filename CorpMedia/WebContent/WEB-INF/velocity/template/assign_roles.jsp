<script>
	$(document).ready(function() {
		$(btn1).click(function() {

			$(fadeout1).fadeOut("slow");
			$(fadein1).fadeIn("slow");
		});
		$(btn2).click(function() {

			$(fadeout2).fadeOut("slow");
			$(fadein2).fadeIn("slow");
		});
		$(btn3).click(function() {

			$(fadeout3).fadeOut("slow");
			$(fadein3).fadeIn("slow");
		});
		$(btn4).click(function() {

			$(fadeout4).fadeOut("slow");
			$(fadein4).fadeIn("slow");
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

									<li ng-class="{'active':(state==='assign_roles')}"><a
										class="anchor-sm" ui-sref="assign_roles">Assign Roles</a></li>



								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>

							<h4>System Roles</h4>
							<p>Define your employees role here.</p>
							<article class="w3-container w3-border">
								<div class="row">
									<div class="col-md-4">
										<!-- first half of the row -->
										<p>
											<b>Global Admin</b>
										</p>
										<p>A global admin has all permissions across the system
											including finances and executive dashboards.</p>
									</div>
									<div class="col-md-8">
										<!-- this is the right part of row -->
										<br> <br>
										<!-- just aligning  the button to the text -->
										<div id="fadeout1">
											<button id="btn1" class="btn btn-info">
													<span class="glyphicon glyphicon-plus"></span>Add New
											</button>
										</div>

										<div id="fadein1" style="display: none">
											<input type="text" placeholder="Search for employees" />
										</div>
										<!-- end of fadein1 -->
									</div>
								</div>
								<!-- end of row -->
								<hr>
								<!--  first row ends here-->
								<div class="row">
									<div class="col-md-4">
										<!-- first half of the row -->
										<p>
											<b>HR Manager</b>
										</p>
										<p>This is HR manager role</p>
									</div>
									<div class="col-md-8">
										<!-- this is the right part of row -->
										<br>
										<!-- just aligning  the button to the text -->
										<div id="fadeout2">
											<button id="btn2" class="btn btn-info">
												<span class="glyphicon glyphicon-plus"></span>Add New
											</button>
										</div>
										<div id="fadein2" style="display: none">
											<input type="text" placeholder="Seach for employees" />
										</div>
										<!-- end of fadein2 -->
									</div>
								</div>
								<!-- end of row -->
								<hr>
								<div class="row">
									<div class="col-md-4">
										<!-- first half of the row -->
										<p>
											<b>Billing Manager</b>
										</p>
										<p>A billing manager has all permissions across the
											projects including finances.</p>
									</div>
									<div class="col-md-8">
										<!-- this is the right part of row -->
										<br>
										<!-- just aligning  the button to the text -->
										<div id="fadeout3">
											<button id="btn3" class="btn btn-info">
												<span class="glyphicon glyphicon-plus"></span>Add New
											</button>
										</div>
										<div id="fadein3" style="display: none">
											<input type="text" placeholder="Seach for employees" />
										</div>
										<!-- end of fadein3 -->
									</div>
								</div>
								<!-- end of row -->
								<hr>
								<div class="row">
									<div class="col-md-4">
										<!-- first half of the row -->
										<p>
											<b>Project Admin</b> 
										</p>
										<p>A project administrator has all permissions across the
											project including team, tasks and billing.</p>
									</div>
									<div class="col-md-8">
										<!-- this is the right part of row -->
										<br>
										<!-- just aligning  the button to the text -->
										<div id="fadeout4">
											<button id="btn4" class="btn btn-info">
												<span class="glyphicon glyphicon-plus"></span>Add New
											</button>
										</div>
										<div id="fadein4" style="display: none">
											<input type="text" placeholder="Seach for employees" />
										</div>
										<!-- end of fadein4 -->
									</div>
								</div>
								<!-- end of row -->
							</article>

							<h4>Contexual Roles</h4>
							<p>A context role is automatically assigned to an employee as
								part of system functionality. These can not be assigned here.
								They are assigned as part of their job fuction or workflow as
								defined below.</p>
							<div class="row">
								<div class="col-md-4">
									<p>
										<b>REPORTING MANAGER</b>
									</p>
								</div>
								<div class="col-md-8">
									<p>An employee can be assigned as a reporting manager for
										any other employees.</p>
								</div>
								<div class="col-md-4">
									<p>
										<b>PROJECT MANAGER</b>
									</p>
								</div>
								<div class="col-md-8">
									<p>An employee can be assigned as project manager for a
										specific project and permissions assigned in the project
										settings. The scope is limitted to that specific project. He
										can manage tasks and task assignments to a project.</p>
								</div>
								<div class="col-md-4">
									<p>
										<b>CLIENT MANAGER</b>
									</p>
								</div>
								<div class="col-md-8">
									<p>An employee can be assigned as client manager for
										specific client and he can manage projects and client.</p>
								</div>
							</div> <!-- end of row for manager-->







						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>



























