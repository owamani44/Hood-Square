package com.chanzo.hoodSquare.lostAndFound.repo;

import com.chanzo.hoodSquare.lostAndFound.model.Claimed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimedRepo extends JpaRepository<Claimed, Long> {
}
