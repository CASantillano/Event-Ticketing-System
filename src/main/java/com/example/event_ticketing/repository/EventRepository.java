package com.example.event_ticketing.repository;

import com.example.event_ticketing.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    // create a new event happens in service

    // List all upcoming events

    // get event details with ticket types

    // get total revenue for an event
}