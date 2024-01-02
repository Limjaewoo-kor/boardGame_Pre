package com.prepot.repository.mybatis.game;

import com.prepot.domain.Game;
import com.prepot.repository.game.GameSearchCond;
import com.prepot.repository.game.GameUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GameMapper {

    void save(Game member);

    List<Game> findAll(GameSearchCond gameSearchCond);

    void update(@Param("gameName") String gameName, @Param("updateParam") GameUpdateDto updateParam);

    Optional<Game> findById(String gameName);

    void deleteGame(String gameName);

    void playGame(@Param("gameName") String gameName,@Param("userId")String userId);

    String playGameCheck(@Param("gameName") String gameName,@Param("userId")String userId);

    void endTimeUpdate(@Param("gameName") String gameName,@Param("userId")String userId);

    void endGame(String userId);

}
