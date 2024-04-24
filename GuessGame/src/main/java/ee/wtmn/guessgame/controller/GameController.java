package ee.wtmn.guessgame.controller;


import ee.wtmn.guessgame.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;


@RestController
public class GameController {
    GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping("/game")
    public Long startNewGame() {
        return gameService.startNewGame();
    }

    @GetMapping("/game/{gameId}/guess/{number}")
    public String makeGuess(@PathVariable Long gameId, @PathVariable int number) {
        return gameService.makeGuess(gameId, number);
    }
}
