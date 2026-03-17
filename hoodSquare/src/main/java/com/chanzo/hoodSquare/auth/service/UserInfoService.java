package com.chanzo.hoodSquare.auth.service;

import com.chanzo.hoodSquare.auth.dtos.UserRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserResponseDTO;
import com.chanzo.hoodSquare.auth.mapper.UserInfoMapper;
import com.chanzo.hoodSquare.auth.model.UserInfo;
import com.chanzo.hoodSquare.auth.repo.UserInfoRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.modulith.NamedInterface;
import org.springframework.stereotype.Service;

@NamedInterface
@Service
@AllArgsConstructor
public class UserInfoService {
    private final UserInfoRepo repo;

    public boolean isValidUser(String username){
        return !repo.existsByUsername(username);
    }


    public String generateUsername(String firstName, String lastName) {
        String base = (firstName.substring(0,1) + lastName).toLowerCase();

        String username = base;
        int counter = 1;
        while (repo.existsByUsername(username)) {
            username = base + counter;
            counter++;
        }
        return username;
    }
    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO){
        UserInfo newUserInfo = UserInfoMapper.toModel(userRequestDTO);
        String username = generateUsername(newUserInfo.getFirstName(),
                newUserInfo.getLastName() );
        newUserInfo.setUsername(username);
       // newUserInfo.setPassword(passwordEncoder.encode(newUserInfo.getPassword()));
        UserInfo savedUserInfo = repo.save(newUserInfo);
        return UserInfoMapper.toDTO(savedUserInfo);
    }


}
