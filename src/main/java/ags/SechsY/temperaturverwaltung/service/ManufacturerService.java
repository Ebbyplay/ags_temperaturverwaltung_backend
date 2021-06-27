package ags.SechsY.temperaturverwaltung.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.exception.EntityNotFoundException;
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

    public Manufacturer findById(long id) {
        Optional<Manufacturer> manufacturer = manufacturerRepo.findById(id);
        if (!manufacturer.isPresent()) {
            throw new EntityNotFoundException(Manufacturer.ENTITY_NAME, id);
        }
        return manufacturer.get();
    }

    public void deleteById(long id) {
        manufacturerRepo.deleteById(id);
    }
}
