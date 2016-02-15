 


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

									<li ng-class="{'active':(state==='weekly_offs')}"><a
										class="anchor-sm" ui-sref="weekly_offs">Weekly Offs</a></li>
									<li ng-class="{'active':(state==='shifts')}"><a
										class="anchor-sm" ui-sref="shifts">Shifts</a></li>
                                    <li ng-class="{'active':(state==='timing_policies')}"><a
										class="anchor-sm" ui-sref="timing_policies">Timing Policies</a></li>	
                                     <li ng-class="{'active':(state==='web_clock_in')}"><a
										class="anchor-sm" ui-sref="web_clock_in">Web Clock-in</a></li>
									<li ng-class="{'active':(state==='wfh')}"><a
										class="anchor-sm" ui-sref="wfh">WFH</a></li>	

								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>


							 <div class="panel panel-default">
                <div class="panel-body" ng-app="myform">

                    <div class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
                        <div class="col-lg-12">


                            <div class="ng-scope" data-ui-view="">

                                <div class="row ng-scope">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 approver-hierarchy" data-ng-class="{'vertical-margin': vm.id }">



                                        <h4 class="page-heading" data-ng-class="{'clear-top-margin': vm.id }">Web Clock-in</h4>
                                        <p class="page-description ng-scope" data-ng-if="!vm.id">Web clock-in allows employees to log time using Corpmedia web application or a Corpmedia mobile app and can be used for field staff time logging.</p>
                                        </br>
                                        <!-- check boxes -->
                                        <div><!-- This div is for checkboxes -->
                                            <form role="form">
                                                <div class="checkbox">
                                                    <label><input type="checkbox" value="" ng-model="parent1">Enable work from home. </label>
                                                    <i class="fa fa-info-circle"></i>
                                                </div>
                                                &nbsp;&nbsp;&nbsp;
                                                <span class="web-clock-in-desc">(You can override this at individual employee level in Employee profile page.)</span>
                                                </br>

                                                <div class="checkbox">
                                                    &nbsp;&nbsp;&nbsp;
                                                    <label><input type="checkbox" value="" ng-model="parent1" ng-disabled="!parent1">Require comment when employee is doing a web clock-in</label>
                                                </div>
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <span class="web-clock-in-desc">(You can override this at individual employee level in Employee profile page.)</span>
                                                </br>
                                                </br>
                                                <div class="checkbox">

                                                    <label><input type="checkbox" value="" ng-model="child2" > Allow web clock-in when an employee forgot his ID card.</label>
                                                </div>
                                                &nbsp;&nbsp;&nbsp;
                                                <span class="web-clock-in-desc">(You can limit this to your work location IP address using IP Restrictions below.)
                                                </span>
                                                </br>
                                                </br>
                                                <div class="checkbox">

                                                    <label><input type="checkbox" value="" ng-model="parent3">Allow employee to adjust missing swipes</label>
                                                </div>
                                                <div class="checkbox">
                                                    &nbsp;&nbsp;&nbsp;
                                                    <label><input type="checkbox" value="" ng-model="parent3" ng-disabled="!parent3">Require Approval when employee requests for missing swipes.</label>
                                                </div>
                                            </form>

                                              
                                            <br>
                                        </div><!-- This is the end of the checkboxes and under formcontroller. -->

                                        <h4>Restrictions</h4>
                                        <div class="checkbox">

                                            <label><input type="checkbox" value="" ng-model="limit_ip"> Limit access to following IP Addresses</label>
                                        </div>
                                        <div id="appear" ng-show="limit_ip">

                                        <button id="btn2" class="add-approver"><i class="fa fa-plus-square"></i>Add New</button>
                                        </br>
                                        </br>
                                        <pre>
                                        <p>IP Range: <input type="ip" placeholder="Eg: 10.0.0.1"/> &nbsp;&nbsp;-&nbsp;&nbsp;<input type="ip" placeholder="Eg: 10.0.0.1"/> <b>(For a single IP address. Leave the second box empty)</p>
                                        </pre>
                                        </div><!-- This is for ip address id is appear-->

                                        <button type="button" class="btn btn-info" style="border-radius: 2px">Save</button>
                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div> <!-- end of panel body and ngapp-->

            </div><!-- This is the and of panel -->



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>


























