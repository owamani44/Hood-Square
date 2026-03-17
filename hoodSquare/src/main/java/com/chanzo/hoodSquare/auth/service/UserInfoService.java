package com.chanzo.hoodSquare.auth.service;

import com.chanzo.hoodSquare.auth.repo.UserInfoRepo;
import lombok.AllArgsConstructor;
import org.springframework.modulith.NamedInterface;
import org.springframework.stereotype.Service;

@NamedInterface
@Service
@AllArgsConstructor
public class UserInfoService {
    private final UserInfoRepo repo;

    public boolean isValidUser(String username){
        return repo.existsByUsername(username);
    }


}
