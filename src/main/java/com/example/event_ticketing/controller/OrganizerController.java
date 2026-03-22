package com.example.event_ticketing.controller;

import com.example.event_ticketing.dto.OrganizerDTO;
import com.example.event_ticketing.entity.Organizer;
import com.example.event_ticketing.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController{
    @Autowired
    private OrganizerService organizerService;

    // create a new organizer
    @PostMapping
    public OrganizerDTO createOrganizer(@RequestBody Organizer organizer){
        Organizer savedOrganizer = organizerService.createOrganizer(organizer);
        return new OrganizerDTO(
                savedOrganizer.getOrganizer_id(),
                savedOrganizer.getName(),
                savedOrganizer.getEmail(),
                savedOrganizer.getPhone()
        );
    }
}