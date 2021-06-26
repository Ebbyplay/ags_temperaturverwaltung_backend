package ags.SechsY.temperaturverwaltung.exception;

public class LogNotFoundException extends RuntimeException {

    public LogNotFoundException() {
        super("Could not log user.");
    }

    public LogNotFoundException(Long id) {
        super("Could not find log with id:" + id + ".");
    }
}
