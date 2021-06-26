package ags.SechsY.temperaturverwaltung.exception;

public class SensorNotFoundException extends RuntimeException {

    public SensorNotFoundException() {
        super("Could not find Sensor.");
    }

    public SensorNotFoundException(long id) {
        super("Could not find Sensor with id: " + id + ".");
    }
}
