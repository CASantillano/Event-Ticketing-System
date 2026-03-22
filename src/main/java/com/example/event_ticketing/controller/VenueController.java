package com.example.event_ticketing.controller;

import com.example.event_ticketing.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/venues")
public class VenueController{
    @Autowired
    private VenueService venueService;

    // create a new venue
}