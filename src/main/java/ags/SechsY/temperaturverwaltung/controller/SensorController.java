package ags.SechsY.temperaturverwaltung.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ags.SechsY.temperaturverwaltung.dto.request.NewSensorRequestDTO;
import ags.SechsY.temperaturverwaltung.dto.request.UpdateMaxTempDTO;
import ags.SechsY.temperaturverwaltung.dto.request.UpdateSensorDTO;
import ags.SechsY.temperaturverwaltung.dto.response.SensorResponseDTO;
import ags.SechsY.temperaturverwaltung.exception.SensorMaxTemperatureUpdateException;
import ags.SechsY.temperaturverwaltung.mapper.request.NewSensorRequestMapper;
import ags.SechsY.temperaturverwaltung.mapper.response.SensorResponseMapper;
import ags.SechsY.temperaturverwaltung.model.Log;
import ags.SechsY.temperaturverwaltung.model.Manufacturer;
import ags.SechsY.temperaturverwaltung.model.Sensor;
import ags.SechsY.temperaturverwaltung.model.ServerRack;
import ags.SechsY.temperaturverwaltung.model.User;
import ags.SechsY.temperaturverwaltung.service.LogService;
import ags.SechsY.temperaturverwaltung.service.ManufacturerService;
import ags.SechsY.temperaturverwaltung.service.SensorService;
import ags.SechsY.temperaturverwaltung.service.ServerRackService;
import ags.SechsY.temperaturverwaltung.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/sensor", produces = MediaType.APPLICATION_JSON_VALUE)
public class SensorController {

    @Autowired
    SensorService sensorService;
    @Autowired
    NewSensorRequestMapper newRequestMapper;
    @Autowired
    SensorResponseMapper responseMapper;
    @Autowired
    LogService logService;
    @Autowired
    UserService userService;
    @Autowired
    ManufacturerService manufacturerService;
    @Autowired
    ServerRackService rackService;

    @GetMapping("/{id}")
    public SensorResponseDTO findById(@PathVariable long id) {
        return responseMapper.mapEntity(sensorService.findById(id));
    }

    @GetMapping(value = "/findAll")
    public List<SensorResponseDTO> findAll() {
        return toDTOList(sensorService.findAll());
    }

    @PostMapping(value = "/create")
    public SensorResponseDTO create(@RequestBody NewSensorRequestDTO dto) {
        Sensor sensor = newRequestMapper.mapDTO(dto);
        sensor = sensorService.create(sensor);
        return responseMapper.mapEntity(sensor);
    }

    @PutMapping(value = "/update")
    public SensorResponseDTO update(@RequestBody UpdateSensorDTO dto) {
        Sensor sensor = sensorService.findById(dto.getSensorId());
        Manufacturer manufacturer = manufacturerService.findById(dto.getManufacturerId());
        ServerRack oldRack = sensor.getServerRack();
        oldRack.setSensor(null);
        rackService.update(oldRack);
        ServerRack rack = rackService.findById(dto.getRackId());
        sensor.setManufacturer(manufacturer);
        sensor.setServerRack(rack);
        sensor = sensorService.update(sensor);
        return responseMapper.mapEntity(sensor);
    }

    @PutMapping(value = "/update/max_temp")
    public SensorResponseDTO updateMaxTemp(@RequestBody UpdateMaxTempDTO dto) {
        Sensor sensor = sensorService.findById(dto.getSensorId());
        User user = userService.findById(dto.getUserId());
        logService.createLog(new Log(dto.getNewMaxTemperature(), user, sensor));
        sensor.setMaxTemperature(dto.getNewMaxTemperature());
        sensor = sensorService.update(sensor);
        return responseMapper.mapEntity(sensor);
    }

    @DeleteMapping("/delete/{id}") // TODO: Cascading delete or delete on rack first | TESTING
    public void deleteById(@PathVariable long id) {
        sensorService.deleteById(id);
    }

    private List<SensorResponseDTO> toDTOList(List<Sensor> list) {
        List<SensorResponseDTO> dtos = new ArrayList<>();
        for (Sensor sensor : list) {
            dtos.add(responseMapper.mapEntity(sensor));
        }
        return dtos;
    }
}
