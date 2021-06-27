package ags.SechsY.temperaturverwaltung.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TemperatureResponseDTO {

    private long id;
    private Float temperature_value;
    private LocalDateTime timestamp;
    private long sensorId;

}
