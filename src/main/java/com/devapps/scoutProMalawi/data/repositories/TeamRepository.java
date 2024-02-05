package com.devapps.scoutProMalawi.data.repositories;

import com.devapps.scoutProMalawi.data.models.Team;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {


    public Optional<Team> getTeamById(long team_id);

    public String getTeamName(String teamName);


}
