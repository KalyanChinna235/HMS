package com.health.HMS.service;

import com.health.HMS.model.Appointment;
import com.health.HMS.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found with id: " + id));
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment newAppointment) {
        Appointment appointment = getAppointmentById(id);
        appointment.setSlotId(newAppointment.getSlotId());
        appointment.setTotalCost(newAppointment.getTotalCost());
        appointment.setDoctor(newAppointment.getDoctor());
        appointment.setPatient(newAppointment.getPatient());
        appointment.setSurgery(newAppointment.getSurgery());
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}