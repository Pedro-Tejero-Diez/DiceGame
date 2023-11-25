package v1.DiceGame.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import v1.DiceGame.dto.GameDto;
import v1.DiceGame.services.IGameService;
import v1.DiceGame.services.IGamerService;


@Controller
@RequestMapping("/games")
public class GameController {
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);

    @Autowired
    IGamerService gamerservice;
    @Autowired
    IGameService gameservice;

    @GetMapping("/{gamer_id}/delete")
    public String deleteGamesList (@PathVariable(value = "gamer_id") String gamer_id) {
        try {
            gameservice.deleteGames(gamer_id);

        } catch (Exception e) {
            logger.error("Error deleting games for gamer with id: {}", gamer_id, e);

            return "error";
        }
        return "success";
    }

    @GetMapping("/{gamer_id}/game")
    public String gameScreen (@PathVariable("gamer_id") String gamer_id, @ModelAttribute("game") GameDto gamedto,
                              Model model) {
        return "game";
    }
}
