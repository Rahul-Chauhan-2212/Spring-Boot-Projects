package com.dgtl.Bnk.template.rest.response;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.dgtl.Bnk.template.rest.Message;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
@JsonPropertyOrder({"header","body"})
public class ResponseMessage implements Message{

	private static final long serialVersionUID = 4145660521112818758L;

	@JsonInclude(Include.NON_NULL)
	private ResponseHeader header;
	
	private Serializable body;
	
	@JsonInclude(Include.NON_NULL)
	private ResponseBPMInfo bpmInfo;

	public ResponseMessage() {
		
	}

	public ResponseMessage(ResponseHeader header) {
		this.header = header;
	}

	public ResponseHeader getHeader() {
		return header;
	}

	public void setHeader(ResponseHeader header) {
		this.header = header;
	}

	public Serializable getBody() {
		return body;
	}

	public void setBody(Serializable body) {
		this.body = body;
	}

	public ResponseBPMInfo getBpmInfo() {
		return bpmInfo;
	}

	public void setBpmInfo(ResponseBPMInfo bpmInfo) {
		this.bpmInfo = bpmInfo;
	}

	@Override
	public String toString() {
		return "ResponseMessage [header=" + header + ", body=" + body + ", bpmInfo=" + bpmInfo + "]";
	}
	
	
	
	

}
