package com.example.event_ticketing.service;

import com.example.event_ticketing.entity.Attendee;
import com.example.event_ticketing.repository.AttendeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;

    // register a new attendee, email must be unique
    @Transactional
    public Attendee createAttendee(String name, String email){
        if (attendeeRepository.existsByEmail(email)){
            throw new RuntimeException("Email already registered");
        }
        Attendee attendee = new Attendee();
        attendee.setName(name);
        attendee.setEmail(email);
        return attendeeRepository.save(attendee);
    }
}