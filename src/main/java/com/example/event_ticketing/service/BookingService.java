package com.example.event_ticketing.service;

import com.example.event_ticketing.entity.Attendee;
import com.example.event_ticketing.entity.Booking;
import com.example.event_ticketing.entity.TicketType;
import com.example.event_ticketing.enums.PaymentStatus;
import com.example.event_ticketing.repository.AttendeeRepository;
import com.example.event_ticketing.repository.BookingRepository;
import com.example.event_ticketing.repository.TicketTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private AttendeeRepository attendeeRepository;
    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    // book a ticket
    @Transactional
    public Booking bookTicket(Booking booking){
        TicketType ticketType = ticketTypeRepository.findById(booking.getTicketType().getTicketTypeId())
                .orElseThrow(() -> new RuntimeException("Ticket type not found"));
        Attendee attendee = attendeeRepository.findById(booking.getAttendee().getAttendeeId())
                .orElseThrow(() -> new RuntimeException("Attendee not found"));
        if((ticketType.getQuantityAvailable() <= 0)){
            throw new RuntimeException("Sorry, this ticket is sold out.");
        }
        if(bookingRepository.existsByAttendee_AttendeeIdAndTicketType_TicketTypeId(
                attendee.getAttendeeId(),
                ticketType.getTicketTypeId())){
            throw new RuntimeException("You have already booked this ticket type.");
        }
        booking.setBookingReference("PENDING");
        ticketType.setQuantityAvailable(ticketType.getQuantityAvailable()-1);
        booking.setBookingDate(LocalDateTime.now());
        booking.setPaymentStatus(PaymentStatus.CONFIRMED);
        booking.setTicketType(ticketType);
        booking.setAttendee(attendee);
        Booking savedBooking = bookingRepository.saveAndFlush(booking);

        savedBooking.setBookingReference("TKT-" + String.valueOf(LocalDateTime.now().getYear()) +
                "-" + String.format("%05d", savedBooking.getBookingId()));

        return bookingRepository.save(savedBooking);
    }

    // cancel a booking
    @Transactional
    public Booking cancelBooking(Integer bookingId){
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(()-> new RuntimeException("Booking does not exist"));
        if(booking.getPaymentStatus() == PaymentStatus.CANCELLED){
            throw new RuntimeException("Booking already cancelled");
        }
        booking.getTicketType().setQuantityAvailable(booking.getTicketType().getQuantityAvailable()+1);
        booking.setPaymentStatus(PaymentStatus.CANCELLED);
        return bookingRepository.save(booking);
    }
}