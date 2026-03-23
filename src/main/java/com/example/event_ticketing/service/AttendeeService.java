package com.example.event_ticketing.service;

import com.example.event_ticketing.dto.AttendeeBookingsDTO;
import com.example.event_ticketing.dto.BookingResponseDTO;
import com.example.event_ticketing.entity.Attendee;
import com.example.event_ticketing.repository.AttendeeRepository;
import com.example.event_ticketing.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;
    @Autowired
    private BookingRepository bookingRepository;

    // register a new attendee, email must be unique
    @Transactional
    public Attendee registerAttendee(Attendee attendee){
        if (attendeeRepository.existsByEmail(attendee.getEmail())){
            throw new RuntimeException("Email already registered");
        }
        return attendeeRepository.save(attendee);
    }

    // get all bookings for an attendee
    public AttendeeBookingsDTO getBookingsByAttendee(Integer attendeeId){
       Attendee attendee = attendeeRepository.findById(attendeeId)
               .orElseThrow(()-> new RuntimeException("Attendee not found"));

        List<BookingResponseDTO> bookings = bookingRepository.findByAttendee_AttendeeId(attendeeId)
                .stream().map(
                booking -> new BookingResponseDTO(
                        booking.getBookingId(),
                        booking.getBookingReference(),
                        booking.getBookingDate(),
                        booking.getPaymentStatus(),
                        booking.getAttendee().getName(),
                        booking.getTicketType().getEvent().getTitle(),
                        booking.getTicketType().getName(),
                        booking.getTicketType().getPrice()
                )
        ).collect(Collectors.toList());
        return new AttendeeBookingsDTO(
                attendee.getName(),
                bookings
        );
    }
}