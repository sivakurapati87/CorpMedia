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
				<table class="table mtable " border="0" style="width: 100%; background-color: white;">
					<tr><th class="th"><h2>Billing</h2> </th></tr><tr>
						<td>
						<p><b><font size="3"></font></b></p>
        <p><font size="2">Billing</font></p>
        
        <!--this is the first row-->
        <div class="row">
<div class="col-md-2">
    <p><b>This project is</b></p>
</div>
            <!--this remains empty-->
            <div class="col-md-1">
                
</div>
            
            <div class="col-md-5">
                <p><input type="radio">&nbsp;&nbsp;Billable</p>
                <p><input type="radio">&nbsp;&nbsp;Non Billable</p>
                <br>
                <p><b>Billing Type</b></p>
                 <p><input type="radio">&nbsp;&nbsp;Time & Material</p>
                  <p><input type="radio">&nbsp;&nbsp;Fixed Bid</p>
                  <p><input type="radio">&nbsp;&nbsp;Allow timesheet users to enter non billable hours </p>
            </div>
            
            <!--this remains empty-->
            <div class="col-md-4"></div>
            
            
        </div>
        
        
        <!--this is the second row-->
        <div class="row">
<div class="col-md-2">
    <p><b>Billing rate</b></p>
</div>
            <!--this remains empty-->
            <div class="col-md-1">
                
</div>
            
            <div class="col-md-5">
                <select class="form-control">
                    <option>Select Billing rate</option>
                    <option>Hourly</option>
                    <option>Weekly</option>
                    <option>Monthly</option>
                </select>
            </div>
            
            <!--this remains empty-->
            <div class="col-md-4"></div>
            
            
        </div>
        <br>
        <!--this is third row-->
        <div class="row">
            
            <!--this remains empty-->
            <div class="col-md-3"></div>
            <div class="col-md-5">
                <p>
                    <a><button class="btn btn-default">Cancel</button></a>
                   <button class="btn btn-success">Next</button>
                </p>
            </div>
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


<div class="main1" ng-show="isProcessing">
	<div class="div1">

		<i class="fa fa-spinner fa-spin " style="font-size: 60px"></i>
	</div>
</div>
































