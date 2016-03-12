<table>
	<tr style="height: 10px"></tr>
	<tr>
		<td><h3>Emp Name : {{empName}}</h3></td>
	</tr>
	<tr style="height: 10px"></tr>
</table>
<table class="table" border="0" style="width: 100%;">
	<tr>
		<td>
			<div class="sub-page-navigation">
				<ul>

					<li ng-class="{'active':(state==='employee_professional')}"><a
						class="anchor-sm" ui-sref="employee_professional">
							Professional </a></li>
					<li ng-class="{'active':(state==='employee_personal')}"><a
						class="anchor-sm" ui-sref="employee_personal">Personal</a></li>
					<li ng-class="{'active':(state==='employee_finance')}"><a
						class="anchor-sm" ui-sref="employee_finance">Finance</a></li>
					<!-- 					<li ng-class="{'active':(state==='employee_job')}"><a -->
<!-- 						class="anchor-sm" ui-sref="employee_job">Job</a></li> -->
				</ul>
			</div>
		</td>
	</tr>
</table>