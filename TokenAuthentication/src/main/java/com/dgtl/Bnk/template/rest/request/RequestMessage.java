package com.dgtl.Bnk.template.rest.request;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.dgtl.Bnk.template.rest.Message;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RequestMessage implements Message {

	private static final long serialVersionUID = -3638977004272896261L;

	private RequestHeader header;

	private RequestBody body;

	private RequestBPMInfo bpmInfo;

	public RequestMessage() {

	}

	public RequestMessage(RequestMessage message) {
		this.header = message.getHeader();
		this.body = message.getBody();
		this.bpmInfo = message.getBpmInfo();
	}

	public RequestHeader getHeader() {
		return header;
	}

	public void setHeader(RequestHeader header) {
		this.header = header;
	}

	public RequestBody getBody() {
		return body;
	}

	public void setBody(RequestBody body) {
		this.body = body;
	}

	public RequestBPMInfo getBpmInfo() {
		return bpmInfo;
	}

	public void setBpmInfo(RequestBPMInfo bpmInfo) {
		this.bpmInfo = bpmInfo;
	}

	@Override
	public String toString() {
		return "RequestMessage [header=" + header + ", body=" + body + ", bpmInfo=" + bpmInfo + "]";
	}

}
