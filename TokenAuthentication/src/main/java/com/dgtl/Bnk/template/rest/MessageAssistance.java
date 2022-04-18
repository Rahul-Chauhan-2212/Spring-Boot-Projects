package com.dgtl.Bnk.template.rest;

import java.io.Serializable;

public interface MessageAssistance extends Serializable{
	
	public String getProcessId();
	public void setProcessId(String processId);
	public String getTaskId();
	public void setTaskId(String taskId);

}
