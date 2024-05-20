package com.health.HMS.controller;

import com.health.HMS.model.Surgery;
import com.health.HMS.service.SurgeryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surgeries")
public class SurgeryController {
    private final SurgeryService surgeryService;

    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @GetMapping
    public List<Surgery> getAllSurgeries() {
        return surgeryService.getAllSurgeries();
    }

    @GetMapping("/{number}")
    public Surgery getSurgeryByNumber(@PathVariable Long number) {
        return surgeryService.getSurgeryByNumber(number);
    }

    @PostMapping
    public Surgery createSurgery(@RequestBody Surgery surgery) {
        return surgeryService.createSurgery(surgery);
    }

    @PutMapping("/{number}")
    public Surgery updateSurgery(@PathVariable Long number, @RequestBody Surgery newSurgery) {
        return surgeryService.updateSurgery(number, newSurgery);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSurgery(@PathVariable Long number) {
        surgeryService.deleteSurgery(number);
        return ResponseEntity.ok().build();
    }
}