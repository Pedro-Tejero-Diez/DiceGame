package v1.DiceGame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import v1.DiceGame.dto.GameDto;
import v1.DiceGame.dto.GamerDto;
import v1.DiceGame.entities.Gamer;
import v1.DiceGame.helper.GameMapper;
import v1.DiceGame.helper.GamerMapper;
import v1.DiceGame.services.GameServiceImp;
import v1.DiceGame.services.GamerServiceImp;
import v1.DiceGame.services.IGameService;
import v1.DiceGame.services.IGamerService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/gamers")
public class GamerController {

    @Autowired
    GamerServiceImp gamerservice;
    @Autowired
    GameServiceImp gameservice;

    @GetMapping
    public String createGamer(Model model) {
        Gamer gamer = new Gamer();
        model.addAttribute("gamer", gamer);
        return "new_gamer";
    }

    @GetMapping("/")
    public String AllGamers(Model model) {
        List<Gamer> gamers = gamerservice.getAllGamer();
        List<GamerDto> gamersdto = gamers.stream().map(GamerMapper::toGamerDto).collect(Collectors.toList());
        model.addAttribute("gamers", gamersdto);

        return "gamer_list";
    }

    @PostMapping("/add")
    public String saveGamerToDb(@ModelAttribute("gamer") Gamer gamer) {
        try {
            gamerservice.saveGamer(gamer);

            return "success";

        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/{gamer_id}/games")
    public String gamerScreen(@PathVariable(value = "gamer_id") String gamer_id, Model model) {

        try {
            Gamer gamer = gamerservice.getGamerById(gamer_id);
            List<GameDto> games = gameservice.getAllGameByGamer(gamer_id).stream()
                    .map(GameMapper::toGameDto).collect(Collectors.toList());
            if (gamer != null) {
                GamerDto gamerdto = GamerMapper.toGamerDto(gamer);
                model.addAttribute("games", games);
                model.addAttribute("gamer", gamerdto);
                return "gamer";
            } else
                return "not_found";
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/{gamer_id}/games")
    public String gameScreen (@PathVariable(value = "gamer_id") String gamer_id, @ModelAttribute GamerDto gamerdto,
                               RedirectAttributes ra, Model model) {
        try {
            GameDto gamedto = new GameDto(gamerdto);
            gameservice.saveGame(gamedto);
            ra.addFlashAttribute("game", gamedto);
            return "redirect:/gamers/{gamer_id}/games";
        } catch (Exception e) {
            return "error";
        }
    }
    @GetMapping("/{gamer_id}/deletelist")
    public String deleteLists (@PathVariable(value = "gamer_id") String gamer_id, RedirectAttributes ra,
                              Model model) {
        try {
            Gamer gamer = gamerservice.getGamerById(gamer_id);
            ra.addFlashAttribute("gamer", gamer);
            return "redirect:/games/{gamer_id}/delete";

        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/Ranking")
    public String showrRanking(Model model) {
        List<Gamer> gamers = gamerservice.getAllGamer();
        model.addAttribute("gamers",
                gamers.stream().map(GamerMapper::toGamerDto).collect(Collectors.toList()));
        return "Ranking";
    }

    @GetMapping("/Ranking/loser")
    public String showLoser(Model model) {
        List<GamerDto> gameres = gamerservice.getAllGamer().stream().map(GamerMapper::toGamerDto)
                .toList();
        String losername = gameres.stream().min(Comparator.comparing(GamerDto::getSuccess)).get().getName();
        model.addAttribute("nameL", losername);
        return "loser";
    }

    @GetMapping("/Ranking/winner")
    public String showWinner(Model model) {
        List<GamerDto> gameres = gamerservice.getAllGamer().stream().map(GamerMapper::toGamerDto)
                .toList();
        String winnername = gameres.stream().max(Comparator.comparing(GamerDto::getSuccess)).get().getName();
        model.addAttribute("nameW", winnername);
        return "winner";
    }

    @GetMapping("/{gamer_id}/getOne")
    public String getOneGamer(@PathVariable(value = "gamer_id") String gamer_id, Model model) {

        try {
            Gamer gamer = gamerservice.getGamerById(gamer_id);
            if (gamer != null) {
                GamerDto gamerdto = GamerMapper.toGamerDto(gamer);
                model.addAttribute("gamerdto", gamerdto);

                return "showone";
            } else
                return "not_found";
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateGamer(@ModelAttribute("gamerdto") GamerDto gamerdto) {
        try {
            gamerservice.updateGamer(gamerdto.getGamer_id(), gamerdto);
            return "success";

        } catch (Exception e) {
            return "error";
        }
    }


}