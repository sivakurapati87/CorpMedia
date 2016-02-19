

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

									<li ng-class="{'active':(state==='job_titles')}"><a
										class="anchor-sm" ui-sref="job_titles">Job Titles</a></li>
									<li ng-class="{'active':(state==='employee_defaults')}"><a
										class="anchor-sm" ui-sref="employee_defaults">Employee
											Defaults</a></li>
									<li ng-class="{'active':(state==='add_employee')}"><a
										class="anchor-sm" ui-sref="add_employee">Add Employee</a></li>
									<li ng-class="{'active':(state==='employee_professional')}"><a
										class="anchor-sm" ui-sref="employee_professional">
											Professional </a></li>
									<li ng-class="{'active':(state==='employee_personal')}"><a
										class="anchor-sm" ui-sref="employee_personal">Personal</a></li>	
									<li ng-class="{'active':(state==='employee_job')}"><a
										class="anchor-sm" ui-sref="employee_job">Job</a></li>			





								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					
					
					
					
						<tr><td colspan="2"><legend>Summary</legend></td></tr>
						<tr height="20px"></tr>
					
					<tr>
						<tr>
						<td><label class="lable16_Regular">Professional Summary </label></td>
						<td><label class="lable16_Regular">Status Message</label></td>
					</tr>

					</tr>
					<tr>
						<td><textarea cols="4" name="description" rows="5" style="width: 58%"
							class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
							 required=""></textarea></td>
						<td><textarea cols="4" name="description" rows="5" style="width: 58%"
							class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
							 required=""></textarea></td>	 
						

					</tr>
					
					<tr>
						<td colspan="2" align="left">


							<button class="btn btn-success" style="width: 100px">Update</button>
							

						</td>
					</tr>
					
				
					
					<tr height="50px"></tr>
					
					
					
					<tr><td colspan="2"><legend>Experience</legend></td></tr>
					<tr height="20px"></tr>
					<tr>
						<td><label class="lable16_Regular">Company Name </label></td>
						<td><label class="lable16_Regular">Job Title</label></td>
					</tr>
					<tr>
						<td><input style="width: 58%"
							class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
							type="text" required=""></td>
						<td><input style="width: 58%"
							class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
							type="text" required=""></td>

					</tr>
					<tr>
						<td><label class="lable16_Regular">Location </label></td>
						<td><label class="lable16_Regular">Time Period</label></td>
					</tr>
					<tr>
						<td><input style="width: 58%"
							class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
							type="text" required=""></td>
						<td><input placeholder="From Date"
				class="input-group-field form-control datepicking ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-required ng-valid-date"
				type="text" required="" date-only="" data-ng-click="ptRegDate=true"
				data-is-open="ptRegDate" data-show-weeks="false"
				data-datepicker-popup="mediumDate"
				data-ng-model="" name="registrationDate3">&nbsp;
				<input  placeholder="To Date"
				class="input-group-field form-control datepicking ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-required ng-valid-date"
				type="text" required="" date-only="" data-ng-click="ptRegDate=true"
				data-is-open="" data-show-weeks="false"
				data-datepicker-popup="mediumDate"
				data-ng-model="" name="registrationDate2"></td>

					</tr>

					<tr>
						<td colspan="2"><label class="lable16_Regular">Description
						</label></td>

					</tr>
					<tr>
						<td colspan="2"><textarea cols="2" name="description" rows="5"
							class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
							 required=""></textarea></td>
						

					</tr>
					
					<tr>
						<td colspan="2" align="left">


							<button class="btn btn-success" style="width: 100px">Add</button>
							<button class="btn btn-cancel" style="width: 100px">Cancel</button>

						</td>
					</tr>
					
					<tr height="50px"></tr>
					
					<tr><td colspan="2"><legend>Education</legend></td></tr>
					
					<tr height="20px"></tr>
					<tr>
						<td><label class="lable16_Regular">Degree </label></td>
						<td><label class="lable16_Regular">Specialization</label></td>
					</tr>
					<tr>
						<td><input style="width: 58%"
							class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
							type="text" required=""></td>
						<td><input style="width: 58%"
							class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
							type="text" required=""></td>

					</tr>
					<tr>
						<td><label class="lable16_Regular">University/College </label></td>
						<td><label class="lable16_Regular">Time Period</label></td>
					</tr>
					<tr>
						<td><input style="width: 58%"
							class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
							type="text" required=""></td>
						<td><input placeholder="From Date"
				class="input-group-field form-control datepicking ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-required ng-valid-date"
				type="text" required="" date-only="" data-ng-click="ptRegDate=true"
				data-is-open="ptRegDate" data-show-weeks="false"
				data-datepicker-popup="mediumDate"
				data-ng-model="" name="registrationDate0">&nbsp;
				<input  placeholder="To Date"
				class="input-group-field form-control datepicking ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-required ng-valid-date"
				type="text" required="" date-only="" data-ng-click="ptRegDate=true"
				data-is-open="" data-show-weeks="false"
				data-datepicker-popup="mediumDate"
				data-ng-model="" name="registrationDate1"></td>

					</tr>

					
					
					<tr>
						<td colspan="2" align="left">


							<button class="btn btn-success" style="width: 100px">Add</button>
							<button class="btn btn-cancel" style="width: 100px">Cancel</button>

						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>



















