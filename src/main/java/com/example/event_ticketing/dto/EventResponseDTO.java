package com.example.event_ticketing.dto;

import com.example.event_ticketing.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO {
    private Integer eventId;
    private String title;
    private LocalDateTime eventDate;
    private EventStatus status;
    private String description;
    private  String organizerName;
    private String venueName;
    private List<TicketTypeDTO> ticketTypes;
}