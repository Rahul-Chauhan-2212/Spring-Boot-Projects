package com.pdf.extraction.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdf.extraction.entity.Detail;
import com.pdf.extraction.entity.ExtractInfo;
import com.pdf.extraction.entity.ExtractionResult;
import com.pdf.extraction.entity.Output;
import com.pdf.extraction.entity.Results;
import com.pdf.extraction.entity.UserDetails;

@RestController
public class ExtractionController {

	private static ExtractionResult extRslt = new ExtractionResult();
	private static ExtractInfo extInfo = new ExtractInfo();
	private static List<Results> rslt= new ArrayList<Results>();
	private static Results rslts = new Results();
	private static Output output = new Output();
	private static List<UserDetails> usrs = new ArrayList<UserDetails>();
    private static UserDetails usrDtls = new UserDetails();
    
	
	static {
		extInfo.setCreatedTime(java.util.Calendar.getInstance());
		extInfo.setExtractedFiles(1);
		extInfo.setNotExtractedFiles(0);
	}
	
	static {
		
		usrDtls.setIdNumber(new Detail("237893849","90.56","text"));
		usrDtls.setFullName(new Detail("Rahul Chauhan","93.67","text"));
		usrDtls.setPassportId(new Detail("1536388","94.75","text"));
		usrDtls.setNationality(new Detail("Indian","64.65","text"));
		usrDtls.setAddress(new Detail("Tundla, Firozabad","64.65","text"));
	}
	
	static {
		usrs.add(usrDtls);
	}
	
	static {
		output.setCPR(usrs);
	}
	
	static {
		rslts.setDietDocumentId("27723u389");
		rslts.setStatus("SUCCESS");
		rslts.setFileName("CPR.pdf");
		rslts.setOutput(output);
		
	}
	
	static {
		rslt.add(rslts);
	}
	
	static {
		
		extRslt.setCode(0);
		extRslt.setMessage("SUCCESS");
		extRslt.setReferenceId("1296899");
		extRslt.setExtractInfo(extInfo);
		extRslt.setResults(rslt);
		
	}

	
	
	
	@GetMapping("/getData")
	public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>(extRslt, HttpStatus.OK);
	   }
	
}
