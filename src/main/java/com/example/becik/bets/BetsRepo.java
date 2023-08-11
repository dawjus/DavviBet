package com.example.becik.bets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BetsRepo extends JpaRepository<Bets, Long> {
    @Query("SELECT b FROM Bets b WHERE b.user.userName = :username")
    List<Bets> findAllBetsUser(@Param("username") String username);
    Bets findBetById(Long id);
}
