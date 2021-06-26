package ags.SechsY.temperaturverwaltung.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.Temperature;

@Repository
public interface TemperatureRepo extends CrudRepository<Temperature, Long> {

}
