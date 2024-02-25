package com.cv.appointmentService.repository;

import com.cv.appointmentService.model.AppointmentType;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppointmentTypeRepository  extends R2dbcRepository<AppointmentType, UUID> {

}
