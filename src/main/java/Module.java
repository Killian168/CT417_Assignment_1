import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Module {

    private String name;
    private String id;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public Module(String name, String id, ArrayList<Student> students, ArrayList<Course> courses) {
        this.name = name;
        this.id = id;
        this.students = students;
        this.courses = courses;
    }

    private void setName(String name) {
        if (name == null) {
            throw new InvalidParameterException("Name can not be null");
        }
        this.name = name;
    }

    private void setId(String id) {
        if (id == null) {
            throw new InvalidParameterException("ID can not be null");
        }
        this.id = id;
    }

    private void setStudents(ArrayList<Student> students) {
        if (students == null) {
            throw new InvalidParameterException("Students can not be null");
        }
        this.students = students;
    }

    private void setCourses(ArrayList<Course> courses) {
        if (courses == null) {
            throw new InvalidParameterException("Courses can not be null");
        }
        this.courses = courses;
    }

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
}
