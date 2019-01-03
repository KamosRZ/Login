package com.fmiproject.login.dto;

import java.util.*;

public class ListGames {
	
        public static List<GamesDTO> games;
        
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
}