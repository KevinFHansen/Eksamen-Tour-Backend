package com.example.toureksamenbackend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Team {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;
     private int ranking;

     public Team(String name, int ranking, String representedCountry) {
          this.name = name;
          this.ranking = ranking;
          this.representedCountry = representedCountry;
     }

     private String representedCountry;

     @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
     private Set<Competitor> competitors = new HashSet<>();


     public void addCompetitor (Competitor competitor){
          this.competitors.add(competitor);
          competitor.setTeam(this);
     }
     public void addCompetitors (Set<Competitor> competitors){
          this.competitors.addAll(competitors);
          for (Competitor competitor : competitors){
               competitor.setTeam(this);
          }
     }
}


