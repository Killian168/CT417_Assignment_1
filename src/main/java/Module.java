import org.joda.time.DateTime;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Module {

    private String name;
    private String id;
    private DateTime start_date;
    private DateTime end_date;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    ////////////// Constructors //////////////

    public Module(String name, String id, DateTime start_date, DateTime end_date,
                  ArrayList<Student> students, ArrayList<Course> courses) {
        this.setName(name);
        this.setId(id);
        this.setStart_date(start_date);
        this.setEnd_date(end_date);
        this.setStudents(students);
        this.setCourses(courses);
    }

    ////////////// Setters //////////////

    public void setName(String name) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new InvalidParameterException("Module name cannot be empty or null");
        }
        this.name = name;
    }

    public void setId(String id) {
        if (id == null || id.isBlank() || id.isEmpty()) {
            throw new InvalidParameterException("Module ID cannot be empty or null");
        }
        this.id = id;
    }

    public void setStudents(ArrayList<Student> students) {
        if (students == null) {
            throw new InvalidParameterException("Module students cannot be null");
        }
        this.students = students;
    }

    public void setCourses(ArrayList<Course> courses) {
        if (courses == null) {
            throw new InvalidParameterException("Module courses cannot be null");
        }
        this.courses = courses;
    }

    public void setStart_date(DateTime start_date) {
        if (start_date == null) {
            throw new InvalidParameterException("Module start date cannot be null");
        }
        if (end_date != null && start_date.isAfter(end_date)) {
            throw new InvalidParameterException("Module start date cannot be after module end date");
        }
        this.start_date = start_date;
    }

    public void setEnd_date(DateTime end_date) {
        if (end_date == null) {
            throw new InvalidParameterException("Module end date cannot be null");
        }
        if (start_date != null && end_date.isBefore(start_date)) {
            throw new InvalidParameterException("Module end date cannot be before module start date");
        }
        this.end_date = end_date;
    }

    ////////////// Getters //////////////

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
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
