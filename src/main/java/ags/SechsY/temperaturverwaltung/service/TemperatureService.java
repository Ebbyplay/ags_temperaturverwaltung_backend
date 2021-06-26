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

    public Temperature createTemperature(Temperature temperature) {
        return temperatureRepo.save(temperature);
    }

    public List<Temperature> findAll() {
        return (List<Temperature>) temperatureRepo.findAll();
    }

    public List<Temperature> findLast10Temperatures() {
        return temperatureRepo.findLast10Temperatures();
    }

    public void deleteTemperature(Temperature temperature) {
        temperatureRepo.delete(temperature);
    }
}
