import org.joda.time.DateTime;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Course {

    private String name;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private DateTime start_date;
    private DateTime end_date;

    ////////////// Constructors //////////////

    public Course(String name, ArrayList<Module> modules, ArrayList<Student> students,
                  DateTime start_date, DateTime end_date) {
        this(name, modules, start_date, end_date);
        this.setStudents(students);
    }

    public Course(String name, ArrayList<Module> modules, DateTime start_date, DateTime end_date) {
        this.setName(name);
        this.setModules(modules);
        this.setStart_date(start_date);
        this.setEnd_date(end_date);
    }

    ////////////// Setters //////////////

    public void setName(String name) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new InvalidParameterException("Course name cannot be empty or null");
        }
        this.name = name;
    }

    public void setModules(ArrayList<Module> modules) {
        if (modules == null) {
            throw new InvalidParameterException("Course modules cannot be set to null");
        }
        this.modules = modules;
    }

    public void setStudents(ArrayList<Student> students) {
        if (students == null) {
            throw new InvalidParameterException("Course students cannot be set to null");
        }
        this.students = students;
    }

    public void setStart_date(DateTime start_date) {
        if (start_date == null) {
            throw new InvalidParameterException("Course start date cannot be null");
        }
        if (end_date != null && start_date.isAfter(end_date)) {
            throw new InvalidParameterException("Course start date cannot be after course end date");
        }
        this.start_date = start_date;
    }

    public void setEnd_date(DateTime end_date) {
        if (end_date == null) {
            throw new InvalidParameterException("Course end date cannot be null");
        }
        if (start_date != null && end_date.isBefore(start_date)) {
            throw new InvalidParameterException("Course end date cannot be before course start date");
        }
        this.end_date = end_date;
    }

    ////////////// Getters //////////////

    public String getName() {
        return name;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public DateTime getStart_date() {
        return start_date;
    }

    public DateTime getEnd_date() {
        return end_date;
    }

    ////////////// Public methods //////////////

    ////////////// Private methods //////////////
}
