package v1.DiceGame.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import v1.DiceGame.entities.Gamer;

public interface GamerRepository extends MongoRepository<Gamer, String> {
}