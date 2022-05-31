package com.example.toureksamenbackend.repositories;

import com.example.toureksamenbackend.entities.Competitor;
import com.example.toureksamenbackend.entities.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompetitorRepoTest {

    @Autowired
    TeamRepo teamRepo;

    @Autowired
    CompetitorRepo competitorRepo;

    @BeforeEach
    void setUp() {
        teamRepo.deleteAll();
        competitorRepo.deleteAll();
        Team team1 = new Team("Cykelholdet", 3, "Danmark");
        Competitor competitor1 = new Competitor("Jesper", "Skiby", 32, "Danmark", 4, 4, 39, "er" );
        Competitor competitor2 = new Competitor("Michael", "Fuglsang", 12, "Danmark", 6, 5, 33, "erer" );
        team1.addCompetitor(competitor1);
        team1.addCompetitor(competitor2);
        teamRepo.save(team1);
    }
    @Test
    public void getCompetitors(){
        List<Competitor> competitorList = competitorRepo.findAll();
        assertEquals(2, competitorList.size());
    }
    @Test
    public void getCompetitorsFromTeam(){
        List<Competitor> competitorList = competitorRepo.findCompetitorByTeamName("Cykelholdet");
        assertEquals(2, competitorList.size());
    }
    @Test
    public void getCompetitorsFromTeamError(){
        List<Competitor> competitorList = competitorRepo.findCompetitorByTeamName("Mountain Lions");
        assertEquals(0, competitorList.size());
    }
}