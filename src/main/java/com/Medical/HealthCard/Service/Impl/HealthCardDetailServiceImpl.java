package com.Medical.HealthCard.Service.Impl;

import com.Medical.HealthCard.DTO.HealthCardDetailsDTO;
import com.Medical.HealthCard.DTO.MedicineDetailsDTO;
import com.Medical.HealthCard.Entity.HeathCardDetailsEntity;
import com.Medical.HealthCard.Entity.MedicineDetailsEntity;
import com.Medical.HealthCard.Repository.HealthCardDetailRepo;
import com.Medical.HealthCard.Repository.MedicineDetailsEntityRepo;
import com.Medical.HealthCard.Service.HealthCardDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HealthCardDetailServiceImpl implements HealthCardDetailService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HealthCardDetailRepo healthCardDetailRepo;

    @Autowired
    private MedicineDetailsEntityRepo medicineDetailsEntityRepo;

    @Override
    public HealthCardDetailsDTO createHealthcard(HealthCardDetailsDTO healthCardDetailsDTO,String healthCardId) {
        final HeathCardDetailsEntity healthCardDetailsEntity = modelMapper.map(healthCardDetailsDTO, HeathCardDetailsEntity.class);
        healthCardDetailsEntity.setHealthCardId(healthCardId);

        //seth HealthCardDetailsID to MedicineList
        for (MedicineDetailsEntity medicineDetailsEntity:healthCardDetailsEntity.getMedicineList())
                medicineDetailsEntity.setHeathCardDetailsEntity(healthCardDetailsEntity);

        final HeathCardDetailsEntity savedDtailsHeathCard = healthCardDetailRepo.save(healthCardDetailsEntity);
        final HealthCardDetailsDTO healthcardDTO = modelMapper.map(savedDtailsHeathCard, HealthCardDetailsDTO.class);
       return healthcardDTO;
    }

    @Override
    public List<HealthCardDetailsDTO> getAllHealthCardDetailsByHealthCard(String healthCardDtlId) {

        final List<HeathCardDetailsEntity> allByHealthCardId = healthCardDetailRepo.findAllByHealthCardId(healthCardDtlId);
       List<HealthCardDetailsDTO> healthCardDetailsDTOS= allByHealthCardId.stream().map(heathCardDetails -> modelMapper.map(heathCardDetails,HealthCardDetailsDTO.class)).toList();
       return healthCardDetailsDTOS;
    }

    @Override
    public String deleteHealthCardDetails(String hCardDetailId) {

        final HeathCardDetailsEntity heathCardDetails = healthCardDetailRepo.findById(hCardDetailId).orElseThrow(()-> new RuntimeException("There is no any Data "));
        healthCardDetailRepo.delete(heathCardDetails);
        return "Data is Deleted successfully !!!!!";
    }

    @Override
    public HealthCardDetailsDTO updateHealthCard(HealthCardDetailsDTO healthCardDetailsDTO,String healthCardDetails) {

        final HeathCardDetailsEntity heathCardDetails = healthCardDetailRepo.findById(healthCardDetails).orElseThrow(() -> new RuntimeException("Health Card Details is found"));
        final HeathCardDetailsEntity heathCardDetailsEntity = modelMapper.map(healthCardDetailsDTO, HeathCardDetailsEntity.class);
        heathCardDetails.setMedicineList(heathCardDetailsEntity.getMedicineList());
        heathCardDetails.setCreatedDate(heathCardDetailsEntity.getCreatedDate());
        heathCardDetails.setAllergy(heathCardDetailsEntity.getAllergy());
        heathCardDetails.setDescription(heathCardDetailsEntity.getDescription());
        heathCardDetails.setRemark(heathCardDetailsEntity.getRemark());
        final HeathCardDetailsEntity savedHealthCardDetails = healthCardDetailRepo.save(heathCardDetails);
        return modelMapper.map(savedHealthCardDetails,HealthCardDetailsDTO.class);
    }
/*d
    @Override
    public List<MedicineDetailsDTO> getMedicineDetails(int hcDtlId) {

        final   HeathCardDetailsEntity heathCardDetailsEntityD = healthCardDetailRepo.findById(hcDtlId).orElseThrow(() -> new RuntimeException("Health card is not found for given "));
        final List<MedicineDetailsEntity> byHealthCardDetailId = medicineDetailsEntityRepo.findByHealthCardDetailId(heathCardDetailsEntityD);
        return byHealthCardDetailId.stream().map(medicineDetails -> modelMapper.map(medicineDetails, MedicineDetailsDTO.class)).collect(Collectors.toList());
    }
*/

}
