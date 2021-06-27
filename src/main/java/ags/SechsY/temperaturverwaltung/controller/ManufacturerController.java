package ags.SechsY.temperaturverwaltung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ags.SechsY.temperaturverwaltung.dto.request.ManufacturerRequestDTO;
import ags.SechsY.temperaturverwaltung.mapper.request.ManufacturerRequestMapper;
import ags.SechsY.temperaturverwaltung.model.Manufacturer;
import ags.SechsY.temperaturverwaltung.service.ManufacturerService;

@RestController
@RequestMapping(value = "/manufacturer", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private ManufacturerRequestMapper mapper;

    @GetMapping("/{id}")
    public Manufacturer findManufacturerById(@PathVariable long id) {
        return manufacturerService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Manufacturer> findManufacturerById() {
        return manufacturerService.findAll();
    }

    @PostMapping("/create")
    public Manufacturer createManufacturer(@RequestBody ManufacturerRequestDTO dto) {
        Manufacturer manufacturer = mapper.mapDTO(dto);
        return manufacturerService.createManufacturer(manufacturer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteManufacturer(@PathVariable long id) {
        manufacturerService.deleteById(id);
    }

}
