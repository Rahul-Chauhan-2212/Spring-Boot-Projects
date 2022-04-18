package com.dgtl.Bnk.template.rest.request;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dgtl.Bnk.template.rest.MessageBody;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class RequestBody implements MessageBody {

	private static final long serialVersionUID = -5515740504267159363L;

	String requestBodyString = null;
	Object requestBodyParsed = null;

	@JsonIgnore
	transient private List<MultipartFile> files = null;

	@JsonIgnore
	transient private List<File> filesConverted = null;

	Serializable requestBodyObject = null;

	public RequestBody(RequestBody body) {
		this.requestBodyString=body.requestBodyString;
		this.requestBodyObject=body.requestBodyObject;
		this.files=body.getFiles();
		this.filesConverted=body.getFilesConverted();

	}

	public String getRequestBodyString() {
		return requestBodyString;
	}

	public void setRequestBodyString(String requestBodyString) {
		this.requestBodyString = requestBodyString;
	}

	public Object getRequestBodyParsed() {
		return requestBodyParsed;
	}

	public void setRequestBodyParsed(Object requestBodyParsed) {
		this.requestBodyParsed = requestBodyParsed;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<File> getFilesConverted() {
		return filesConverted;
	}

	public void setFilesConverted(List<File> filesConverted) {
		this.filesConverted = filesConverted;
	}

	public Serializable getRequestBodyObject() {
		return requestBodyObject;
	}

	public void setRequestBodyObject(Serializable requestBodyObject) {
		this.requestBodyObject = requestBodyObject;
	}

	@Override
	public String toString() {
		return "RequestBody [requestBodyString=" + requestBodyString + "]";
	}
	
	

}
