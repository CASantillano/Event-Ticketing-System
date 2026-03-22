package com.example.event_ticketing.controller;

import com.example.event_ticketing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController{
    @Autowired
    private BookingService bookingService;

    //
}