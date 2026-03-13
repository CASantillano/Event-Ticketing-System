package com.example.event_ticketing.repository;

import com.example.event_ticketing.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    // book a ticket in service?
    // cancel a booking in service?

    //get all bookings for an attendee
    //List<Booking> findByAttendde_Id(Integer id);?
}