package ags.SechsY.temperaturverwaltung.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dto.LogResponseDTO;
import ags.SechsY.temperaturverwaltung.model.Log;
import ags.SechsY.temperaturverwaltung.service.SensorService;
import ags.SechsY.temperaturverwaltung.service.UserService;

@Component
public class LogMapper implements BaseMapper<Log, LogResponseDTO> {

    @Autowired
    UserService userService;
    @Autowired
    SensorService sensorService;

    @Override
    public LogResponseDTO mapEntity(Log log) {
        LogResponseDTO dto = new LogResponseDTO();
        dto.setNewMaxTemperature(log.getNewMaxTemperature());
        dto.setTimestamp(log.getTimestamp());
        dto.setUserId(log.getUser().getId());
        dto.setSesnorId(log.getSensor().getId());
        return dto;
    }

    @Override
    public Log mapDTO(LogResponseDTO dto) {
        Log log = new Log();
        log.setTimestamp(dto.getTimestamp());
        log.setNewMaxTemperature(dto.getNewMaxTemperature());
        log.setUser(userService.findUserById(dto.getUserId()));
        log.setSensor(sensorService.findSensorById(dto.getSesnorId()));
        return log;
    }

}
