package com.example.event_ticketing.repository;

import com.example.event_ticketing.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    //get all bookings for an attendee
    List<Booking> findByAttendee_Attendee_Id(Integer attendeeId);

    // check if attendee already booked same ticket type
    boolean existsByAttendee_Attendee_idAndTicket_type_Ticket_type_id(
            Integer attendeeId,
            Integer ticketTypeId
    );
}