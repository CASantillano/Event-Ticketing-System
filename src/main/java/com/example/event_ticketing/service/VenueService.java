package com.example.event_ticketing.service;

import com.example.event_ticketing.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;
}