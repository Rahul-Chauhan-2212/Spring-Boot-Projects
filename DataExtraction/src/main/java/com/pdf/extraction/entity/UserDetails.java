package com.pdf.extraction.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {
	
	@JsonProperty("Id Number")
	private Detail IdNumber;
	private Detail FullName;
	private Detail PassportId;
	private Detail Nationality;
	private Detail Address;
	public UserDetails() {
		
	}
	
	public Detail getIdNumber() {
		return IdNumber;
	}

	public void setIdNumber(Detail idNumber) {
		IdNumber = idNumber;
	}

	public Detail getFullName() {
		return FullName;
	}

	public void setFullName(Detail fullName) {
		FullName = fullName;
	}

	public Detail getPassportId() {
		return PassportId;
	}

	public void setPassportId(Detail passportId) {
		PassportId = passportId;
	}

	public Detail getNationality() {
		return Nationality;
	}

	public void setNationality(Detail nationality) {
		Nationality = nationality;
	}

	public Detail getAddress() {
		return Address;
	}

	public void setAddress(Detail address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "UserDetails [IdNumber=" + IdNumber + ", FullName=" + FullName + ", PassportId=" + PassportId
				+ ", Nationality=" + Nationality + ", Address=" + Address + "]";
	}
	
	


}
