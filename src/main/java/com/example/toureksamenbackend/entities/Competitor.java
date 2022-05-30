package com.example.toureksamenbackend.entities;


import com.example.toureksamenbackend.dto.CompetitorRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Competitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private int age;
    private String nationality;
    private int climberPoints;
    private int sprintPoints;
    private int totalTime;

    public Competitor(String firstName, String lastName, int age, String nationality, int climberPoints, int sprintPoints, int totalTime, String imageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.climberPoints = climberPoints;
        this.sprintPoints = sprintPoints;
        this.totalTime = totalTime;
        this.imageUrl = imageUrl;
    }

    @ManyToOne()
    private Team team;

    private String imageUrl;


    public Competitor(CompetitorRequest body){
        this.firstName = body.getFirstName();
        this.lastName = body.getLastName();
        this.age = body.getAge();
        this.nationality = body.getNationality();
        this.climberPoints = body.getClimberPoints();
        this.sprintPoints = body.getSprintPoints();
        this.totalTime = body.getTotalTime();
        this.imageUrl = body.getImageUrl();
        this.team = body.getTeam();
    }
}
