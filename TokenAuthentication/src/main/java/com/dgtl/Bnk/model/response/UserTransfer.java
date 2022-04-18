package com.dgtl.Bnk.model.response;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;

public class UserTransfer {

	private String username;
	private List<String> roles;
	private String authToken;
	private String csrfToken;
	private HttpStatus status;

	public UserTransfer(String username, List<String> roles, String token, String csrfToken, HttpStatus status) {
		this.roles = roles;
		this.authToken = token;
		this.csrfToken = csrfToken;
		this.username = username;
		this.status = status;
	}

	public UserTransfer() {
		this.authToken = "";
		this.csrfToken = "";
		this.username = "";
		this.roles = Collections.emptyList();
		this.status = HttpStatus.NOT_FOUND;
	}

	public List<String> getRoles() {
		return this.roles;
	}

	public String getAuthToken() {
		return this.authToken;
	}
	public String getCsrfToken() {
		return this.csrfToken;
	}

	public String getUsername() {
		return this.username;
	}

	public HttpStatus getStatus() {
		return this.status;
	}

}
