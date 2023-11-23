package v1.DiceGame.services;

import v1.DiceGame.dto.GamerDto;
import v1.DiceGame.entities.Gamer;

import java.util.List;

public interface IGamerService {

    List<Gamer> getAllGamer();

    void saveGamer(Gamer gamer);

    Gamer getGamerById(String gamer_id);

    void updateGamer(String gamer_id, GamerDto gamerdto);

    boolean deleteGamer(String gamer_id);
}