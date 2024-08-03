package com.Medical.HealthCard.Service;

import com.Medical.HealthCard.DTO.HealthCardDetailsDTO;
import com.Medical.HealthCard.DTO.MedicineDetailsDTO;

import java.util.List;

public interface HealthCardDetailService {

//Create health card
        public HealthCardDetailsDTO createHealthcard(HealthCardDetailsDTO healthCardDetailsDTO,String healthCardId);

        //Get All Details of HealthCardDetail
        public List<HealthCardDetailsDTO> getAllHealthCardDetailsByHealthCard(String healthCardDtlId);

        //Delete healthCardDetails
        public String deleteHealthCardDetails(String hCardDetailId);

        //update
         public HealthCardDetailsDTO updateHealthCard(HealthCardDetailsDTO healthCardDetailsDTO,String hCardDetailsId);

         //get medicine Details
      //  public List<MedicineDetailsDTO> getMedicineDetails(int hcDtlId);


}
