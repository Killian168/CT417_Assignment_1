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

    public Student(String name, int age, DateTime dob, double id, Course course, ArrayList<Module> modules, boolean registered) {
        this.setName(name);
        this.setAge(age);
        this.setDob(dob);
        this.setId(id);
        this.setCourses(course);
        this.setModules(modules);
        this.setRegistered(registered);
        this.username = this.getUsername();
    }

    private String getUsername() throws InvalidParameterException {
        if (this.username == null) {
            if (this.name == null || this.age == -1) {
                throw new InvalidParameterException("Name or Age can not be null");
            }
            this.username = this.name + this.age;
        }
        return this.username;
    }

    private void setName(String name) {
        if (name == null) {
            throw new InvalidParameterException("Name can not be null");
        }
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setDob(DateTime dob) {
        if (dob == null) {
            throw new InvalidParameterException("Date Of Birth can not be null");
        }
        this.dob = dob;
    }

    private void setId(double id) {
        this.id = id;
    }

    private void setCourses(Course course) {
        if (course == null) {
            throw new InvalidParameterException("Course can not be null");
        }
        this.course = course;
    }

    private void setModules(ArrayList<Module> modules) {
        if (modules == null) {
            throw new InvalidParameterException("Modules can not be null");
        }
        this.modules = modules;
    }

    private void setRegistered(boolean registered) {
        this.registered = registered;
    }
}
