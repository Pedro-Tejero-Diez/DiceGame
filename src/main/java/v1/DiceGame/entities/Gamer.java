package v1.DiceGame.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "gamers")
public class Gamer {

    @Id
    private String gamer_id;
    private LocalDate regdate;
    private String name;
    private String pwd;

    @DocumentReference(lookup = "{'gamer':?#{#self._id} }")
    private List<Game> games;

    public Gamer(String gamer_id, LocalDate regdate, String name, String pwd, List<Game> games) {

        this.gamer_id = gamer_id;
        this.regdate = regdate;
        this.name = name;
        this.pwd = pwd;
        this.games= games;

    }

    public Gamer(String gamer_id, LocalDate regdate, String name, String pwd) {

        this.gamer_id = gamer_id;
        this.regdate = regdate;
        this.name = name;
        this.pwd = pwd;

    }

    public Gamer(LocalDate regdate, String name, String pwd) {

        this.regdate = LocalDate.now();
        this.name = name;
        this.pwd = pwd;
    }

}