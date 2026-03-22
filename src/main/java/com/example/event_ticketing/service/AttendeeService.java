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
    public Attendee registerAttendee(Attendee attendee){
        if (attendeeRepository.existsByEmail(attendee.getEmail())){
            throw new RuntimeException("Email already registered");
        }
        return attendeeRepository.save(attendee);
    }
}