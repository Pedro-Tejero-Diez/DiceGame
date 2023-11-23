package v1.DiceGame.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import v1.DiceGame.entities.Game;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class GamerDto {

    private String gamer_id;
    private String name;
    private List<Game> games;
    private float win;

    public GamerDto(String gamer_id, String name, List<Game> games) {

        this.gamer_id = gamer_id;
        this.name = name;
        this.games = games;
        float summation = 0;
        for (Game game : games) {
            if ((game.getOne() + game.getTwo() == 7)) {
                summation += 1;
            }
        }
        this.setWin((float) (summation / games.size()) * 100);
    }

    public GamerDto (String gamer_id, String name) {
        this.gamer_id = gamer_id;
        this.name = name;
    };
}

