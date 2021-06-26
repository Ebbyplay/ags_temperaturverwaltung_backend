package ags.SechsY.temperaturverwaltung.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.exception.SensorNotFoundException;
import ags.SechsY.temperaturverwaltung.model.Sensor;
import ags.SechsY.temperaturverwaltung.repo.SensorRepo;

@Service
public class SensorService {

    @Autowired
    SensorRepo sensorRepo;

    public Sensor createSensor(Sensor sensor) {
        return sensorRepo.save(sensor);
    }

    public List<Sensor> findAll() {
        return (List<Sensor>) sensorRepo.findAll();
    }

    public Sensor findSensorById(Long id) {
        Optional<Sensor> sensor = sensorRepo.findById(id);
        if (!sensor.isPresent()) {
            throw new SensorNotFoundException(id);
        }
        return sensor.get();
    }

    public Sensor updateSensor(Sensor sensor) {
        return createSensor(sensor);
    }

    public void deleteSensor(Sensor sensor) {
        try {
            sensorRepo.delete(sensor);
        } catch (IllegalArgumentException e) {
            e.fillInStackTrace();
            throw new SensorNotFoundException(sensor.getId());
        }
    }
}
