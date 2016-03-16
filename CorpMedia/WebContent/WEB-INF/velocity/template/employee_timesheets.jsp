
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
			<td valign="top"><employee-info-top></employee-info-top>
				<table class="table" border="1"
					style="width: 100%; background-color: white">
					<tr>
						<td>
							<div
								class="col-lg-4 col-md-4 col-sm-5 clear-side-padding ng-scope">
								<span class="fa fa-arrow-circle-left fa-2x"
									ng-click="previousWeek(weekDays[0])"></span> <span
									class="labelfont_16">{{week_StartAndEndDays}}</span> <span
									class="fa fa-arrow-circle-right fa-2x"
									ng-click="nextWeek(weekDays[6])"></span>
							</div>
						</td>
					</tr>
				</table></td>
		</tr>
	</table>
</div>
