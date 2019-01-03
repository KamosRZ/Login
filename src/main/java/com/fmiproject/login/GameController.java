package com.fmiproject.login;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fmiproject.login.dto.CheckGameStatusResponseDTO;
import com.fmiproject.login.dto.CreateGameDTO;
import com.fmiproject.login.dto.ListGames;
import com.fmiproject.login.dto.ListGames.GamesDTO;
import com.fmiproject.login.dto.ResponseDTO;

@RestController
public class GameController {
	
	private final static String START_GAME = "start";
	private final static String JOIN_GAME = "join";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/game")
	public String submit(@RequestParam("userid") Long userid, @RequestParam("action") String action,
			@RequestParam("role") Long role) throws RestClientException, URISyntaxException {
		String response = "";
		if (action.equals(START_GAME)) {
			RequestEntity<CreateGameDTO> request = RequestEntity
					.post(new URI("https://ug-game-api.azurewebsites.net/api/game")).accept(MediaType.APPLICATION_JSON)
					.body(new CreateGameDTO(userid, role));
			ResponseEntity<ResponseDTO> responseDTO = restTemplate.exchange(request, ResponseDTO.class);
			response = responseDTO.getBody().getData().getGame().getGameID();
		} else if (action.equals(JOIN_GAME)) {
			ResponseEntity<ListGames> responseDTO = restTemplate
					.getForEntity(new URI("https://ug-game-api.azurewebsites.net/api/games/to_join"), ListGames.class);
			List<GamesDTO> gamesList = responseDTO.getBody().getData().getGames();
			response = gamesList.get(gamesList.size() - 1).getGameID();
		}
		return response;
	}
	
	@GetMapping("/game/check/{gameId}")
	public Long checkGameStatus(@PathVariable("gameId") String gameId) throws RestClientException, URISyntaxException {
		ResponseEntity<CheckGameStatusResponseDTO> response = restTemplate.getForEntity(
				new URI("https://ug-game-api.azurewebsites.net/api/game/" + gameId), CheckGameStatusResponseDTO.class);
		return response.getBody().getData().getGame().getStateID();
	}
}
