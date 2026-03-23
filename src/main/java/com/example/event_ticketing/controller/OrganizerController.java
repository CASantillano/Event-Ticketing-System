package com.example.event_ticketing.controller;

import com.example.event_ticketing.dto.OrganizerDTO;
import com.example.event_ticketing.entity.Organizer;
import com.example.event_ticketing.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController{
    @Autowired
    private OrganizerService organizerService;

    // create a new organizer
    @PostMapping
    public ResponseEntity<OrganizerDTO> createOrganizer(@RequestBody Organizer organizer){
        Organizer savedOrganizer = organizerService.createOrganizer(organizer);
        OrganizerDTO dto = new OrganizerDTO(
                savedOrganizer.getOrganizerId(),
                savedOrganizer.getName(),
                savedOrganizer.getEmail(),
                savedOrganizer.getPhone()
        );
        return ResponseEntity.status(201).body(dto);
    }
}