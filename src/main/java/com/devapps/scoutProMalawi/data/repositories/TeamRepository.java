package com.devapps.scoutProMalawi.data.repositories;

import com.devapps.scoutProMalawi.data.models.Agent;
import com.devapps.scoutProMalawi.data.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

   @Query("SELECT t FROM team t WHERE t.teamname = teamname")
    Optional<Team> findByTeamname(@Param("teamname") String teamname);

    @Query("SELECT t FROM team t WHERE t.username = :username")
    Optional<Team> findTeamByUsername(@Param("username") String username);
}
