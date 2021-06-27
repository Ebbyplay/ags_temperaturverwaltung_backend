package ags.SechsY.temperaturverwaltung.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LogResponseDTO {

    private Float newMaxTemperature;
    private LocalDateTime timestamp;
    private long userId;
    private long sesnorId;

}
