package com.example.event_ticketing.controller;

import com.example.event_ticketing.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController{
    @Autowired
    private AttendeeService attendeeService;

    // register a new attendee
}