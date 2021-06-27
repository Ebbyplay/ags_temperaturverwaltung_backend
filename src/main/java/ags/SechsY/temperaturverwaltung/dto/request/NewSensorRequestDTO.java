package ags.SechsY.temperaturverwaltung.dto.request;

import lombok.Data;

@Data
public class NewSensorRequestDTO {

    private Float maxTemperature;
    private long serverRackId;
    private long manufacturerId;
}
