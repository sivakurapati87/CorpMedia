



<script>
	$(document).ready(function() {
		$("#table_row").click(function() {
			$("#table_row").append("<br>hello");
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
					<tr><th class="th"><h2>CLIENTS</h2></th> </tr><tr>
						<td>
							<div id="fade_out">

								<br>

								<p>
									<b><font size="3"></font></b>
								</p>
								<p>
									<font size="2">Here you can add / manage the client</font>
								</p>

								<div class="row">
									<div class="col-md-2">
										<button type="button" class="btn btn-info"
											ng-click="isCollapse = !isCollapse">
											<span class="glyphicon glyphicon-plus"></span>Add Client
										</button>
									</div>



									<div class="col-md-6"></div>

									

								</div>
								<!--row ends here-->

								<br>



								
								<!--table ends here-->




							</div> <!--this is the first part which shall fade out--> <!--following is the second part which shall fade in-->
							<div collapse="isCollapse">

								<!--here starts the first portion means create client-->



								<h3>Create Client</h3>
								<section>
									<br>
									<p>
										<b><font size="3">Welcome to Create Client</b></font>
									</p>
									<p>
										<font size="2">Creating clients is very easy with
											Corpmedia. Just follow the quick and easy step by step
											process to initiate the client import. </font>
									</p>

									<form ng-submit="saveClients()">

										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label for="client_name">Client Name</label> <input
														type="text" class="form-control" id="client_name"
														placeholder="Client Name" ng-model="clients.clientName">
												</div>

												<br>

												<div class="form-group">
													<label for="client_relation">Who manages this
														client relation</label> <input type="text" class="form-control"
														id="client_relation" placeholder="client manager name"
														ng-model="clients.managerName">
												</div>

												<br>

											</div>

											<div class="col-md-1"></div>

											<div class="col-md-4">
												<div class="form-group">
													<label for="notes">Notes</label>
													<textarea class="form-control" rows="5" id="notes"
														placeholder="optional" ng-model="clients.notes"></textarea>
												</div>

											</div>

											<div class="col-md-3"></div>

										</div>
										<!--first row ends here-->

										<br>


										<div class="row">

											<!--this remains empty-->
											<div class="col-md-8"></div>

											<div class="col-md-4">
												<p>
													<button class="btn btn-cancel" 
																		ng-click="cancelClients()" type="button">Cancel</button>
													<button type="submit" class="btn btn-success">Save</button>
												</p>
											</div>


										</div>
									</form>

								</section>






							</div>
							
							
							<div class="col-lg-8">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										<tr>
											<th>Client</th>
											<th>CLIENT MANAGER</th>
											<th>Actions</th>
										</tr>
										<tr ng-repeat="clients in clientsList" ng-class-odd="'odd'" 
											ng-class-even="'even'" style="height: 30px">
											<td>{{clients.clientName}}</td>
											<td>{{clients.managerName}}</td>
											<td><a ng-click="editClients(clients)" tooltip="edit"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
												tooltip="delete" ng-click="deleteClients(clients.clientsId)"
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
				</table>
			</td>
		</tr>

	</table>


</div>



























