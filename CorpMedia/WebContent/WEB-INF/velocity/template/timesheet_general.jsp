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
									
									<li ng-class="{'active':(state==='timesheet_general')}"><a
										class="anchor-sm" ui-sref="timesheet_general">General</a></li>
									<li ng-class="{'active':(state==='timesheet_approval_chain')}"><a
										class="anchor-sm" ui-sref="timesheet_approval_chain">Approval Chain</a></li>	
									
								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td><div class="panel-body">

<div class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
<div class="col-lg-12">
  <h4 class="page-heading">General settings</h4>
  <p class="page-description">The information about general company working hours.</p>
</div>
</div>


<form class="form-horizontal ng-dirty ng-invalid ng-valid-min ng-valid-number ng-invalid-required" name="TimesheetSettings">
                    <div class="col-lg-12 clear-left-padding">
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6">
                                <label>Hours Per Week</label>
                                <input data-set-focus="true" class="form-control ng-dirty ng-invalid ng-valid-number ng-valid-min ng-invalid-required ng-touched" type="number" placeholder="Hours Per Week" data-min="1" ng-model="model.hoursPerWeek" name="hoursPerWeek" required="">
                                <div data-validation-messages="" data-model-controller="TimesheetSettings.hoursPerWeek" data-required-error="Hours Per Week is Required." data-min-error="Must be greater than zero." data-form-submit="submitted" class="ng-isolate-scope"><div><!-- ngRepeat: message in errorMessages --><small class="error ng-binding ng-scope" ng-repeat="message in errorMessages" ng-show="(!modelController.$pristine &amp;&amp; $first) || formSubmit">Hours Per Week is Required.</small><!-- end ngRepeat: message in errorMessages --></div></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 clear-left-padding">
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6">
                                <label>Hours Per Month</label>
                                <input class="form-control ng-pristine ng-valid-min ng-valid ng-valid-required ng-touched" type="number" placeholder="Hours Per Month" data-min="1" ng-model="model.hoursPerMonth" name="hoursPerMonth" required="">
                                <div data-validation-messages="" data-model-controller="TimesheetSettings.hoursPerMonth" data-required-error="Hours Per Month is Required." data-min-error="Must be greater than zero." data-form-submit="submitted" class="ng-isolate-scope"><div><!-- ngRepeat: message in errorMessages --></div></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 clear-left-padding">
                        <div class="form-group">
                            <div class="col-md-6">
                                
<input type="button" class="btn btn-submit btn-sm pull-left" data-ng-click="updateGeneralInfo();submitted=true;" value="Update">


                            </div>
                        </div>
                    </div>
                </form>
</div>
     
     
     
     </td>
					</tr>



					





	





					










				</table>
			</td>
		</tr>
	</table>
</div>





















