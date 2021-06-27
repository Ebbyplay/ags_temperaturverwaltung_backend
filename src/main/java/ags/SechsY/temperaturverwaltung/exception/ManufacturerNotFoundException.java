package ags.SechsY.temperaturverwaltung.exception;

public class ManufacturerNotFoundException extends RuntimeException {

    public ManufacturerNotFoundException() {
        super("Could not find Manufacturer.");
    }

    public ManufacturerNotFoundException(long id) {
        super("Could not find Manufacturer with id: " + id + ".");
    }
}
