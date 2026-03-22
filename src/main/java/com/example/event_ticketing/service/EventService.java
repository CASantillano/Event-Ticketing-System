package com.example.event_ticketing.service;

import com.example.event_ticketing.entity.Event;
import com.example.event_ticketing.entity.Organizer;
import com.example.event_ticketing.entity.Venue;
import com.example.event_ticketing.repository.EventRepository;
import com.example.event_ticketing.repository.OrganizerRepository;
import com.example.event_ticketing.repository.VenueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private VenueRepository venueRepository;

    // create a new event, validate
    @Transactional
    public Event createEvent(Event event, Integer organizerId, Integer venueId){
        Organizer organizer = organizerRepository.findById(organizerId).orElseThrow(()-> new RuntimeException("Organizer not found"));
        Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new RuntimeException("Venue not found"));

        event.setOrganizer(organizer);
        event.setVenue(venue);
        return eventRepository.save(event);
    }

    // list all upcoming events

    // get event details with ticket types

    // get total revenue for an event
}