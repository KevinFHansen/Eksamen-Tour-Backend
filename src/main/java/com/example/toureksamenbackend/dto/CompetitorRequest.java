package com.example.toureksamenbackend.dto;

import com.example.toureksamenbackend.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetitorRequest {
    String firstName;
    String lastName;
    int age;
    String nationality;
    int climberPoints;
    int sprintPoints;
    int totalTime;
    Team team;
    String imageUrl;
}
