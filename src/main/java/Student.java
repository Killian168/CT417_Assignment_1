import org.joda.time.DateTime;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Student {

    private String name = null;
    private int age = -1;
    private DateTime dob = null;
    private double id = -1;
    private String username;
    private Course course = null;
    private ArrayList<Module> modules = null;
    private boolean registered = false;

    ////////////// Constructors //////////////

    public Student(String name, DateTime dob, double id, Course course, ArrayList<Module> modules,
                   boolean registered) {
        this.setName(name);
        this.setDob(dob);
        this.setId(id);
        this.setCourse(course);
        this.setModules(modules);
        this.setRegistered(registered);
        this.username = this.getUsername();
    }

    ////////////// Setters //////////////

    public void setName(String name) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new InvalidParameterException("Student name cannot be empty or null");
        }
        this.name = name;
    }

    public void setAge() {
        this.age = this.calculateAge(this.dob, DateTime.now());
    }

    public void setDob(DateTime dob) {
        if (dob == null) {
            throw new InvalidParameterException("Student Date of Birth cannot be set to null");
        }
        this.dob = dob;
        this.setAge();
    }

    public void setId(double id) {
        if (id < 1) {
            throw new InvalidParameterException("Student id cannot be less than 1");
        }
        this.id = id;
    }

    public void setCourse(Course course) {
        if (course == null) {
            throw new InvalidParameterException("Student course cannot be set to null");
        }
        this.course = course;
    }

    public void setModules(ArrayList<Module> modules) {
        if (modules == null) {
            throw new InvalidParameterException("Student modules cannot be set to null");
        }
        if (modules.isEmpty()) {
            throw new InvalidParameterException("Student modules cannot be set to empty");
        }
        this.modules = modules;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }


    ////////////// Getters //////////////

    public String getUsername() throws InvalidParameterException {
        if (this.username == null) {
            if (this.name == null) {
                throw new InvalidParameterException("Name must not be null to set Username");
            }
            if (this.age < 1) {
                throw new InvalidParameterException("Age must not be less than 1 to set Username");
            }
            this.username = this.name + this.age;
        }
        return this.username;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public DateTime getDob() {
        return dob;
    }

    public double getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public boolean isRegistered() {
        return registered;
    }

    ////////////// Public methods //////////////

    ////////////// Private methods //////////////

    private int calculateAge(DateTime birthDate, DateTime currentDate) {
        if (birthDate.isAfter(currentDate)) {
            throw new InvalidParameterException("BirthDate cannot be after currentDate");
        }
        return currentDate.getYear() - birthDate.getYear();
    }
}
