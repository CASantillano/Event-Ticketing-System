package com.example.event_ticketing.controller;

import com.example.event_ticketing.dto.AttendeeBookingsDTO;
import com.example.event_ticketing.entity.Attendee;
import com.example.event_ticketing.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attendees")
public class AttendeeController{
    @Autowired
    private AttendeeService attendeeService;

    // register a new attendee
    @PostMapping
    public AttendeeBookingsDTO registerAttendee(@RequestBody Attendee attendee) {
        Attendee savedAttendee = attendeeService.registerAttendee(attendee);
        return new AttendeeBookingsDTO(
                savedAttendee.getAttendee_id(),
                savedAttendee.getName(),
                savedAttendee.getEmail()
        );
    }
}