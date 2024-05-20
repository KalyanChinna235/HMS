package com.health.HMS.service;

import com.health.HMS.model.Surgery;
import com.health.HMS.repository.SurgeryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryService {
    private final SurgeryRepository surgeryRepository;

    public SurgeryService(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    public List<Surgery> getAllSurgeries() {
        return surgeryRepository.findAll();
    }

    public Surgery getSurgeryByNumber(Long number) {
        return surgeryRepository.findById(number)
                .orElseThrow(() -> new EntityNotFoundException("Surgery not found with number: " + number));
    }

    public Surgery createSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    public Surgery updateSurgery(Long number, Surgery newSurgery) {
        Surgery surgery = getSurgeryByNumber(number);
        surgery.setPostcode(newSurgery.getPostcode());
        surgery.setRegion(newSurgery.getRegion());
        return surgeryRepository.save(surgery);
    }

    public void deleteSurgery(Long number) {
        surgeryRepository.deleteById(number);
    }
}