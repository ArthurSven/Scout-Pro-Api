package com.devapps.scoutProMalawi.data.controllers;

import com.devapps.scoutProMalawi.data.models.Agent;
import com.devapps.scoutProMalawi.data.models.ApiResponse;
import com.devapps.scoutProMalawi.data.repositories.AgentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent")
@CrossOrigin(origins = "http://localhost:3000")
public class AgentController {

@Autowired
    private final AgentRepository agentRepository;
    private final Logger logger = LoggerFactory.getLogger(AgentController.class);
    private final BCryptPasswordEncoder passwordEncoder;

    public List<Agent> agents;

    public AgentController(AgentRepository agentRepository, BCryptPasswordEncoder passwordEncoder) {
        this.agentRepository = agentRepository;
        this.passwordEncoder = passwordEncoder;
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
public ApiResponse createAgent(@RequestBody Agent agent) {
    try {
        // Hash the password before saving it to the database
        String hashedPassword = passwordEncoder.encode(agent.getPassword());
        agent.setPassword(hashedPassword);

        agentRepository.save(agent);
        return new ApiResponse(true, agent.getUsername() + "'s account has been created");
    } catch (Exception e) {
        return new ApiResponse(false, agent.getUsername() + "'s account failed to create, please try again");
    }
}

@GetMapping("/get-agent-id/{agent_id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable long agent_id) {
        try {
            Optional<Agent> agentIdOptional = agentRepository.findById(agent_id);

            if(agentIdOptional.isPresent()) {
                Agent agent = agentIdOptional.get();
                return ResponseEntity.ok(agent);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error occurred while retrieving agent Id", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
}

@GetMapping("/get-agent-username/{username}")
    public ResponseEntity<Agent> getAgentByUsername(@PathVariable String username) {
        try {
          Optional<Agent> agentOptional = agentRepository.findAgentByUsername(username);

          if(agentOptional.isPresent()) {
              Agent agent = agentOptional.get();
              return ResponseEntity.ok(agent);
          } else {
              return ResponseEntity.notFound().build();
          }
        } catch (Exception e) {
            logger.error("Error occurred while retrieving " + username + ": " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
}

@GetMapping("/agent-email/{email}")
    public ResponseEntity<Agent> getAgentByEmail(@PathVariable String email) {
        try {
            Optional<Agent> agentEmail = agentRepository.findAgentByEmail(email);

            if(agentEmail.isPresent()) {
                Agent agent = agentEmail.get();
                return ResponseEntity.ok(agent);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            logger.error("Error occurred while retrieving " + email + ": " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

}
}
