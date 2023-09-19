package com.example.becik.bets;

import com.example.becik.betsDetails.BetsDetailsRepo;
import com.example.becik.event.EventService;
import com.example.becik.user.User;
import com.example.becik.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bets")
public class BetsController {

    private final BetsService betsService;
    private final BetsDetailsRepo betsDetailsRepo;
    private final EventService eventService;

    private final UserService userService;

    public BetsController(BetsService betsService, BetsDetailsRepo betsDetailsRepo, EventService eventService, UserService userService) {
        this.betsService = betsService;
        this.betsDetailsRepo = betsDetailsRepo;
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/all/{username}")
    public ResponseEntity<List<Bets>> getBetsUser(@PathVariable("username") String username){
        List<Bets> bets = betsService.findBetsUser(username);
        return new ResponseEntity<>(bets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bets> getBetsUser(@PathVariable("id") Long id){
        Bets bet = betsService.findBetsByID(id);
        return new ResponseEntity<>(bet, HttpStatus.OK);
    }

    @PostMapping("/{username}")
    public void createBet(
            @PathVariable("username") String username,
            @RequestParam double price) {

        Bets bet = new Bets();
        User user = userService.findByUsername(username);
        bet.setUser(user);
        bet.setPrice(price);
        user.setBalance(user.getBalance()-price);
        bet.setLoseEvents(0);
        bet.setWinEvents(0);
        betsService.addBets(bet);
    }


}
