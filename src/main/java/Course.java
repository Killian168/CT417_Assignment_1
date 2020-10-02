import org.joda.time.DateTime;
import java.util.ArrayList;

public class Course {

    private String name;
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private DateTime start_dat;
    private DateTime end_date;

    public Course(String name, ArrayList<Module> modules, ArrayList<Student> students, DateTime start_dat, DateTime end_date) {
        this.name = name;
        this.modules = modules;
        this.students = students;
        this.start_dat = start_dat;
        this.end_date = end_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public DateTime getStart_dat() {
        return start_dat;
    }

    public void setStart_dat(DateTime start_dat) {
        this.start_dat = start_dat;
    }

    public DateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(DateTime end_date) {
        this.end_date = end_date;
    }
}
