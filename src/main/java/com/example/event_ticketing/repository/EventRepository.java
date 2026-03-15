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
    // get event details with ticket types
    List<Event> findByStatus(EventStatus status);

    // get total revenue for an event
    @Query("SELECT SUM(b.ticket_type.price)" +
            "FROM Booking b WHERE b.ticket_type.event.event_id = :event_id AND b.payment_status = 'CONFIRMED'")
    BigDecimal calculateRevenueByEventId(@Param("event_id") Integer event_id);
}