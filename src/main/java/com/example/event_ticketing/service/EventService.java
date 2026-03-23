package com.example.event_ticketing.service;

import com.example.event_ticketing.dto.EventResponseDTO;
import com.example.event_ticketing.dto.RevenueDTO;
import com.example.event_ticketing.dto.TicketTypeDTO;
import com.example.event_ticketing.entity.Event;
import com.example.event_ticketing.entity.Organizer;
import com.example.event_ticketing.entity.TicketType;
import com.example.event_ticketing.entity.Venue;
import com.example.event_ticketing.enums.EventStatus;
import com.example.event_ticketing.repository.EventRepository;
import com.example.event_ticketing.repository.OrganizerRepository;
import com.example.event_ticketing.repository.VenueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private VenueRepository venueRepository;

    // create a new event, validate
    @Transactional
    public Event createEvent(Event event, Integer organizerId, Integer venueId){
        Organizer organizer = organizerRepository.findById(organizerId)
                .orElseThrow(()-> new RuntimeException("Organizer not found"));
        Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new RuntimeException("Venue not found"));

        event.setOrganizer(organizer);
        event.setVenue(venue);
        return eventRepository.save(event);
    }

    // list all upcoming events
    public List<EventResponseDTO> getAllUpcomingEvents(){
        return eventRepository.findByStatus(EventStatus.UPCOMING).stream().map(
                event -> new EventResponseDTO(
                        event.getEvent_id(),
                        event.getTitle(),
                        event.getEvent_date(),
                        event.getStatus(),
                        event.getDescription(),
                        event.getOrganizer().getName(),
                        event.getVenue().getName(),
                        null
                )
        ).collect(Collectors.toList());
    }

    // get event details with ticket types
    public EventResponseDTO getEvent(Integer eventId){
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        List<TicketTypeDTO> tickets = new ArrayList<>();
        for (TicketType t: event.getTicketTypes()){
            TicketTypeDTO tDTO = new TicketTypeDTO(
                    t.getTicket_type_id(),
                    t.getName(),
                    t.getQuantity_available(),
                    t.getPrice()
            );
            tickets.add(tDTO);
        }

        return new EventResponseDTO(
                event.getEvent_id(),
                event.getTitle(),
                event.getEvent_date(),
                event.getStatus(),
                event.getDescription(),
                event.getOrganizer().getName(),
                event.getVenue().getName(),
                tickets
        );
    }

    // get total revenue for an event
    public RevenueDTO getRevenue(Integer eventId){
        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new RuntimeException("Event not found"));

        BigDecimal revenue = eventRepository.calculateRevenueByEventId(eventId);
        if(revenue == null){
            revenue = BigDecimal.ZERO;
        }
        return new RevenueDTO(
                event.getTitle(),
                revenue
        );
    }
}