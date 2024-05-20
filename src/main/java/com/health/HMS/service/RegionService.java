package com.health.HMS.service;

import com.health.HMS.model.Region;
import com.health.HMS.repository.RegionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }

    public Region getRegionByCouncil(String council) {
        return regionRepository.findById(council)
                .orElseThrow(() -> new EntityNotFoundException("Region not found with council: " + council));
    }

    public Region createRegion(Region region) {
        return regionRepository.save(region);
    }

    public Region updateRegion(String council, Region newRegion) {
        Region region = getRegionByCouncil(council);
        region.setRegion(newRegion.getRegion());
        return regionRepository.save(region);
    }

    public void deleteRegion(String council) {
        regionRepository.deleteById(council);
    }
}
