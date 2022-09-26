package service;

import data.GameDao;
import data.RoundDao;
import entity.Game;
import entity.Round;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Author Talha
@Service
public class ServiceLayer {
    @Autowired
    GameDao gameDao;
    
    @Autowired
    RoundDao roundDao;

    public List<Game> getAllGames() {
        List<Game> games = gameDao.getAll();
        for (Game game : games) {
            if (!game.isFinished()) {
                game.setAnswer("****");
            }
        }

        return games;
    }

    public List<Round> getAllRoundsByGameId(int gameid) {
        return roundDao.getRoundbyGameid(gameid);
    }

    public Round makeGuess(Round round) {
        String answer = gameDao.findById(round.getID()).getAnswer();
        String guess = round.getGuess();
        String result = determineResult(guess, answer);
        round.setResult(result);
        
        if (guess.equals(answer)) {
            Game game = getGameById(round.getID());
            game.setFinished(true);
            gameDao.update(game);
        }
        
        return roundDao.add(round);
    }

    public Game getGameById(int gameId) {
        Game game = gameDao.findById(gameId);
        if (!game.isFinished()) {
            game.setAnswer("****");
        }

        return game;
    }

    public Game addGame(Game game) {
        return gameDao.add(game);
    }

    public int newGame() {
        Game game = new Game();
        game.setAnswer(generateAnswer());
        game = gameDao.add(game);

        return game.getGameID();
    }

    private String generateAnswer() {
        Random rnd = new Random();
        int digit1 = rnd.nextInt(10);

        int digit2 = rnd.nextInt(10);
        while (digit2 == digit1) {
            digit2 = rnd.nextInt(10);
        }

        int digit3 = rnd.nextInt(10);
        while (digit3 == digit2 || digit3 == digit1) {
            digit3 = rnd.nextInt(10);
        }

        int digit4 = rnd.nextInt(10);
        while (digit4 == digit3 || digit4 == digit2 || digit4 == digit1) {
            digit4 = rnd.nextInt(10);
        }

        String answer = String.valueOf(digit1) + String.valueOf(digit2)
                + String.valueOf(digit3) + String.valueOf(digit4);

        return answer;
    }

    public String determineResult(String guess, String answer) {
        char[] guessChars = guess.toCharArray();
        char[] answerChars = answer.toCharArray();
        int exact = 0;
        int partial = 0;
        
        for (int i = 0; i < guessChars.length; i++) {
            if (answer.indexOf(guessChars[i]) > -1) {
                if (guessChars[i] == answerChars[i]) {
                    exact++;
                } else {
                    partial++;
                }
            }
        }
        
        String result = "e:" + exact + ":p:" + partial;
        
        return result;
    } 
}
