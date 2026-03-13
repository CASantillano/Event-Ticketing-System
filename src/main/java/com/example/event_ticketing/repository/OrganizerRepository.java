package com.example.event_ticketing.repository;

import com.example.event_ticketing.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    //create a new organizer happens in service
}