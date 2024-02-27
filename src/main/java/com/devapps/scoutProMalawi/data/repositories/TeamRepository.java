package com.devapps.scoutProMalawi.data.repositories;

import com.devapps.scoutProMalawi.data.models.Agent;
import com.devapps.scoutProMalawi.data.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
