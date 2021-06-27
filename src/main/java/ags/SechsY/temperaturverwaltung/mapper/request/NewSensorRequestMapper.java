package ags.SechsY.temperaturverwaltung.mapper.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dto.request.NewSensorRequestDTO;
import ags.SechsY.temperaturverwaltung.mapper.BaseMapper;
import ags.SechsY.temperaturverwaltung.model.Sensor;
import ags.SechsY.temperaturverwaltung.service.ManufacturerService;
import ags.SechsY.temperaturverwaltung.service.ServerRackService;

@Component
public class NewSensorRequestMapper implements BaseMapper<Sensor, NewSensorRequestDTO> {

    @Autowired
    ServerRackService rackService;
    @Autowired
    ManufacturerService manufacturerService;

    @Override
    public NewSensorRequestDTO mapEntity(Sensor sensor) {
        NewSensorRequestDTO dto = new NewSensorRequestDTO();
        dto.setMaxTemperature(sensor.getMaxTemperature());
        dto.setServerRackId(sensor.getServerRack().getId());
        dto.setManufacturerId(sensor.getManufacturer().getId());
        return dto;
    }

    @Override
    public Sensor mapDTO(NewSensorRequestDTO dto) {
        Sensor sensor = new Sensor();
        sensor.setMaxTemperature(dto.getMaxTemperature());
        sensor.setManufacturer(manufacturerService.findById(dto.getManufacturerId()));
        sensor.setServerRack(rackService.findById(dto.getServerRackId()));
        return sensor;
    }

}
