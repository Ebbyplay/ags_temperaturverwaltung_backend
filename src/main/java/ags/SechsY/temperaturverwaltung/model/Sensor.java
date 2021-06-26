package ags.SechsY.temperaturverwaltung.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "max_temperature", nullable = false)
    private Float max_temperature;

    @OneToOne
    @JoinColumn(name = "rack_id", nullable = false)
    private ServerRack serverRack;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "manufacturerId", nullable = false)
    private Manufacturer manufacturer;

    public Sensor() {

    }

    public Sensor(Float max_temp, ServerRack rack, Manufacturer manufacturer) {
        this.max_temperature = max_temp;
        this.serverRack = rack;
        this.manufacturer = manufacturer;
    }
}
