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
    public Organizer createOrganizer(String name, String email){
        if(organizerRepository.existsByEmail(email)){
            throw new RuntimeException("Email is already registered");
        }
        Organizer organizer = new Organizer();
        organizer.setEmail(email);
        organizer.setName(name);
        return organizerRepository.save(organizer);
    }
}