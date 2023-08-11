package com.example.becik.match;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepo extends JpaRepository<Match, Long> {
    Match findMatchById(Long id);
}
