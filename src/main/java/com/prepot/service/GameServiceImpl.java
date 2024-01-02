package com.prepot.service;

import com.prepot.domain.Game;
import com.prepot.domain.Member;
import com.prepot.repository.game.GameRepository;
import com.prepot.repository.game.GameSearchCond;
import com.prepot.repository.game.GameUpdateDto;
import com.prepot.repository.member.MemberSearchCond;
import com.prepot.repository.member.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public List<Game> findGames(GameSearchCond gameSearchCond) {
        return gameRepository.findAll(gameSearchCond);
    }

    @Override
    public void update(String gameName, GameUpdateDto updateParam) {
        gameRepository.update(gameName,updateParam);
    }

    @Override
    public Optional<Game> findById(String gameName) {
        return gameRepository.findById(gameName);
    }

    @Override
    public void deleteGame(String gameName) {
        gameRepository.deleteGame(gameName);
    }

    @Override
    public void playGame(String gameName,String userId) {
        gameRepository.playGame(gameName,userId);
    }

    @Override
    public String playGameCheck(String gameName, String userId) {
        return gameRepository.playGameCheck(gameName,userId);
    }

    @Override
    public void endTimeUpdate(String gameName, String userId) {
        gameRepository.endTimeUpdate(gameName,userId);
    }

    @Override
    public void endGame(String userId) {
        gameRepository.endGame(userId);
    }

}
