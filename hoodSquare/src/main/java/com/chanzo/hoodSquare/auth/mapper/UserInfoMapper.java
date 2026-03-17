package com.chanzo.hoodSquare.auth.mapper;

import com.chanzo.hoodSquare.auth.dtos.UserRequestDTO;
import com.chanzo.hoodSquare.auth.dtos.UserResponseDTO;
import com.chanzo.hoodSquare.auth.model.UserInfo;

public class UserInfoMapper {
    public static UserResponseDTO toDTO(UserInfo userInfo){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(userInfo.getId());
        dto.setFirstName(userInfo.getFirstName());
        dto.setLastName(userInfo.getLastName());
        dto.setUsername(userInfo.getUsername());
        dto.setPassword(userInfo.getPassword());
        return dto;
    }

    public static UserInfo toEntity(UserRequestDTO requestDTO){
        UserInfo user = new UserInfo();
        user.setFirstName(requestDTO.getFirstName());
        user.setLastName(requestDTO.getLastName());
        user.setPassword(requestDTO.getPassword());
        return user;
    }
}
