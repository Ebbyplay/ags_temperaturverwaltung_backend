package ags.SechsY.temperaturverwaltung.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.Sensor;

@Repository
public interface SensorRepo extends CrudRepository<Sensor, Long> {

}
