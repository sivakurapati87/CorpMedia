

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
			<td valign="top"><employee-info-top></employee-info-top>
				<table class="table mtable" border="0"
					style="width: 100%; background-color: white">
					<tr><th class="th"><h2>PROFESSIONAL</h2></th> </tr><tr>


					<tr>
						<td colspan="4" width="100%">
							<form ng-submit="saveOrUpdateEmployeeProfessionalInfo()">
								<table width="100%">
									<tr>
										<td colspan="2"><legend>Summary</legend></td>
									</tr>
<!-- 									<tr height="20px"></tr> -->
<!-- 									<tr> -->
<!-- 										<td colspan="4" align="center"><select -->
<!-- 											ng-change="onChangeEmployeeId()" style="width: 280px" -->
<!-- 											class="form-control ng-pristine ng-valid ng-valid-required ng-touched" -->
<!-- 											required ng-model="employeeProfessionalInfoJson.employeeId" -->
<!-- 											ng-options="emp.employeeId as emp.displayName for emp in  EmployeeJsonList"> -->
<!-- 												<option value="" disabled selected>Select</option> -->
<!-- 										</select></td> -->
<!-- 									</tr> -->

									<tr>
										<td><label class="lable16_Regular">Professional
												Summary </label></td>
										<td><label class="lable16_Regular">Status Message</label></td>
									</tr>


									<tr style="height: 10px"></tr>

									<tr>
										<td><textarea cols="4" name="description" rows="5"
												style="width: 58%"
												ng-model="employeeProfessionalInfoJson.professionalSummery"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												required=""></textarea></td>
										<td><textarea cols="4" name="description" rows="5"
												style="width: 58%"
												ng-model="employeeProfessionalInfoJson.statusMessage"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												required=""></textarea></td>


									</tr>
									<tr style="height: 10px"></tr>
									<tr>
										<td colspan="2" align="left">


											<button class="btn btn-success" style="width: 100px"
												type="submit">Update</button>


										</td>
									</tr>
								</table>
							</form>
						</td>
					</tr>

					<tr height="50px"></tr>



					<tr>
						<td colspan="2"><legend>Experience</legend>
							<div class="row">
								<div class="col-md-2">
									<button type="button" class="btn btn-info"
										ng-click="isExpCollapse = !isExpCollapse">
										<span class="glyphicon glyphicon-plus"></span>Add New
									</button>
								</div>
								<div class="col-md-10"></div>

							</div></td>
					</tr>
					<tr height="20px"></tr>
					<tr>
						<td colspan="4" width="100%">
							<div collapse="isExpCollapse">
								<form ng-submit="saveOrUpdateEmployeeExperienceInfo()">
									<table width="100%">
										<tr>
											<td><label class="lable16_Regular">Company Name
											</label></td>
											<td><label class="lable16_Regular">Job Title</label></td>
										</tr>
										<tr>
											<td><input style="width: 58%"
												ng-model="employeeExperienceInfoJson.companyName"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>
											<td><input style="width: 58%"
												ng-model="employeeExperienceInfoJson.jobTitle"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>

										</tr>
										<tr>
											<td><label class="lable16_Regular">Location </label></td>
											<td><label class="lable16_Regular">Time Period</label></td>
										</tr>
										<tr>
											<td><input style="width: 58%"
												ng-model="employeeExperienceInfoJson.location"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>
											<td><div class="input-group">
													<input type="text" class="form-control"
														ng-model="employeeExperienceInfoJson.strFromDate"
														datepicker-popup="dd-MMM-yyyy" is-open="Opened"
														ng-click="Opened=true"> <span
														class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="Opened=true;$event.stopPropagation();">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
												</div>&nbsp;
												<div class="input-group">
													<input type="text" class="form-control"
														ng-model="employeeExperienceInfoJson.strToDate"
														datepicker-popup="dd-MMM-yyyy" is-open="ExpToOpened"
														ng-click="ExpToOpened=true"> <span
														class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="ExpToOpened=true;$event.stopPropagation();">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
												</div></td>

										</tr>

										<tr>
											<td colspan="2"><label class="lable16_Regular">Description
											</label></td>

										</tr>
										<tr>
											<td colspan="2"><textarea cols="2" name="description"
													rows="5" ng-model="employeeExperienceInfoJson.description"
													class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
													required=""></textarea></td>


										</tr>

										<tr>
											<td colspan="2" align="left">


												<button class="btn btn-success" style="width: 100px"
													type="submit">Add</button>
												<button class="btn btn-cancel" style="width: 100px"
													ng-click="cancelExpInfo()" type="button">Cancel</button>

											</td>
										</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2"><table style="width: 100%" border="0"
								class="table table-bordered">
								<tr>
									<th>Job Title</th>
									<th>Company Name</th>
									<th>Location</th>
									<th>Time Period</th>
									<th>Description</th>
									<th>Actions</th>
								</tr>
								<tr ng-repeat="exp in EmployeeExperienceJsonList"
									ng-class-odd="'odd'" ng-class-even="'even'"
									style="height: 30px">
									<td>{{exp.jobTitle}}</td>
									<td>{{exp.companyName}}</td>
									<td>{{exp.location}}</td>
									<td>{{exp.strFromDate}} &nbsp; to &nbsp;{{exp.strToDate}}</td>
									<td>{{exp.description}}</td>
									<td><a ng-click="editExperienceInfo(exp)" tooltip="edit"
										style="cursor: pointer; font-size: 12px"><i
											class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
										tooltip="delete"
										ng-click="deleteExperienceInfo(exp.employeeExperienceInfoId)"
										style="cursor: pointer; font-size: 12px"><i
											class="fa fa-trash"></i></a></td>
								</tr>
							</table></td>
					</tr>
					<tr height="50px"></tr>


					<tr>
						<td colspan="2"><legend>Education</legend>
							<div class="row">
								<div class="col-md-2">
									<button type="button" class="btn btn-info"
										ng-click="isEduCollapse = !isEduCollapse">
										<span class="glyphicon glyphicon-plus"></span>Add New
									</button>
								</div>
								<div class="col-md-10"></div>

							</div></td>
					</tr>

					<tr height="20px"></tr>
					<tr>
						<td colspan="4" width="100%">
							<div collapse="isEduCollapse">
								<form ng-submit="saveOrUpdateEmployeeEducationalInfo()">
									<table width="100%">
										<tr>
											<td><label class="lable16_Regular">Degree </label></td>
											<td><label class="lable16_Regular">Specialization</label></td>
										</tr>
										<tr>
											<td><input style="width: 58%"
												ng-model="employeeEducationalInfoJson.degree"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>
											<td><input style="width: 58%"
												ng-model="employeeEducationalInfoJson.specialization"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>

										</tr>
										<tr>
											<td><label class="lable16_Regular">University/College
											</label></td>
											<td><label class="lable16_Regular">Time Period</label></td>
										</tr>
										<tr>
											<td><input style="width: 58%"
												ng-model="employeeEducationalInfoJson.university"
												class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
												type="text" required=""></td>
											<td><div class="input-group">
													<input type="text" class="form-control"
														ng-model="employeeEducationalInfoJson.strFromDate"
														datepicker-popup="dd-MMM-yyyy" is-open="EduFromOpened"
														ng-click="EduFromOpened=true"> <span
														class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="EduFromOpened=true;$event.stopPropagation();">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
												</div>&nbsp;
												<div class="input-group">
													<input type="text" class="form-control"
														ng-model="employeeEducationalInfoJson.strToDate"
														datepicker-popup="dd-MMM-yyyy" is-open="EduToOpened"
														ng-click="EduToOpened=true"> <span
														class="input-group-btn">
														<button type="button" class="btn btn-default"
															ng-click="EduToOpened=true;$event.stopPropagation();">
															<i class="glyphicon glyphicon-calendar"></i>
														</button>
													</span>
												</div></td>

										</tr>



										<tr>
											<td colspan="2" align="left">


												<button class="btn btn-success" style="width: 100px"
													type="submit">Add</button>
												<button class="btn btn-cancel" style="width: 100px"
													ng-click="cancelEduInfo()" type="button">Cancel</button>

											</td>
										</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>

					<tr>
						<td colspan="2"><table style="width: 100%" border="0"
								class="table table-bordered">
								<tr>
									<th>Degree</th>
									<th>Specialization</th>
									<th>University/College</th>
									<th>Time Period</th>
									<th>Actions</th>
								</tr>
								<tr ng-repeat="edu in EmployeeEducationalJsonList"
									ng-class-odd="'odd'" ng-class-even="'even'"
									style="height: 30px">
									<td>{{edu.degree}}</td>
									<td>{{edu.specialization}}</td>
									<td>{{edu.university}}</td>
									<td>{{edu.strFromDate}} &nbsp; to &nbsp;{{edu.strToDate}}</td>
									<td><a ng-click="editEducationalInfo(edu)" tooltip="edit"
										style="cursor: pointer; font-size: 12px"><i
											class="fa fa-pencil-square-o"></i></a> &nbsp;&nbsp;<a
										tooltip="delete"
										ng-click="deleteEducationalInfo(edu.employeeEducationalInfoId)"
										style="cursor: pointer; font-size: 12px"><i
											class="fa fa-trash"></i></a></td>
								</tr>
							</table></td>
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