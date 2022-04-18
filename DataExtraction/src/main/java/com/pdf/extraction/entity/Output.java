package com.pdf.extraction.entity;

import java.util.List;

public class Output {
	
	private List<UserDetails> CPR;

	public Output() {
		
	}

	public List<UserDetails> getCPR() {
		return CPR;
	}

	public void setCPR(List<UserDetails> cPR) {
		CPR = cPR;
	}

	@Override
	public String toString() {
		return "Output [CPR=" + CPR + "]";
	}
	
	
	
	
	
	
   

}
