package com.example.event_ticketing.controller;

import com.example.event_ticketing.dto.BookingResponseDTO;
import com.example.event_ticketing.entity.Booking;
import com.example.event_ticketing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController{
    @Autowired
    private BookingService bookingService;

    // book a ticket
    @PostMapping
    public BookingResponseDTO bookTicket(@RequestBody Booking booking){
        Booking savedBooking = bookingService.bookTicket(booking);
        return new BookingResponseDTO(
                savedBooking.getBooking_id(),
                savedBooking.getBooking_reference(),
                savedBooking.getBooking_date(),
                savedBooking.getPayment_status(),
                savedBooking.getAttendee().getName(),
                savedBooking.getTicket_type().getEvent().getTitle(),
                savedBooking.getTicket_type().getName(),
                savedBooking.getTicket_type().getPrice()
        );
    }

    // cancel booking
    @PutMapping("/{id}/cancel")
    public BookingResponseDTO cancelBooking(@PathVariable Integer id){
        Booking savedBooking = bookingService.cancelBooking(id);
        return new BookingResponseDTO(
                savedBooking.getBooking_id(),
                savedBooking.getBooking_reference(),
                savedBooking.getBooking_date(),
                savedBooking.getPayment_status(),
                savedBooking.getAttendee().getName(),
                savedBooking.getTicket_type().getEvent().getTitle(),
                savedBooking.getTicket_type().getName(),
                savedBooking.getTicket_type().getPrice()
        );
    }
}