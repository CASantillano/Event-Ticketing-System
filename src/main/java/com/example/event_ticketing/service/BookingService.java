package com.example.event_ticketing.service;

import com.example.event_ticketing.dto.BookingResponseDTO;
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
        TicketType ticketType = ticketTypeRepository.findById(booking.getTicket_type().getTicket_type_id())
                .orElseThrow(() -> new RuntimeException("Ticket type not found"));
        Attendee attendee = attendeeRepository.findById(booking.getAttendee().getAttendee_id())
                .orElseThrow(() -> new RuntimeException("Attendee not found"));
        if((ticketType.getQuantity_available() <= 0)){
            throw new RuntimeException("Sorry, this ticket is sold out.");
        }
        if(bookingRepository.existsByAttendeeIdAndTicketTypeId(attendee.getAttendee_id(), ticketType.getTicket_type_id())){
            throw new RuntimeException("You have already booked this ticket type.");
        }

        ticketType.setQuantity_available(ticketType.getQuantity_available()-1);
        booking.setBooking_date(LocalDateTime.now());
        booking.setPayment_status(PaymentStatus.CONFIRMED);
        booking.setTicket_type(ticketType);
        booking.setAttendee(attendee);
        Booking savedBooking = bookingRepository.save(booking);

        savedBooking.setBooking_reference("TKT-" + String.valueOf(LocalDateTime.now().getYear()) +
                "-" + String.format("%05d", savedBooking.getBooking_id()));

        return bookingRepository.save(savedBooking);
    }

    // cancel a booking
    @Transactional
    public Booking cancelBooking(Integer bookingId){
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(()-> new RuntimeException("Booking does not exist"));
        if(booking.getPayment_status() == PaymentStatus.CANCELLED){
            throw new RuntimeException("Booking already cancelled");
        }
        booking.getTicket_type().setQuantity_available(booking.getTicket_type().getQuantity_available()+1);
        booking.setPayment_status(PaymentStatus.CANCELLED);
        return bookingRepository.save(booking);
    }

    // get all bookings for an attendee
}