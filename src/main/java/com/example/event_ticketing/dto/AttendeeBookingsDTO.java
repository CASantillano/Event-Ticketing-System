package com.example.event_ticketing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeBookingsDTO {
    private Integer attendee_id;
    private String name;
    private String email;
}