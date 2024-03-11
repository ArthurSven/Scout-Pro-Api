package com.devapps.scoutProMalawi.data.controllers;

import com.devapps.scoutProMalawi.Utils.AgentResponse;
import com.devapps.scoutProMalawi.Utils.TeamResponse;
import com.devapps.scoutProMalawi.data.models.ApiResponse;
import com.devapps.scoutProMalawi.data.models.Team;
import com.devapps.scoutProMalawi.data.repositories.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

    @Autowired
        private final TeamRepository teamRepository;

    private final Logger logger = LoggerFactory.getLogger(TeamController.class);
    private final BCryptPasswordEncoder passwordEncoder;


    public TeamController(TeamRepository teamRepository, BCryptPasswordEncoder passwordEncoder) {
        this.teamRepository = teamRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/team-list")
    List<Team> getAllTeams() {
        try {

            return teamRepository.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while retrieving teams", e);
        }

        return null;
    }

    @PostMapping("/create-team")
    public ApiResponse createTeam(@RequestBody Team team) {
        try {
            String hashedPassword = passwordEncoder.encode(team.getPassword());
            team.setPassword(hashedPassword);

            teamRepository.save(team);
            return new ApiResponse(true, team.getTeamname() + "'s account has been created");
        } catch (Exception e) {
            return new ApiResponse(false, team.getTeamname() + "'s account failed to create");
        }
    }

    @GetMapping("/get-team-id/{teamId}")
    public Optional<Team> getTeamById(@RequestBody long teamId) {
        try {
            teamRepository.findById(teamId);
        } catch (Exception e) {
            logger.error("Error occurred while retrieving agent Id", e);
        }
        return null;
    }

    @GetMapping("get-team-name/{teamname}")
    public Optional<Team> getTeamByTeamname(String teamname) {
        try {
            return teamRepository.findByTeamname(teamname);
        } catch (Exception e) {
            logger.error("Error occurred while retrieving " + teamname + ": " + e);
        }

        return null;
    }
}

