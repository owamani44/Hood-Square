package com.chanzo.hoodSquare.lostAndFound.service;

import com.chanzo.hoodSquare.lostAndFound.dtos.LostRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.LostResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface LostServiceInterface {
    LostResponseDTO postLostItem(LostRequestDTO requestDTO, MultipartFile image);
}
