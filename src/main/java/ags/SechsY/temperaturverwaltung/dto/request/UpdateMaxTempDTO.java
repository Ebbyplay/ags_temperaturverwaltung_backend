package ags.SechsY.temperaturverwaltung.dto.request;

import lombok.Data;

@Data
public class UpdateMaxTempDTO {

    private long sensorId;
    private Float newMaxTemperature;
    private long userId;
}