package ags.SechsY.temperaturverwaltung.mapper.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dto.response.SensorResponseDTO;
import ags.SechsY.temperaturverwaltung.mapper.BaseMapper;
import ags.SechsY.temperaturverwaltung.model.Sensor;
import ags.SechsY.temperaturverwaltung.service.ManufacturerService;
import ags.SechsY.temperaturverwaltung.service.ServerRackService;

@Component
public class SensorResponseMapper implements BaseMapper<Sensor, SensorResponseDTO> {

    @Autowired
    ServerRackService rackService;
    @Autowired
    ManufacturerService manufacturerService;

    @Override
    public SensorResponseDTO mapEntity(Sensor entity) {
        SensorResponseDTO dto = new SensorResponseDTO();
        dto.setId(entity.getId());
        dto.setMaxTemperature(entity.getMaxTemperature());
        dto.setManufacturerId(entity.getManufacturer().getId());
        dto.setRackId(entity.getServerRack().getId());
        return dto;
    }

    @Override
    public Sensor mapDTO(SensorResponseDTO dto) {
        Sensor entity = new Sensor();
        entity.setId(dto.getId());
        entity.setMaxTemperature(dto.getMaxTemperature());
        entity.setManufacturer(manufacturerService.findById(dto.getManufacturerId()));
        entity.setServerRack(rackService.findById(dto.getRackId()));
        return entity;
    }

}
