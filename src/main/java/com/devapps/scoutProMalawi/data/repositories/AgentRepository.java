package com.devapps.scoutProMalawi.data.repositories;

import com.devapps.scoutProMalawi.data.models.Agent;
import com.devapps.scoutProMalawi.data.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    public Optional<Agent> getAgentById(long agent_id);

    public Optional<Agent> getAgentByUsername(String username);

}
