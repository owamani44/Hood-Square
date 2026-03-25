package com.chanzo.hoodSquare.auth.service;

import com.chanzo.hoodSquare.auth.dtos.UserRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserResponseDTO;
import com.chanzo.hoodSquare.auth.mapper.UserInfoMapper;
import com.chanzo.hoodSquare.auth.model.UserInfo;
import com.chanzo.hoodSquare.auth.repo.UserInfoRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.modulith.NamedInterface;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@NamedInterface
@Service
@AllArgsConstructor
public class UserInfoService {
    private final UserInfoRepo repo;
    private final PasswordEncoder passwordEncoder;

    public boolean isValidUser(String username){
        return !repo.existsByUsername(username);
    }



    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO){
        UserInfo newUserInfo = UserInfoMapper.toEntity(userRequestDTO);
       newUserInfo.setPassword(passwordEncoder.encode(newUserInfo.getPassword()));
        UserInfo savedUserInfo = repo.save(newUserInfo);
        return UserInfoMapper.toDTO(savedUserInfo);
    }


}
