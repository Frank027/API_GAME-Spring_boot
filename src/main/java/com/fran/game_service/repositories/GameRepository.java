package com.fran.game_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fran.game_service.commons.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
