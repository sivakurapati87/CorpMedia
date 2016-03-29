 <script>
    $(function(){

        $("#typed").typed({
            // strings: ["Typed.js is a <strong>jQuery</strong> plugin.", "It <em>types</em> out sentences.", "And then deletes them.", "Try it out!"],
            stringsElement: $('#typed-strings'),
            typeSpeed: 150,
            backDelay: 500,
            loop: true,
            contentType: 'html', // or text
            // defaults to false for infinite loop
            loopCount: false,
            callback: function(){ foo(); },
            resetCallback: function() { newTyped(); }
        });

        $(".reset").click(function(){
            $("#typed").typed('reset');
        });

    });

    function newTyped(){ /* A new typed object */ }

    function foo(){ console.log("Callback"); }

    </script>
    <style>
        /* code for animated blinking cursor */
        .typed-cursor{
            opacity: 1;
            font-weight: 100;
            -webkit-animation: blink 0.7s infinite;
            -moz-animation: blink 0.7s infinite;
            -ms-animation: blink 0.7s infinite;
            -o-animation: blink 0.7s infinite;
            animation: blink 0.7s infinite;
        }
        @-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-webkit-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-moz-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-ms-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
        @-o-keyframes blink{
            0% { opacity:1; }
            50% { opacity:0; }
            100% { opacity:1; }
        }
    </style>

<div class="container-fluid"
	style="width: 100%;background-image: url('resources/images/finance.png'); background-repeat: no-repeat; background-size: cover; height: 696px">
	<table class="table" border="0">
	<tr style="height: 100px"></tr>
	<tr>
	<td colspan="2" align="center">
	<label class="lable60_blue">Payz</label>
	<label class="lable60_green">Payz  </label>
	</td>
	</tr>
	<tr>
		<td>
				<div class="log">
				<form action="post">
					<div style="width: 100%;height:20px; "></div>
					<div class="row2">
						
							<label >Email address</label>
   							 <input type="text" class="form-control"  placeholder="Email" required="required" title="Enter a Valied E-mail Id" 
   							 pattern="^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,50}" maxlength="49"
   							 >
						
						
					</div>
					<div style="width: 100%;height:20px; "></div>
					<div class="row2">
						
							<label >Password</label>
   							 <input type="password" class="form-control"  placeholder="password">
						
						
					</div>
					<div style="width: 100%;height:20px; "></div>
					<div class="row2 center">
						<input type="submit" value="Submit" class="btn btn-success lrspace_10">  
						<input type="button" value="Reset" class="btn btn-primary lrspace_10">
						
												
						
					</div>
					</form>
				</div>
		</td>
	</tr>
		<!-- <tr>
			<td width="100%" style="padding-top: 60px" align="center">
				<table border="0" style="width: 70%;" >
					<tr>
						<td width="100%" class="searchBg">
							<form class="box" name="myForm">
								<table style="width: 96%;" align="center">
								
								<tr style="height: 15px"></tr>
									<tr>
										<td style="height: 30px; padding-left: 25px" width="80%" >
											<div angucomplete-alt id="companiesId" class="lable16"
												placeholder="Enter a company to search " pause="100"
												selected-object="selectedCompanyAction"
												 search-fields="companyName"
												title-field="companyName" minlength="2"
												remote-url = "http://localhost:8080/CorpMediaService/CompanyController/findCompanyByName/"
												input-class="search-control height46 lable42 "
												match-class="highlight"></div>
										</td>
										<td align="right">
											<a ui-sref="company_legalentities.mainInfo({legEntity:'cmpInfo'})">
											<button  value="Search" ng-disabled = "selectedCompany == null" 
												class=" form-control btn  btn-sm height46 lable16" style="background: #13ef18;">
												<span class="glyphicon glyphicon-search" style="font-size: 18px"></span> 
												<span class="lable18">Search</span>
											</button></a>
										</td>
									</tr>
									<tr style="height: 15px"></tr>
								</table>
							</form>
						</td>
					</tr>
				</table>
		</td>
		</tr> -->
		<tr style="height: 60px;"></tr>
		<tr>
			<td align="center" width="100%">
				<table border="0" width="100%">
					<tr>
						<td class="type-wrap lable42" align="right" width="50%">
							<table>
								<tr>
									<td><span class="glyphicon glyphicon-thumbs-up"
										style="color: grey;"></span></td>
										<td width="5px"></td>
									<td><label style="color: #8d8d8d; font-size: 42;">Know
									</label></td>
								</tr>
							</table>
						</td>
						<td width="1%"></td>
						<td>
							<div class="type-wrap lable42">

								<div id="typed-strings">
									<p><label style="color: #b5bde1;"> More</label></p>
									<p><label style="color: #ffcf9f;"> Faster</label></p>
									<p><label style="color: #b5bde1;"> Relevant</label></p>
									<p><label style="color: #ffcf9f;"> Accurate</label></p>
								</div>
								<span id="typed" style="white-space: pre;"></span>
							</div>
							<div style="clear: both;"></div>
						</td>
					</tr>
				</table>
				


			</td>
		</tr>
	</table>
</div>

