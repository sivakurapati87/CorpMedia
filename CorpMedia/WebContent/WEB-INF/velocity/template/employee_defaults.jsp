 
 <script>
         $(document).ready(function(){
             $(fader).click(function(){
                 $(fade_out).fadeOut();
                 $(fade_in).fadeIn();
             });
         });
         </script>
 
  


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
										class="anchor-sm" ui-sref="employee_defaults">Employee Defaults</a></li>	
													
										
										
									

								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>

							 
            
  
       
        <p><font size="4">Employee Default Settings</font></p>
        <p><font size="3">These are the default settings which apply to new recruits</font></p>
        
         <div id="fade_out">
        <div class="row">
            <div class="col-md-2">
                <button id="fader" class="btn btn-primary"><i class="fa fa-pencil-square fa-5"></i>&nbsp;&nbsp;&nbsp;</button>
            </div>
            <div class="col-md-10">
            </div>
        </div>
        
             
        <br>
        
        
       <div class="row">
           <div class="col-md-4">
               
               
               <div class="row">
                   <div class="col-md-5">
               <p><b><font size="3">Probation Period</font></b></p>
                   </div>
                   <div class="col-md-1">
                       <p>-</p>
                       </div>
                   <div class="col-md-6">
                       <p><b><font size="3">{{probation_period}}&nbsp;{{probation_month}}</font></b></p>
                   </div>
               </div>
               
               <br>
               
                <div class="row">
                   <div class="col-md-5">
                       <p><b><font size="3">Worker Type</font></b></p></div>
                     <div class="col-md-1">
                       <p>-</p>
                       </div>
                   <div class="col-md-6">
                        <p><b><font size="3">{{work_type}}</font></b></p>
                   </div>
                </div>
               
                <br>
                
                <div class="row">
                   <div class="col-md-5">
                       <p><b><font size="3">Time Type</font></b></p>
                   </div>
                        <div class="col-md-1">
                       <p>-</p>
                       </div>
                       
                        <div class="col-md-6">
                        <p><b><font size="3">{{time_type}}</font></b></p>
                        </div>
                   </div>
                
                 <br>
                 
                  <div class="row">
                   <div class="col-md-5">
                 <p><b><font size="3">Notice Period</font></b></p>
                   </div>
                      <div class="col-md-1">
                       <p>-</p>
                       </div>
                      
                      <div class="col-md-6">
                        <p><b><font size="3">
                         {{notice_time}}&nbsp;{{notice_period}}</font></b></p>
                      </div>
                  </div>
                 
                  <br>
                  
                  <div class="row">
                   <div class="col-md-5">
                   <p><b><font size="3">Allow employee to edit Personal Details</font></b></p>
                   </div>
                      <div class="col-md-1">
                       <p>-</p>
                       </div>
                      
                      <div class="col-md-6">
                        <p><b><font size="3">
                           {{permission}}</font></b></p>
                      </div>
       </div>
                  
           <div class="col-md-8">
       </div>
                  
           </div>
           <div class="col-md-8"></div>
        
        </div>
        
        
         </div>
        
        
        <div id="fade_in" style="display: none">
            
      
            
            <!--this is the first row-->
            
            <div class="row">
                
                <div class="col-md-2">
                    <p><b>Probation Period</b></p>
                </div>
                    
                <div class="col-md-1"></div>
                
                <div class="col-md-2">
                    <input type="number" style="width: 100px" class="form-control" ng-model="probation_period">
                </div>
                
                <div class="col-md-3">
                      <select class="form-control" ng-model="probation_month">
                          <option>select</option>
                           <option>Months</option>
                            <option>Weeks</option>
                             <option>Days</option>
                      </select>
                </div>
                
                <div class="col-md-4"></div>
                
                </div>
            
            <br>
            
             <!--this is the second row-->
             
            <div class="row">
                
                <div class="col-md-2">
                    <p><b>Worker Type</b></p>
                </div>
                    
                <div class="col-md-1"></div>
                
                <div class="col-md-5">
                    <select class="form-control" ng-model="work_type">
                          <option>select Worker Type</option>
                           <option>Permanent</option>
                            <option>Contract</option>
                      </select>
                </div>
                
                <div class="col-md-4"></div>
                
                </div>
                
             <br>
             
              <!--this is the third row-->
              
            <div class="row">
                
                <div class="col-md-2">
                    <p><b>Time Type</b></p>
                </div>
                    
                <div class="col-md-1"></div>
                
                <div class="col-md-5">
                    <select class="form-control" ng-model="time_type">
                          <option>select Time Type</option>
                           <option>Full Time</option>
                            <option>Part Time</option>
                      </select>
                </div>
                
                <div class="col-md-4"></div>
                
                </div>
                   
              
              <br>
              
               <!--this is the first row-->
            <div class="row">
                
                <div class="col-md-2">
                    <p><b>Notice Period</b></p>
                </div>
                    
                <div class="col-md-1"></div>
                <div class="col-md-2">
                    <input type="number" style="width: 100px" class="form-control" ng-model="notice_time">
                </div>
                <div class="col-md-3">
                    <select class="form-control" ng-model="notice_period">
                          <option>select</option>
                           <option>Months</option>
                            <option>Weeks</option>
                             <option>Days</option>
                      </select>
                </div>
                
                <div class="col-md-4"></div>
                
                </div>
            
               <br>
               
               <p><input type="checkbox" ng-model="permission">&nbsp;&nbsp;Allow Employees to update personal details</p>
               
               <p>
                   <button type="button" class="btn btn-success">Update</button>
                   <button type="button" class="btn btn-default">Cancel</button>
               </p>
               
                </div>
                
                
            
       
     
        



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>














