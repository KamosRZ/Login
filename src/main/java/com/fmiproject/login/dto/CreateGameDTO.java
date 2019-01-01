package com.fmiproject.login.dto;

import java.io.Serializable;

public class CreateGameDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long playerID;
	private Long playerRoleID;
	
	public CreateGameDTO(Long playerID, Long playerRoleID) {
		super();
		this.playerID = playerID;
		this.playerRoleID = playerRoleID;
	}
	
	/**
	 * @return the playerID
	 */
	public Long getPlayerID() {
		return playerID;
	}
	/**
	 * @param playerID the playerID to set
	 */
	public void setPlayerID(Long playerID) {
		this.playerID = playerID;
	}
	/**
	 * @return the playerRoleID
	 */
	public Long getPlayerRoleID() {
		return playerRoleID;
	}
	/**
	 * @param playerRoleID the playerRoleID to set
	 */
	public void setPlayerRoleID(Long playerRoleID) {
		this.playerRoleID = playerRoleID;
	}
}
