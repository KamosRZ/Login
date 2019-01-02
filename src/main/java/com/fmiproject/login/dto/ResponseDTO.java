package com.fmiproject.login.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Data data;
	private String errors;
	/**
	 * @return the game
	 */
	public Data getData() {
		return data;
	}
	/**
	 * @param game the game to set
	 */
	public void setData(Data data) {
		this.data = data;
	}
	/**
	 * @return the errors
	 */
	public String getErrors() {
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	public void setErrors(String errors) {
		this.errors = errors;
	}
}
