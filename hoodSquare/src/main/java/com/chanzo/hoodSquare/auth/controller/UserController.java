package com.chanzo.hoodSquare.auth.controller;

import com.chanzo.hoodSquare.auth.dtos.LoginRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.LoginResponseDTO;
import com.chanzo.hoodSquare.auth.dtos.UserRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserResponseDTO;
import com.chanzo.hoodSquare.auth.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserInfoService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = service.registerUser(userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponseDTO> authenticateUser(@RequestBody LoginRequestDTO loginRequestDTO){
        String token= service.authenticate(loginRequestDTO);
        if (token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok().body(new LoginResponseDTO(token));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponseDTO getUserById(@PathVariable Long id){
         return service.getUserInfo(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.deleteUser(id);
       return ResponseEntity.noContent().build();
    }
}
