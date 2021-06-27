package ags.SechsY.temperaturverwaltung.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entityName) {
        super(entityName + " could not be found.");
    }

    public EntityNotFoundException(String entityName, long id) {
        super(entityName + " with id: " + id + " could not be found.");
    }

}
