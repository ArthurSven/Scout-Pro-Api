package com.devapps.scoutProMalawi.data.repositories;

import com.devapps.scoutProMalawi.data.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    public Optional<Player> getPlayerById(Long player_id);

    public Optional<Player> getPlayerByFirstname(String firstname);

    public Optional<Player> getPlayerByAgent(Long agent_id);
}
