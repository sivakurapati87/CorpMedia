


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

									<li ng-class="{'active':(state==='categories')}"><a
										class="anchor-sm" ui-sref="categories">Categories</a></li>
									<li ng-class="{'active':(state==='tags')}"><a
										class="anchor-sm" ui-sref="tags">Tags</a></li>


								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table mtable  " border="0"
					style="width: 100%; background-color: white">
					<tr><th class="th"><h4>Tags</h4></th> </tr><tr>
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

													<!-- This is all needs to be hide. -->
													<div id="replacable">
														<h4 class="page-heading"
															data-ng-class="{'clear-top-margin': vm.id }">Expense
															Claim Tags</h4>
														<p class="page-description ng-scope" data-ng-if="!vm.id">You
															can specify tags for expense claims.</p>



														<div class="add-new">
															<div
																class="col-lg-12 col-md-12 col-sm-12 col-xs-12 clear-side-padding">
																<div
																	class="col-lg-2 col-md-4 col-sm-4 col-xs-12 clear-side-padding">

																	<div class="col-md-2">
																		<button type="button" class="btn btn-info"
																			ng-click="isCollapse = !isCollapse">
																			<span class="glyphicon glyphicon-plus"></span>Add New
																		</button>
																	</div>














																</div>
															</div>
														</div>


														<br> <br> <br>
													</div>
												</div>
												<!-- This is our div we need to hide. -->
												<div collapse="isCollapse">


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
																				<h4 class="branded-heading ng-scope">Add
																					Expense Tag</h4>
																				<!-- end ngIf: !model.id -->
																			</div>
																		</div>
																		<form ng-submit="saveTags()">

																			<div
																				class="col-md-6 col-lg-6 col-sm-12 clear-side-padding">
																				<div class="form-group">
																					<label>Tag Name</label> <input
																						data-set-focus="true" data-show="true"
																						class="form-control ng-pristine ng-invalid ng-invalid-required ng-touched"
																						type="text" placeholder="Tag Name"
																						ng-model="tags.tagName" required="">

																				</div>
																				<div class="pull-right">
																					<!-- ngIf: !model.id -->
																					<button class="btn btn-success" type="submit"
																						style="width: 100px">Save</button>
																					&nbsp;
																					<button class="btn btn-cancel" style="width: 100px" ng-click="cancelTags()"
																						type="button">Cancel</button>
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
							
							
							<div class="col-lg-8">
								<table style="width: 100%" border="0"
									class="table table-bordered">
									<tr>
										<th>Tag Name</th>
										<th>Actions</th>
									</tr>
									<tr ng-repeat="tags in tagsList"
										ng-class-odd="'odd'" ng-class-even="'even'"
										style="height: 30px">
										<td>{{tags.tagName}}</td>
										<td><a ng-click="editTags(tags)"
											tooltip="edit" style="cursor: pointer; font-size: 12px"><i
												class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
											tooltip="delete"
											ng-click="deleteTags(tags.tagId)"
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
<div class="main1" ng-show="isProcessing">
	<div class="div1">

		<i class="fa fa-spinner fa-spin " style="font-size: 60px"></i>
	</div>
</div>































