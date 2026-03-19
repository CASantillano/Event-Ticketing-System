package com.example.event_ticketing.service;

import com.example.event_ticketing.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    // create a new event, validate
    @Transactional

    // list all upcoming events

    // get event details with ticket types

    // get total revenue for an event
}