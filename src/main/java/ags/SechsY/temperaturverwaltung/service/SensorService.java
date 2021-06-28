package ags.SechsY.temperaturverwaltung.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.exception.EntityNotFoundException;
import ags.SechsY.temperaturverwaltung.exception.ServerRackAlreadyHasSensorException;
import ags.SechsY.temperaturverwaltung.model.Sensor;
import ags.SechsY.temperaturverwaltung.model.ServerRack;
import ags.SechsY.temperaturverwaltung.repo.SensorRepo;

@Service
public class SensorService {

    @Autowired
    SensorRepo sensorRepo;
    @Autowired
    ServerRackService rackService;

    public Sensor create(Sensor sensor) {
        ServerRack rack = rackService.findById(sensor.getServerRack().getId());
        if (rack.getSensor() == null) {
            sensor = sensorRepo.save(sensor);

            rack.setSensor(sensor);
            rackService.update(rack);
        } else if (rack.getSensor().getId() == sensor.getId()) {
            sensor = sensorRepo.save(sensor);
        } else {
            throw new ServerRackAlreadyHasSensorException(rack.getId());
        }
        return sensor;
    }

    public List<Sensor> findAll() {
        return (List<Sensor>) sensorRepo.findAll();
    }

    public Sensor findById(Long id) {
        Optional<Sensor> sensor = sensorRepo.findById(id);
        if (!sensor.isPresent()) {
            throw new EntityNotFoundException(Sensor.ENTITY_NAME, id);
        }
        return sensor.get();
    }

    public Sensor update(Sensor sensor) {
        return create(sensor);
    }

    public void deleteById(long id) {
        try {
            Sensor sensor = findById(id);
            ServerRack rack = sensor.getServerRack();
            rack.setSensor(null);// TODO: doesnt work because constraints
            sensorRepo.deleteById(id);
        } catch (IllegalArgumentException e) {
            e.fillInStackTrace();
            throw new EntityNotFoundException(Sensor.ENTITY_NAME, id);
        }
    }
}