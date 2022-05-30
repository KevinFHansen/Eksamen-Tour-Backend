package com.example.toureksamenbackend.service;

import com.example.toureksamenbackend.dto.CompetitorRequest;
import com.example.toureksamenbackend.dto.CompetitorResponse;
import com.example.toureksamenbackend.entities.Competitor;
import com.example.toureksamenbackend.repositories.CompetitorRepo;
import com.example.toureksamenbackend.repositories.TeamRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitorService {
    TeamRepo teamRepo;
    CompetitorRepo competitorRepo;

    public CompetitorService(TeamRepo teamRepo, CompetitorRepo competitorRepo) {
        this.teamRepo = teamRepo;
        this.competitorRepo = competitorRepo;
    }

    public List<CompetitorResponse> getAllCompetitors(String teamName){
        List<Competitor> competitors;
        if (teamName != null){
            competitors = competitorRepo.findCompetitorByTeamName(teamName);
        } else{
            competitors = competitorRepo.findAll();
        }
        return competitors.stream().map((competitor) -> new CompetitorResponse(competitor)).collect(Collectors.toList());
    }

    public void addNewCompetitor(CompetitorRequest body){
        competitorRepo.save(new Competitor(body));
    }

    public CompetitorResponse editCompetitor(CompetitorRequest body, int competitorId){
        Competitor competitor = competitorRepo.findById(competitorId).orElseThrow();
        competitor.setFirstName(body.getFirstName());
        competitor.setLastName(body.getLastName());
        competitor.setAge(body.getAge());
        competitor.setNationality(body.getNationality());
        competitor.setClimberPoints(body.getClimberPoints());
        competitor.setSprintPoints(body.getSprintPoints());
        competitor.setTotalTime(body.getTotalTime());
        competitor.setImageUrl(body.getImageUrl());
       // competitor.setTeam(body.getTeam());
        competitor.setTeam(body.getTeam());
        competitorRepo.save(competitor);
        return new CompetitorResponse(competitor);
    }

    public void deleteCompetitor(int competitorId){
        competitorRepo.deleteById(competitorId);
    }
}
