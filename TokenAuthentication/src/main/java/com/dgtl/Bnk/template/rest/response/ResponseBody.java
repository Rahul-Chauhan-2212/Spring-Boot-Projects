package com.dgtl.Bnk.template.rest.response;

import com.dgtl.Bnk.template.rest.MessageBody;

public class ResponseBody implements MessageBody {
	
private static final long serialVersionUID = -1421422364479857598L;
	
	String bodyString =null;
	
	Object bodyObject=null;

	public ResponseBody() {
		
	}

	public String getBodyString() {
		return bodyString;
	}

	public void setBodyString(String bodyString) {
		this.bodyString = bodyString;
	}

	public Object getBodyObject() {
		return bodyObject;
	}

	public void setBodyObject(Object bodyObject) {
		this.bodyObject = bodyObject;
	}

	@Override
	public String toString() {
		return "ResponseBody [bodyString=" + bodyString + ", bodyObject=" + bodyObject + "]";
	}
	

}
