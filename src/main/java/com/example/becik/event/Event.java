package com.example.becik.event;

import com.example.becik.match.Match;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private String description;
    private double course;
    @Enumerated(EnumType.STRING)
    private ResultType result;
    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

}
