package com.chanzo.hoodSquare.lostAndFound.repo;

import com.chanzo.hoodSquare.lostAndFound.model.Lost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LostRepo extends JpaRepository<Lost,Long> {

    boolean existsByClaimNumber(String claimNumber);

    Optional<Lost> findByClaimNumber(String claimNumber);
}
