package com.ibm.manageCurrency.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class APIResponse {

	public static final String STATUS_SUCCESS = "SUCCESS";
	public static final String STATUS_ERROR = "ERROR";

	private String status;
	private String errorMessage;
	private Object errDetails;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errMsg) {
		this.errorMessage = errMsg;
	}

	public Object getErrDetails() {
		return errDetails;
	}

	public void setErrDetails(Object errDetails) {
		this.errDetails = errDetails;
	}

}
