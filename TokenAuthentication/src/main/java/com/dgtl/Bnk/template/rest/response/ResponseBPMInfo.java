package com.dgtl.Bnk.template.rest.response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.dgtl.Bnk.template.rest.MessageAssistance;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ResponseBPMInfo implements MessageAssistance {

	private static final long serialVersionUID = -3112074339671044518L;

	@JsonInclude(Include.NON_NULL)
	private String processId;

	@JsonInclude(Include.NON_NULL)
	private String taskId;

	@JsonInclude(Include.NON_NULL)
	private String nextPage;

	@JsonInclude(Include.NON_NULL)
	private String type;

	@Override
	public String getProcessId() {
		return processId;
	}

	@Override
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	@Override
	public String getTaskId() {
		return taskId;
	}

	@Override
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ResponseBPMInfo [processId=" + processId + ", taskId=" + taskId + ", nextPage=" + nextPage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nextPage == null) ? 0 : nextPage.hashCode());
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseBPMInfo other = (ResponseBPMInfo) obj;
		if (nextPage == null) {
			if (other.nextPage != null)
				return false;
		} else if (!nextPage.equals(other.nextPage))
			return false;
		if (processId == null) {
			if (other.processId != null)
				return false;
		} else if (!processId.equals(other.processId))
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		return true;
	}
	
	

}
