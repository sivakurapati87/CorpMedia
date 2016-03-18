 <script>
$(document).ready(function(){
  // $(replacedwith).hide();
    $("#btn2").click(function(){
        // this is the culprit if your program breaks.
        var temp='hello';
        $(replacable).fadeOut("slow");
        $(replacewith).fadeIn("slow");
        // $(noexpense).remove();
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

									<li ng-class="{'active':(state==='weekly_offs')}"><a
										class="anchor-sm" ui-sref="weekly_offs">Weekly Offs</a></li>
									<li ng-class="{'active':(state==='shifts')}"><a
										class="anchor-sm" ui-sref="shifts">Shifts</a></li>
                                    <li ng-class="{'active':(state==='timing_policies')}"><a
										class="anchor-sm" ui-sref="timing_policies">Timing Policies</a></li>	
                                    
									<li ng-class="{'active':(state==='wfh')}"><a
										class="anchor-sm" ui-sref="wfh">WFH</a></li>	

								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table mtable  " border="0"
					style="width: 100%; background-color: white">
					<tr><th class="th"><h2>WFH</h2></th> </tr><tr>
						<td>


							 <div class="panel-body">

                        <div class="col-lg-12 col-md-12 col-sm-12 sub-page-container content-container">
                            <div class="col-lg-12">


                                <div class="ng-scope" data-ui-view="">

                                    <div class="row ng-scope">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 approver-hierarchy" data-ng-class="{'vertical-margin': vm.id }">
                                       
                                         
                                            <h4 class="page-heading" data-ng-class="{'clear-top-margin': vm.id }">Work from home</h4>
                                            <p class="page-description ng-scope" data-ng-if="!vm.id">Work from home allows employees to work from home and log time using keka web application or keka mobile app.</p>
                                           <!-- here are our checkboxes -->
<div><!-- This div is for checkboxes -->
  <form role="form">
    <div class="checkbox">
      <label><input type="checkbox" value="" ng-model="parent">Enable work from home </label>
      <i class="fa fa-info-circle"></i>
</div>
&nbsp;
<span class="web-clock-in-desc">(You can override this at individual employee level in Employee profile page.)</span>
</br>
</br>
<!-- here start sub check boxes -->
<div class="row">
<div class="col-sm-0">
</div>
<div class="col-sm-12">

<div class="checkbox">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <label><input type="checkbox" value="" ng-model="child1" ng-disabled="!parent">Allow only employees who have WFH enabled in their profile </label>
</div>
<div class="checkbox">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <label><input type="checkbox" value="" ng-model="child2" ng-disabled="!parent">Require Approval from Reporting Manager or a HR Admin for WFH </label>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<span class="web-clock-in-desc">(You can override this at individual employee level in Employee profile page.)</span>
<div class="checkbox">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <label><input type="checkbox" value="" ng-model="child3" ng-disabled="!parent">Require comment when employee is applying WFH request  </label>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<span class="web-clock-in-desc">(You can override this at individual employee level in Employee profile page.)</span>
</div>
</div>
<!-- this is the end of the row. -->
<br>
<!-- This is button-->
<a href="#" class="btn btn-info btn-lg active" role="button">Save</a>
</form>


<!-- little fun with angular js
{{ parent }}
{{ child1 }} -->
    </div>
    <!-- This is the end of the checkboxes. -->

                                                    

                                        </div>
                                        
                                        

                                            </div>
                                    </div>
                                </div>
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


























