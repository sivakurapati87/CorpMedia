


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

							 
            
 <div class="panel panel-default">
                    <div class="panel-body">

                        <div class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
                            <div class="col-lg-12">

                                            <h4>Welcome Screen</h4>
                                            <p class="page-description ng-scope" data-ng-if="!vm.id">This screen is visible when an employee logged into the Keka for the first time and will be visible until he/she completes onboarding tasks.</p>
                                           


                                                    <div class="add-new">
                                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 clear-side-padding">
                                                            <div class="col-lg-2 col-md-4 col-sm-4 col-xs-12 clear-side-padding"  ng-app="approver">
                                                        
                                                                </br>
                                                                <div class="col-sm-6 welcome-screen-container clear-bottom center-block clear-side-padding">
        <div class="form-group">
            <label>Welcome Message</label>
            <textarea data-set-focus="true" rows="5" class="form-control ng-pristine ng-valid ng-touched" data-ng-model="vm.welcomeMessage"></textarea>
        </div>
        <div class="form-group">

            <p>Contacts to assit new joinees</p>
            <p class="welcome-screen-container-sub-label">These contacts will be shown on the welcome screen to assist new joinees.</p>
<!-- add new button. -->
<!-- <button id="btn2" class="add-approver"><i class="fa fa-plus-square"></i>Add New</button> -->



<button type="button" class="add-approver" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus-square"></i>Add New</button>
<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
<!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add Employee</h4>
        </div>
        <div class="modal-body">
          

<input type="text" class="form-control" placeholder="Start typing employee name"/>

        </div>
        <div class="modal-footer">
        <input type="button" class="btn btn-submit" value="ADD">
          <button type="button" class="btn btn-info btn-lg" value="Preview" style="border-radius:1px;font-size: 12px;margin-right: 10px;padding: 10px 15px 10px 15px" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
         <div class="col-lg-12 clear-side-padding add-new">
                <!-- <a class="" data-ng-click="addEmployees();"><span class="icon-plus-circle"></span>Add New</a> -->
            </div>
                    </div>
                </div><!-- end ngRepeat: contact in vm.helpDeskMembers -->
            </div><!-- end ngIf: vm.helpDeskMembers.length != 0 -->

        </div>



        <div class="clear-element">

        <p>
           
             <input type="button" class="btn btn-submit" value="Save">
             <input type="button" class="btn btn-info btn-lg" value="Preview" style="border-radius:1px;font-size: 12px;margin-right: 10px;padding: 10px 15px 10px 15px">
            </p>
        </div>
    </div>



 </div>
 </div>
 </div>
 </div>
 



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>






































