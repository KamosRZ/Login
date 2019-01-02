package com.fmiproject.login.dto;

import java.io.Serializable;

public class Data implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;
	/**
	 * @return the game
	 */
	public Game getGame() {
		return game;
	}
	/**
	 * @param game the game to set
	 */
	public void setGame(Game game) {
		this.game = game;
	}
}
