package com.example.event_ticketing.repository;

import com.example.event_ticketing.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType, Integer> {
    //
}