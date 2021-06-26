package ags.SechsY.temperaturverwaltung.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Could not find user.");
    }

    public UserNotFoundException(Long id) {
        super("Could not find user with id:" + id + ".");
    }
}