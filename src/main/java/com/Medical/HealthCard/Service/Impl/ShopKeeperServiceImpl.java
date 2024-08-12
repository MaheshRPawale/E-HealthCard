package com.Medical.HealthCard.Service.Impl;

import com.Medical.HealthCard.DTO.ShopKeeperDto;
import com.Medical.HealthCard.Entity.ShopkeeperEntity;
import com.Medical.HealthCard.Repository.ShopkeeperRepo;
import com.Medical.HealthCard.Service.ShopKeeperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopKeeperServiceImpl implements ShopKeeperService {
    @Autowired
    ShopkeeperRepo shopkeeperRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ShopKeeperDto createShopKeeperDTO(ShopKeeperDto shopKeeperDto) {
        final ShopkeeperEntity shopKeeper = modelMapper.map(shopKeeperDto, ShopkeeperEntity.class);
        final ShopkeeperEntity savedShopkeeper = shopkeeperRepo.save(shopKeeper);
        return modelMapper.map(savedShopkeeper,ShopKeeperDto.class);
    }
}
