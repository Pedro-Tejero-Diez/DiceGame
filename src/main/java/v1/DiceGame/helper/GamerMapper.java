package v1.DiceGame.helper;
import org.springframework.stereotype.Component;
import v1.DiceGame.dto.GamerDto;
import v1.DiceGame.entities.Gamer;

import java.time.LocalDate;

@Component
public class GamerMapper {


    public static GamerDto toGamerDto(Gamer gamer) {


        return new GamerDto(gamer.getGamer_id(),
                gamer.getName(), gamer.getGames());
    }

    public static Gamer toGamer(GamerDto gamerdto, String pwd) {

        LocalDate regdate = LocalDate.now();

        return new Gamer(regdate, gamerdto.getName(), pwd);

    }

}