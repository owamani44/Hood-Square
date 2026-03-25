package com.chanzo.hoodSquare.auth.service;

import com.chanzo.hoodSquare.auth.dtos.LoginRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserResponseDTO;
import com.chanzo.hoodSquare.auth.jwt.JwtService;
import com.chanzo.hoodSquare.auth.mapper.UserInfoMapper;
import com.chanzo.hoodSquare.auth.model.UserInfo;
import com.chanzo.hoodSquare.auth.repo.UserInfoRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.modulith.NamedInterface;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NamedInterface
@Service
@AllArgsConstructor
public class UserInfoService {
    private final UserInfoRepo repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

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

    public String authenticate(LoginRequestDTO loginRequestDTO){
        Authentication authenticate =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword()));
        if(authenticate.isAuthenticated()) {
           String role = authenticate
                    .getAuthorities()
                    .iterator()
                    .next()
                    .getAuthority()
                    .replace("ROLE_", "");
            return jwtService.generateToken(loginRequestDTO.getUsername(), role);
        }
        return null;
    }


}
