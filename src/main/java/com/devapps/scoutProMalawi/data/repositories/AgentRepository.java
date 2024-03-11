package com.devapps.scoutProMalawi.data.repositories;

import com.devapps.scoutProMalawi.data.models.Agent;
import com.devapps.scoutProMalawi.data.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Query("SELECT a FROM Agent a WHERE a.username = :username")
    Optional<Agent> findAgentByUsername(@Param("username")String username);

    @Query("SELECT a FROM Agent a WHERE a.email = :email")
    Optional<Agent> findAgentByEmail(@Param("email")String email);

}
