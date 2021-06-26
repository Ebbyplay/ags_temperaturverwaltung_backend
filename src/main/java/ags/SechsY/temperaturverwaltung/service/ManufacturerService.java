package ags.SechsY.temperaturverwaltung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.model.Manufacturer;
import ags.SechsY.temperaturverwaltung.repo.ManufacturerRepo;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepo manufacturerRepo;

    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepo.save(manufacturer);
    }

    public List<Manufacturer> findAll() {
        return (List<Manufacturer>) manufacturerRepo.findAll();
    }
}
