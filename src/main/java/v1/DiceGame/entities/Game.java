package v1.DiceGame.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Document(collection="games")
public class Game {

    @MongoId
    private String game_id;
    private LocalDate gamedate;
    private byte one;
    private byte two;
    @DocumentReference(lazy=true)
    private Gamer gamer;

    public Game(LocalDate gamedate, byte one, byte two, Gamer gamer) {

        this.gamedate = gamedate;
        this.one = one;
        this.two = two;
        this.gamer=gamer;
    }

    public Game (Gamer gamer, LocalDate gamedate, byte one, byte two) {

        this.gamer = gamer;
        this.gamedate = gamedate;
        this.one = one;
        this.two = two;
    }
}

