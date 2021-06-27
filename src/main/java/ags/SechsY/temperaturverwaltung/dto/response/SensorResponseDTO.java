package ags.SechsY.temperaturverwaltung.dto.response;

import lombok.Data;

@Data
public class SensorResponseDTO {

    private long id;
    private Float maxTemperature;
    private long rackId;
    private long manufacturerId;
}
