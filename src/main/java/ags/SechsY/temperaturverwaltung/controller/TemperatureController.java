package ags.SechsY.temperaturverwaltung.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ags.SechsY.temperaturverwaltung.dto.response.TemperatureResponseDTO;
import ags.SechsY.temperaturverwaltung.mapper.response.TemperatureResponseMapper;
import ags.SechsY.temperaturverwaltung.model.Temperature;
import ags.SechsY.temperaturverwaltung.service.TemperatureService;

@RestController
@RequestMapping(value = "temperature", produces = MediaType.APPLICATION_JSON_VALUE)
public class TemperatureController {

    @Autowired
    TemperatureService temperatureService;
    @Autowired
    TemperatureResponseMapper mapper;

    @GetMapping("/findAll")
    public List<TemperatureResponseDTO> findAll() {
        return toDTOList(temperatureService.findAll());
    }

    @GetMapping("/findLast10")
    public List<TemperatureResponseDTO> findLast10() {
        return toDTOList(temperatureService.findLast10());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id) {
        temperatureService.deleteById(id);
    }

    private List<TemperatureResponseDTO> toDTOList(List<Temperature> list) {
        List<TemperatureResponseDTO> dtos = new ArrayList<>();
        for (Temperature temp : list) {
            dtos.add(mapper.mapEntity(temp));
        }
        return dtos;
    }
}
