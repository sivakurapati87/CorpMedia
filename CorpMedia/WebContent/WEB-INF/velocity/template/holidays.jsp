
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
									<li ng-class="{'active':(state==='holidays')}"><a
										class="anchor-sm" ui-sref="holidays">Holidays</a></li>



								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>
							<div id="fade_out">
								<p>
									<font size="3"><b>Holidays</b></font>
								</p>
								<p>
									<font size="2">You can specify holidays list here. These
										can be assigned to specific location. The default holidays
										list applies to a location when not explicitly set.</font>
								</p>
								<br>
								<br>
								<div class="row">
									<div class="col-md-3">
										<button class="btn btn-primary"
											style="background-color: #3697EF" id="add_holiday">
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
							<div id="fade_in" style="display: none">
								<p>
									<font size="3">Add Holiday</font>
								</p>
								<hr>
								<br>
								<div class="row">
									<div class="col-md-9">
										<form class="form">

											<div class="form-group">
												<label for="name">Name</label> <input type="text"
													class="form-control" id="name">
											</div>
											<div class="form-group">
												<label for="description">Description</label>
												<textarea id="description" class="form-control" rows="3"></textarea>
											</div>

											<div class="form-group">
												<label for="date">Date</label> <input type="date" id="date">
											</div>

											<p>
												<input type="checkbox">&nbsp;&nbsp;This is a
												floating holiday
											</p>

											<div class="row">
												<div class="col-md-8"></div>
												<div class="col-md-4">
													<p>
														<button type="submit" class="btn btn-success">
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ADD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
														<button type="submit" class="btn btn-default">&nbsp;&nbsp;&nbsp;&nbsp;Cancel&nbsp;&nbsp;&nbsp;&nbsp;</button>
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


























				</table>
			</td>
		</tr>
	</table>
</div>















