package ags.SechsY.temperaturverwaltung.dto.request;

import lombok.Data;

@Data
public class SensorRequestDTO {

    private Float maxTemperature;
    private long serverRackId;
    private long manufacturerId;
}
