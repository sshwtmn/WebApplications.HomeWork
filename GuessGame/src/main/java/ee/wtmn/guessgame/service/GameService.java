package ee.wtmn.guessgame.service;

import ee.wtmn.guessgame.model.Game;
import ee.wtmn.guessgame.repository.GuessGameRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@AllArgsConstructor
public class GameService {
    private GuessGameRepo guessGameRepo;

    public Long startNewGame() {
        int secretNumber = new Random().nextInt(100) + 1;
        Game game = new Game();
        game.setSecretNumber(secretNumber);
        Game saved = guessGameRepo.save(game);
        return saved.getGameId();
    }


    public String makeGuess(Long gameId, int number) {
        Optional<Game> optionalGame = guessGameRepo.findById(gameId);
        if (optionalGame.isEmpty()) {
            return "wrong game id";
        }
        Game game = optionalGame.get();

        int secretNumber = game.getSecretNumber();

        int finalResult = game.getCount();

        if (game.isGuessed()){
            return "You have already won the game with " + finalResult + " tries";
        }

        finalResult++;
        game.setCount(finalResult);
        guessGameRepo.save(game);

        if (secretNumber > number){
            return "Greater";
        }

        if (secretNumber < number){
            return "Less";
        }

        game.setGuessed(true);
        guessGameRepo.save(game);
        return "You have won the games with " + finalResult  + " times";
    }

}
