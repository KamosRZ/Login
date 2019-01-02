package com.fmiproject.login.dto;

import java.io.Serializable;

public class JoinGameDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long playerID;
	
	public JoinGameDTO(Long playerID) {
		super();
		this.playerID = playerID;
	}
	
	public Long getPlayerID() {
		return playerID;
	}

	public void setPlayerID(Long playerID) {
		this.playerID = playerID;
	}
}
