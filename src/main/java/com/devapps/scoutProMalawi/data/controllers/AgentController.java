package com.devapps.scoutProMalawi.data.controllers;

import com.devapps.scoutProMalawi.Utils.AgentResponse;
import com.devapps.scoutProMalawi.data.models.Agent;
import com.devapps.scoutProMalawi.data.models.Team;
import com.devapps.scoutProMalawi.data.repositories.AgentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AgentController {

    private AgentRepository agentRepository;
    private Agent agentProfile;

    @GetMapping(value = "agent/create-agent")
    public AgentResponse createAgent(@RequestBody Agent agent) {
        try {
            Agent savedAgent = agentRepository.save(agent);
            return new AgentResponse.Success(savedAgent);
        } catch (Exception e){
            return new AgentResponse.Error("Agent account failed to create: " + e);
        }
    }

    @GetMapping(value = "agent/get-agent/{agent_id}")
    public ResponseEntity<Optional<Agent>> getAgentById(long agent_id) {
        Optional<Agent> agent = agentRepository.getAgentById(agent_id);

        if(agent.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(agent);
        }
    }

    @GetMapping(value = "agent/get-agent/{username}")
    public ResponseEntity<Optional<Agent>> getAgentByUsername(String username) {
        Optional<Agent> agentUsername = agentRepository.getAgentByUsername(username);

        if (agentUsername.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(agentUsername);
        }
    }
}
