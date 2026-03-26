package com.chanzo.hoodSquare.auth.repo;

import com.chanzo.hoodSquare.auth.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Long> {
    boolean existsByUsername(String username);
    Optional<UserInfo> findByUsername(String username);

    UserInfo findUserInfoById(Long id);
}
