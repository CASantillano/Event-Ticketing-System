package com.example.event_ticketing.controller;

import com.example.event_ticketing.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController{
    @Autowired
    private OrganizerService organizerService;

    // create a new organizer

}