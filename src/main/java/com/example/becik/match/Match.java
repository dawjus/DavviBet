package com.example.becik.match;

import com.example.becik.event.SportType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matches")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamA;
    private String teamB;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date date;
    @Enumerated(EnumType.STRING)
    private SportType sport;

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", sport='" + sport + '\'' +
                '}';
    }
}
