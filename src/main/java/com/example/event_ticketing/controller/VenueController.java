package com.example.event_ticketing.controller;

import com.example.event_ticketing.dto.VenueDTO;
import com.example.event_ticketing.entity.Venue;
import com.example.event_ticketing.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/venues")
public class VenueController{
    @Autowired
    private VenueService venueService;

    // create a new venue
    @PostMapping
    public ResponseEntity<VenueDTO> createVenue(@RequestBody Venue venue){
        Venue savedVenue = venueService.createVenue(venue);
        VenueDTO dto = new VenueDTO(
                savedVenue.getVenue_id(),
                savedVenue.getName(),
                savedVenue.getAddress(),
                savedVenue.getCity(),
                savedVenue.getTotal_capacity()
        );
        return ResponseEntity.status(201).body(dto);
    }
}