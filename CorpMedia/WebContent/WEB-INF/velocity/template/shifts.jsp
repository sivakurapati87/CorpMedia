


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

									<li ng-class="{'active':(state==='weekly_offs')}"><a
										class="anchor-sm" ui-sref="weekly_offs">Weekly Offs</a></li>
									<li ng-class="{'active':(state==='shifts')}"><a
										class="anchor-sm" ui-sref="shifts">Shifts</a></li>
									<li ng-class="{'active':(state==='timing_policies')}"><a
										class="anchor-sm" ui-sref="timing_policies">Timing
											Policies</a></li>
									<li ng-class="{'active':(state==='web_clock_in')}"><a
										class="anchor-sm" ui-sref="web_clock_in">Web Clock-in</a></li>
									<li ng-class="{'active':(state==='wfh')}"><a
										class="anchor-sm" ui-sref="wfh">WFH</a></li>

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


											<div class="ng-scope" data-ui-view="">

												<div class="row ng-scope">
													<div
														class="col-lg-12 col-md-12 col-sm-12 col-xs-12 approver-hierarchy"
														data-ng-class="{'vertical-margin': vm.id }">

														<!-- This is all needs to be hide. -->
														<div id="replacable">
															<h4 class="page-heading"
																data-ng-class="{'clear-top-margin': vm.id }">Shifts</h4>
															<p class="page-description ng-scope" data-ng-if="!vm.id">You
																can specify shifts schedules here. These can be assigned
																to individual employees. The default shift plan gets
																applied to all employees when not explicitly set.</p>



															<div class="add-new">
																<div
																	class="col-lg-12 col-md-12 col-sm-12 col-xs-12 clear-side-padding">
																	<div
																		class="col-lg-2 col-md-4 col-sm-4 col-xs-12 clear-side-padding">

																		<button type="button" class="btn btn-info"
																		data-toggle="collapse" data-target="#shifts">
																		<span class="glyphicon glyphicon-plus"></span>Add New
																		</button>


																		


																	</div>
																</div>
															</div>


															<br> <br> <br>
														</div>
													</div>
													<!-- This is our div we need to hide. -->
													<div id="shifts" class="collapse">
														<!-- Here is your tag form -->


														<div
															class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
															<!-- uiView:  -->
															<div data-ui-view="" class="ng-scope">




																<!-- ngIf: vm.hideForm -->

																<!-- ngIf: !vm.hideForm -->
																<div ng-if="!vm.hideForm" class="ng-scope">
																	<div
																		class="col-lg-12 col-md-12 col-sm-12 clear-side-padding">
																		<div id="EmployeeRoleController"
																			class="employee-role-template">
																			<div>
																				<div>
																					<!-- ngIf: model.id -->
																					<!-- ngIf: !model.id -->
																					<h4 
																						class="branded-heading ng-scope">Add Expense
																						Tag</h4>
																					<!-- end ngIf: !model.id -->
																				</div>
																			</div>
																			<form id="newTag" name="vm.newTag"
																				class="ng-pristine ng-invalid ng-invalid-required">

																				<div
																					class="col-md-6 col-lg-6 col-sm-12 clear-side-padding">
																					<div class="form-group">
																						<label>Tag Name</label> <input
																							data-set-focus="true" data-show="true"
																							class="form-control ng-pristine ng-invalid ng-invalid-required ng-touched"
																							type="text" placeholder="Tag Name"
																							data-ng-model="model.name" id="name" name="name"
																							data-ng-model-options="vm.modelOptions"
																							required="">
																						<div data-validation-messages=""
																							data-model-controller="vm.newTag.name"
																							data-required-error="Tag Name is required"
																							data-form-submit="submitted"
																							class="ng-isolate-scope">
																							<div>
																								<!-- ngRepeat: message in errorMessages -->
																								<small class="error ng-binding ng-scope ng-hide"
																									ng-repeat="message in errorMessages"
																									ng-show="(!modelController.$pristine &amp;&amp; $first) || formSubmit">Tag
																									Name is required</small>
																								<!-- end ngRepeat: message in errorMessages -->
																							</div>
																						</div>
																					</div>
																					<div class="pull-right">
																						<!-- ngIf: !model.id -->
																						<input data-ng-if="!model.id" type="button"
																							class="btn btn-submit ng-scope"
																							data-ng-click="submitted=true; saveTag(model);"
																							value="Save">
																						<!-- end ngIf: !model.id -->
																						<!-- ngIf: model.id -->
																						<input type="button"
																							class="btn btn-default btn-basic btn-cancel"
																							data-ng-click="cancel()" value="Cancel">
																					</div>
																				</div>
																			</form>
																		</div>
																	</div>
																</div>
																<!-- end ngIf: !vm.hideForm -->

															</div>
														</div>



													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- this is plug and chug. -->
								</div>
							</div>



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>


















