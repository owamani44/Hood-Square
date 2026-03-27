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

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class UserController {

    private final UserInfoService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = service.registerUser(userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticateUser(@RequestBody LoginRequestDTO loginRequestDTO){
       Optional<String> token= service.authenticate(loginRequestDTO);
        return token.map(s -> ResponseEntity.ok().body(new LoginResponseDTO(s)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


    @GetMapping("/me")
    public ResponseEntity<UserResponseDTO> getMe(Principal principal) {
        return ResponseEntity.ok(service.getUserInfo(principal.getName()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.deleteUser(id);
       return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> dto2 = service.getUsers();
        return ResponseEntity.ok().body(dto2);
    }
}
