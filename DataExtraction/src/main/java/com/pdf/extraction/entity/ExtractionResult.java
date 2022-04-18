package com.pdf.extraction.entity;

import java.util.List;


public class ExtractionResult {
	
	private int code;
	private String message;
	private String referenceId;
	private ExtractInfo extractInfo;
	private List<Results> results;
	
	public ExtractionResult() {
		
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public ExtractInfo getExtractInfo() {
		return extractInfo;
	}
	public void setExtractInfo(ExtractInfo extractInfo) {
		this.extractInfo = extractInfo;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "ExtractionResult [code=" + code + ", message=" + message + ", referenceId=" + referenceId + "]";
	}
	
	
	
	
	
	
	

}
