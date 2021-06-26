package ags.SechsY.temperaturverwaltung.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.ServerRack;

@Repository
public interface ServerRackRepo extends CrudRepository<ServerRack, Long> {

}
