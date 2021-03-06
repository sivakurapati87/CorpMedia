


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
			<td valign="top"><payroll-info-top></payroll-info-top>
				<table class="table mtable  " border="0"
					style="width: 100%; background-color: white">
					<tr>
						<th class="th">
							<h2>Salary components</h2> <a ui-sref="Salary_component">click
								here </a>
						</th>
					</tr>
					<tr>
						<td>



							<div class="cont">


								<p class="dis_block">
									<font size="2"><b>In this section,you can set up and
											define properties for salary components.</b></font>
								</p>




								<p class="dis_block">
									<font size="3">Basic components</font>
								</p>
								<p>
									<font size="2">Basic, HRA & PF are auto calculated based
										on the individual salary structure to optimize tax savings.
										Special allowance is used as a bucket for allocating the
										balance of salary left after allocating all the other
										allowances and components. You can edit the name of Special
										Allowance to suit your needs. </font>
								</p>


							</div>
							<div class="cont">
								<div class="col-md-2 " style="background-color: #dedede;">
									<p></p>
									<p>Basic</p>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2" style="background-color: #ccc;">
									<p></p>
									<p>HRA</p>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2" style="background-color: #ccc;">
									<p></p>
									<p>PF Employee</p>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2" style="background-color: #ccc;">
									<p></p>
									<p>Special allowance</p>
								</div>


							</div>


							<div class="cont">

								<p class="dis_block">
									<font size="3">Recurring Salary Heads</font>
								</p>
								<p class="dis_block">
									<font size="2">Allowances are the salary components
										within an Employee Gross Salary. All Statutory tax-exempt
										allowances are already provided and for most part you do not
										have to make any changes here. Salary components such as
										Basic, HRA etc are auto calculated by the system optimized for
										each employee.</font>
								</p>

							</div>


							<div class="cont">
								<div style="background: #fff; padding: 10px;">

									<h4>STANDARD ALLOWANCES</h4>


									<!--this is first box for medical allowance-->
									<div class="abc">
										<label>Medical reimbursement</label> <span class="dis_block">Tax
											Free,Max limit: Rs.{{medicalreimbursement.maxAnnualLimit}} <a
											href="" data-toggle="modal"
											data-target="#medicalmodelpopupid "><i
												class="fa fa-cog lrspace_10"></i> </a> </sapn>
									</div>



									<!--bootstrap modal for the first box-->
									<div class="modal fade" id="medicalmodelpopupid" role="dialog">
										<div class="modal-dialog">
											<form ng-submit="saveMedicalReimbursement()">
												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">Edit medical reimbursement</h4>
													</div>
													<div class="modal-body">
														<div class="form-group">

															<p class="form-controll">
																Maximum annual limit Rs.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
																	type="number"
																	ng-model="medicalreimbursement.maxAnnualLimit">
															</p>
															<br> <label for="medical_sel2">Require
																submission of bills to claim this allowance:</label> <select
																class="form-control" id="medical_sel2"
																ng-model="medicalreimbursement.requireSubmissionId"
																ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
																<option value="" disabled selected>Select</option>


															</select>
														</div>
													</div>
													<div class="modal-footer">
														<p>
															<button type="submit" class="btn btn-primary">Save</button>
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Close</button>
														</p>
													</div>
												</div>
											</form>

										</div>
									</div>






									<!--this is second box for transport allowance-->
									<p></p>
									<div class="abc">

										<label>Transport allowance</label> <span class="dis_block">Tax
											Free, Max Limit : Rs.{{transportallowance.maxAnnualLimit}} <a
											href="" data-toggle="modal"
											data-target="#transportmodelpopupid"><i
												class="fa fa-cog lrspace_10"></i></a>
										</span>

									</div>



									<!--bootstrap modal for the second box-->
									<div class="modal fade" id="transportmodelpopupid"
										role="dialog">
										<div class="modal-dialog">
											<form ng-submit="saveTransportAllowance()">
												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">Edit transport allowance</h4>
													</div>
													<div class="modal-body">
														<div class="form-group">


															<p class="form-controll">
																Maximum annual limit Rs.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
																	type="number"
																	ng-model="transportallowance.maxAnnualLimit">
															</p>
															<br> <label for="medical_sel2">Require
																submission of bills to claim this allowance:</label> <select
																class="form-control" id="medical_sel2"
																ng-model="transportallowance.requireSubmissionId"
																ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
																<option value="" disabled selected>Select</option>

															</select>
														</div>
													</div>
													<div class="modal-footer">
														<p>
															<button type="submit" class="btn btn-primary">Save</button>
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Close</button>
														</p>
													</div>
												</div>
											</form>

										</div>
									</div>





									<!--this is third box for professional allowance-->
									<p></p>
									<div class="abc">
										<label>Professional allowance</label> <span class="dis_block">Tax
											Free, Max Limit: Rs.{{professionalallowance.maxAnnualLimit}}
											<a href="" data-toggle="modal"
											data-target="#professionalmodelpopupid"> <i
												class="fa fa-cog lrspace_10"></i></a>
										</span>
									</div>


									<!--bootstrap modal for the third box-->
									<div class="modal fade" id="professionalmodelpopupid"
										role="dialog">
										<div class="modal-dialog">
											<form ng-submit="saveProfessionalAllowance()">
												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">Edit professional allowance</h4>
													</div>
													<div class="modal-body">
														<div class="form-group">
															<p class="form-controll">
																Maximum annual limit Rs.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
																	type="number"
																	ng-model="professionalallowance.maxAnnualLimit">
															</p>
															<br> <label for="medical_sel2">Require
																submission of bills to claim this allowance:</label> <select
																class="form-control" id="medical_sel2"
																ng-model="professionalallowance.requireSubmissionId"
																ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
																<option value="" disabled selected>Select</option>

															</select>
														</div>
													</div>
													<div class="modal-footer">
														<p>
															<button type="submit" class="btn btn-primary">Save</button>
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Close</button>
														</p>
													</div>
												</div>
											</form>

										</div>
									</div>


									<!--this is fourth box for travel reimbursement-->
									<p></p>
									<div class="abc">
										<label>Travel reimbursement</label> <span class="dis_block">Tax
											Free, Max Limit: Rs.{{travelreimbursement.maxAnnualLimit}} <a
											href="" data-toggle="modal" data-target="#travelmodelpopupid">
												<i class="fa fa-cog lrspace_10 "></i>
										</a>
										</span>
									</div>



									<!--bootstrap modal for the fourth box-->
									<div class="modal fade" id="travelmodelpopupid" role="dialog">
										<div class="modal-dialog">
											<form ng-submit="saveTravelReimbursement()">
												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">Edit Travel Reimbursement</h4>
													</div>
													<div class="modal-body">
														<div class="form-group">
															<p class="form-controll">
																Maximum annual limit Rs.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
																	type="number"
																	ng-model="travelreimbursement.maxAnnualLimit">
															</p>
															<br> <label for="medical_sel2">Require
																submission of bills to claim this allowance:</label> <select
																class="form-control" id="medical_sel2"
																ng-model="travelreimbursement.requireSubmissionId"
																ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
																<option value="" disabled selected>Select</option>

															</select>
														</div>
													</div>
													<div class="modal-footer">
														<p>
															<button type="submit" class="btn btn-primary">Save</button>
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Close</button>
														</p>
													</div>
												</div>
											</form>

										</div>
									</div>



									<!--this is fifth box for food allowance-->
									<p></p>
									<div class="abc">
										<label>Food coupons</label> <span class="dis_block">Tax
											Free, Max Limit: Rs.{{foodcoupons.maxAnnualLimit}} <a href=""
											data-toggle="modal" data-target="#foodmodelpopupid"> <i
												class="fa fa-cog lrspace_10"></i></a>
										</span>
									</div>



									<!--bootstrap modal for the fifth box-->
									<div class="modal fade" id="foodmodelpopupid" role="dialog">
										<div class="modal-dialog">
											<form ng-submit="saveFoodCoupons()">
												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">Edit Food Coupons</h4>
													</div>
													<div class="modal-body">
														<div class="form-group">
															<p class="form-controll">
																Maximum annual limit Rs.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
																	type="number" ng-model="foodcoupons.maxAnnualLimit">
															</p>
															<br> <label for="medical_sel2">Require
																submission of bills to claim this allowance:</label> <select
																class="form-control" id="medical_sel2"
																ng-model="foodcoupons.requireSubmissionId"
																ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
																<option value="" disabled selected>Select</option>

															</select>
														</div>
													</div>
													<div class="modal-footer">
														<p>
															<button type="submit" class="btn btn-primary">Save</button>
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Close</button>
														</p>
													</div>
												</div>
											</form>

										</div>
									</div>


									<!--this is sixth box for compensatory allowance-->
									<p></p>
									<div class="abc">

										<label>City compensatory allowance</label> <span
											class="dis_block"> Tax Free, Max Limit:
											Rs.{{citycompensatoryallowance.maxAnnualLimit}} <a href=""
											data-toggle="modal" data-target="#citymodelpopupid"> <i
												class="fa fa-cog lrspace_10"></i></a>
										</span>
									</div>




									<!--bootstrap modal for the sixth box-->
									<div class="modal fade" id="citymodelpopupid" role="dialog">
										<div class="modal-dialog">
											<form ng-submit="saveCityCompensatoryAllowance()">
												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">Edit City Compensatory
															Allowance</h4>
													</div>
													<div class="modal-body">
														<div class="form-group">
															<p class="form-controll">
																Maximum annual limit Rs.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
																	type="number"
																	ng-model="citycompensatoryallowance.maxAnnualLimit">
															</p>
															<br> <label for="medical_sel2">Require
																submission of bills to claim this allowance:</label> <select
																class="form-control" id="medical_sel2"
																ng-model="citycompensatoryallowance.requireSubmissionId"
																ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
																<option value="" disabled selected>Select</option>

															</select>
														</div>
													</div>
													<div class="modal-footer">
														<p>
															<button type="submit" class="btn btn-primary">Save</button>
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Close</button>
														</p>
													</div>
												</div>
											</form>

										</div>
									</div>

									<!--this is seventh box for daily allowance-->
									<p></p>
									<div class="abc">

										<label>Daily allowance</label> <span class="dis_block">
											Tax Free, Max Limit: Rs.{{dailyallowance.maxAnnualLimit}} <a
											href="" data-toggle="modal" data-target="#dailymodelpopupid">
												<i class="fa fa-cog lrspace_10"></i>
										</a>
										</span>
									</div>



									<!--bootstrap modal for the seventh box-->
									<div class="modal fade" id="dailymodelpopupid" role="dialog">
										<div class="modal-dialog">
											<form ng-submit="saveDailyAllowance()">
												<!-- Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">Edit Daily Allowance</h4>
													</div>
													<div class="modal-body">
														<div class="form-group">
															<p class="form-controll">
																Maximum annual limit Rs.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
																	type="number" ng-model="dailyallowance.maxAnnualLimit">
															</p>
															<br> <label for="medical_sel2">Require
																submission of bills to claim this allowance:</label> <select
																class="form-control" id="medical_sel2"
																ng-model="dailyallowance.requireSubmissionId"
																ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
																<option value="" disabled selected>Select</option>

															</select>
														</div>
													</div>
													<div class="modal-footer">
														<p>
															<button type="submit" class="btn btn-primary">Save</button>
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Close</button>
														</p>
													</div>
												</div>
											</form>

										</div>
									</div>




									<p></p>

									<!--first part of the row-->
								</div>

								<!--left blank since we want to make some space-->
								<div class="col-md-2"></div>


								<!--this is the second half of the row(right hand side part)-->
								<div class="">

									<p></p>
									<p>
										<b><font size="3">CUSTOM ALLOWANCES</font></b>
									</p>
									<div class="" style="background-color: #fffff">
										<br>
										<!--making it a link since we need to trigger bootstrap modal-->
										<a href="" data-toggle="modal"
											data-target="#custommodelpopupid">
											<p style="align-self: center">
												<font size="3">
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<i class="fa fa-plus"></i>&nbsp;Add custom allowances
												</font>
											</p>
										</a>
										<table style="width: 40%" border="0"
											class="table table-bordered">
											<tr>
												<th>Name</th>
												<th>Actions</th>
											</tr>
											<tr ng-repeat="customallowance in customAllowanceList"
												ng-class-odd="'odd'" ng-class-even="'even'"
												style="height: 30px">
												<td>{{customallowance.Name}}</td>
												<td><a ng-click="editCustomAllowance(customallowance)"
													tooltip="edit" style="cursor: pointer; font-size: 12px"><i
														class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
													tooltip="delete"
													ng-click="deleteCustomAllowance(customallowance.customAllowanceId)"
													style="cursor: pointer; font-size: 12px"><i
														class="fa fa-trash"></i></a></td>
											</tr>
										</table>


									</div>
								</div>
							</div> <!--bootstrap modal for adding custom allowances--> <!-- Modal -->
							<div class="modal fade" id="custommodelpopupid" role="dialog">
								<div class="modal-dialog">
									<form ng-submit="saveCustomAllowance()" class="form-horizontal"
										role="form">
										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Add Custom Component</h4>
											</div>
											<div class="modal-body">
												<div class="row">

													<div class="form-group">
														<label class="control-label col-sm-4" for="name">Name</label>
														<div class="col-sm-6">
															<input type="text" class="form-control" id="name"
																ng-model="customallowance.Name" placeholder="Enter name" />
														</div>
													</div>

													<div class="form-group">
														<label class="control-label col-sm-4" for="name">Maximum
															annual limit</label>
														<div class="col-sm-6">
															<input type="number"
																ng-model="customallowance.maxAnnualLimit" />
														</div>
													</div>

													<div class="form-group">
														<label class="control-label col-sm-4" for="benefit">Has
															tax benefits</label>
														<div class="col-sm-6">
															<select class="form-control" id="sel1"
																ng-model="customallowance.taxBenefitId"
																ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
																<option value="" disabled selected>Select</option>
															</select>
														</div>
													</div>


													<div class="form-group">
														<label class="control-label col-sm-4" for="bill">Requires
															submit of bill</label>
														<div class="col-sm-6">
															<select class="form-control" id="bill"
																ng-model="customallowance.submitBillId"
																ng-options="bank.lookupDetailId as bank.description for bank in  lookup.trueorfalseList">
																<option value="" disabled selected>Select</option>
															</select>
														</div>
													</div>


												</div>
											</div>


											<div class="modal-footer">
												<p>
													<button type="submit" class="btn btn-primary">Save</button>
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</p>
											</div>
										</div>
									</form>

								</div>
							</div>





							<div class="cont" style="margin-top: 50px;">

								<label>CONTRIBUTIONS</label>
								<div class="abc">

									<label>Employee Gratuity contribution</label> <span
										class="dis_block"> Gratuity :
										Rs.{{gratuitycontribution.maxAnnualLimit}} <a href=""
										data-toggle="modal" data-target="#myModal_gratuity"><i
											class="fa fa-cog lrspace_10"></i></a>
									</span>
								</div>

							</div> <!--bootstrap modal for the gratuity box-->
							<div class="modal fade" id="myModal_gratuity" role="dialog">
								<div class="modal-dialog">
									<form ng-submit="saveGratuityContribution()">
										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Edit Employee Gratuity
													contribution</h4>
											</div>
											<div class="modal-body">
												<div class="form-group">
													<p class="form-controll">
														Maximum annual limit Rs.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
															type="number"
															ng-model="gratuitycontribution.maxAnnualLimit">
													</p>
													<br>


												</div>
											</div>
											<div class="modal-footer">
												<p>
													<button type="submit" class="btn btn-primary">Save</button>
													<button type="button" class="btn btn-default"
														data-dismiss="modal">Close</button>
												</p>
											</div>
										</div>
									</form>

								</div>
							</div> <br> <br>





						</td>
					</tr>
























					<tr>
						<td class="bth"><h2></h2></td>
					</tr>

				</table></td>
		</tr>
	</table>
</div>
<div class="main1" ng-show="isProcessing">
	<div class="div1">

		<i class="fa fa-spinner fa-spin " style="font-size: 60px"></i>
	</div>
</div>
















