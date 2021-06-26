package ags.SechsY.temperaturverwaltung.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseEntity {

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();
}
