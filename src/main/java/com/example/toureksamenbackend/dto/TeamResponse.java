package com.example.toureksamenbackend.dto;


import com.example.toureksamenbackend.entities.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamResponse {
    private int id;
    private String name;
    private int ranking;
    private String representedCountry;

    public TeamResponse(Team body){
        this.id = body.getId();
        this.name = body.getName();
        this.ranking = body.getRanking();
        this.representedCountry = getRepresentedCountry();
    }
}
