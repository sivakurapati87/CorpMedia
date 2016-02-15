<div class="container-fluid" style="width: 100%;">
	<table>
		<tr style="height: 120px;background-image:url('resources/images/bgimg3.png');">
			<td class="lable50_blue" align="center" colspan="3">{{companyName}}</td>
		</tr>
		<tr>
			<td width="20%" valign="top" bgcolor="white">
				<left-menu></left-menu>
			</td>
			<td width="1%"></td>
			<td valign="top">
				<table class="table" border="0" style="width: 100%;">
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
				<table class="table" border="0" style="width: 100%;background-color: white">
					<tr>
						<td><h4>Under Construction</h4></td>
					</tr>
					
				</table>
			</td>
		</tr>

	</table>


</div>


