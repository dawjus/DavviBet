package com.example.becik.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public Event addEvent(Event event){
        return eventRepo.save(event);
    }

    public List<Event> findEvent(Long matchID){
        return eventRepo.findAllEventsByMatchId(matchID);
    }

    public Event findEventById(Long id){
        return eventRepo.findEventById(id);
    }

    public List<Event> findEventUnsettled(){
        return eventRepo.findEventUnsettled();
    }
}
