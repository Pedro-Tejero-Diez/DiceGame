package v1.DiceGame.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import v1.DiceGame.entities.Game;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

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
        for (Game game : games) {
            if ((game.getOne() + game.getTwo() == 7)) {
                summation += 1;
            }
        }
        // Calculate success percentage
        float successPercentage = (float) (summation / games.size()) * 100;

        // Format the result to two decimal places
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        this.success = Float.parseFloat(df.format(successPercentage));
        //this.setSuccess((float) (summation / games.size()) * 100);
    }

   public GamerDto (String gamer_id, String name) {
        this.gamer_id = gamer_id;
        this.name = name;
    }
}

