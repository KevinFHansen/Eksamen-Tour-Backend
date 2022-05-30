package com.example.toureksamenbackend.repositories;

import com.example.toureksamenbackend.entities.Competitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitorRepo extends JpaRepository<Competitor, Integer> {
    List<Competitor> findCompetitorByTeamName (String name);
}
