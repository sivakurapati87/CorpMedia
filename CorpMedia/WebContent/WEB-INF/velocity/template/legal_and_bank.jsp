 


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

	<article class="w3-container w3-border">
<h3>Legal and Bank information</h3>
<br>



<!-- angular js application -->
<div>
<div class="row">
<div class="col-sm-4">
<div class="form-group">
  <label for="sel1">Select the legal entity that is used for payroll:</label>
  <select class="form-control" id="sel1" ng-model="sel1">
    <option>ABC Company</option>
    <option>xyz</option>
  </select>
</div>
</div>
<div class="col-sm-8">
</div>


</div><!-- end of row -->
<!-- buttons at the bottom -->
  <button type="button" class="btn btn-primary">Save&Continue</button>
  <br>
  <br>
  <p data-toggle="modal" data-target="#myModal2"><font size="4">{{sel1}}</font>&nbsp;&nbsp;&nbsp;&nbsp;<a href=""><span class="glyphicon glyphicon-plus"></span></a></p>
  <!-- here add the bootstrap modal -->
  <!-- Modal -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit legal Entity</h4>
        </div>
        <div class="modal-body">
          <form class="form">
          <div class="row">
          <div class="col-md-8">
          <label for="#name">Entity Name</label>
          <input type="text" class="form-control" id="fathername" placeholder="Enter Signatory Name" ng-model="sel1">
          </br>
          <label for="#name">Financial Year</label>
          <input type="date" class="form-control" id="fathername"/>
          </div>
          <div class="col-md-4">
          </div>
          </div>
          </form>
        </div>
        <div class="modal-footer">
        <p>
        <button type="button" class="btn btn-primary">Update</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </p>
        </div>
      </div>
      
    </div>
  </div>
  <!-- this is the end of  model-->
 

 </div><!-- This is the end of angularjs -->
  


<br>
<div>
<h6><b>Authorized SIGNATORIES</b></h6>
<!-- link for bootstrap modal -->
<p data-toggle="modal" data-target="#myModal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a><i class="fa fa-plus"></i>&nbsp;Add New Signatory</a></p>


<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add Signatory</h4>
        </div>
        <div class="modal-body">
          <form role="form">
          <div class="row">
          <div class="col-md-5">
    <div class="checkbox">
      <label><input type="checkbox" value="">Choose existing employee</label>
    </div>
    </div>
    <div class="col-md-7">
    <input type="search" placeholder="Start typing employee name"/>
    </div>
    </div><!-- end of row -->

    <div class="row">
    <div class="col-md-4">
    <label for="#name">Signatory Name</label>
      <input type="text" class="form-control" id="fathername" placeholder="Enter Signatory Name">
    </div>
    <div class="col-md-4">
    <label for="#name">Signatory Father Name</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Signatory Father Name">
    </div>
    <div class="col-md-4">
    <label for="#name">Signatory Designation</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Signatory Designation">
    </div>
    </div><!-- end of row -->
    <div class="row">
    <div class="col-md-8">
    </br>
    <p><b>Adress</b></p>
    <input type="text" />
    </br>
    </br>
    <input type="text" />
    </br>
    </br>

    </div>
    <!-- pincode row -->

    <div class="col-md-4">
    <!-- empty for show porpuse -->
    </div>

    </div>
     <div class="row">
    <div class="col-md-3">
    <input type="text" placeholder="city" maxlength="6">
    </div>
    <div class="col-md-1">
    </div>
    <div class="col-md-2">
    <input type="number" placeholder="pincode" maxlength="6">
    </div>
     <div class="col-md-1">
    </div>
    <div class="col-md-4">
    <!--  <input type="text" placeholder="phone" maxlength="6"/> -->
    </div>
     <div class="col-md-1">
    </div>
    </div>
    </br>
    <div class="row">
    <div class="col-md-8">
     <label for="#name">Email</label>
      <input type="email" class="form-control" id="name" placeholder="Enter email">
    </div>
    <div class="col-md-4">
     <label for="#name">Pancard</label>
      <input type="number" class="form-control" id="name" placeholder="Enter your Pancard.">
    </div>
    </div>
    </form>
        </div>
        <div class="modal-footer">
        <p>
          <button type="button" class="btn btn-primary">Add Signatory</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </p>
        </div>
      </div>
      
    </div>
  </div>
  



</div>
</br>
</br>
<div>
<h6><b>BANK ACCOUNTS</b></h6>
<p data-toggle="modal" data-target="#myModal1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a><i class="fa fa-plus"></i>&nbsp;Add New Bank Accounts</a></p>
</div>
<!-- buttons at the bottom -->
  <button type="button" class="btn btn-primary">Save&Continue</button>
  <!-- Modal -->
  <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add Bank Account</h4>
        </div>
        <div class="modal-body">
          <div class="row">
          <div class="col-md-8">
          <form class="form">
           <label for="#name">Name of Bank</label>
           <input type="text" class="form-control" id="name" placeholder="Enter Name of Bank">
           </br>
           <label for="#name">Account Number</label>
           <input type="number" class="form-control" id="name" placeholder="Enter Account Number">
           </br>
           <label for="#code">IFSC Code</label>
           <input type="text" class="form-control" id="code" placeholder="Enter IFSC CODE">
           </br>
           <label for="#branch">Branch</label>
           <input type="text" class="form-control" id="branch" placeholder="Enter Branch">
          </form>
          </div>
          <div class="col-md-4">
          </div>
          </div>
        </div>
        <!-- model footer -->
        <div class="modal-footer">
        <p>
        <button type="button" class="btn btn-primary">Add Account</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
          </p>
        </div>
      </div>
      
    </div>
  </div>
  </br>
  </br>
</article>

 



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>





















