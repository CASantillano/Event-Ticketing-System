package com.example.event_ticketing.repository;

import com.example.event_ticketing.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Integer> {
    // register a new attendee happens in service

}