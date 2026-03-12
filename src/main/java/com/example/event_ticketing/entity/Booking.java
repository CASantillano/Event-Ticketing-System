package com.example.event_ticketing.entity;

import com.example.event_ticketing.enums.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer booking_id;

    @Column(nullable = false, unique = true)
    private String booking_reference;

    @Column(nullable = false)
    private LocalDateTime booking_date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus payment_status;

    @ManyToOne
    @JoinColumn(name = "attendee_id")
    private Attendee attendee;

    @ManyToOne
    @JoinColumn(name = "ticket_type_id")
    private TicketType ticket_type;

}
