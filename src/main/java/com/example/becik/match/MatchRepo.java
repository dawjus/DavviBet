package com.example.becik.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface MatchRepo extends JpaRepository<Match, Long> {
    Match findMatchById(Long id);

    @Query("SELECT m FROM Match m WHERE m.date > :currentDate")
    List<Match> findUpcomingMatches(Date currentDate);

    @Query("SELECT m FROM Match m WHERE m.date < :currentDate")
    List<Match> findFinishedMatches(Date currentDate);
}
