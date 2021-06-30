package ags.SechsY.temperaturverwaltung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.model.Temperature;
import ags.SechsY.temperaturverwaltung.repo.TemperatureRepo;

@Service
public class TemperatureService {

    @Autowired
    private TemperatureRepo temperatureRepo;

    public Temperature create(Temperature temperature) {
        return temperatureRepo.save(temperature);
    }

    public List<Temperature> findAll() {
        return (List<Temperature>) temperatureRepo.findAll();
    }

    public List<Temperature> findLast10() {
        return temperatureRepo.findLast10Temperatures();
    }

    public List<Temperature> findBySensorId(long sensorId) {
        return temperatureRepo.findBySensorId(sensorId);
    }

    public void deleteById(long id) {
        temperatureRepo.deleteById(id);
    }
}
