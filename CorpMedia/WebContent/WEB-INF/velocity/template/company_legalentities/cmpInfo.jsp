<div class="container-fluid" style="width: 100%;">

	<table class="table" border="0" width="100%" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><label><h3>Company Registration</h3></label></td>
		</tr>
		<tr>
			<td><label class="lable16_Regular"> Legal Name of the
					Company </label></td>
			<td><label class="lable16_Regular">Type of Business</label></td>
		</tr>
		<tr>
			<td><input id="panNumber" style="width: 58%"
				class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
				type="text" required="" data-ng-model="model.panNumber"
				name="panNumber"></td>

			<td><select id="formSignatory" style="width: 58%"
				class="form-control ng-pristine ng-valid ng-valid-required ng-touched"
				required="" data-ng-model="model.form16SignatoryId"
				name="formSignatory"
				data-ng-options="s.employeeId as s.name for s in vm.authorizedSignatories">
					<option class="" value="" selected="selected">Select Type</option>

			</select></td>

		</tr>
		<tr>
			<td width="50%"><label class="lable16_Regular">Date of
					Incorporation </label></td>
			<td><label class="lable16_Regular">Registration office
					Address</label></td>
		</tr>
		<tr>
			<td><input style="width: 58%"
				class="input-group-field form-control datepicking ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-required ng-valid-date"
				type="text" required="" date-only="" data-ng-click="ptRegDate=true"
				data-is-open="ptRegDate" data-show-weeks="false"
				data-datepicker-popup="mediumDate"
				data-ng-model="ptInfo.registrationDate" name="registrationDate0"></td>
			<td><table>

					<tr>
						<td colspan="3"><input type="email" class="form-control"
							id="exampleInputEmail1" placeholder="Address Line 1"></td>
					</tr>
					<tr height="5px"></tr>
					<tr>
						<td colspan="3"><input type="email" class="form-control"
							id="exampleInputEmail1" placeholder="Address Line 2"></td>
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
			<td colspan="2"><label class="lable16_Regular">Company
					Identification Number </label></td>
		</tr>
		<tr>
			<td colspan="2"><input id="panNumber" style="width: 29%"
				class="form-control ng-pristine ng-untouched ng-valid ng-valid-required"
				type="text" required="" data-ng-model="model.panNumber"
				name="panNumber"></td>
		</tr>
		<tr>
			<td colspan="3" align="right">
				<div class="col-sm-12 vertical-margin">
					<div
						class="col-sm-6 text-right pull-right vertical-margin clear-right-padding">
						<button class="btn btn-success">Save</button>
						<button class="btn btn-cancel">Clear</button>
					</div>
				</div>
			</td>
		</tr>
	</table>




	<table class="table" border="0" width="100%">
		<tr>
			<td ng-repeat="cInfo in companyInfo">
				<table border="0" width="100%"
					class="table table-hover table table-bordered">
					<tr style="height: 10px"></tr>
					<tr>
						<td class="lable16_Regular">CIN:</td>
						<td class="lable14">{{cInfo.cin}}</td>
						<td class="lable16_Regular">Registration Number:</td>
						<td class="lable16_numbers">{{cInfo.registrationNumber}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">Registered with ROC:</td>
						<td class="lable14">{{cInfo.strIsRegisteredWithRoc}}</td>
						<td class="lable16_Regular">PSU:</td>
						<td class="lable14">{{cInfo.strIsPSU}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">Public Or Private:</td>
						<td class="lable14">{{cInfo.companyType}}</td>
						<td class="lable16_Regular">Date of Incorporation:</td>
						<td class="lable14">{{cInfo.strD_o_incorporation}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">Address 1:</td>
						<td class="lable14">{{cInfo.address1}}</td>
						<td class="lable16_Regular">Address 2:</td>
						<td class="lable14">{{cInfo.address2}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">City:</td>
						<td class="lable14">{{cInfo.city}}</td>
						<td class="lable16_Regular">State:</td>
						<td class="lable14">{{cInfo.state}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">Country:</td>
						<td class="lable14">{{cInfo.country}}</td>
						<td class="lable16_Regular">PIN:</td>
						<td class="lable16_numbers">{{cInfo.pincode}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">Email:</td>
						<td class="lable14">{{cInfo.email}}</td>
						<td class="lable16_Regular">Is Listed Or Not:</td>
						<td class="lable14">{{cInfo.strIsListed}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">Date of Last AGM:</td>
						<td class="lable14">{{cInfo.dateOfLastAGM}}</td>
						<td class="lable16_Regular">Date of Balance Sheet:</td>
						<td class="lable14">{{cInfo.dateOfBalanceSheet}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">Board Number:</td>
						<td class="lable14">{{cInfo.boardNumber}}</td>
						<td class="lable16_Regular">Fax Number:</td>
						<td class="lable16_numbers">{{cInfo.faxNumber}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">Website:</td>
						<td class="lable14">{{cInfo.website}}</td>
						<td class="lable16_Regular">Twitter:</td>
						<td class="lable14">{{cInfo.twitterLink}}</td>
					</tr>
					<tr style="height: 5px"></tr>
					<tr>
						<td class="lable16_Regular">Facebook:</td>
						<td class="lable14">{{cInfo.facebookLink}}</td>
						<td class="lable16_Regular">Naukri:</td>
						<td class="lable14">{{cInfo.naukri}}</td>
					</tr>

					<tr height="30px"></tr>
					<tr>
						<td class="lable50_blue" colspan="5"><span
							class="glyphicon glyphicon-user"></span> COMPANY SIGNATORIES</td>
					</tr>
					<tr height="40px"></tr>


					<tr ng-repeat="signator in cInfo.companySignatorJsonsList">
						<td colspan="4" width="100%">
							<table border="0" class="table table-striped" style="width: 60%">
								<tr class="info">
									<td class="lable18_Medium " colspan="3">{{signator.signatorName}}</td>
								</tr>
								<tr style="height: 5px"></tr>
								<tr class="success">
									<td class="lable16_Regular">Din Number:</td>
									<td class="lable16_numbers">{{signator.dinNumber}}</td>
								</tr>
								<tr style="height: 5px"></tr>
								<tr class="info">
									<td class="lable16_Regular">Designation:</td>
									<td class="lable14">{{signator.designation}}</td>

								</tr>
								<tr style="height: 5px"></tr>
								<tr class="success">
									<td class="lable16_Regular">Managing Director:</td>
									<td class="lable14">{{signator.isManagingDirector}}</td>

								</tr>
								<tr style="height: 5px"></tr>
								<tr class="info">
									<td class="lable16_Regular">Secratery:</td>
									<td class="lable14">{{signator.isSecretory}}</td>

								</tr>
								<tr style="height: 5px"></tr>
								<tr class="success">
									<td class="lable16_Regular">Email:</td>
									<td class="lable14">{{signator.email}}</td>

								</tr>
								<tr style="height: 5px"></tr>
								<tr class="info">
									<td class="lable16_Regular">Mobile:</td>
									<td class="lable16_numbers">{{signator.mobile}}</td>

								</tr>
								<tr style="height: 5px"></tr>
								<tr class="success">
									<td class="lable16_Regular">Phone:</td>
									<td class="lable16_numbers">{{signator.phone}}</td>

								</tr>
								<tr style="height: 5px"></tr>
								<tr class="info">
									<td class="lable16_Regular">Address:</td>
									<td class="lable14">{{signator.address}}</td>

								</tr>
							</table>
						</td>

					</tr>





				</table>
			</td>
		</tr>
		<tr height="80px"></tr>


	</table>




</div>



