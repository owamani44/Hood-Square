package com.chanzo.hoodSquare.auth.repo;

import com.chanzo.hoodSquare.auth.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Long> {
    boolean existsByUsername(String username);
}
