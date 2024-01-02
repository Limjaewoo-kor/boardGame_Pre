package com.prepot.repository.game;

import com.prepot.domain.Game;


import java.util.List;
import java.util.Optional;

public interface GameRepository {

    Game save(Game game);

    List<Game> findAll(GameSearchCond gameSearchCond);

    void update(String gameName, GameUpdateDto updateParam);

    Optional<Game> findById(String gameName);

    void deleteGame(String gameName);

    void playGame(String gameName,String userId);

    String playGameCheck(String gameName, String userId);

    void endTimeUpdate(String gameName, String userId);

    void endGame(String userId);
}
