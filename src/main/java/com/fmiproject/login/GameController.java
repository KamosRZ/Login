package com.fmiproject.login;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fmiproject.login.dto.CreateGameDTO;
import com.fmiproject.login.dto.Game;

@Controller
public class GameController {
	
	private final static String START_GAME = "start";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/game")
	public void submit(@RequestParam("user") Long user, @RequestParam("action") String action,
			@RequestParam("role") Long role) throws RestClientException, URISyntaxException {
		if (action.equals(START_GAME)) {
			ResponseEntity<Game> game = restTemplate.postForEntity(
					new URI("https://ug-game-api.azurewebsites.net/api/game"), new CreateGameDTO(user, role), Game.class);
		}
	}

}
