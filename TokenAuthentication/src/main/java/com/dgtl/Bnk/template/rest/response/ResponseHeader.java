package com.dgtl.Bnk.template.rest.response;

import java.util.UUID;

import com.dgtl.Bnk.template.rest.MessageHeader;

public class ResponseHeader implements MessageHeader{

	private static final long serialVersionUID = -9090223379633327435L;
	
	private UUID requestId;
	
	private Integer status;
	
	private String csrfToken;
	
	private Integer entityId;
	
	private String language;

	public ResponseHeader() {
		
	}

	public ResponseHeader(UUID requestId, Integer status, String csrfToken) {
		this.requestId = requestId;
		this.status = status;
		this.csrfToken = csrfToken;
	}

	public UUID getRequestId() {
		return requestId;
	}

	public void setRequestId(UUID requestId) {
		this.requestId = requestId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCsrfToken() {
		return csrfToken;
	}

	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "ResponseHeader [requestId=" + requestId + ", status=" + status + ", csrfToken=" + csrfToken
				+ ", entityId=" + entityId + ", language=" + language + "]";
	}
	
	

}
