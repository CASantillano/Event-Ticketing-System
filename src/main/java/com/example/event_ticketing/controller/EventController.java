package com.example.event_ticketing.controller;

import com.example.event_ticketing.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController{
    @Autowired
    private EventService eventService;

    // create a new event

    // list all upcoming events

    // get all upcoming event details with ticket types

    // get total revenue for an event
}