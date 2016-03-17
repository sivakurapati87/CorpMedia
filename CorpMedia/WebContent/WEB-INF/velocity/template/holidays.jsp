
<script>
	$(document).ready(function() {
		$("#add_holiday").click(function() {
			$("#fade_out").fadeOut();
			$("#fade_in").fadeIn();
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

									<li ng-class="{'active':(state==='leave_plans')}"><a
										class="anchor-sm" ui-sref="leave_plans">Leave Plans </a></li>
									<li ng-class="{'active':(state==='leave_types')}"><a
										class="anchor-sm" ui-sref="leave_types">Leave Types</a></li>
									<li ng-class="{'active':(state==='notify')}"><a
										class="anchor-sm" ui-sref="notify">Notify</a></li>
									<li ng-class="{'active':(state==='holidays')}"><a
										class="anchor-sm" ui-sref="holidays">Holidays</a></li>



								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table mtable  " border="0"
					style="width: 100%; background-color: white">
					<tr><th><h2>Holidays</h2></th> </tr><tr>
						<td>
							<div id="fade_out">
								
								<p>
									<font size="2">You can specify holidays list here. These
										can be assigned to specific location. The default holidays
										list applies to a location when not explicitly set.</font>
								</p>
								<br> <br>
								<div class="row">
									<div class="col-md-3">
										<button class="btn btn-primary"
											style="background-color: #3697EF" ng-click="isCollapse = !isCollapse">
											<i class="fa fa-plus-circle fa-1x"></i>&nbsp;Add Holiday
										</button>
									</div>
									<div class="col-md-6"></div>
									<div class="col-md-3">
										<div class="upload-file-container">
											<input type="file" name="photo" />
										</div>
									</div>
								</div>
								<!--this is the end of the row-->
								<br>
								<div class="row">
									<div class="col-md-9"></div>
									<div class="col-md-3">
										<button class="btn btn-primary"
											style="background-color: #3697EF" id="add_holiday">
											Delete Selected</button>
									</div>
								</div>

							</div> <!--this is fade in form-->
							<div collapse="isCollapse">
								<p>
									<font size="3">Add Holiday</font>
								</p>
								<hr>
								<br>
								<div class="row">
									<div class="col-md-9">
										<form ng-submit="saveOrUpdateHoliday()">

											<div class="form-group">
												<label for="name">Name</label> <input type="text"
													ng-model="holidayJson.holidayName" class="form-control"
													id="name">
											</div>
											<div class="form-group">
												<label for="description">Description</label>
												<textarea id="description" class="form-control" rows="3"
													ng-model="holidayJson.description"></textarea>
											</div>

											<div class="form-group">
												<label for="date">Date</label>
												<div class="input-group">
													<input type="text" class="form-control"
														ng-model="holidayJson.strHolidayDate"
														datepicker-popup="dd-MMM-yyyy" is-open="Opened"
														ng-click="Opened=true"> <span
														class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="Opened=true;$event.stopPropagation();">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
												</div>
											</div>

											<p>
												<input type="checkbox"
													ng-model="holidayJson.isFloatingHoliday">&nbsp;&nbsp;This
												is a floating holiday
											</p>

											<div class="row">
												<div class="col-md-8"></div>
												<div class="col-md-4">
													<p>
														<button type="submit" class="btn btn-success">
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ADD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
														<button type="button" ng-click="cancel()"
															class="btn btn-default">&nbsp;&nbsp;&nbsp;&nbsp;Cancel&nbsp;&nbsp;&nbsp;&nbsp;</button>
													</p>
												</div>




											</div>



										</form>
									</div>
									<div class="col-md-3"></div>

								</div>
							</div>





						</td>
					</tr>
					<tr>
						<td>
							<div class="gridStyle" ng-grid="gridOptions"></div>
							<div class="selectedItems">{{mySelections}}</div>
						</td>
					</tr>

























				</table>
			</td>
		</tr>
	</table>
</div>















