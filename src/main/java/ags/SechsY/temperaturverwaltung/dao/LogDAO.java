package ags.SechsY.temperaturverwaltung.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.Log;

@Repository
public interface LogDAO extends CrudRepository<Log, Long> {

}
