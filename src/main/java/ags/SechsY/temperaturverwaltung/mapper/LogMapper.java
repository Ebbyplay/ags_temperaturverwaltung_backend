package ags.SechsY.temperaturverwaltung.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ags.SechsY.temperaturverwaltung.dto.LogDTO;
import ags.SechsY.temperaturverwaltung.model.Log;
import ags.SechsY.temperaturverwaltung.service.UserService;

@Component
public class LogMapper implements BaseMapper<Log, LogDTO> {

    @Autowired
    UserService userService;

    @Override
    public LogDTO mapEntity(Log log) {
        LogDTO logDto = new LogDTO();
        logDto.setNewMaxTemperature(log.getNewMaxTemperature());
        logDto.setUserId(log.getUser().getId());
        return logDto;
    }

    @Override
    public Log mapDTO(LogDTO dto) {
        Log log = new Log();
        log.setNewMaxTemperature(dto.getNewMaxTemperature());
        log.setUser(userService.findUserById(dto.getUserId()));
        return log;
    }

}
