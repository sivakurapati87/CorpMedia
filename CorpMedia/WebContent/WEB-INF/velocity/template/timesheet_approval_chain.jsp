<script>
$(document).ready(function(){
    // $("#btn1").click(function(){                 This is currently of no use.
    //     $("p").append(" <b>Appended text</b>.");
    // });
// whenever this is pressed a new form is generated after element which possess id as kappa.
    $("#btn2").click(function(){
        $(kappa).append("<br><br><input type=text class=form-control><br>");
    });
});
</script>


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
						<td>
     
     <div class="panel-body">

                        <div class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
                            <div class="col-lg-12">


                                <div class="ng-scope" data-ui-view="">

                                    <div class="row ng-scope">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 approver-hierarchy" data-ng-class="{'vertical-margin': vm.id }">

                                            <h4 class="page-heading" data-ng-class="{'clear-top-margin': vm.id }">Approval Chain</h4>
                                            <p class="page-description ng-scope" data-ng-if="!vm.id">This is the default timesheet approval chain. When a new project is created, then this approval chain is applied by default</p>
                                            <div class="row">
                                                <div class="col-md-4">


                                                    <div class="add-new">
                                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 clear-side-padding">
                                                            <div class="col-lg-2 col-md-4 col-sm-4 col-xs-12 clear-side-padding">
                                                                <!--  -->
                                                                <button id="btn2" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span>Add Approver level</button>
                                                               

                                                                <br>
                                                                <br>
                                                                <!-- here to append -->

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <p><i class="fa fa-users"></i>Role Based</p>
                                                </div>
                                                <div class="col-md-4"> 
                                                    <p><i class="fa fa-user"></i>Employees</p>
                                                </div>
                                            </div>  
                                            <!-- this is the end of row -->
                                            <p id="kappa"></p>
                                            <input type=button class='btn btn-submit' value=Update>
                                            <br>
                                            <br>
                                            <br>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- this is plug and chug. -->
                    </div>
     
     </td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>








































