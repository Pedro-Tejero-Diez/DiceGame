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
    private float success;

    public GamerDto(String gamer_id, String name, List<Game> games) {

        this.gamer_id = gamer_id;
        this.name = name;
        this.games = games;
        float summation = 0;
        for (int i = 0; i<games.size(); i++) {
            if((games.get(i).getOne() + games.get(i).getTwo() == 7)) {
                summation += 1;
            }
        }
        this.setSuccess((float) (summation / games.size()) * 100);
    }

   public GamerDto (String gamer_id, String name) {
        this.gamer_id = gamer_id;
        this.name = name;
    }
}

