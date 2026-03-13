package com.example.event_ticketing.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Table(name="Organizer")
@Data
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organizer_id;

    @Column(nullable = false)
    private String name;

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
