package com.example.event_ticketing.dto;

import com.example.event_ticketing.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO {
    private Integer event_id;
    private String title;
    private LocalDateTime event_date;
    private EventStatus status;
    private String description;
}