package com.example.toureksamenbackend.api;

import com.example.toureksamenbackend.dto.CompetitorRequest;
import com.example.toureksamenbackend.dto.CompetitorResponse;
import com.example.toureksamenbackend.service.CompetitorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/competitors")
public class CompetitorController {

    CompetitorService competitorService;

    public CompetitorController(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @GetMapping
    public List<CompetitorResponse> getAllCompetitors(@RequestParam(value = "team", required = false) String team){
        return competitorService.getAllCompetitors(team);
    }

    @PostMapping
    public void addNewCompetitor(@RequestBody CompetitorRequest body){
        competitorService.addNewCompetitor(body);
    }

    @PutMapping("/{id}")
    public CompetitorResponse editCompetitor(@RequestBody CompetitorRequest body, @PathVariable int id){
        return competitorService.editCompetitor(body, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable int id){
        competitorService.deleteCompetitor(id);
    }

}
