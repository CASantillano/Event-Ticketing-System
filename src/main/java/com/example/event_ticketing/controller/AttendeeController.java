package com.example.event_ticketing.controller;

import com.example.event_ticketing.dto.AttendeeBookingsDTO;
import com.example.event_ticketing.dto.BookingResponseDTO;
import com.example.event_ticketing.entity.Attendee;
import com.example.event_ticketing.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // get all bookings for an attendee
    @GetMapping("/{id}/bookings")
    public List<BookingResponseDTO> getBookingsByAttendee(@RequestParam Integer attendeeId){
        return attendeeService.getBookingsByAttendee(attendeeId);
    }
}