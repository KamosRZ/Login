package com.fmiproject.login.dto;

import java.util.List;

public class ListGames {

	private GameData data;

	public static class GameData {
		private List<GamesDTO> games;

		/**
		 * @return the games
		 */
		public List<GamesDTO> getGames() {
			return games;
		}

		/**
		 * @param games the games to set
		 */
		public void setGames(List<GamesDTO> games) {
			this.games = games;
		}
	}

	public static class GamesDTO {
		private String gameID;
		private Long stateID;

		public String getGameID() {
			return gameID;
		}

		public Long getStateID() {
			return stateID;
		}
	}

	/**
	 * @return the data
	 */
	public GameData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(GameData data) {
		this.data = data;
	}

}