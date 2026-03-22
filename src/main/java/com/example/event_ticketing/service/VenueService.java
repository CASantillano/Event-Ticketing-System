package com.example.event_ticketing.service;

import com.example.event_ticketing.entity.Venue;
import com.example.event_ticketing.repository.VenueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    // create a new venue
    @Transactional
    public Venue createVenue(Venue venue){
        if(venue.getTotal_capacity() <= 0){
            throw new RuntimeException("Capacity must be greater than 0");
        }
        return venueRepository.save(venue);
    }
}