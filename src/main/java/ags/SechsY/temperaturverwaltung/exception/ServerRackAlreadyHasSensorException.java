package ags.SechsY.temperaturverwaltung.exception;

public class ServerRackAlreadyHasSensorException extends RuntimeException {

    public ServerRackAlreadyHasSensorException() {
        super("The specified serverRack already has a sensor.");
    }

    public ServerRackAlreadyHasSensorException(long rackId) {
        super("The ServerRack with id: " + rackId + " already has a sensor.");
    }
}
