package ags.SechsY.temperaturverwaltung.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ags.SechsY.temperaturverwaltung.model.Temperature;

@Repository
public interface TemperatureRepo extends CrudRepository<Temperature, Long> {

    @Query(value = "SELECT * FROM temperature ORDER BY timestamp DESC LIMIT 10", nativeQuery = true)
    List<Temperature> findLast10Temperatures();

    @Query(value = "SELECT * FROM temperature WHERE sensor_id = :sensorId ORDER BY timestamp ASC", nativeQuery = true)
    List<Temperature> findBySensorId(@Param("sensorId") long sensorId);

    @Query(value = "DELETE FROM temperature WHERE timestamp < :timestamp", nativeQuery = true)
    void deleteAllBefore(@Param("timestamp") LocalDateTime timestamp);
}
