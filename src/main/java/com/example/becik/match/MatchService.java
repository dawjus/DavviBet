package com.example.becik.match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepo matchRepo;

    @Autowired
    public MatchService(MatchRepo matchRepo) {
        this.matchRepo = matchRepo;
    }

    public Match addMatch(Match match){
        return matchRepo.save(match);
    }

    public List<Match> findAllMatches(){
        return matchRepo.findAll();
    }
}
