package com.chanzo.hoodSquare.auth.controller;

import com.chanzo.hoodSquare.auth.dtos.LoginRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserResponseDTO;
import com.chanzo.hoodSquare.auth.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("authenticate")
    public ResponseEntity<LoginRequestDTO> authenticateUser(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok().body(loginRequestDTO);
    }
}
