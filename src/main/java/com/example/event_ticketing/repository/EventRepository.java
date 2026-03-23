package com.example.event_ticketing.repository;

import com.example.event_ticketing.entity.Event;
import com.example.event_ticketing.enums.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByStatus(EventStatus status);

    // get total revenue for an event
    @Query("SELECT SUM(b.ticketType.price) " +
            "FROM Booking b " +
            "WHERE b.ticketType.event.eventId = :eventId " +
            "AND b.paymentStatus = com.example.event_ticketing.enums.PaymentStatus.CONFIRMED")
    BigDecimal calculateRevenueByEventId(@Param("eventId") Integer eventId);
}