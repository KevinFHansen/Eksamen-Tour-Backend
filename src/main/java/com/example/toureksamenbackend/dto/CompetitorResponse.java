package com.example.toureksamenbackend.dto;


import com.example.toureksamenbackend.entities.Competitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompetitorResponse {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String nationality;
    private int climberPoints;
    private int sprintPoints;
    private int totalTime;
    private TeamResponse teamResponse;
    private String imageUrl;

    public CompetitorResponse(Competitor body){
        this.id = body.getId();
        this.firstName = body.getFirstName();
        this.lastName = body.getLastName();
        this.age = body.getAge();
        this.nationality = body.getNationality();
        this.climberPoints = body.getClimberPoints();
        this.sprintPoints = body.getSprintPoints();
        this.totalTime = body.getTotalTime();
        this.teamResponse = new TeamResponse(
                body.getTeam().getId(),
                body.getTeam().getName(),
                body.getTeam().getRanking(),
                body.getTeam().getRepresentedCountry());
        this.imageUrl = body.getImageUrl();
    }
}

