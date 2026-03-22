package com.example.event_ticketing.service;

import com.example.event_ticketing.entity.Event;
import com.example.event_ticketing.entity.TicketType;
import com.example.event_ticketing.repository.EventRepository;
import com.example.event_ticketing.repository.TicketTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketTypeService {
    @Autowired
    private TicketTypeRepository ticketTypeRepository;
    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public TicketType createTicketType(TicketType ticketType, Integer eventId){
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        ticketType.setEvent(event);
        return ticketTypeRepository.save(ticketType);
    }
}