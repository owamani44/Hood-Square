package com.chanzo.hoodSquare.auth.service;

import com.chanzo.hoodSquare.auth.dtos.LoginRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserResponseDTO;
import com.chanzo.hoodSquare.auth.jwt.JwtService;
import com.chanzo.hoodSquare.auth.mapper.UserInfoMapper;
import com.chanzo.hoodSquare.auth.model.Role;
import com.chanzo.hoodSquare.auth.model.UserInfo;
import com.chanzo.hoodSquare.auth.repo.UserInfoRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.modulith.NamedInterface;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
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
    private final AuthenticationProvider provider;

    public boolean isValidUser(String username){
        return !repo.existsByUsername(username);
    }
    public int adminCount(){return repo.countByRole(Role.ROLE_ADMIN);}


    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO){
        UserInfo newUserInfo = UserInfoMapper.toEntity(userRequestDTO);
       newUserInfo.setPassword(passwordEncoder.encode(newUserInfo.getPassword()));
       if(adminCount() <= 2){
           newUserInfo.setRole(Role.ROLE_ADMIN);
       }else{ newUserInfo.setRole(Role.ROLE_USER);}
        UserInfo savedUserInfo = repo.save(newUserInfo);
        return UserInfoMapper.toDTO(savedUserInfo);
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO){
//        Authentication authenticate =provider.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),
//                        loginRequestDTO.getPassword()));
//        assert authenticate != null;
//        if(authenticate.isAuthenticated()) {
//           String role = authenticate
//                    .getAuthorities()
//                    .iterator()
//                    .next()
//                    .getAuthority()
//                    .replace("ROLE_", "");
//            return jwtService.generateToken(loginRequestDTO.getUsername(), role);
//        }
//        return null;
        Optional<String> token = repo.findByUsername
                        (loginRequestDTO.getUsername())
                .filter(u->passwordEncoder.matches(loginRequestDTO.getPassword(),
                        u.getPassword()))
                .map(u->jwtService.generateToken(u.getUsername(), String.valueOf(u.getRole())));

        return token;
    }

    public UserResponseDTO getUserInfo(Long id){
        return UserInfoMapper.toDTO(repo.findUserInfoById(id));
    }

    public void deleteUser(Long id){
        repo.deleteById(id);
    }

}
