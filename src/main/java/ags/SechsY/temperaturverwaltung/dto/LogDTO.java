package ags.SechsY.temperaturverwaltung.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LogDTO {

    private Float newMaxTemperature;
    private LocalDateTime timestamp;

}
