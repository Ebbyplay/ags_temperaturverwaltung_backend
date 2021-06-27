package ags.SechsY.temperaturverwaltung.mapper.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dto.request.SensorRequestDTO;
import ags.SechsY.temperaturverwaltung.mapper.BaseMapper;
import ags.SechsY.temperaturverwaltung.model.Sensor;
import ags.SechsY.temperaturverwaltung.service.ManufacturerService;
import ags.SechsY.temperaturverwaltung.service.ServerRackService;

@Component
public class SensorRequestMapper implements BaseMapper<Sensor, SensorRequestDTO> {

    @Autowired
    ServerRackService rackService;
    @Autowired
    ManufacturerService manufacturerService;

    @Override
    public SensorRequestDTO mapEntity(Sensor sensor) {
        SensorRequestDTO dto = new SensorRequestDTO();
        dto.setMaxTemperature(sensor.getMaxTemperature());
        dto.setServerRackId(sensor.getServerRack().getId());
        dto.setManufacturerId(sensor.getManufacturer().getId());
        return dto;
    }

    @Override
    public Sensor mapDTO(SensorRequestDTO dto) {
        Sensor sensor = new Sensor();
        sensor.setMaxTemperature(dto.getMaxTemperature());
        sensor.setManufacturer(manufacturerService.findById(dto.getManufacturerId()));
        sensor.setServerRack(rackService.findById(dto.getServerRackId()));
        return sensor;
    }

}
