package com.example.toureksamenbackend.config;

import com.example.toureksamenbackend.entities.Team;
import com.example.toureksamenbackend.entities.Competitor;
import com.example.toureksamenbackend.repositories.TeamRepo;
import com.example.toureksamenbackend.repositories.CompetitorRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Profile("!test")
public class MakeTestData implements ApplicationRunner {

    TeamRepo teamRepo;
    CompetitorRepo competitorRepo;

    public MakeTestData(TeamRepo teamRepo, CompetitorRepo competitorRepo){
        this.teamRepo = teamRepo;
        this.competitorRepo = competitorRepo;
    }

    public void createTeamWithCompetitors(){
        Team team1 = new Team("Jumbo-Visma", 0, "Netherlands" );
        Team team2 = new Team("Quick-Step Alpha Vinyl Team", 0, "Belgium");
        Team team3 = new Team("Trek - Segafredo", 0, "Luxembourg");

//        Team team4 = new Team("Team DSM", 0, "Netherlands");
//        Team team5 = new Team("Alpecin-Deceuninck", 0, "Belgium");
//        Team team6 = new Team("Cofidis", 0, "France");

        //TEAM JUMBO-VISMA
        Competitor competitor1 = new Competitor("Sepp", "Kuss", 27, "United States", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/bf/sepp-kuss-2022.jpeg");
        Competitor competitor2 = new Competitor("Tiesj", "Benoot", 28, "Belgium", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/ba/tiesj-benoot-2022.jpeg");
        Competitor competitor3 = new Competitor("Jonas", "Vingegaard", 25, "Denmark", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/ea/jonas-vingegaard-rasmussen-2022.jpeg");
        Competitor competitor4 = new Competitor("Rohan", "Dennis", 32, "Australia", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/cb/rohan-dennis-2022.jpeg");
        Competitor competitor5 = new Competitor("Wout", "Aert", 27, "Belgium", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/ea/wout-van-aert-2022.jpeg");


        // TEAM Quick-Step Alpha Vinyl Team
        Competitor competitor6 = new Competitor("Michael", "Mørkøv", 37, "Denmark", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/fa/michael-morkov-2022.jpeg");
        Competitor competitor7 = new Competitor("Yves", "Lampaert", 31, "Belgium", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/aa/yves-lampaert-2022.jpeg");
        Competitor competitor8 = new Competitor("Tim", "Declercq", 33, "Belgium", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/fc/tim-declercq-2022.jpeg");
        Competitor competitor9 = new Competitor("Julian", "Alaphilippe", 29, "France", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/bf/julian-alaphilippe-2022.jpeg");
        Competitor competitor10 = new Competitor("Fabio", "Jakobsen", 25, "Denmark", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/df/fabio-jakobsen-2022.jpeg");

        // TEAM Trek - Segafredo
        Competitor competitor11 = new Competitor("Quinn", "Simmons", 21, "United States", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/ac/quinn-simmons-2022.jpeg");
        Competitor competitor12 = new Competitor("Jasper", "Stuyven", 30, "Belgium", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/aa/yves-lampaert-2022.jpeg");
        Competitor competitor13 = new Competitor("Antwan", "Tolhoek", 28, "Netherlands", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/bd/antwan-tolhoek-2022.jpeg");
        Competitor competitor14 = new Competitor("Bauke", "Mollema", 35, "Netherlands", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/ca/bauke-mollema-2022.jpeg");
        Competitor competitor15 = new Competitor("Mads ", "Pedersen", 26, "Denmark", 0, 0, 0 ,"https://www.procyclingstats.com/images/riders/bp/ca/mads-pedersen-2022.jpeg");

        team1.addCompetitors(Set.of(competitor1,competitor2,competitor3,competitor4,competitor5));
        team2.addCompetitors(Set.of(competitor6,competitor7,competitor8,competitor9,competitor10));
        team3.addCompetitors(Set.of(competitor11,competitor12,competitor13,competitor14,competitor15));
        teamRepo.saveAll(List.of(team1, team2, team3));
    }
    @Override
    public void run(ApplicationArguments args) throws Exception{
        createTeamWithCompetitors();
    }

}
