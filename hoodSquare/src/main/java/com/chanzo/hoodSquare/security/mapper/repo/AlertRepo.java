package com.chanzo.hoodSquare.security.mapper.repo;

import com.chanzo.hoodSquare.security.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepo extends JpaRepository<Alert,Long> {
}
