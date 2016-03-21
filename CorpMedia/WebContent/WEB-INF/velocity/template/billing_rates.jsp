
<script>
	$(document).ready(function() {
		$("#btn1").click(function() {
			$("#fade_out").fadeOut();
			$("#fade_in").fadeIn();

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
					<tr><th class="th"><h2>Billing Rates</h2> </th></tr><tr>
						<td>
							<div id="fade_in">
								<!--this is the next part in steps means -->

								<br>
								<br>
								<h3>Create Client</h3>
								
									<br>
									<p>
										<b><font size="3">Welcome to Create Client</font></b>
									</p>
									<p>
										<font size="2">Creating clients is very easy with
											Corpmedia. Just follow the quick and easy step by step
											process to initiate the client import. </font>
									</p>
									<br>
									<br>
									<h3>Billing Rates</h3>
									<form ng-submit="saveBillingRates">
									<section>
									
										<div class="row">
											<div class="col-md-8">
												<div class="form-group">
													<label for="sel1">Billing Currency</label> <select
														class="form-control ng-pristine ng-valid ng-valid-required ng-touched" id="currency"
														ng-model="billingrates.billingCurrencyId"
														ng-options="bank.lookupDetailId as bank.description for bank in  lookup.currencyList">
														<option value="" disabled selected>Currency</option>
														</select>

													 <br> <br>
													<!--our table for billing-->
													<div class="panel panel-default">
														<div class="panel-body">
															<table class="table">

																<tr>
																	<th>BILLING ROLE</th>
																	<th>HOURLY RATE</th>
																	<th>WEEKLY RATE</th>
																	<th>MONTHLY RATE</th>
																</tr>

																<tr id="table_row">
																	<td><input type="text" style="width: 100px" ng-model="billingrates.billingRole"></td>
																	<td><input type="text" style="width: 50px" ng-model="billingrates.hourlyRate"></td>
																	<td><input type="text" style="width: 50px" ng-model="billingrates.weeklyRate"></td>
																	<td><input type="text" style="width: 50px" ng-model="billingrates.monthlyRate"></td>
																</tr>

															</table>
														</div>

													</div>

												</div>
											</div>

											<!--this remains empty-->
											<div class="col-md-4"></div>

										</div>

										<div class="row">

											<!--this remains empty-->
											<div class="col-md-8"></div>

											<div class="col-md-4">
												<p>
													<button type="button" class="btn btn-default">SKIP</button>
													<button type="submit" class="btn btn-success">SAVE</button>
												</p>
											</div>


										</div>

                                      
									</section>
									</form>
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



















