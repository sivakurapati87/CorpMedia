


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
				<table class="table mtable " border="0"
					style="width: 100%; background-color: white">
					<tr><th class="th"><h2>Exit Settings</h2></th> </tr><tr>
						<td>



							<div class="w3-container w3-border">
								<h4>Termination Reasons</h4>
								<p>You can specify different reasons for Employee
									termination for each of the following three types of
									Terminations.</p>

								<button type="button" class="btn btn-info" data-toggle="modal"
									data-target="#myModal">
									<span class="glyphicon glyphicon-plus"></span>Add New
								</button>
								<!-- Modal -->
								<div class="modal fade" id="myModal" role="dialog">
									<div class="modal-dialog">
                                          <form ng-submit="saveExitSettings()">
										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Add Reason</h4>
											</div>
											<div class="modal-body">

												<label>Reason</label> <input type="text" ng-model="exitsettings.reason"
													class="form-control" placeholder="Reason type" />
												<!-- <label>Reason Type</label> -->
												<div class="form-group">
													<label for="sel1">Reason Type:</label>  <select
														class="form-control ng-pristine ng-valid ng-valid-required ng-touched" 
														ng-model="exitsettings.reasonTypeId"
														ng-options="bank.lookupDetailId as bank.description for bank in  lookup.reasonTypeList">
														<option value="" disabled selected>Select</option>
														</select>
												</div>

											</div>
											<div class="modal-footer">
												<button type="submit" class="btn btn-primary">ADD</button>
												<button type="button" class="btn btn-info btn-lg"
													value="Preview"
													style="border-radius: 1px; font-size: 12px; margin-right: 10px; padding: 10px 15px 10px 15px"
													data-dismiss="modal">Close</button>
											</div>
										</div>
										</form>

									</div>
								</div>
								
							</div>
							<!-- this is the end of w3 region -->
							<br>
							<br>
							
							
							<div class="col-lg-8">
									<table style="width: 100%" border="0"
										class="table table-bordered">
										<tr>
											<th>Reason</th>
											<th>Reason Type</th>
											<th>Actions</th>
										</tr>
										<tr ng-repeat="exitsettings in exitSettingsList" ng-class-odd="'odd'" 
											ng-class-even="'even'" style="height: 30px">
											<td>{{exitsettings.reason}}</td>
											<td>{{exitsettings.reasonTypeId}}</td>
											<td><a  data-toggle="modal"
									data-target="#myModal" ng-click="editExitSettings(exitsettings)" tooltip="edit"
												style="cursor: pointer; font-size: 12px"><i
													class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
												tooltip="delete" ng-click="deleteExitSettings(exitsettings.exitSettingsId)"
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































