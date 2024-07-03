package com.lec12.web;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String ctlFileUpload(Model model, @RequestParam("ufile") MultipartFile file) {

		// 파일명, 크기, 확장자, 시스템파일명(유니크)
		String fileRealName 	= file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
		long size 				= file.getSize(); //파일 사이즈
		String fileExtension 	= fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		String uniqueName 		= UUID.randomUUID().toString().split("-")[0];
		
		
		String uploadFolder = "C:\\KOSTA\\S3917_J11\\workspace_sts3\\uploads";
		String filePath = uploadFolder + "\\" + uniqueName + fileExtension;
	
		FileVO fvo = new FileVO();
		fvo.setFpath(filePath);
//		fvo.setFseq(0);
		fvo.setFsize(size);
		fvo.setOname(fileRealName);
		fvo.setSeq(1);
		fvo.setSname(uniqueName + fileExtension);
		

		System.out.println(fvo.toString());
		

		
		// file copy
		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "lec12_file/file_upload_result";
	}


}
