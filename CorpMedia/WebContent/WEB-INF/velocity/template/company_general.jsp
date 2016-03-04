 <script>
       function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah')
                    .attr('src', e.target.result)
                    .width(100)
                    .height(60);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
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
									<li ng-class="{'active':(state==='legalentities')}"><a
										class="anchor-sm"
										ui-sref="company_legalentities.mainInfo({legEntity:'cmpInfo'})">Legal
											Entities</a></li>
									<li ng-class="{'active':(state==='general')}"><a
										class="anchor-sm" ui-sref="company_general">General Info</a></li>
									<li ng-class="{'active':(state==='locations')}"><a
										class="anchor-sm" ui-sref="company_locations">Locations</a></li>
									<li ng-class="{'active':(state==='department')}"><a
										class="anchor-sm" ui-sref="company_department">Departments</a>
									</li>
										
									
								</ul>
							</div>
						</td>
					</tr>
				</table>
				<table class="table" border="0" style="width: 100%;background-color: white">
					<tr>
						<td><br><br>
        <p><b><font size='3'>Company Info</font></b></p>
        <p><font size='2'>Information about the company</font></p>
        <br>
        <form class='form' method="get" action="">
            <label for='company_name'>Short Name</label>
            <input type='text' class='form-control' id='company_name' style="width: 500px">
       <br>
       <p><b>Label</b></p>
       
       <div class='row'>
           <div class='col-sm-2'>
               
               
               <img id="blah" src="#" alt="Logo" />
               
    
           </div>
<!--           <div class='col-sm-1'></div>-->
           <div class='col-sm-1'>
               <input type='file' onchange="readURL(this);"/>
               <!--<input type='file' style="color: blue" ng-model="logo">-->
           </div>
           <div class='col-sm-9'></div>
           
       
          
       
       
       </div>
       
      
       
       
       <p><i><font size='2'>Note: Upload an image of dimensions 100*60 otherwise the image will be resized</font></i></p>
       <br>
       <button class='btn btn-success'>Update</button>
       </form></td>
					</tr>
					
				</table>
			</td>
		</tr>

	</table>


</div>













