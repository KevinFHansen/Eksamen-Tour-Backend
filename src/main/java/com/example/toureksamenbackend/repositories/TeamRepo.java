package com.example.toureksamenbackend.repositories;

import com.example.toureksamenbackend.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Integer> {
}
