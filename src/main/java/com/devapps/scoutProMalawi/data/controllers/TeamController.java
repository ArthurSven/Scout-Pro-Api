package com.devapps.scoutProMalawi.data.controllers;

import com.devapps.scoutProMalawi.Utils.TeamResponse;
import com.devapps.scoutProMalawi.data.models.Team;
import com.devapps.scoutProMalawi.data.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping(value = "/create-team")
    public TeamResponse createTeam(@RequestBody Team team) {
        try {
           Team savedTeam = teamRepository.save(team);
           return new TeamResponse.Success(savedTeam);
        } catch (Exception e) {
            return new TeamResponse.Error("Team failed to create: " + e);
        }
    };

    @GetMapping(value = "team/get-teams")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping(value = "team/get-team/{team_id}")
    public ResponseEntity<Optional<Team>> getTeamById(@PathVariable Long team_id) {
        Optional<Team> team = teamRepository.getTeamById(team_id);

        if(team.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(team);
        }
    }

}
