package com.example.event_ticketing.repository;

import com.example.event_ticketing.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    //get all bookings for an attendee
    List<Booking> findByAttendee_Id(Integer id);

    // check if attendee already booked same ticket type
    boolean existsByAttendeeIdAndTicketTypeId(Integer attendee_id, Integer ticket_type_id);
}