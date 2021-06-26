package ags.SechsY.temperaturverwaltung.mapper;

import ags.SechsY.temperaturverwaltung.dto.LogDTO;
import ags.SechsY.temperaturverwaltung.model.Log;

public class LogMapper implements BaseMapper<Log, LogDTO> {

    @Override
    public LogDTO mapEntity(Log log) {
        LogDTO logDto = new LogDTO();
        logDto.setNewMaxTemperature(log.getNewMaxTemperature());
        logDto.setTimestamp(log.getTimestamp());
        return logDto;
    }

    @Override
    public Log mapDTO(LogDTO dto) {
        Log log = new Log();
        log.setNewMaxTemperature(dto.getNewMaxTemperature());
        log.setTimestamp(dto.getTimestamp());
        return log;
    }

}
