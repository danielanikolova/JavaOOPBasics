package bg.softuni.exeptions;

/**
 * Created by danie on 11/14/2017.
 */
public class KeyNotFoundException extends RuntimeException {

    private static final String NOT_ENROLLED_IN_COURSE = "Student must be enrolled in a course before you set his mark.";

    public KeyNotFoundException() {
        super(NOT_ENROLLED_IN_COURSE);
    }
}