package com.example.event_ticketing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeDTO {
    private Integer attendeeId;
    private String name;
    private String email;
}