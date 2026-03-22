package com.example.event_ticketing.service;

import com.example.event_ticketing.entity.Organizer;
import com.example.event_ticketing.repository.OrganizerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    // create a new organizer
    @Transactional
    public Organizer createOrganizer(Organizer organizer){
        if(organizerRepository.existsByEmail(organizer.getEmail())){
            throw new RuntimeException("Email is already registered");
        }
        return organizerRepository.save(organizer);
    }
}