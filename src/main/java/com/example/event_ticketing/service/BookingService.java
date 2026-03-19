package com.example.event_ticketing.service;

import com.example.event_ticketing.entity.Booking;
import com.example.event_ticketing.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    // book a ticket
    @Transactional

    // cancel a booking
    @Transactional

    // get all bookings for an attendee
}