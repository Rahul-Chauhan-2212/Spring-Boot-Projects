package com.pdf.extraction.entity;

public class Detail {
	
	private String value;
	private String score;
	private String valueType;
	public Detail() {
		
	}
	
	public Detail(String value, String score, String valueType) {
		this.value = value;
		this.score = score;
		this.valueType = valueType;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
	@Override
	public String toString() {
		return "Detail [value=" + value + ", score=" + score + ", valueType=" + valueType + "]";
	}
	
	
	

}
