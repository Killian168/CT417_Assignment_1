import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {

    private String name = "testName";
    private DateTime dob = new DateTime(1998, 8, 16, 12, 12);
    private double id = 18101573;
    private Course course = Mockito.mock(Course.class);
    private ArrayList<Module> modules;
    private boolean registered = false;
    private Student testStudent;

    @BeforeEach
    public void setUpTestStudent() {
        modules = new ArrayList<>();
        Module m = Mockito.mock(Module.class);
        modules.add(m);
        this.testStudent = new Student(name, dob, id, course, modules, registered);
    }

    @Test
    @DisplayName("Test setName if null")
    public void testSetNameNull() {
        checkInvalidParamException(() -> {
            testStudent.setName(null);
        }, "Student name cannot be empty or null");
    }

    @Test
    @DisplayName("Test setName if empty")
    public void testSetNameEmpty() {
        checkInvalidParamException(() -> {
            testStudent.setName("");
        }, "Student name cannot be empty or null");
    }

    @Test
    @DisplayName("Test setName if blank")
    public void testSetNameBlank() {
        checkInvalidParamException(() -> {
            testStudent.setName("     ");
        }, "Student name cannot be empty or null");
    }

    @Test
    @DisplayName("Test setModules if null")
    public void testSetModulesNull() {
        checkInvalidParamException(() -> {
            testStudent.setModules(null);
        }, "Student modules cannot be set to null");
    }

    @Test
    @DisplayName("Test setModules if empty")
    public void testSetModulesEmpty() {
        checkInvalidParamException(() -> {
            testStudent.setModules(new ArrayList<>());
        }, "Student modules cannot be set to empty");
    }

    @Test
    @DisplayName("Test setCourse if null")
    public void testSetStudentsNull() {
        checkInvalidParamException(() -> {
            testStudent.setCourse(null);
        }, "Student course cannot be set to null");
    }

    @Test
    @DisplayName("Test setDob if null")
    public void testSetDOBNull() {
        checkInvalidParamException(() -> {
            testStudent.setDob(null);
        }, "Student Date of Birth cannot be set to null");
    }

    @Test
    @DisplayName("Test setId if less than 1")
    public void testSetIdNull() {
        checkInvalidParamException(() -> {
            testStudent.setId(-1);
        }, "Student id cannot be less than 1");
    }

    @Test
    @DisplayName("Test setCourse if null")
    public void testSetCourseNull() {
        checkInvalidParamException(() -> {
            testStudent.setCourse(null);
        }, "Student course cannot be set to null");
    }

    @Test
    @DisplayName("Test getUsername")
    public void testGetUsername() {
        String username = "testName22";
        assertEquals(testStudent.getUsername(), username);
    }

    @Test
    @DisplayName("Test getName")
    public void testGetName() {
        assertEquals(testStudent.getName(), this.name);
    }

    @Test
    @DisplayName("Test getId")
    public void testGetId() {

        double delta = Math.pow(10, Math.log10(Math.abs(this.id)) - 12);
        assertEquals(testStudent.getId(), this.id, delta);
    }

    @Test
    @DisplayName("Test getAge")
    public void testGetStudents() {
        int age = 22;
        assertEquals(testStudent.getAge(), age);
    }

    @Test
    @DisplayName("Test getStart_date")
    public void testGetStart_date() {
        assertEquals(testStudent.getDob(), this.dob);
    }

    @Test
    @DisplayName("Test getCourse")
    public void testGetCourse() {
        assertEquals(testStudent.getCourse(), this.course);
    }

    @Test
    @DisplayName("Test getModules")
    public void testGetModules() {
        assertEquals(testStudent.getModules(), this.modules);
    }

    @Test
    @DisplayName("Test isRegistered")
    public void testIsRegistered() {
        assertEquals(testStudent.isRegistered(), this.registered);
    }

    public void checkInvalidParamException(Runnable courseMethod, String exceptionMessage) {
        Exception exception = assertThrows(InvalidParameterException.class, courseMethod::run);
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(exceptionMessage));
    }
}
