package com.example.becik.admin;

import com.example.becik.bets.Bets;
import com.example.becik.betsDetails.BetsDetailsService;
import com.example.becik.event.Event;
import com.example.becik.event.EventService;
import com.example.becik.match.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final EventService eventService;
    private final BetsDetailsService betsDetailsService;

    @Autowired
    public AdminService(EventService eventService, BetsDetailsService betsDetailsService) {
        this.eventService = eventService;
        this.betsDetailsService = betsDetailsService;
    }

    public List<Event> getUnsettledEvent(){
        return eventService.findEventUnsettled();
    }

    public void winBetsUpdate(Long eventID){
        List<Bets> bets = betsDetailsService.findBetsToUpdate(eventID);
        for (Bets bet: bets){
            bet.increase_win_events();
        }
    }

    public void loseBetsUpdate(Long eventID){
        List<Bets> bets = betsDetailsService.findBetsToUpdate(eventID);
        for (Bets bet: bets){
            bet.increase_lose_events();
        }
    }

}
