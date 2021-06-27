package ags.SechsY.temperaturverwaltung.mapper.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dto.response.ServerRackResponseDTO;
import ags.SechsY.temperaturverwaltung.mapper.BaseMapper;
import ags.SechsY.temperaturverwaltung.model.ServerRack;
import ags.SechsY.temperaturverwaltung.service.SensorService;

@Component
public class ServerRackResponseMapper implements BaseMapper<ServerRack, ServerRackResponseDTO> {

    @Autowired
    SensorService sensorService;

    @Override
    public ServerRackResponseDTO mapEntity(ServerRack entity) {
        ServerRackResponseDTO dto = new ServerRackResponseDTO();
        dto.setId(entity.getId());
        dto.setSensorId(entity.getSensor().getId());
        return dto;
    }

    @Override
    public ServerRack mapDTO(ServerRackResponseDTO dto) {
        ServerRack entity = new ServerRack();
        entity.setId(dto.getId());
        entity.setSensor(sensorService.findById(dto.getSensorId()));
        return entity;
    }

}
