package com.example.becik.bets;

import com.example.becik.event.ResultType;
import com.example.becik.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bets")
public class Bets implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double course=1;
    private double price;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    @Enumerated(EnumType.STRING)
    private ResultType result = ResultType.UNSETTLED;
    private int number_events;
    private int winEvents;
    private int loseEvents;

    public void increase_win_events() {
        this.winEvents += 1;
        if (this.winEvents == this.number_events) {
            this.result = ResultType.WIN;
            user.setBalance(user.getBalance()+this.course*this.price);
        }
    }

    public void increase_lose_events() {
        this.loseEvents += 1;
        this.result = ResultType.LOSE;
    }

    public void addCourse(double course){
        this.course *= course;
    }

}
