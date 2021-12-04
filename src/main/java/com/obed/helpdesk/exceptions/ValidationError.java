package com.obed.helpdesk.exceptions;

import java.util.ArrayList;
import java.util.List;

import helpdesk.exceptions.StandError;

public class ValidationError extends StandError   {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message ) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
