package com.example.event_ticketing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeDTO {
    private Integer ticket_type_id;
    private String name;
    private Integer quantity_available;
    private BigDecimal price;
}