package com.cv.appointmentService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;


@Table("appointment")
public class AppointmentType {

    @Id
    private UUID id;
    private String name;
    private  String description;
    private long duration_minutes;
    private String color_hex_code;

    public AppointmentType(UUID id, String name, String description, long duration_minutes, String color_hex_code) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration_minutes = duration_minutes;
        this.color_hex_code = color_hex_code;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDuration_minutes() {
        return duration_minutes;
    }

    public void setDuration_minutes(long duration_minutes) {
        this.duration_minutes = duration_minutes;
    }

    public String getColor_hex_code() {
        return color_hex_code;
    }

    public void setColor_hex_code(String color_hex_code) {
        this.color_hex_code = color_hex_code;
    }
}
