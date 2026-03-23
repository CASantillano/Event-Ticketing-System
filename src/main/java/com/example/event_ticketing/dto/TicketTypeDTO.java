package com.example.event_ticketing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeDTO {
    private Integer ticketTypeId;
    private String name;
    private Integer quantityAvailable;
    private BigDecimal price;
}