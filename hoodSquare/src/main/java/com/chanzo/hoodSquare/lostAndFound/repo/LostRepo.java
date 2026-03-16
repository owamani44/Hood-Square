package com.chanzo.hoodSquare.lostAndFound.repo;

import com.chanzo.hoodSquare.lostAndFound.model.Lost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostRepo extends JpaRepository<Lost,Long> {

    boolean existsByClaimNumber(String claimNumber);
}
