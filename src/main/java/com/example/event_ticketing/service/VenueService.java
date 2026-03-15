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
    public Venue createVenue(String name, String address, String city, Integer total_capacity){
        Venue venue = new Venue();
        venue.setName(name);
        venue.setAddress(address);
        venue.setCity(city);
        venue.setTotal_capacity(total_capacity);

        return venueRepository.save(venue);
    }
}