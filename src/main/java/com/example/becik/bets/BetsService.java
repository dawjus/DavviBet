package com.example.becik.bets;

import com.example.becik.betsDetails.BetsDetails;
import com.example.becik.betsDetails.BetsDetailsRepo;
import com.example.becik.event.EventRepo;
import com.example.becik.event.EventService;
import com.example.becik.event.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetsService {

    private final EventService eventService;
    private final BetsRepo betsRepo;

    @Autowired
    public BetsService(EventService eventService, BetsRepo betsRepo) {
        this.eventService = eventService;
        this.betsRepo = betsRepo;
    }

    public List<Bets> findBetsUser(String username){
        return betsRepo.findAllBetsUser(username);
    }

    public Bets findBetsByID(Long id) {
        return betsRepo.findBetById(id);
    }

    public Bets addBets(Bets bets){return betsRepo.save(bets);}

}
