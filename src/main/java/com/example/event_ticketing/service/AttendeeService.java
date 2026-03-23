package com.example.event_ticketing.service;

import com.example.event_ticketing.dto.BookingResponseDTO;
import com.example.event_ticketing.entity.Attendee;
import com.example.event_ticketing.entity.Booking;
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
    public List<BookingResponseDTO> getBookingsByAttendee(Integer attendeeId){
        List<Booking> bookings = bookingRepository.findByAttendee_Id(attendeeId);

        return bookings.stream().map(
                booking -> new BookingResponseDTO(
                        booking.getBooking_id(),
                        booking.getBooking_reference(),
                        booking.getBooking_date(),
                        booking.getPayment_status(),
                        booking.getAttendee().getName(),
                        booking.getTicket_type().getEvent().getTitle(),
                        booking.getTicket_type().getName(),
                        booking.getTicket_type().getPrice()
                )
        ).collect(Collectors.toList());
    }
}