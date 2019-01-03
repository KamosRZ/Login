package com.fmiproject.login.dto;

public class CheckGameStatusResponseDTO {
	
	private GameStatusData data;
	
	public static class GameStatusData {
		private GameStatus game;

		/**
		 * @return the game
		 */
		public GameStatus getGame() {
			return game;
		}

		/**
		 * @param game the game to set
		 */
		public void setGame(GameStatus game) {
			this.game = game;
		}
	}
	
	public static class GameStatus {
		private String gameID;
		private Long stateID;
		private Long responderID;
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
		/**
		 * @return the responderID
		 */
		public Long getResponderID() {
			return responderID;
		}
		/**
		 * @param responderID the responderID to set
		 */
		public void setResponderID(Long responderID) {
			this.responderID = responderID;
		}
	}

	/**
	 * @return the data
	 */
	public GameStatusData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(GameStatusData data) {
		this.data = data;
	}
}
