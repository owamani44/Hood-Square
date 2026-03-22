package com.chanzo.hoodSquare.security.service;

import com.chanzo.hoodSquare.security.dtos.AlertRequestDTO;
import com.chanzo.hoodSquare.security.dtos.AlertResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface AlertServiceInterface {
    AlertResponseDTO reportAlert(AlertRequestDTO requestDTO, MultipartFile image);
}
