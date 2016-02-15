


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
								    <li ng-class="{'active':(state==='web_clock_in')}"><a
										class="anchor-sm" ui-sref="web_clock_in">Web Clock-in</a></li>
									<li ng-class="{'active':(state==='wfh')}"><a
										class="anchor-sm" ui-sref="wfh">WFH</a></li>				


								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0"
					style="width: 100%; background-color: white">
					<tr>
						<td>


							<div class="container">
<h4>Create Timing Policy</h4>
<p>You can specify Timing policies here. These can be assigned to specific location. The default Timing policies applies to a location when not explicitly set.</p>
 </br>
</br>
 

  <form class="form-horizontal" role="form">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Policy Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <div class="col-sm-5">
        <input type="email" class="form-control" id="email" placeholder="Eg: Hyderabad Time policy">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Late Attendence&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
      <div class="col-sm-10">          
        <!-- <input type="password" class="form-control" id="pwd" placeholder="Enter password"> -->
        <form role="form">
    <div class="radio">
      <label><input type="radio" name="optradio">Ignore late attendance</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="optradio">Deduct leave</label>
    </div>
  </form>
      </div>
    </div>
  </form>
</div>

<p sty>
  <button type="button" class="btn btn-primary">Create</button>
  <button type="button" class="btn btn-default">Cancel</button>
</p>



						</td>
					</tr>


























				</table>
			</td>
		</tr>
	</table>
</div>






























