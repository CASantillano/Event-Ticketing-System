package com.example.event_ticketing.repository;

import com.example.event_ticketing.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    boolean existsByEmail(String email);
}