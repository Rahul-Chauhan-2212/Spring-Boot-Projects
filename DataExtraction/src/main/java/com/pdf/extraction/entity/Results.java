package com.pdf.extraction.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"DIETDocumentId","status","fileName","output"})
public class Results {

	@JsonProperty("DIETDocumentId")
	private String dietDocumentId;
	
	@JsonProperty("fileName")
	private String fileName;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("output")
	private Output output;
	public Results() {
		
	}
	public String getDietDocumentId() {
		return dietDocumentId;
	}
	public void setDietDocumentId(String dietDocumentId) {
		this.dietDocumentId = dietDocumentId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output output) {
		this.output = output;
	}
	@Override
	public String toString() {
		return "Results [dietDocumentId=" + dietDocumentId + ", fileName=" + fileName + ", status=" + status + "]";
	}
	
	
	
	
	
}
