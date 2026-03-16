package com.chanzo.hoodSquare.lostAndFound.service;

import com.chanzo.hoodSquare.auth.service.UserInfoService;
import com.chanzo.hoodSquare.lostAndFound.dtos.ClaimRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.LostRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.LostResponseDTO;
import com.chanzo.hoodSquare.lostAndFound.mapper.LostMapper;
import com.chanzo.hoodSquare.lostAndFound.model.Claimed;
import com.chanzo.hoodSquare.lostAndFound.model.Lost;
import com.chanzo.hoodSquare.lostAndFound.repo.ClaimedRepo;
import com.chanzo.hoodSquare.lostAndFound.repo.LostRepo;
import com.chanzo.hoodSquare.security.service.AlertService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class LostService {

    private UserInfoService service;
    private final LostRepo repo;
    private final ClaimedRepo claimedRepo;

    public String generateClaimNumber() {
        String prefix = "C";
        String suffix="0";
        String base = prefix + suffix;
        String claimNumber = base;
       int counter = 1;
         while (repo.existsByClaimNumber(claimNumber)) {;
            claimNumber= base + counter;
            counter++;
         }
        return claimNumber;
    }
    @Transactional
    public LostResponseDTO postLostItem(LostRequestDTO requestDTO){

        Lost lost = LostMapper.toEntity(requestDTO);
        lost.setClaimNumber(generateClaimNumber());
        Lost saved= repo.save(lost);
        return LostMapper.toDTO(saved);
    }

    @Transactional
    public Claimed claimItem(ClaimRequestDTO claimRequestDTO){
        if(!service.isValidUser(claimRequestDTO.getUsername())){
            throw new RuntimeException("Invalid User");
        }
        Lost lost = new Lost();
        lost.setClaimed(true);
       return claimedRepo.save(LostMapper.toModel(claimRequestDTO));
    }

}
