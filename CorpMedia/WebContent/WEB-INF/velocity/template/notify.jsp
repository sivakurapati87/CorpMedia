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
				<table class="table" border="0"
					style="width: 100%; background-color: white">

					<tr>
						<td><a data-toggle="modal" data-target="#addSignatoryPopupId"
							id="addSignatoryId" style="cursor: pointer; font-size: 20px"><span
								class="glyphicon glyphicon-plus-sign"></span>&nbsp;Add Notifier</a>
							<!-- Modal -->
							<div class="modal fade" id="addSignatoryPopupId" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel">
								<div class="modal-dialog" role="document">
									<form ng-submit="addNotify()">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">Add Employee</h4>
											</div>
											<div class="modal-body">

												<table class="table" border="0" width="100%" cellpadding="0"
													cellspacing="0">
													<tr>
														<td width="33%"><div angucomplete-alt class="lable16"
																placeholder="Start Typing employee Name" pause="100"
																selected-object="selectedEmployeeIdAction"
																local-data="autoCompleteEmpList"
																search-fields="displayName" id="employeeId"
																title-field="displayName" minlength="2"
																input-class="search-control" match-class="highlight"></div>

															</div></td>
													</tr>
												</table>




											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Cancel</button>
												<button type="submit" class="btn btn-primary">Add
													Notifier</button>
											</div>
										</div>
									</form>
								</div>
							</div></td>
					</tr>
					<tr>
						<td align="left"><table
								style="width: 40%; text-align: center" border="0"
								class="table table-bordered">

								<tr ng-repeat="notify in notifiesList">
									<td width="80%"><label>{{notify.notifierName}}</label></td>
									<td><a href="#" tooltip="Delete" tooltip-placement="right"
										ng-click="deleteNotify(notify.leavesNotifyId)"><i
												class="fa fa-trash fa-2x"></i></a></td>
								</tr>
							</table></td>
					</tr>



					<tr>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
