package com.fmiproject.login;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fmiproject.login.dto.CheckGameStatusResponseDTO;
import com.fmiproject.login.dto.CreateGameDTO;
import com.fmiproject.login.dto.JoinGameDTO;
import com.fmiproject.login.dto.ResponseDTO;

@RestController
public class GameController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/game/join")
	public void joinGame(@RequestParam("userid") Long userid, @RequestParam("gameid") String gameId)
			throws RestClientException, URISyntaxException {
		restTemplate.put(new URI("https://ug-game-api.azurewebsites.net/api/game/" + gameId), new JoinGameDTO(userid));
	}
	
	
	@GetMapping("/game/create")
	public String createGame(@RequestParam("userid") Long userid, @RequestParam("role") Long role)
			throws RestClientException, URISyntaxException {
		RequestEntity<CreateGameDTO> request = RequestEntity
				.post(new URI("https://ug-game-api.azurewebsites.net/api/game")).accept(MediaType.APPLICATION_JSON)
				.body(new CreateGameDTO(userid, role));
		ResponseEntity<ResponseDTO> responseDTO = restTemplate.exchange(request, ResponseDTO.class);
		String gameId = responseDTO.getBody().getData().getGame().getGameID();
		return gameId;
	}
	
	@GetMapping("/game/check/{gameId}")
	public Long checkGameStatus(@PathVariable("gameId") String gameId) throws RestClientException, URISyntaxException {
		ResponseEntity<CheckGameStatusResponseDTO> response = restTemplate.getForEntity(
				new URI("https://ug-game-api.azurewebsites.net/api/game/" + gameId), CheckGameStatusResponseDTO.class);
		return response.getBody().getData().getGame().getStateID();
	}
}
