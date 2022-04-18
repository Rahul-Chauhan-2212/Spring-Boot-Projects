package com.pdf.extraction.entity;

import java.time.LocalDateTime;
import java.util.Calendar;

public class ExtractInfo {

	private Calendar createdTime;
	private int extractedFiles;
	private int notExtractedFiles;
	public ExtractInfo() {
		
	}
	public Calendar getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}
	public int getExtractedFiles() {
		return extractedFiles;
	}
	public void setExtractedFiles(int extractedFiles) {
		this.extractedFiles = extractedFiles;
	}
	public int getNotExtractedFiles() {
		return notExtractedFiles;
	}
	public void setNotExtractedFiles(int notExtractedFiles) {
		this.notExtractedFiles = notExtractedFiles;
	}
	@Override
	public String toString() {
		return "ExtractInfo [createdTime=" + createdTime + ", extractedFiles=" + extractedFiles + ", notExtractedFiles="
				+ notExtractedFiles + "]";
	}
	
	
	
	
	
}
