package com.dgtl.Bnk.template.rest.request;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.dgtl.Bnk.template.rest.MessageAssistance;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RequestBPMInfo implements MessageAssistance {

	private static final long serialVersionUID = -928382968775365123L;

	private String processId;

	private String taskId;

	private String type;

	public RequestBPMInfo() {

	}

	public RequestBPMInfo(final RequestBPMInfo assistance) {
		this.processId = assistance.getProcessId();
		this.taskId = assistance.getTaskId();

	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		RequestBPMInfo other = (RequestBPMInfo) obj;
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
