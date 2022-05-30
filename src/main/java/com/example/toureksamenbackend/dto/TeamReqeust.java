package com.example.toureksamenbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamReqeust {
    int id;
    String name;
    int ranking;
    String representedCountry;
}
