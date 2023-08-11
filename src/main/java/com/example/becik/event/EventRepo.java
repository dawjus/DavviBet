package com.example.becik.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e JOIN FETCH e.match m WHERE m.id = :matchId")
    List<Event> findAllEventsByMatchId(@Param("matchId") Long matchId);

    Event findEventById(Long id);

    @Query("SELECT e FROM Event e WHERE e.result = 'UNSETTLED'")
    List<Event> findEventUnsettled();
}
