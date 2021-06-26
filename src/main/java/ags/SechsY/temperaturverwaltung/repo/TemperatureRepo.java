package ags.SechsY.temperaturverwaltung.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.Temperature;

@Repository
public interface TemperatureRepo extends CrudRepository<Temperature, Long> {

    @Query(value = "SELECT * FROM temperature ORDER BY timestamp ASC LIMIT 10", nativeQuery = true)
    List<Temperature> findLast10Temperatures();
}
