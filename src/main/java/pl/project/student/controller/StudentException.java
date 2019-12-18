package pl.project.student.controller;

/**
 * Created by A.Wójcik on 13.12.2019.
 */
public class StudentException extends RuntimeException {

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentException(Throwable cause) {
        super(cause);
    }
}
