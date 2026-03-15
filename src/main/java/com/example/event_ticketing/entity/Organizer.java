package com.example.event_ticketing.entity;

import jakarta.persistence.*;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name="Organizer")
@Data
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organizer_id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String phone;

    // relationship
    // do @ManyToOne
    // @JoinColumn(name = "organizer_id") in event to finish relationship
    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<Event> events;
}
