package ags.SechsY.temperaturverwaltung.exception;

public class ServerRackNotFoundException extends RuntimeException {

    public ServerRackNotFoundException() {
        super("Could not find ServerRack.");
    }

    public ServerRackNotFoundException(long id) {
        super("Could not find ServerRack with id: " + id + ".");
    }

}
