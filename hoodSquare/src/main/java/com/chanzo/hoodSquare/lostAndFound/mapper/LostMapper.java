package com.chanzo.hoodSquare.lostAndFound.mapper;

import com.chanzo.hoodSquare.lostAndFound.dtos.ClaimRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.ClaimResponseDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.LostRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.LostResponseDTO;
import com.chanzo.hoodSquare.lostAndFound.model.Claimed;
import com.chanzo.hoodSquare.lostAndFound.model.Lost;

public class LostMapper {
    public static LostResponseDTO toDTO(Lost lost) {
        LostResponseDTO dto = new LostResponseDTO();
        dto.setId(lost.getId());
        dto.setClaimNumber(lost.getClaimNumber());
        dto.setMessage(lost.getMessage());
        dto.setClaimed(lost.isClaimed());

        return dto;
    }

    public static Lost toEntity(LostRequestDTO requestDTO) {
        Lost lost = new Lost();
        lost.setMessage(requestDTO.getMessage());

        lost.setClaimed(false);
        return lost;
    }

    public static Claimed toModel(ClaimRequestDTO claimRequestDTO){
        Claimed claimed =new Claimed();
        claimed.setClaimNumber(claimRequestDTO.getClaimNumber());
        claimed.setUsername(claimRequestDTO.getUsername());
        return claimed;
    }
    public static ClaimResponseDTO toClaimDTO(Claimed claimed){
        ClaimResponseDTO dto = new ClaimResponseDTO();
        dto.setId(claimed.getId());
        dto.setUsername(claimed.getUsername());
        dto.setClaimNumber(claimed.getClaimNumber());
        return dto;
    }
}
