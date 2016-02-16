


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

									<li ng-class="{'active':(state==='general_payroll_settings')}"><a
										class="anchor-sm" ui-sref="general_payroll_settings">Payroll settings</a></li>
									<li ng-class="{'active':(state==='adhoc_components')}"><a
										class="anchor-sm" ui-sref="adhoc_components">Adhoc Components</a></li>	
									<li ng-class="{'active':(state==='salary_component_structure')}"><a
										class="anchor-sm" ui-sref="salary_component_structure">Salary Structure</a></li>
									<li ng-class="{'active':(state==='provident_fund')}"><a
										class="anchor-sm" ui-sref="provident_fund">Provident Fund</a></li>
									<li ng-class="{'active':(state==='legal_and_bank')}"><a
										class="anchor-sm" ui-sref="legal_and_bank">Legal and Bank</a></li>	
									<li ng-class="{'active':(state==='employee_loan_settings')}"><a
										class="anchor-sm" ui-sref="employee_loan_settings">Loan Settings</a></li>				
										
										
									

								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>

							 
            
  <div class="row">
                <div class="col-md-7">
                    <p><font size="4"><b>PAYROLL CYCLE SETTINGS</b></font></p>

                    <div style="background-color:#CECEF6">
                        <!-- this is our container for the first form -->


                        <br>



                        <div class="form-group">
                            <form class="form-horizontal" role="form">


                                <!-- field 1 -->
                                <div class="row">
                                    <div class="col-md-1"><!-- empty first column to make some room --></div>
                                    <div class="col-md-5">
                                        <label><b>Pay Frequency</b></label>
                                    </div>
                                    <div class="col-md-5">
                                        <select class="form-control" id="sel1">
                                            <option>Monthly</option>
                                        </select>
                                    </div>
                                </div><!-- this is the end of the internal row -->
                                <br>


                                <!-- field 2 -->
                                <div class="row">
                                    <div class="col-md-1"><!-- empty first column to make some room --></div>
                                    <div class="col-md-5">
                                        <label><b>Which pay cycle do you want to start using Corpmedia for Payroll</b></label>
                                    </div>
                                    <div class="col-md-5">
                                        <select class="form-control" id="sel1">
                                            <option>Select a Paycycle month</option>
                                            <option>NOV</option>
                                            <option>DEC</option>
                                            <option>JAN</option>
                                            <option>FEB</option>

                                        </select>
                                    </div>
                                </div><!-- this is the end of the internal row -->


                                <br>

                                <!-- field 3 -->
                                <div class="row">
                                    <div class="col-md-1"><!-- empty first column to make some room --></div>
                                    <div class="col-md-5">
                                        <label><b>Which day did the pay period end in Nov</b></label>
                                    </div>
                                    <div class="col-md-5">
                                        <select class="form-control" id="sel1">
                                            <option>Select a Paycycle month</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                            <option>6</option>
                                            <option>7</option>
                                            <option>8</option>
                                            <option>9</option>
                                            <option>10</option>
                                            <option>11</option>
                                            <option>12</option>
                                            <option>13</option>
                                            <option>14</option>
                                            <option>15</option>
                                            <option>16</option>
                                            <option>17</option>
                                            <option>18</option>
                                            <option>19</option>
                                            <option>20</option>
                                            <option>21</option>
                                            <option>22</option>
                                            <option>23</option>
                                            <option>24</option>
                                            <option>25</option>
                                            <option>26</option>
                                            <option>27</option>

                                        </select>
                                    </div>
                                </div><!-- this is the end of the internal row -->

                        </div>
                        <br>
                        <div style="text-align:center">
                            <button type="button" class="btn btn-primary active" style="align:center">Complete</button>
                        </div>
                        <br>
                        <br>
                    </div><!-- this is the end of the first form -->

                    <div class="col-md-5"><!-- second half of the row --></div>

                </div><!-- end of first half of row. -->

                <div class="col-md-5"></div>

                <br>
                <br>
                <br>

            </div>
            <!--this the end of the first row(form)-->

            <br>
            <br>
            <!--this the the second row(form)-->
            <div class="row">
                <div class="col-md-7">
                    <p><font size="4"><b>PAYROLL PERIOD CALCULATION</b></font></p>

                    <div style="background-color:#CECEF6">
                        <!-- this is our container for the first form -->


                        <br>



                        <div class="form-group">
                            <form class="form-horizontal" role="form">


                                <!-- field 1 -->
                                <div class="row">
                                    <div class="col-md-1"><!-- empty first column to make some room --></div>
                                    <div class="col-md-5">
                                        <label><b>Pay Days in a month</b></label>
                                    </div>
                                    <div class="col-md-5">
                                        <select class="form-control" id="sel1">
                                            <option>Select working days</option>
                                             <option>Select working days</option>
                                              <option>28</option>
                                               <option>29</option>
                                                <option>30</option>
                                                 <option>31</option>
                                                  <option>Actual days in month</option>
                                        </select>
                                    </div>
                                </div><!-- this is the end of the internal row -->
                                <br>


                                <!-- field 2 -->
                                <div class="row">
                                    <div class="col-md-1"><!-- empty first column to make some room --></div>
                                    <div class="col-md-5">
                                        <label><b>Exclude Weekly offs</b></label>
                                    </div>
                                    <div class="col-md-5">
                                        <select class="form-control" id="sel1">
                                            <option>Yes</option>
                                            <option>No</option>
                                        </select>
                                    </div>
                                </div><!-- this is the end of the internal row -->


                                <br>

                                <!-- field 3 -->
                                <div class="row">
                                    <div class="col-md-1"><!-- empty first column to make some room --></div>
                                    <div class="col-md-5">
                                        <label><b>Exclude Holidays</b></label>
                                    </div>
                                    <div class="col-md-5">
                                        <select class="form-control" id="sel2">
                                            <option>Yes</option>
                                            <option>No</option>
                                            
                                        </select>
                                    </div>
                                </div><!-- this is the end of the internal row -->

                        </div>
                        <br>
                        <div style="text-align:center">
                            <button type="button" class="btn btn-primary active" style="align:center">Complete</button>
                        </div>
                        <br>
                        <br>
                    </div><!-- this is the end of the first form -->

                    <div class="col-md-5"><!-- second half of the row --></div>

                </div><!-- end of first half of row. -->

                <div class="col-md-5">
                    <p><b><font size="3">NOTE:</font></b></p>
                    <p><font size="2">Calculation of number of days for a given pay period has significant impact when deducting salary for Loss of Pay due to Leave or other reason.
Ex: Loss of Pay for 1 day for an employee whose salary is Rs.30,000/month is calculated as below</font></p>
                    <p><font size="2">Loss of Pay when days = 30</font></p>
                    <p><font size="2">-> Rs.30,000/30 = Rs.1000</font></p>
                    <p><font size="2">Loss of Pay when days are calculated excluding Weekends. </font></p>
                    <p><font size="2">Lets say there are 8 Saturday & Sundays in month. </font></p>
                    <p><font size="2">Effective days = 30-8 = 22 days</font></p>
                    <p><font size="2">Loss of Pay = Rs.30,000/22 = Rs.1364.</font></p>
                </div>

                <br>
                <br>
                <br>

            </div>
            <!--end of second form-->
 



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>















