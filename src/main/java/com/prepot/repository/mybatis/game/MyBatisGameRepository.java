package com.prepot.repository.mybatis.game;


import com.prepot.domain.Game;
import com.prepot.domain.Member;
import com.prepot.repository.game.GameRepository;
import com.prepot.repository.game.GameSearchCond;
import com.prepot.repository.game.GameUpdateDto;
import com.prepot.repository.member.MemberRepository;
import com.prepot.repository.member.MemberSearchCond;
import com.prepot.repository.member.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MyBatisGameRepository implements GameRepository {

    private final GameMapper gameMapper;

    @Override
    public Game save(Game game) {
        log.info("m class={}", gameMapper.getClass());
        gameMapper.save(game);
        return game;
    }

    @Override
    public List<Game> findAll(GameSearchCond gameSearchCond) {
        return gameMapper.findAll(gameSearchCond);
    }

    @Override
    public void update(String gameName, GameUpdateDto updateParam) {
        gameMapper.update(gameName,updateParam);
    }

    @Override
    public Optional<Game> findById(String gameName) {
        return gameMapper.findById(gameName);
    }

    @Override
    public void deleteGame(String gameName) {
        gameMapper.deleteGame(gameName);
    }

    @Override
    public void playGame(String gameName,String userId) {
        gameMapper.playGame(gameName,userId);
    }

    @Override
    public String playGameCheck(String gameName, String userId) {
        return gameMapper.playGameCheck(gameName,userId);
    }

    @Override
    public void endTimeUpdate(String gameName, String userId) {
        gameMapper.endTimeUpdate(gameName,userId);
    }

    @Override
    public void endGame(String userId) {
        gameMapper.endGame(userId);
    }

}
