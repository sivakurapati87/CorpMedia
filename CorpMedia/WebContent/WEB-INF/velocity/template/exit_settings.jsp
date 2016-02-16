


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

									<li ng-class="{'active':(state==='welcome_screen')}"><a
										class="anchor-sm" ui-sref="welcome_screen">Welcome Screen</a></li>
									<li ng-class="{'active':(state==='on_boarding')}"><a
										class="anchor-sm" ui-sref="on_boarding">Onboarding</a></li>	
									<li ng-class="{'active':(state==='exit_settings')}"><a
										class="anchor-sm" ui-sref="exit_settings">Exit Settings</a></li>	
										
									

								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>

							 
            
 <div class="w3-container w3-border">
<h4>Termination Reasons</h4>
<p>You can specify different reasons for Employee termination for each of the following three types of Terminations.</p>

<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span>Add New</button>
<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
<!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add Reason</h4>
        </div>
        <div class="modal-body">
          
<label>Reason</label>
<input type="text" class="form-control" placeholder="Reason type"/>
<!-- <label>Reason Type</label> -->
<div class="form-group">
      <label for="sel1">Reason Type:</label>
      <select class="form-control" id="sel1">
        <option>Select</option>
        <option>Voluntary</option>
        <option>Involuntary</option>
        <option>Other</option>
        </select>
        </div>

        </div>
        <div class="modal-footer">
        <input type="button" class="btn btn-submit" value="ADD">
          <button type="button" class="btn btn-info btn-lg" value="Preview" style="border-radius:1px;font-size: 12px;margin-right: 10px;padding: 10px 15px 10px 15px" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
<br>
<br>
<h6><b>Reasons for Voluntary Termination</h6>
<h6><b>Reasons for Involuntary Termination</h6>
<h6><b>Reasons for Other Termination</h6>
<div class="alert alert-success" role="alert" id="noexpense">There are no termination reasons!</div>
  </div><!-- this is the end of w3 region -->
 



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>



































