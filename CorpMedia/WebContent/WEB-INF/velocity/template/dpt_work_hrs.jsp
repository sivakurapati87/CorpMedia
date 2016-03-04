 <script>
      $(document).ready(function(){
         $("#btn1").click(function(){
             $("#fade_out").fadeOut();
             $("#fade_in").fadeIn();
             
         }); 
      });
      </script>
<div class="container-fluid" style="width: 100%;">
	<table border="0">
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
									<li ng-class="{'active':(state==='projects')}"><a
										class="anchor-sm"
										ui-sref="projects">Projects
											</a></li>
									<li ng-class="{'active':(state==='billing')}"><a
										class="anchor-sm"
										ui-sref="billing">Billing
											</a></li>
									<li ng-class="{'active':(state==='clients')}"><a
										class="anchor-sm"
										ui-sref="clients">Clients
											</a></li>
									<li ng-class="{'active':(state==='billing_rates')}"><a
										class="anchor-sm"
										ui-sref="billing_rates">Billing Rates
											</a></li>	
									<li ng-class="{'active':(state==='reports')}"><a
										class="anchor-sm"
										ui-sref="reports">Reports
											</a></li>									
									
									
								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0" style="width: 100%; background-color: white;">
					<tr>
						<td width="20%">
						 <div class="row">
            <!--first part is for vertical navigation bar.-->
             <div class="subnavbar-static-side">
				<ul class="nav">
  <li ng-class="{'active':(state==='reports')}"><a
										class="anchor-sm"
										ui-sref="reports">Client Details
											</a></li>              
   <li ng-class="{'active':(state==='project_details')}"><a
										class="anchor-sm"
										ui-sref="project_details">Project Details</a></li>
  <li ng-class="{'active':(state==='task_billing')}"><a
										class="anchor-sm"
										ui-sref="task_billing">Task Billing</a></li>
  <li ng-class="{'active':(state==='dpt_work_hrs')}"><a
										class="anchor-sm"
										ui-sref="dpt_work_hrs">Department Work Hours</a></li>
  <li ng-class="{'active':(state==='project_work_hrs')}"><a
										class="anchor-sm"
										ui-sref="project_work_hrs">Project Work Hours</a></li>
   <li ng-class="{'active':(state==='client_work_hrs')}"><a
										class="anchor-sm"
										ui-sref="client_work_hrs">Client Work Hours</a></li>
   <li ng-class="{'active':(state==='employee_timesheets')}"><a
										class="anchor-sm"
										ui-sref="employee_timesheets">Employee Timesheets</a></li>
</ul>
                
            </div>
            </td>
            <td width="1%"></td>
            <td>
            
            
            <!--rest of the page and data comes here-->
            <div class="col-md-12">


                <!--first row in the right part of the page-->
                <div class="row">
                    
                    <div class="col-md-4">
                        <p><b><font size="3">
                                Department Work Hours Summary</font></b></p>
                    </div>

                    <div class="col-md-5"></div>
                    
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="sel1">EXPORT</label>
                            <select class="form-control" id="sel1">
                                <option>csv</option>
                                <option>pdf</option>
                            </select>
                        </div>

                    </div>
                    
                </div>

                <br>

                
                <!--this is the second row-->
                <div class="row">
                    
                    <div class="col-md-3">
                        
                         <div class="form-group">
  <label for="sel1">Department</label>
  <select class="form-control" id="sel1">
    <option>select a department</option>
    <option>All Departments</option>
    <option>Ungrouped Departments</option>
    <option>Accounts</option>
    <option>Web Development</option>
    
  </select>
</div>
                        <br>
                        <div class="form-group">
  <label for="date_from">From</label>
  <input type="date" class="form-control" id="date_from">
</div>
                        
                    </div>
                    
                    <div class="col-md-1"></div>
                    
                    <div class="col-md-3">
                        
                        <div class="form-group">
  <label for="sel1">Group By</label>
  <select class="form-control" id="sel1">
    <option>Month</option>
    <option>Timesheet Period</option>
    <option>Ungrouped Departments</option>
  </select>
</div>
                        <br>
                        <div class="form-group">
  <label for="date_to">To</label>
  <input type="date" class="form-control" id="date_to">
</div>
                        
                    </div>
                    
                    <!--this remains empty for the show-off purpose:for styling-->
                    <div class="col-md-5"></div>

                </div>
                <!--this is the end of the row-->
              <div class="row">
                  
                  <div class="col-md-3">
                      <p><input type="checkbox">&nbsp;&nbsp;Include non billable hours</p>
                  </div>
                  
                  <div class="col-md-1"></div>
                  
                  <div class="col-md-3">
                      <button class="btn btn-success">Submit</button>
                  </div>
                  
                  <div class="col-md-2"></div>
                  <div class="col-md-3">
                      <input type="search" placeholder="search" class="form-control">
                  </div>
              </div>
                <br>
                <p><b>No department work hours summary</b></p>
            </div>
            
        </div>
          <!--this is the end of the main row-->
						
						
						</td>
					</tr>
					



					




				</table>
			</td>
		</tr>

	</table>


</div>
































