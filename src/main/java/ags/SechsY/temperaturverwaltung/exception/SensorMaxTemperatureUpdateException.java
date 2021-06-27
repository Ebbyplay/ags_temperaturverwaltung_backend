package ags.SechsY.temperaturverwaltung.exception;

public class SensorMaxTemperatureUpdateException extends RuntimeException {

    public SensorMaxTemperatureUpdateException() {
        super("If you change the MaxTemperature the User has to be provided!");
    }
}
