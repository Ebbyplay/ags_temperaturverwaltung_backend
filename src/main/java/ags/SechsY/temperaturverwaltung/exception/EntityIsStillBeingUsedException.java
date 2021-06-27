package ags.SechsY.temperaturverwaltung.exception;

public class EntityIsStillBeingUsedException extends RuntimeException {

    public EntityIsStillBeingUsedException(String entityName) {
        super(entityName + "is still being used and cannot be deleted.");
    }

    public EntityIsStillBeingUsedException(String entityName, long id) {
        super(entityName + " with the id: " + id + " is still being used and cannot be deleted.");
    }
}
