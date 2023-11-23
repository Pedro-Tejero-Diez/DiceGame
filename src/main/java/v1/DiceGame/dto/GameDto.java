package v1.DiceGame.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@Setter
@Getter
public class GameDto {
    private String gamer_id;
    private LocalDate gamedate;
    private byte one;
    private byte two;
    private boolean win;

    public GameDto(GamerDto gamerdto) {

        this.gamer_id= gamerdto.getGamer_id();
        byte min = 1;
        byte max = 6;
        this.gamedate = LocalDate.now();
        this.one = (byte) Math.floor(Math.random() * (max - min + 1) + min);
        this.two = (byte) Math.floor(Math.random() * (max - min + 1) + min);
        this.win = ((one + two == 7) ? true : false);
    }

    public GameDto(String gamer_id, LocalDate gamedate, byte one, byte two) {

        this.setGamer_id(gamer_id);
        this.gamedate = gamedate;
        this.one = one;
        this.two = two;
        this.win = (one + two == 7) ? true : false;
        ;
    }
}

