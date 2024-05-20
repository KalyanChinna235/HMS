package com.health.HMS.controller;

import com.health.HMS.model.Region;
import com.health.HMS.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

    @GetMapping("/{council}")
    public Region getRegionByCouncil(@PathVariable String council) {
        return regionService.getRegionByCouncil(council);
    }

    @PostMapping
    public Region createRegion(@RequestBody Region region) {
        return regionService.createRegion(region);
    }

    @PutMapping("/{council}")
    public Region updateRegion(@PathVariable String council, @RequestBody Region newRegion) {
        return regionService.updateRegion(council, newRegion);
    }

    @DeleteMapping("/{council}")
    public ResponseEntity<?> deleteRegion(@PathVariable String council) {
        regionService.deleteRegion(council);
        return ResponseEntity.ok().build();
    }
}