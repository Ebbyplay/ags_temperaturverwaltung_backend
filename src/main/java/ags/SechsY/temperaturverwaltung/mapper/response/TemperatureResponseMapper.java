package ags.SechsY.temperaturverwaltung.mapper.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dto.response.TemperatureResponseDTO;
import ags.SechsY.temperaturverwaltung.mapper.BaseMapper;
import ags.SechsY.temperaturverwaltung.model.Temperature;
import ags.SechsY.temperaturverwaltung.service.SensorService;

@Component
public class TemperatureResponseMapper implements BaseMapper<Temperature, TemperatureResponseDTO> {

    @Autowired
    SensorService sensorService;

    @Override
    public TemperatureResponseDTO mapEntity(Temperature entity) {
        TemperatureResponseDTO dto = new TemperatureResponseDTO();
        dto.setId(entity.getId());
        dto.setTemperature_value(entity.getTemperature_value());
        dto.setTimestamp(entity.getTimestamp());
        dto.setSensorId(entity.getSensor().getId());
        return dto;
    }

    @Override
    public Temperature mapDTO(TemperatureResponseDTO dto) {
        Temperature entity = new Temperature();
        entity.setId(dto.getId());
        entity.setTemperature_value(dto.getTemperature_value());
        entity.setTimestamp(dto.getTimestamp());
        entity.setSensor(sensorService.findById(dto.getSensorId()));
        return entity;
    }

}
