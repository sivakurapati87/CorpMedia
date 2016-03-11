package com.intuiture.corp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

import com.intuiture.corp.bean.FileBean;

@CrossOrigin
@RestController
@RequestMapping("/LoginController")
public class LoginController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("imageValue") String imageValue) throws IOException {
		String fileName = null;
		BufferedOutputStream buffStream = null;
		try {
			byte[] bytes = new BASE64Decoder().decodeBuffer(imageValue.split(",")[1]);

			File newFile = new File("D:\\" + "sivakur.png");
			buffStream = new BufferedOutputStream(new FileOutputStream(newFile));
			buffStream.write(bytes);
			if (buffStream != null) {
				buffStream.close();
			}
		} catch (Exception e) {
			return "You failed to upload " + fileName + ": " + e.getMessage();
		}
		return "";
	}

	//
	// @RequestMapping(value = "/download", method = RequestMethod.GET)
	// public void download(final HttpServletRequest request, final
	// HttpServletResponse response) {
	//
	// File file = new File("D:\\example.pdf");
	// try (InputStream fileInputStream = new FileInputStream(file);
	// OutputStream output = response.getOutputStream();) {
	//
	// response.reset();
	//
	// response.setContentType("application/octet-stream");
	// response.setContentLength((int) (file.length()));
	//
	// response.setHeader("Content-Disposition", "attachment; filename=\"" +
	// file.getName() + "\"");
	//
	// // IOUtils.copyLarge(fileInputStream, output);
	// output.flush();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// }

	public static String getInputStream() {
		String inputStreamToString = null;
		try {
			File initialFile = new File("\\" + "siva.png");
			InputStream inputStream = new FileInputStream(initialFile);
			inputStreamToString = new BASE64Encoder().encode(IOUtils.toByteArray(inputStream));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inputStreamToString;

	}

	@RequestMapping(value = "/previewFile", method = RequestMethod.GET)
	public @ResponseBody FileBean previewFile() {
		FileBean bean = new FileBean();
		try {
			bean.setStrInputStream(getInputStream());
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return bean;
	}
	// @RequestMapping(value = "/previewPDF", method = RequestMethod.GET,
	// produces = "application/pdf")
	// public ResponseEntity<byte[]> getPDF() {
	// FileInputStream fileStream;
	// try {
	// fileStream = new FileInputStream(new File("D:\\example.pdf"));
	// byte[] contents = IOUtils.toByteArray(fileStream);
	// HttpHeaders headers = new HttpHeaders();
	// headers.setContentType(MediaType.parseMediaType("application/pdf"));
	// String filename = "test.pdf";
	// headers.setContentDispositionFormData(filename, filename);
	// ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents,
	// headers, HttpStatus.OK);
	// return response;
	// } catch (FileNotFoundException e) {
	// System.err.println(e);
	// } catch (IOException e) {
	// System.err.println(e);
	// }
	// return null;
	// }
}
