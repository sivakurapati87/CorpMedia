
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
				<table>
					<tr>
						<td>
							<div ng-show="imageCropStep == 1">
								<br /> <input type="file" name="fileInput" id="fileInput"
									onchange="angular.element(this).scope().fileChanged(event)" />
							</div>

							<div ng-show="imageCropStep == 2">
								<image-crop data-height="400" data-width="400"
									data-shape="square" data-step="imageCropStep" src="imgSrc"
									data-result="result" data-result-blob="resultBlob"
									crop="initCrop" padding="250" max-size="1024"></image-crop>
							</div>

							<div ng-show="imageCropStep == 2">
								<br />
								<button ng-click="clear()">Cancel</button>
								<button ng-click="initCrop = true">Crop</button>
							</div>

							<div ng-show="imageCropStep == 3">
								<button ng-click="upload()">upload</button>
								<h2>Result</h2>
								<img ng-src="{{result}}"></img>
								<p>The Base64 String used in the image above:</p>
								<textarea class="result-datauri">{{ result }}</textarea>
								<button ng-click="clear()">Clear</button>

							</div>
						</td>
					</tr>
					<tr>
						<td><img ng-src="{{'data:image/png;base64,'+baseEncodedObj}}" ></td>
					</tr>
				</table></td>
		</tr>
	</table>
</div>
















