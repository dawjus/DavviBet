package com.example.becik.betsDetails;

import com.example.becik.bets.Bets;
import com.example.becik.bets.BetsRepo;
import com.example.becik.bets.BetsService;
import com.example.becik.event.Event;
import com.example.becik.event.EventService;
import com.example.becik.event.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetsDetailsService {
    private final EventService eventService;
    private final BetsService betsService;
    private final BetsRepo betsRepo;
    private final BetsDetailsRepo betsDetailsRepo;

    @Autowired
    public BetsDetailsService(EventService eventService, BetsService betsService, BetsRepo betsRepo, BetsDetailsRepo betsDetailsRepo) {
        this.eventService = eventService;
        this.betsService = betsService;
        this.betsRepo = betsRepo;
        this.betsDetailsRepo = betsDetailsRepo;
    }

    public void addEventToBet(Long eventId, Long betId){
        BetsDetails newBets = new BetsDetails();
        Bets bet = betsService.findBetsByID(betId);
        Event event = eventService.findEventById(eventId);
        bet.addCourse(event.getCourse());
        newBets.setResult(ResultType.UNSETTLED);
        newBets.setBet(bet);
        newBets.setEvent(event);
        betsDetailsRepo.save(newBets);
        betsRepo.save(bet);
    }

    public List<Bets> findBetsToUpdate(Long eventID){
        return betsDetailsRepo.findBetsFromEvent(eventID);
    }

}
