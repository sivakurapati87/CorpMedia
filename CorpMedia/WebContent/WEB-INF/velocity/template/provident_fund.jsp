 


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
										
									<li ng-class="{'active':(state==='employee_loan_settings')}"><a
										class="anchor-sm" ui-sref="employee_loan_settings">Loan Settings</a></li>				
										
										
									

								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table mtable  " border="0"
					style="width: 100%; background-color: white">
					<tr><th class="th"><h2>PROVIDENT FUND & ESI SETTING</h2></th> </tr><tr>
						<td>

						 
            
  <div class="row">
    <div class="col-md-9">
        <p>The settings here are defaulted to general industry practices.</p>
        <div class="row">
            <div class="col-md-6">
                <p>Provident fund status</p>
            </div>
            <div class="col-md-4">
                <!--on-off switch-->
                <div class="onoffswitch" id="switch1">
    <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" checked ng-model="myonoffswitch">
    <label class="onoffswitch-label" for="myonoffswitch">
        <span class="onoffswitch-inner"></span>
        <span class="onoffswitch-switch"></span>
    </label>
</div>
            </div>
        </div>
        <!--make some room-->
        <br>
        <div ng-show="myonoffswitch">
        <p><font size="2">PF CONTRIBUTION</font></p>
        <div style="background-color:#81BEF7">
            <br>
            <br>
            <div class="row">
                <div class="col-md-1">
                </div>
                <div class="col-md-11">
                    
            <p>Statutory minimum monthly basic for PF Calculation &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;<input type="text" maxlength="8"/></p>
            <br>
            <div class="checkbox">
  <label><input type="checkbox" name="optradio1"> Limit PF amount to Statutory minimum Salary for all employees.</label>
</div>
             <div class="checkbox">
  <label><input type="checkbox" name="optradio2">  Allow PF calculated as percentage of Basic Salary beyond Statutory Minimum.</label>
</div>
            <br><!--give some space-->
            <div class="checkbox">
  <label><input type="checkbox" name="optradio3"> Pay Employer Contribution of Provident Fund outside the Gross Salary of an Employee</label>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="checkbox" name="optradio2">Limit employer contribution amount to a Maximum amount of INR
    &nbsp;&nbsp;&nbsp;  <input type="text" maxlength="8"/></label></p>
</div>
            
      <br>      
            <div class="checkbox">
  <label><input type="checkbox" name="optradio4">  Allow admin to adjust employee's share of PF contribution</label>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input type="checkbox" name="optradio2">Allow an employee to adjust their share of PF contribution</label></p>
</div>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;How Often Employees can update their PF contribution ?</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="optradio5">  Monthly before 
          <input type="text" maxlength="2">&nbsp;&nbsp;day of the month</p>
      <div class="checkbox">
  <label><input type="checkbox" name="optradio1"> Allow an employee to opt-out from PF deduction if Monthly basic exceed.
  <input type="text"/></label>
      
      </div>
                </div>
                </div>
            <br>
            <br>
            
        </div>
        </div>
        <br>
            <br>
        <!--second half of the form-->
        <div class="row">
            <div class="col-md-6">
                <p>ESI Status</p>
            </div>
            <div class="col-md-4">
                <!--on-off switch-->
                <div class="onoffswitch">
    <input type="checkbox" name="onoffswitch2" class="onoffswitch-checkbox" id="myonoffswitch2" checked ng-model="myonoffswitch2">
    <label class="onoffswitch-label" for="myonoffswitch2">
        <span class="onoffswitch-inner"></span>
        <span class="onoffswitch-switch"></span>
    </label>
</div>
            </div>
        </div>
<!--make some room-->
<br>
<div ng-show="!myonoffswitch2">
<p><b><font size="2">ESI CONTRIBUTION</font></b></p>
<div style="background-color:#81BEF7">
            <br>
            <br>
            <div class="row">
                <div class="col-md-1">
                </div>
                <div class="col-md-11">
                    
            <p>Maximum monthly gross salary eligible for ESI  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;<input type="text" maxlength="8"/></p>
            <br>
            <p>ESI Employee Contribution is  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;<input type="text" maxlength="8"/>&nbsp;&nbsp;of gross salary</p>
             <p>ESI Employer Contribution is  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;<input type="text" maxlength="8"/>&nbsp;&nbsp;of gross salary</p>
            
       <label><input type="checkbox" name="optradio6">Pay Employer Contribution of ESI outside the Gross Salary of an Employee
  <input type="text"/></label>
       <br>
       <br>
       
            
      
      
  
      
      </div>
                </div>
                </div>
</div>
            <br>
            <br>
            
        </div>
 <div class="col-md-3"></div>

            </div>
            

 



						</td>
					</tr>

























				<tr>
						<td class="bth"><h2></h2></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>











