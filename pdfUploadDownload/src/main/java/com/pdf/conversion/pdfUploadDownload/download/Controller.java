package com.pdf.conversion.pdfUploadDownload.download;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdf.conversion.pdfUploadDownload.upload.Upload;

@RestController
public class Controller {
	
	@Autowired
	Download download;  
	
	@Autowired
	Upload upload;
	
	@GetMapping("/downloadPDF")
	public String downloadPDF()
	{
		download.downloadPDF();
		
		return "PDF Downloaded";
	}
	
	@GetMapping("/uploadPDF")
	public String uploadPDF()
	{		
		return upload.uploadPDF();
	}

}
