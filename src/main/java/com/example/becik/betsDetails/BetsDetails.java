package com.example.becik.betsDetails;

import com.example.becik.bets.Bets;
import com.example.becik.event.Event;
import com.example.becik.event.ResultType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@IdClass(BetsDetailsId.class)
@Table(name = "bets_details")
public class BetsDetails implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "bet_id")
    private Bets bet;
    @Id
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @Enumerated(EnumType.STRING)
    private ResultType result;

}
