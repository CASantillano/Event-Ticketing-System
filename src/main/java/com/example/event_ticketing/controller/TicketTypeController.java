package com.example.event_ticketing.controller;

import com.example.event_ticketing.dto.TicketTypeDTO;
import com.example.event_ticketing.entity.TicketType;
import com.example.event_ticketing.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickettypes")
public class TicketTypeController{
    @Autowired
    private TicketTypeService ticketTypeService;

    // create a ticket
    @PostMapping
    public ResponseEntity<TicketTypeDTO> createTicketType(
            @RequestBody TicketType ticketType,
            @RequestParam Integer eventId
            ){
        TicketType savedTicket = ticketTypeService.createTicketType(
                ticketType,
                eventId
        );
        TicketTypeDTO dto = new TicketTypeDTO(
                savedTicket.getTicketTypeId(),
                savedTicket.getName(),
                savedTicket.getQuantityAvailable(),
                savedTicket.getPrice()
        );
        return ResponseEntity.status(201).body(dto);
    }
}