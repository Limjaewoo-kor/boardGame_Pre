package com.prepot.service;

import com.prepot.domain.Game;
import com.prepot.repository.game.GameSearchCond;
import com.prepot.repository.game.GameUpdateDto;

import java.util.List;
import java.util.Optional;

public interface GameService {

    Game save(Game game);

    List<Game> findGames(GameSearchCond gameSearchCond);

    void update(String userId, GameUpdateDto updateParam);

    Optional<Game> findById(String gameName);

    void deleteGame(String gameName);

    void playGame(String gameName,String userId);

    String playGameCheck(String gameName, String userId);

    void endTimeUpdate(String gameName, String userId);

    void endGame(String userId);
}
