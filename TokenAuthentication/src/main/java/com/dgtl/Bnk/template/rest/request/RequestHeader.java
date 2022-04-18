package com.dgtl.Bnk.template.rest.request;

import com.dgtl.Bnk.template.rest.MessageHeader;

public class RequestHeader implements MessageHeader {

	private static final long serialVersionUID = -1236973524649326535L;

	private String requestId;

	private String authenticationToken;

	private String csrfToken;

	private int entity;

	private String language;

	private String hashToken;

	public RequestHeader() {

	}

	public RequestHeader(RequestHeader requestHeader) {
		this.requestId = requestHeader.getRequestId();
		this.authenticationToken = requestHeader.getAuthenticationToken();
		this.csrfToken = requestHeader.getCsrfToken();
		this.entity = requestHeader.getEntity();
		this.language = requestHeader.getLanguage();
		this.hashToken = requestHeader.getCsrfToken();
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	public String getCsrfToken() {
		return csrfToken;
	}

	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}

	public int getEntity() {
		return entity;
	}

	public void setEntity(int entity) {
		this.entity = entity;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHashToken() {
		return hashToken;
	}

	public void setHashToken(String hashToken) {
		this.hashToken = hashToken;
	}

	@Override
	public String toString() {
		return "RequestHeader [requestId=" + requestId + ", authenticationToken=" + authenticationToken + ", csrfToken="
				+ csrfToken + ", entity=" + entity + ", language=" + language + ", hashToken=" + hashToken + "]";
	}

	
	
}
