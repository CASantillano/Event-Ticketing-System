package com.example.event_ticketing.service;

import com.example.event_ticketing.entity.Organizer;
import com.example.event_ticketing.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    // create a new organizer
}