package ags.SechsY.temperaturverwaltung.dao;

import org.springframework.data.repository.CrudRepository;

import ags.SechsY.temperaturverwaltung.model.User;

public interface UserDAO extends CrudRepository<User, Long> {

}
