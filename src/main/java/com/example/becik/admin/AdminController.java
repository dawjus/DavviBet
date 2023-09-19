package com.example.becik.admin;

import com.example.becik.event.Event;
import com.example.becik.event.EventService;
import com.example.becik.event.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final EventService eventService;

    @Autowired
    public AdminController(AdminService adminService, EventService eventService) {
        this.adminService = adminService;
        this.eventService = eventService;
    }

    @GetMapping("/unsettled")
    public ResponseEntity<List<Event>> getAllUnsettledEvent(){
        List<Event> events = adminService.getUnsettledEvent();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PostMapping("/unsettled/{id}")
    public ResponseEntity<Event> changeStatus(
            @PathVariable("id") Long id,
            @RequestBody ResultType result
    ){
        Event event = eventService.findEventById(id);
        event.setResult(result);
        eventService.updateEvent(event);
        switch (result){
            case WIN ->  adminService.winBetsUpdate(id);
            case LOSE -> adminService.loseBetsUpdate(id);
            case UNSETTLED -> {}
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }



}
