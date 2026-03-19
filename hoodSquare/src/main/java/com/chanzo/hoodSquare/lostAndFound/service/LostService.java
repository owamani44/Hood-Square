package com.chanzo.hoodSquare.lostAndFound.service;

import com.chanzo.hoodSquare.auth.service.UserInfoService;
import com.chanzo.hoodSquare.event.ItemClaimedEvent;
import com.chanzo.hoodSquare.lostAndFound.dtos.ClaimRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.ClaimResponseDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.LostRequestDTO;
import com.chanzo.hoodSquare.lostAndFound.dtos.LostResponseDTO;
import com.chanzo.hoodSquare.lostAndFound.mapper.LostMapper;
import com.chanzo.hoodSquare.lostAndFound.model.Claimed;
import com.chanzo.hoodSquare.lostAndFound.model.Lost;
import com.chanzo.hoodSquare.lostAndFound.repo.ClaimedRepo;
import com.chanzo.hoodSquare.lostAndFound.repo.LostRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class LostService implements LostServiceInterface{

    private UserInfoService service;
    private final LostRepo repo;
    private final ClaimedRepo claimedRepo;
    private final ApplicationEventPublisher publisher;

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

        /**method first checks if a user claiming a lost item is really a valid user of hood square**/

    @Transactional
    public ClaimResponseDTO claimItem(ClaimRequestDTO claimRequestDTO){
        if(service.isValidUser(claimRequestDTO.getUsername())){
            throw new RuntimeException("Invalid User");
        }
        Lost lost = new Lost();
        lost.setClaimed(true);
       Claimed claimed = claimedRepo.save(LostMapper.toModel(claimRequestDTO));
        publisher.publishEvent(new ItemClaimedEvent(claimed.getUsername(),
                claimed.getClaimNumber()));
        return LostMapper.toClaimDTO(claimed);
    }


    @Override
    public LostResponseDTO postLostItem(LostRequestDTO requestDTO, MultipartFile image) {
        try {
            Lost lost = LostMapper.toEntity(requestDTO);
            lost.setClaimNumber(generateClaimNumber());
            if(image!=null && !image.isEmpty()){
                lost.setImage(image.getBytes());
            }
            Lost saved = repo.save(lost);

            return LostMapper.toDTO(saved);
        } catch (IOException e){
            throw new RuntimeException("Error processing image  ", e);
        }
    }
}
