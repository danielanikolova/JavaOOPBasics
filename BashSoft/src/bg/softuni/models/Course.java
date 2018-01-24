package bg.softuni.models;

import bg.softuni.exeptions.DuplicateEntryInStructureException;
import bg.softuni.exeptions.InvalidStringException;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by danie on 11/14/2017.
 */
public class Course {

    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private Map<String, Student> studentsByName;

    public Course(String name) {
        this.name = name;
        this.studentsByName = new LinkedHashMap<>();
    }

    public void enrollStudent(Student student) {
        if (this.studentsByName.containsKey(student.getUserName())) {
            throw new DuplicateEntryInStructureException(student.getUserName(), this.name);
        }

        this.studentsByName.put(student.getUserName(), student);
    }

    public String getName() {
        return name;
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    public void setName(String name) throws InvalidStringException {
        if (name == null || name.equals("")) {
            throw new InvalidStringException();
        }
        this.name = name;
    }
}
