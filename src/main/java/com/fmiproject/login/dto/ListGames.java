package com.fmiproject.login.dto;

import java.io.Serializable;
import java.util.*;
public class ListGames implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long gameID;
	private Long stateID;
        private List<String> gameList;
        
        
        public List gameList(Long gameID, Long stateID) {
            return gameList;
        }
        
	public Long getGameID() {
		return gameID;
	}
        public void setGameID(Long gameID) {
		this.gameID = gameID;
	}

	public Long getStateID() {
		return stateID;
	}

	public void setStateID(Long stateID) {
		this.stateID = stateID;
	}
}
