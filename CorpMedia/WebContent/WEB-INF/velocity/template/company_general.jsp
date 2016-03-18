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
				<table class="table " border="0" style="width: 100%;">
					<tr>
						<td>
							<div class="sub-page-navigation">
								<ul>
									<li ng-class="{'active':(state==='legalentities')}"><a
										class="anchor-sm"
										ui-sref="company_legalentities.mainInfo({legEntity:'cmpInfo'})">Legal
											Entities</a></li>
									<li ng-class="{'active':(state==='general')}"><a
										class="anchor-sm" ui-sref="company_general">General Info</a></li>
									<li ng-class="{'active':(state==='locations')}"><a
										class="anchor-sm" ui-sref="company_locations">Locations</a></li>
									<li ng-class="{'active':(state==='department')}"><a
										class="anchor-sm" ui-sref="company_department">Departments</a>
									</li>


								</ul>
							</div>
						</td>
					</tr>
				</table>
				<form ng-submit="saveCompanyGeneralInfo()">
					<table class="table mtable table-hover table-striped" border="0"
						style="width: 100%; background-color: white; border-radius:10px;">
						<tr>
							<th class="th"><h2>Company Info</h2></th>
						</tr>
						<tr height="1px"></tr>
						<tr>
							<td>Information about the company</td>
						</tr>
						
						<tr>
							<td>Short Name</td>
						</tr>
						<tr>
							<td><input type='text' class='form-control'
								ng-model="companyJson.shortName" style="width: 200px"></td>
						</tr>
						<tr>
							<td><img ng-src="{{companyLogo}}" width="200" height="200"
								ng-show="companyLogo != null"> <img
								ng-src="{{'data:image/png;base64,'+companyJson.base64logo}}"
								width="200" height="200" ng-show="companyLogo == null"></td>
						</tr>
						<tr>
							<td><input type="file" name="fileInput" id="fileInput"
								onchange="angular.element(this).scope().fileChanged(event)" /></td>
						</tr>
						<!-- <tr height="10px"></tr> -->
						<tr>
							<td><button class="btn btn-success" type="submit"
									style="width: 100px">Save</button></td>
						</tr>
						<tr height="10px"></tr>
					<tr>
						<td class="bth"><h2></h2></td>
					</tr>
					</table>
				</form>
			</td>
		</tr>

	</table>


</div>













