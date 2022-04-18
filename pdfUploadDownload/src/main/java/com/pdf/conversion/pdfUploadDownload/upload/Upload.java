package com.pdf.conversion.pdfUploadDownload.upload;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

@Component
public class Upload {

	   public String uploadPDF()
	   {
	      try
	      {
	    	 PdfReader reader = new PdfReader("HelloWorld.pdf"); 
	    	 String pageContent=PdfTextExtractor.getTextFromPage(reader, 1);
	         reader.close();
	         return pageContent;

	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return "Excpetion Occured";
	   }
	
}
