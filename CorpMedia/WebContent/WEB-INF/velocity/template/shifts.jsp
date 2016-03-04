


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

																	<!-- ----------------------------------------------------------------------- -->



																	<div
																		class="col-sm-9 tab-pane active clear-side-padding">
																		<form ng-submit="saveShift()">
																			<div
																				class="form-group col-lg-12 col-md-12 col-sm-12 clear-side-padding">
																				<label class="col-sm-4 col-md-3 control-label">Name</label>
																				<div class="col-sm-5">
																					<input type="text" class="form-control "
																						placeholder="Ex: Regular Shift"
																						ng-model="shifts.shiftName" required="">

																				</div>
																			</div>
																			<div
																				class="form-group col-lg-12 col-md-12 col-sm-12 clear-side-padding">
																				<label
																					class="col-sm-4 col-md-3 control-label shift-time">Start
																					Time</label>

																				<div class="col-sm-8 col-md-9">
																					<table border="0">
																						<tbody>

																							<tr>
																								<td class="form-group"><input
																									style="width: 50px;" type="text"
																									class="form-control text-center "
																									ng-model="shifts.startTimeHrs" maxlength="2">
																								</td>
																								<td>:</td>
																								<td class="form-group"><input
																									style="width: 50px;" type="text"
																									class="form-control text-center "
																									ng-model="shifts.startTimeMns" maxlength="2">
																								</td>
																								<td><button type="button"
																										class="btn btn-default text-center ng-binding"
																										ng-click="changeStartTimeMeridian()">{{StartTimeMaridian}}</button></td>
																							</tr>

																						</tbody>
																					</table>
																				</div>
																			</div>
																			<div
																				class="form-group col-lg-12 col-md-12 col-sm-12 clear-side-padding">
																				<label
																					class="col-sm-4 col-md-3 control-label shift-time">End
																					Time</label>
																				<div class="col-sm-8 col-md-9">
																					<table border="0">
																						<tbody>

																							<tr>
																								<td class="form-group"><input
																									style="width: 50px;" type="text"
																									class="form-control text-center "
																									ng-model="shifts.toTimeHrs" maxlength="2">
																								</td>
																								<td>:</td>
																								<td class="form-group"><input
																									style="width: 50px;" type="text"
																									class="form-control text-center "
																									ng-model="shifts.toTimeMns" maxlength="2">
																								</td>
																								<td><button type="button"
																										class="btn btn-default text-center ng-binding"
																										ng-click="changeEndTimeMeridian()">{{EndTimeMaridian}}</button></td>
																							</tr>

																						</tbody>
																					</table>
																				</div>
																			</div>
																			<div
																				class="form-group col-lg-12 col-md-12 col-sm-12 clear-side-padding">
																				<label class="col-sm-4 col-md-3 control-label ">Break
																					Duration (minutes)</label>
																				<div class="col-sm-5">
																					<input type="text" class="form-control "
																						ng-model="shifts.breakDuratation"
																						placeholder="Break Duration" required=""
																						pattern="[0-9]{1,4}"
																						title="Duration must be number of  Minutes(Integer vlue) ">

																				</div>
																			</div>

																			<div class="form-group">
																				<div
																					class="col-lg-9 col-md-9 col-sm-8 col-sm-offset-4 col-md-offset-3">
																					<input type="submit"
																						class="btn btn-submit ng-scope" value="Create">

																					<input type="button"
																						class="btn btn-default btn-cancel" value="Cancel">
																				</div>
																			</div>
																		</form>
																	</div>

																	<!-- ----------------------------------------------------------------------- -->
																</div>

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


















