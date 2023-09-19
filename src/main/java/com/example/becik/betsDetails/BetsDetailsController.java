package com.example.becik.betsDetails;

import com.example.becik.bets.Bets;
import com.example.becik.bets.BetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/createBets")
public class BetsDetailsController {

    private final BetsDetailsService betsDetailsService;
    private final BetsService betsService;
    @Autowired
    public BetsDetailsController(BetsDetailsService betsDetailsService, BetsService betsService) {
        this.betsDetailsService = betsDetailsService;
        this.betsService = betsService;
    }
    @PostMapping("{username}/{bet_id}")
    public void addEventToBet(
            @PathVariable("username") String username,
            @PathVariable("bet_id") Long id,
            @RequestBody List<Long> eventIds) {
        Bets bet = betsService.findBetsByID(id);
        for (Long eventId: eventIds){
            betsDetailsService.addEventToBet(eventId, bet.getId());
        }
        bet.setNumber_events(eventIds.size());
        betsService.addBets(bet);
    }
}
