package v1.DiceGame.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import v1.DiceGame.dto.GameDto;
import v1.DiceGame.entities.Game;
import v1.DiceGame.repository.GamerRepository;


import java.time.LocalDate;

@Component
public class GameMapper {

    @Autowired
    static GamerRepository gamerRepository;

    public static GameDto toGameDto(Game game) {
        String gamer_id = game.getGamer().getGamer_id();
        LocalDate gamedate = game.getGamedate();
        byte one = game.getOne();
        byte two = game.getTwo();

        return new GameDto(gamer_id, gamedate, one, two);
    }

    public static Game toGame(GameDto gamedto) {

        return new Game(gamedto.getGamedate(),
                gamedto.getOne(), gamedto.getTwo(), gamerRepository.findById(gamedto.getGamer_id()).get());
    }

}
