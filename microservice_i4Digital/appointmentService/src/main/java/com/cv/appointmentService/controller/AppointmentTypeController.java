package com.cv.appointmentService.controller;

import com.cv.appointmentService.model.AppointmentType;
import com.cv.appointmentService.service.AppointmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/api")
public class AppointmentTypeController {
    @Autowired
    private AppointmentTypeService appointmentTypeService;


    @GetMapping("/appointmentTypes")
    @ResponseStatus(HttpStatus.OK)
    public Flux<AppointmentType> getAllAppointmentTypes() {
        return appointmentTypeService.getAllAppointmentTypes();
    }

    @GetMapping("/appointmentTypes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<AppointmentType> getAppointmentTypeById(@PathVariable UUID id) {
        return appointmentTypeService.getAppointmentTypeById(id);
    }

    @PostMapping("/appointmentTypes")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AppointmentType> createAppointmentType(@RequestBody AppointmentType appointmentType) {
        return appointmentTypeService.createAppointmentType(appointmentType);
    }

    @PutMapping("/appointmentTypes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<AppointmentType> updateAppointmentType(@PathVariable UUID id, @RequestBody AppointmentType appointmentType) {

        return appointmentTypeService.updateAppointmentType(id,appointmentType);
    }

    @DeleteMapping("/appointmentTypes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAppointmentType(@PathVariable UUID id) {
        return appointmentTypeService.deleteAppointmentType(id);
    }
}
