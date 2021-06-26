package ags.SechsY.temperaturverwaltung.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.Log;

@Repository
public interface LogRepo extends CrudRepository<Log, Long> {

}
