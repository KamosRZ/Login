package com.fmiproject.login.dto;

import java.io.Serializable;

public class ListGames implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long gameID[];
	private Long stateID[];
        public static Long firstgameID;
        
	public Long[] getGameID() {
		return gameID;
	}

        public Long firstgameID() {
                return firstgameID = gameID[0];
        }

        public void setGameID(Long[] gameID) {
		this.gameID = gameID;
	}

	public Long[] getStateID() {
		return stateID;
	}

	public void setStateID(Long[] stateID) {
		this.stateID = stateID;
	}
}
