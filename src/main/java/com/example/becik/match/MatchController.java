package com.example.becik.match;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/")
    public String hello(){
        return "meczyki";
    }

    @PostMapping("/add")
    public ResponseEntity<Match> addMatch(@RequestBody Match match){
        Match newMatch = matchService.addMatch(match);
        return new ResponseEntity<>(newMatch, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Match>> getAllUsers(){
        List<Match> matches = matchService.findAllMatches();
        return new ResponseEntity<>(matches, HttpStatus.OK);
    }


}
