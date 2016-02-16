<div class="container-fluid" style="width: 100%;">
	<table border="0">
		<tr style="height: 120px; background-image:url('resources/images/bgimg3.png');" >
			<td class="lable50_blue" align="center" colspan="3">{{companyName}}</td>
		</tr>
		<tr>
			<td width="20%" valign="top" bgcolor="white">
				<left-menu></left-menu>
			</td>
			<td width="1%"></td>
			<td valign="top">
				<table class="table" border="0" style="width: 100%;">
					<tr>
						<td>
							<div class="sub-page-navigation">
								<ul>
									<li ng-class="{'active':(state==='legalentities')}"><a
										class="anchor-sm"
										ui-sref="company_legalentities.mainInfo({legEntity:'cmpInfo'})">Legal
											Entities</a></li>
									<li ng-class="{'active':(state==='general')}"><a
										class="anchor-sm" ui-sref="company_general">General Info</a></li>

									<li ng-class="{'active':(state==='locations')}"><a
										class="anchor-sm" ui-sref="company_locations">Locations</a></li>
									<li ng-class="{'active':(state==='department')}"><a
										class="anchor-sm" ui-sref="company_department">Departments</a></li>

								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">

					<tr>
						<td><a data-toggle="modal" data-target="#myModal" 
							style="cursor: pointer; font-size: 20px"><span
								class="glyphicon glyphicon-plus-sign"></span>&nbsp;Add New Signatory</a>
							<!-- Modal -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">Add Signatory</h4>
										</div>
										<div class="modal-body">
											<table class="table" border="0" width="100%" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="33%"><label class="lable16_Regular">
															Signatory Name </label></td>
													<td width="33%"><label class="lable16_Regular">
															Father's Name</label></td>
													<td><label class="lable16_Regular">Signatory
															Designation</label></td>
												</tr>
												<tr>
													<td><input id="panNumber" style="width: 100%"
														placeholder="Signatory Name"
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
														type="text" required="" data-ng-model="model.panNumber"
														name="panNumber"></td>
													<td><input id="panNumber" style="width: 100%"
														placeholder="Father's Name"
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
														type="text" required="" data-ng-model="model.panNumber"
														name="panNumber"></td>
													<td><input id="panNumber" style="width: 100%"
														placeholder="Designation"
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
														type="text" required="" data-ng-model="model.panNumber"
														name="panNumber"></td>
												</tr>
												<tr>
													<td colspan="2"><label class="lable16_Regular">Address
													</label></td>

												</tr>
												<tr>
													<td colspan="2"><table>

															<tr>
																<td colspan="3"><input type="email"
																	class="form-control" id="exampleInputEmail1"
																	placeholder="Address Line 1"></td>
															</tr>
															<tr height="5px"></tr>
															<tr>
																<td colspan="3"><input type="email"
																	class="form-control" id="exampleInputEmail1"
																	placeholder="Address Line 2"></td>
															</tr>
															<tr height="5px"></tr>
															<tr>
																<td><input type="email" class="form-control"
																	id="exampleInputEmail1" placeholder="City"></td>
																<td><input type="email" class="form-control"
																	id="exampleInputEmail1" placeholder="State"></td>
																<td><input type="email" class="form-control"
																	id="exampleInputEmail1" placeholder="Pin"></td>


															</tr>
														</table></td>

												</tr>
												<tr>
													<td><label class="lable16_Regular"> Email </label></td>
													<td><label class="lable16_Regular">Pan Number
													</label></td>
												</tr>
												<tr>
													<td><input id="panNumber" style="width: 100%"
														placeholder="Email"
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
														type="text" required="" data-ng-model="model.panNumber"
														name="panNumber"></td>
													<td><input id="panNumber" style="width: 100%"
														placeholder="Pan Number"
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
														type="text" required="" data-ng-model="model.panNumber"
														name="panNumber"></td>
												</tr>

											</table>





										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Cancel</button>
											<button type="button" class="btn btn-primary">Add
												Signatory</button>
										</div>
									</div>
								</div>
							</div></td>
					</tr>



					<tr>
						<td><a data-toggle="modal" data-target="#myModal1"
							style="cursor: pointer;font-size: 20px"><span
								class="glyphicon glyphicon-plus-sign"></span>&nbsp; Add Bank Account</a> <!-- Modal -->
							<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">Add Bank
												Account</h4>
										</div>
										<div class="modal-body">
											<table class="table" border="0" width="100%" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="33%"><label class="lable16_Regular">
															Name of the Bank </label></td>

												</tr>
												<tr>

													<td><select id="formSignatory" style="width: 100%"
														class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
														required="" data-ng-model="model.form16SignatoryId"
														name="formSignatory"
														data-ng-options="s.employeeId as s.name for s in vm.authorizedSignatories">
															<option class="" value="" selected="selected">Select
																Bank</option>

													</select></td>
													
												</tr>
												
												<tr>
													<td><label class="lable16_Regular"> Account Number </label></td>
													
												</tr>
												<tr>
													<td><input id="panNumber" style="width: 100%"
														placeholder="Account Number"
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
														type="text" required="" data-ng-model="model.panNumber"
														name="panNumber"></td>
													
												</tr>
												<tr>
													<td><label class="lable16_Regular">IFSC Code </label></td>
													
												</tr>
												<tr>
													<td><input id="panNumber" style="width: 100%"
														placeholder="IFSC Code"
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
														type="text" required="" data-ng-model="model.panNumber"
														name="panNumber"></td>
													
												</tr>
												<tr>
													<td><label class="lable16_Regular">Branch </label></td>
													
												</tr>
												<tr>
													<td><input id="panNumber" style="width: 100%"
														placeholder="Branch"
														class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
														type="text" required="" data-ng-model="model.panNumber"
														name="panNumber"></td>
													
												</tr>

											</table>





										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Cancel</button>
											<button type="button" class="btn btn-primary">Add
												Account</button>
										</div>
									</div>
								</div>
							</div></td>
					</tr>

					<tr>
						<td>
							<div
								class="internal-details-menu nav-list col-sm-12 nav-bar-align">
								<ul class="nav nav-tabs">
									<li ng-class="{'active': (state_info_name==='cmpInfo')}">
										<a class="anchor-md"
										ui-sref="company_legalentities.mainInfo({legEntity:'cmpInfo'})">Company
											Info</a>
									</li>
									<li ng-class="{'active': (state_info_name==='itInfo')}"><a
										class="anchor-md"
										ui-sref="company_legalentities.mainInfo({legEntity:'itInfo'})">IT
											Info</a></li>
									<li ng-class="{'active': (state_info_name === 'pfInfo')}">
										<a class="anchor-md"
										ui-sref="company_legalentities.mainInfo({legEntity:'pfInfo'})">PF
											Info</a>
									</li>
									<li ng-class="{'active': (state_info_name == 'esiInfo')}">
										<a class="anchor-md"
										ui-sref="company_legalentities.mainInfo({legEntity:'esiInfo'})">ESI
											Info</a>
									</li>
									<li class="ng-scope"
										ng-class="{'active': (state_info_name == 'ptInfo')}"><a
										class="anchor-md"
										ui-sref="company_legalentities.mainInfo({legEntity:'ptInfo'})">PT
											Info</a></li>

								</ul>
							</div>
							<div ui-view="company_legal_entities_info"></div>
						</td>
					</tr>

					<tr>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>