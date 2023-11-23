package v1.DiceGame.services;

import v1.DiceGame.dto.GameDto;
import v1.DiceGame.entities.Game;

import java.util.List;

public interface IGameService {

    List<Game> getAllGame();

    List<Game> getAllGameByGamer(String gamer_id);

    void saveGame(GameDto gamedto);

    void deleteGames(String gamer_id);
}