package com.example.becik.event;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService =  eventService;
    }

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event){
        Event newEvent = eventService.addEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Event>> getEventsByMatch(@PathVariable("id") Long matchId){
        List<Event> events = eventService.findEvent(matchId);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

}
