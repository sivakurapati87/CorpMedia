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

									<li ng-class="{'active':(state==='timesheet_general')}"><a
										class="anchor-sm" ui-sref="timesheet_general">General</a></li>
									<li ng-class="{'active':(state==='timesheet_approval_chain')}"><a
										class="anchor-sm" ui-sref="timesheet_approval_chain">Approval
											Chain</a></li>

								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>

							<div class="panel-body">

								<div
									class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
									<div class="col-lg-12">


										<div class="ng-scope" data-ui-view="">

											<div class="row ng-scope">
												<div
													class="col-lg-12 col-md-12 col-sm-12 col-xs-12 approver-hierarchy"
													data-ng-class="{'vertical-margin': vm.id }">

													<h4 class="page-heading"
														data-ng-class="{'clear-top-margin': vm.id }">Approval
														Chain</h4>
													<p class="page-description ng-scope" data-ng-if="!vm.id">This
														is the default timesheet approval chain. When a new
														project is created, then this approval chain is applied by
														default</p>
													<div class="row">
														<div class="col-md-4">


															<div class="add-new">
																<div
																	class="col-lg-12 col-md-12 col-sm-12 col-xs-12 clear-side-padding">
																	<div
																		class="col-lg-2 col-md-4 col-sm-4 col-xs-12 clear-side-padding"
																		ng-app="approver">
																		<!--  -->
																		<button id="btn2" class="btn btn-info"
																			ng-click="addApproverLevel()">
																			<span class="glyphicon glyphicon-plus"></span>Add
																			Approver level
																		</button>


																		<br> <br>
																		<!-- here to append -->

																	</div>
																</div>
															</div>
														</div>
														<div class="col-md-4">
															<p>
																<i class="fa fa-users"></i>Role Based
															</p>
														</div>
														<div class="col-md-4">
															<p>
																<i class="fa fa-user"></i>Employees
															</p>
														</div>
													</div>
													<!-- this is the end of row -->
													<div>
														<table ng-repeat="approver in approverList">
															<tr>
																<td width="500px"><input style="width: 58%"
																	class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
																	type="text" required="" ng-model="approver.approver"></td>
															</tr>
															<tr height="20px"></tr>
														</table>
													</div>
                                                       <br>

													<input type=button class='btn btn-submit' value=Update>
													<br> <br> <br>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- this is plug and chug. -->
							</div>

						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

<div class="main1">
	<div class="div1">
    	<div class="div4">
        </div>
        <div class="div3">
        </div>
        <div class="div2">
        </div>
         <div class="div3">
        </div>
         <div class="div4">
        </div>
        <div class="div3">
        </div>
        <div class="div2">
        </div>
        <div class="div3">
        </div>
         <div class="div4">
        </div>
        <div class="div3">
        </div>
        <div class="div2">
        </div>
        <div class="div3">
        </div>
        <div class="div4">
        </div>
        
        
        
       
        
         
    </div>
    <div class="loading"><h5>Loading..</h5></div>
</div>



























