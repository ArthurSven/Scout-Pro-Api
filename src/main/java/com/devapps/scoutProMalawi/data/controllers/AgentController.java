package com.devapps.scoutProMalawi.data.controllers;

import com.devapps.scoutProMalawi.data.models.Agent;
import com.devapps.scoutProMalawi.data.repositories.AgentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent")
@CrossOrigin(origins = "http://localhost:3000") //
public class AgentController {

@Autowired
    private final AgentRepository agentRepository;
    private final Logger logger = LoggerFactory.getLogger(AgentController.class);

    public List<Agent> agents;

    public AgentController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @GetMapping("/agent-list")
    public List<Agent> getAllAgents() {
    try {
        return agentRepository.findAll();
    } catch (Exception e) {
        logger.error("Error occurred while retrieving agents", e);
    }
        return null;
    }

@PostMapping("/create-agent")
    public String createAgent(@RequestBody Agent agent) {
        try {
            agentRepository.save(agent);
            return agent.getUsername() + "'s account has been created";
        } catch (Exception e) {
            return agent.getUsername() + "'s account failed to create, please try again";
        }
}

@GetMapping("/get-agent-id/{agent_id}")
    public Optional<Agent> getAgentById(@PathVariable long agent_id) {
        try {
            return  agentRepository.findById(agent_id);
        } catch (Exception e) {
            logger.error("Error occurred while retrieving agent Id", e);
        }
       return null;
}

@GetMapping("/get-agent-username/{username}")
    public Optional<Agent> getAgentByUsername(@PathVariable String username) {
        try {
          return  agentRepository.findByUsername(username);
        } catch (Exception e) {
            logger.error("Error occurred while retrieving " + username + ": " + e);
        }
        return null;
}

}
