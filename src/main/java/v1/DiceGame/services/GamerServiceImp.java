package v1.DiceGame.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v1.DiceGame.dto.GamerDto;
import v1.DiceGame.entities.Gamer;
import v1.DiceGame.repository.GamerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GamerServiceImp implements IGamerService {

    @Autowired
    GamerRepository gamerrepository;

    @Override
    public List<Gamer> getAllGamer() {
        return gamerrepository.findAll();
    }

    @Override
    public void saveGamer(Gamer gamer) {
        gamerrepository.save(new Gamer(gamer.getRegdate(),
                gamer.getName(), gamer.getPwd()));
    }

    @Override
    public Gamer getGamerById(String gamer_id) {
        Optional<Gamer> gamer = gamerrepository.findById(gamer_id);
        if (gamer.isPresent()) {
            Gamer gamer1 = gamer.get();
            return gamer1;
        } else
            return null;
    }

    @Override
    @Transactional
    public void updateGamer(String gamer_id, GamerDto gamerdto) {
        Gamer gamer = gamerrepository.findById(gamer_id).get();
        gamer.setName(gamerdto.getName());
        gamerrepository.save(gamer);
    }

    @Override
    public boolean deleteGamer(String gamer_id) {

        Optional<Gamer> gamer = gamerrepository.findById(gamer_id);
        if (gamer.isPresent()) {
            gamerrepository.deleteById(gamer_id);
            return true;
        } else
            return false;

    }
}