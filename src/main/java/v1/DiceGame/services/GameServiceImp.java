package v1.DiceGame.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import v1.DiceGame.dto.GameDto;
import v1.DiceGame.entities.Game;
import v1.DiceGame.entities.Gamer;
import v1.DiceGame.repository.GameRepository;
import v1.DiceGame.repository.GamerRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImp implements IGameService {

    @Autowired
    GameRepository gamerepository;
    @Autowired
    GamerRepository gamerrepository;

    @Override
    public List<Game> getAllGame() {
        return gamerepository.findAll();
    }

    @Override
    public List<Game> getAllGameByGamer(String gamer_id) {

        return gamerepository.findAllByGamerId(gamer_id);
    }

    @Override
    public void saveGame(GameDto gamedto) {
        Gamer gamer = gamerrepository.findById(gamedto.getGamer_id()).get();

        gamerepository.save(new Game(gamedto.getGamedate(), gamedto.getOne(),
                gamedto.getTwo(), gamer));
    }

    @Override
    public void deleteGames(String gamer_id) {

            List<Game> games = gamerepository.findAll();
            for (Game game : games) {
                if (game.getGamer().getGamer_id().equals(gamer_id)) {
                    gamerepository.delete(game);
                }
            }
        }
    }
