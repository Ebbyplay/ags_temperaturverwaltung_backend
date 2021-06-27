package ags.SechsY.temperaturverwaltung.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "temperature")
public class Temperature {

    public static String ENTITY_NAME = "Temperature";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "temperature_value", nullable = false)
    private Float temperature_value;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sensorId", nullable = false)
    private Sensor sensor;

    public Temperature() {
    }

    public Temperature(Float temp_value, Sensor sensor) {
        this.temperature_value = temp_value;
        this.sensor = sensor;
    }
}
