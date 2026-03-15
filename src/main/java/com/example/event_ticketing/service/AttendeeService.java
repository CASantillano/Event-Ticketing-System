package com.example.event_ticketing.service;

import com.example.event_ticketing.entity.Attendee;
import com.example.event_ticketing.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;

    // register a new attendee, email must be unique

    //
}