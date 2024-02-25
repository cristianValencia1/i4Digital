package com.cv.appointmentService.service;


import com.cv.appointmentService.model.AppointmentType;
import com.cv.appointmentService.repository.AppointmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class AppointmentTypeService {

    private final AppointmentTypeRepository appointmentTypeRepository;
    private final TransactionalOperator transactionalOperator;


    @Autowired
    public AppointmentTypeService(AppointmentTypeRepository appointmentTypeRepository, ReactiveTransactionManager transactionManager) {
        this.appointmentTypeRepository = appointmentTypeRepository;
        this.transactionalOperator = TransactionalOperator.create(transactionManager);
    }

    public Mono<AppointmentType> createAppointmentType(AppointmentType appointmentType) {
        return appointmentTypeRepository.save(appointmentType)
                .as(transactionalOperator::transactional);
    }

    public Flux<AppointmentType> getAllAppointmentTypes() {
        return appointmentTypeRepository.findAll();
    }

    public Flux<AppointmentType> findAll() {
        return appointmentTypeRepository.findAll();
    }

    public Mono<AppointmentType> getAppointmentTypeById(UUID id) {
        return appointmentTypeRepository.findById(id);
    }

    public Mono<AppointmentType> updateAppointmentType(UUID id, AppointmentType appointmentType) {
        return appointmentTypeRepository.findById(id)
                .flatMap(existingAppointmentType -> {
                    existingAppointmentType.setName(appointmentType.getName());
                    existingAppointmentType.setDescription(appointmentType.getDescription());
                    existingAppointmentType.setDuration_minutes(appointmentType.getDuration_minutes());
                    existingAppointmentType.setColor_hex_code(appointmentType.getColor_hex_code());
                    return appointmentTypeRepository.save(existingAppointmentType);
                })
                .as(transactionalOperator::transactional);
    }

    public Mono<Void> deleteAppointmentType(UUID id) {
        return appointmentTypeRepository.deleteById(id)
                .then()
                .as(transactionalOperator::transactional);
    }
}
