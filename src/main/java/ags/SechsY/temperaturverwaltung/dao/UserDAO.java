package ags.SechsY.temperaturverwaltung.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

}
