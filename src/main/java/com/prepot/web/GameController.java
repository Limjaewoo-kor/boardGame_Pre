package com.prepot.web;


import com.prepot.SessionConst;
import com.prepot.domain.Game;
import com.prepot.domain.Member;
import com.prepot.repository.game.GameSearchCond;
import com.prepot.repository.game.GameUpdateDto;
import com.prepot.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public String games(@ModelAttribute("gameSearch") GameSearchCond gameSearchCond, Model model) {
        List<Game> games = gameService.findGames(gameSearchCond);
        model.addAttribute("games", games);
        return "game/gameList";
    }

    @GetMapping("/user")
    public String gamesUser(@ModelAttribute("gameSearch") GameSearchCond gameSearchCond, Model model) {
        List<Game> games = gameService.findGames(gameSearchCond);
        model.addAttribute("games", games);
        return "game/gameListUser";
    }

    @GetMapping("/add")
    public String addForm() {
        return "game/addGameForm";
    }


    @PostMapping("/add")
    public String gameAdd(Game game){
        Game save = gameService.save(game);
        System.out.println(save.getGameName());
        return "redirect:/games";
    }

    @GetMapping("/{gameName}")
    public String game(@PathVariable String gameName, Model model) {
        Game game = gameService.findById(gameName).get();
        model.addAttribute("game", game);
        return "game/game";
    }

    @GetMapping("/start/{gameName}")
    public String gameStart(@PathVariable String gameName, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        String userId = member.getUserId();

        String OldGameName = gameService.playGameCheck(gameName,userId);

        if(null != OldGameName || !OldGameName.equals("") ){
            if(!OldGameName.equals(gameName)){
                gameService.endTimeUpdate(OldGameName,userId);
                gameService.playGame(gameName,userId);
            }
        }else {
            gameService.playGame(gameName,userId);
        }

        return "redirect:/games/user";
    }

    @GetMapping("/end")
    public String gameEnd(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        String userId = member.getUserId();

        gameService.endGame(userId);

        return "redirect:/games/user";
    }




    @GetMapping("/{gameName}/edit")
    public String editForm(@PathVariable String gameName, Model model) {
        Game game = gameService.findById(gameName).get();
        model.addAttribute("game", game);
        return "game/editGameForm";
    }


    @GetMapping("/{gameName}/delete")
    public String deleteGame(@PathVariable String gameName, Model model) {
        gameService.deleteGame(gameName);
        return "redirect:/games";
    }

    @PostMapping("/{gameName}/edit")
    public String edit(@PathVariable String gameName, @ModelAttribute GameUpdateDto updateParam) {
        gameService.update(gameName, updateParam);
        return "redirect:/games/{gameName}";
    }

}
