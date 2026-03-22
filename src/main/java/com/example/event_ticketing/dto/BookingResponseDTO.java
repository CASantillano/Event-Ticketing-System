package com.example.event_ticketing.dto;

import com.example.event_ticketing.entity.TicketType;
import com.example.event_ticketing.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {
    private Integer booking_id;
    private String booking_reference;
    private LocalDateTime booking_date;
    private PaymentStatus payment_status;
    private String attendeeName;
    private String eventTitle;
    private String ticketTypeName;
    private BigDecimal price;
}