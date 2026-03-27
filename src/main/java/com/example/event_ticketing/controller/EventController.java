package com.example.event_ticketing.controller;

import com.example.event_ticketing.dto.EventResponseDTO;
import com.example.event_ticketing.dto.RevenueDTO;
import com.example.event_ticketing.entity.Event;
import com.example.event_ticketing.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController{
    @Autowired
    private EventService eventService;

    // create a new event
    @PostMapping
    public EventResponseDTO createEvent(
            @RequestBody Event event,
            @RequestParam Integer organizerId,
            @RequestParam Integer venueId
    ){
        Event savedEvent = eventService.createEvent(event, organizerId, venueId);
        return new EventResponseDTO(
                savedEvent.getEventId(),
                savedEvent.getTitle(),
                savedEvent.getEventDate(),
                savedEvent.getStatus(),
                savedEvent.getDescription(),
                savedEvent.getOrganizer().getName(),
                savedEvent.getVenue().getName(),
                null
        );
    }

    // list all upcoming events
    @GetMapping
    public List<EventResponseDTO> getUpcomingEvents(){
        return eventService.getAllUpcomingEvents();
    }

    // get event details with ticket types
    @GetMapping("/{eventId}")
    public EventResponseDTO getEvent(@PathVariable Integer eventId){
        return eventService.getEvent(eventId);
    }

    // get total revenue for an event
    @GetMapping("/{eventId}/revenue")
    public RevenueDTO getRevenue(@PathVariable Integer eventId){
        return eventService.getRevenue(eventId);
    }
}