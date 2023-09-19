package com.example.becik.betsDetails;

import com.example.becik.bets.Bets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BetsDetailsRepo extends JpaRepository<BetsDetails, Long> {

    @Query("SELECT bd.bet FROM BetsDetails bd WHERE bd.event.id = :eventId")
    List<Bets> findBetsFromEvent(@Param("eventId") Long eventId);
}
