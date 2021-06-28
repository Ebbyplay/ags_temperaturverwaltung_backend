package ags.SechsY.temperaturverwaltung.dto.request;

import lombok.Data;

@Data
public class UpdateSensorDTO {

    private long sensorId;
    private long rackId;
    private long manufacturerId;

}
