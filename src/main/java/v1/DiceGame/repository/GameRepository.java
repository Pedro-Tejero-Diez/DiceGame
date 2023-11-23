package v1.DiceGame.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import v1.DiceGame.entities.Game;

import java.util.List;

public interface GameRepository extends MongoRepository<Game, String> {


    //@Query("{ 'jugador' : {'$oid' : : #{#jugador_id}}")
    //List<Jugada> findAllByJugador_id(@Param("jugador_id") String jugador_id);


    @Query("{ 'gamer' : {'$oid' : ?0}}")
    List<Game> findAllByGamerId(String gamer_id);
}



