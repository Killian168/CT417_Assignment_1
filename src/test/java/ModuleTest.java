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

public class ModuleTest {

    private Module testModule;
    private String testName = "testName";
    private String id = "testID";
    private DateTime start_date = new DateTime();
    private DateTime end_date = new DateTime();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    @BeforeEach
    public void setUpTestModule() {
        Student s = Mockito.mock(Student.class);
        Course c = Mockito.mock(Course.class);
        students.add(s);
        courses.add(c);
        this.testModule = new Module(testName, id, start_date, end_date, students, courses);
    }

    @Test
    @DisplayName("Test setName if null")
    public void testSetNameNull() {
        checkInvalidParamException(() -> {
            testModule.setName(null);
        }, "Module name cannot be empty or null");
    }

    @Test
    @DisplayName("Test setName if empty")
    public void testSetNameEmpty() {
        checkInvalidParamException(() -> {
            testModule.setName("");
        }, "Module name cannot be empty or null");
    }

    @Test
    @DisplayName("Test setName if blank")
    public void testSetNameBlank() {
        checkInvalidParamException(() -> {
            testModule.setName("     ");
        }, "Module name cannot be empty or null");
    }

    @Test
    @DisplayName("Test setId if null")
    public void testSetIdNull() {
        checkInvalidParamException(() -> {
            testModule.setId(null);
        }, "Module ID cannot be empty or null");
    }

    @Test
    @DisplayName("Test setId if empty")
    public void testSetIdEmpty() {
        checkInvalidParamException(() -> {
            testModule.setId("");
        }, "Module ID cannot be empty or null");
    }

    @Test
    @DisplayName("Test setId if blank")
    public void testSetIdBlank() {
        checkInvalidParamException(() -> {
            testModule.setId("     ");
        }, "Module ID cannot be empty or null");
    }

    @Test
    @DisplayName("Test setStudents if null")
    public void testSetStudentsNull() {
        checkInvalidParamException(() -> {
            testModule.setStudents(null);
        }, "Module students cannot be null");
    }

    @Test
    @DisplayName("Test setCourse if null")
    public void testSetCourseNull() {
        checkInvalidParamException(() -> {
            this.testModule.setCourses(null);
        }, "Module courses cannot be null");
    }

    @Test
    @DisplayName("Test setStartData if null")
    public void testStartDateNull() {
        checkInvalidParamException(() -> {
            testModule.setStart_date(null);
        }, "Module start date cannot be null");
    }

    @Test
    @DisplayName("Test setStartData if after end date")
    public void testStartDateAfterEndDate() {
        checkInvalidParamException(() -> {
            testModule.setEnd_date(new DateTime(2020, 12, 22, 12, 12));
            testModule.setStart_date(new DateTime(2021, 12, 22, 12, 12));
        }, "Module start date cannot be after module end date");
    }

    @Test
    @DisplayName("Test setEndDate if null")
    public void testEndDateNull() {
        checkInvalidParamException(() -> {
            testModule.setEnd_date(null);
        }, "Module end date cannot be null");
    }

    @Test
    @DisplayName("Test setEndDate if before start date")
    public void testEndDateAfterEndDate() {
        checkInvalidParamException(() -> {
            testModule.setEnd_date(new DateTime(2021, 12, 22, 12, 12));
            testModule.setStart_date(new DateTime(2020, 12, 22, 12, 12));
            testModule.setEnd_date(new DateTime(2019, 12, 22, 12, 12));
        }, "Module end date cannot be before module start date");
    }

    @Test
    @DisplayName("Test getName")
    public void getName() {
        assertEquals(testModule.getName(), this.testName);
    }

    @Test
    @DisplayName("Test getId")
    public void getId() {
        assertEquals(testModule.getId(), this.id);
    }

    @Test
    @DisplayName("Test getStudents")
    public void getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        Student s = Mockito.mock(Student.class);
        students.add(s);
        testModule.setStudents(students);
        assertEquals(testModule.getStudents(), students);
    }

    @Test
    @DisplayName("Test getCourses")
    public void getCourses() {
        assertEquals(testModule.getCourses(), this.courses);
    }

    @Test
    @DisplayName("Test getStart_date")
    public void getStart_date() {
        assertEquals(testModule.getStart_date(), this.start_date);
    }

    @Test
    @DisplayName("Test getEnd_date")
    public void getEnd_date() {
        assertEquals(testModule.getEnd_date(), this.end_date);
    }

    public void checkInvalidParamException(Runnable courseMethod, String exceptionMessage) {
        Exception exception = assertThrows(InvalidParameterException.class, courseMethod::run);
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(exceptionMessage));
    }
}
