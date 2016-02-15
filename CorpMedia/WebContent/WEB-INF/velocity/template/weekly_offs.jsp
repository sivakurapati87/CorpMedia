<script>
	$(document).ready(function() {
		// $(replacedwith).hide();
		$("#btn2").click(function() {
			// this is the culprit if your program breaks.

			$(replacable).fadeOut("slow");
			$(table).fadeIn("slow");
			// $(noexpense).remove();
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

									<li ng-class="{'active':(state==='weekly_offs')}"><a
										class="anchor-sm" ui-sref="weekly_offs">Weekly Offs</a></li>
									<li ng-class="{'active':(state==='shifts')}"><a
										class="anchor-sm" ui-sref="shifts">Shifts</a></li>
                                    <li ng-class="{'active':(state==='timing_policies')}"><a
										class="anchor-sm" ui-sref="timing_policies">Timing Policies</a></li>
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


							<div class="panel-body">

								<div
									class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
									<div class="col-lg-12">
										<div id="replacable">
											<h4 class="page-heading"
												data-ng-class="{'clear-top-margin': vm.id }">Edit
												Weekly off</h4>
											<p class="page-description ng-scope" data-ng-if="!vm.id">You
												can specify weekly off schedules here. These can be assigned
												to individual employees. The default weekly off plan gets
												applied to all employees when not explicitly set.</p>
											<br>
											<button id="btn2" class="btn btn-info">
												<span class="glyphicon glyphicon-plus"></span>AddNew
											</button>
										</div>
										<!-- This is end of replacable -->
										<div id="table" style="display: none">
											<!-- this is place for placing week off days. -->
											<table class="table">
												<th></th>
												<th></th>
												<th></th>
												<tr>
													<td><p>
															<b>Name</b>
														</p></td>
													<td><input type="text" placeholder="day's off"></td>
													<td><input type="button" value="Current Version" /></td>
												<tr>
													<td><p>
															<b>Off Days</b>
														</p></td>
													<td>
														<table class="table">
															<tr>
																<th></th>
																<th></th>
															</tr>
															<tr>


																<td>
																	<form role="form">
																		<div class="checkbox">
																			<label><input type="checkbox" value="">Sunday</label>

																		</div>
																	</form>
																</td>
																<td>
																	<form role="form">
																		<div class="form-group">
																			<select class="form-control" id="sel1">
																				<option>All</option>
																				<option>Ist</option>
																				<option>2nd</option>
																				<option>3rd</option>
																				<option>4th</option>
																				<option>5th</option>
																				<option>Odd(1,3,5)</option>
																				<option>Even(2,4,6)</option>
																			</select>
																		</div>
																	</form>
																</td>
															</tr>
															<tr>
																<td>
																	<form role="form">
																		<div class="checkbox">
																			<label><input type="checkbox" value="">Monday</label>
																		</div>
																	</form>
																</td>
																<td>
																	<form role="form">
																		<div class="form-group">
																			<select class="form-control" id="sel1">
																				<option>All</option>
																				<option>Ist</option>
																				<option>2nd</option>
																				<option>3rd</option>
																				<option>4th</option>
																				<option>5th</option>
																				<option>Odd(1,3,5)</option>
																				<option>Even(2,4,6)</option>
																			</select>
																		</div>
																	</form>
																</td>
															</tr>
															<tr>
																<td>
																	<form role="form">
																		<div class="checkbox">
																			<label><input type="checkbox" value="">Tuesday</label>
																		</div>
																	</form>
																</td>
																<td>
																	<form role="form">
																		<div class="form-group">
																			<select class="form-control" id="sel1">
																				<option>All</option>
																				<option>Ist</option>
																				<option>2nd</option>
																				<option>3rd</option>
																				<option>4th</option>
																				<option>5th</option>
																				<option>Odd(1,3,5)</option>
																				<option>Even(2,4,6)</option>
																			</select>
																		</div>
																	</form>
																</td>
															</tr>
															<tr>
																<td>
																	<form role="form">
																		<div class="checkbox">
																			<label><input type="checkbox" value="">Wednesday</label>
																		</div>
																	</form>
																</td>
																<td>
																	<form role="form">
																		<div class="form-group">
																			<select class="form-control" id="sel1">
																				<option>All</option>
																				<option>Ist</option>
																				<option>2nd</option>
																				<option>3rd</option>
																				<option>4th</option>
																				<option>5th</option>
																				<option>Odd(1,3,5)</option>
																				<option>Even(2,4,6)</option>
																			</select>
																		</div>
																	</form>
																</td>
															</tr>
															<tr>
																<td>
																	<form role="form">
																		<div class="checkbox">
																			<label><input type="checkbox" value="">Thursday</label>
																		</div>
																	</form>
																</td>
																<td>
																	<form role="form">
																		<div class="form-group">
																			<select class="form-control" id="sel1">
																				<option>All</option>
																				<option>Ist</option>
																				<option>2nd</option>
																				<option>3rd</option>
																				<option>4th</option>
																				<option>5th</option>
																				<option>Odd(1,3,5)</option>
																				<option>Even(2,4,6)</option>
																			</select>
																		</div>
																	</form>
																</td>
															</tr>
															<tr>
																<td>
																	<form role="form">
																		<div class="checkbox">
																			<label><input type="checkbox" value="">Friday</label>
																		</div>
																	</form>
																</td>
																<td>
																	<form role="form">
																		<div class="form-group">
																			<select class="form-control" id="sel1">
																				<option>All</option>
																				<option>Ist</option>
																				<option>2nd</option>
																				<option>3rd</option>
																				<option>4th</option>
																				<option>5th</option>
																				<option>Odd(1,3,5)</option>
																				<option>Even(2,4,6)</option>
																			</select>
																		</div>
																	</form>
																</td>
															</tr>
															<tr>
																<td>
																	<form role="form">
																		<div class="checkbox">
																			<label><input type="checkbox" value="">Saturday</label>
																		</div>
																	</form>
																</td>
																<td>
																	<form role="form">
																		<div class="form-group">
																			<select class="form-control" id="sel1">
																				<option>All</option>
																				<option>Ist</option>
																				<option>2nd</option>
																				<option>3rd</option>
																				<option>4th</option>
																				<option>5th</option>
																				<option>Odd(1,3,5)</option>
																				<option>Even(2,4,6)</option>
																			</select>
																		</div>
																	</form>
																</td>

															</tr>
															</td>

															</div>
															</form>
															</td>
															</tr>

														</table>
													</td>
													<td></td>
												<tr>
													<td>
														<p>
															<b> effective from </b>
														</p>
													</td>
													<td><input type="date" id="myDate" value="2014-02-09"
														button onclick="myFunction()"> <script>
															function myFunction() {
																var x = document
																		.getElementById("myDate").value;
																document
																		.getElementById("demo").innerHTML = x;
															}
														</script></td>
													<td></td>
												</tr>
											</table>

											<div
												class="col-lg-7 col-md-7 col-sm-9 col-sm-offset-4 col-md-offset-3 clear-side-padding">
												<!-- ngIf: !model.weekOff.id -->
												<!-- ngIf: model.weekOff.id -->
												<input type="button" class="btn btn-submit ng-scope"
													ng-if="model.weekOff.id" value="Update"
													data-ng-click="saveWeekOffs();vm.submitted=true;">
												<!-- end ngIf: model.weekOff.id -->
												<input type="button" class="btn btn-cancel" value="Cancel"
													data-ng-click="cancel();">
											</div>

										</div>
										<!-- This is packing table -->
									</div>
									<!-- This is enclosing tables. -->
								</div>
							</div>



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>

































