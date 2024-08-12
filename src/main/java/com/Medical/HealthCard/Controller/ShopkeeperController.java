package com.Medical.HealthCard.Controller;

import com.Medical.HealthCard.DTO.HealthCardDetailsDTO;
import com.Medical.HealthCard.DTO.ShopKeeperDto;
import com.Medical.HealthCard.Service.HealthCardDetailService;
import com.Medical.HealthCard.Service.ShopKeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopkeeper")
public class ShopkeeperController {

    @Autowired
    ShopKeeperService shopKeeperService;
    @Autowired
    public HealthCardDetailService healthCardDetailService;

    @PostMapping("/create")
    public ResponseEntity<ShopKeeperDto> createShopkeeper(@RequestBody ShopKeeperDto shopKeeperDto){

        final ShopKeeperDto shopKeeperDTO = shopKeeperService.createShopKeeperDTO(shopKeeperDto);
        return new ResponseEntity<>(shopKeeperDTO, HttpStatus.OK);
    }

    @GetMapping("/getHCDetails")
    public ResponseEntity<List<HealthCardDetailsDTO>> gethealthCardDetails(
             @RequestParam String healthCardId
    ){
        final List<HealthCardDetailsDTO> allHealthCardDetailsByHealthCard = healthCardDetailService.getAllHealthCardDetailsByHealthCard(healthCardId);
        return new ResponseEntity<>(allHealthCardDetailsByHealthCard,HttpStatus.OK);

    }
}
