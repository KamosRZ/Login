package com.fmiproject.login.dto;

import java.io.Serializable;

public class Game implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gameID;
	private Long stateID;
	/**
	 * @return the gameID
	 */
	public String getGameID() {
		return gameID;
	}
	/**
	 * @param gameID the gameID to set
	 */
	public void setGameID(String gameID) {
		this.gameID = gameID;
	}
	/**
	 * @return the stateID
	 */
	public Long getStateID() {
		return stateID;
	}
	/**
	 * @param stateID the stateID to set
	 */
	public void setStateID(Long stateID) {
		this.stateID = stateID;
	}
}
