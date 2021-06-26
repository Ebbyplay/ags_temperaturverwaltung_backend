package ags.SechsY.temperaturverwaltung.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.Manufacturer;

@Repository
public interface ManufacturerRepo extends CrudRepository<Manufacturer, Long> {

}
