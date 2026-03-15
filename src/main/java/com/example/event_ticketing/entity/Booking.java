package com.example.event_ticketing.entity;

import com.example.event_ticketing.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="Booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer booking_id;

    @NotBlank(message = "Booking reference is required")
    @Column(nullable = false, unique = true)
    private String booking_reference;

    @Column(nullable = false, updatable = false)
    private LocalDateTime booking_date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus payment_status;

    @ManyToOne
    @JoinColumn(name = "attendee_id", nullable = false)
    private Attendee attendee;

    @ManyToOne
    @JoinColumn(name = "ticket_type_id", nullable = false)
    private TicketType ticket_type;

}
