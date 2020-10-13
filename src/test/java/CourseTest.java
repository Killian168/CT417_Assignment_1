import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseTest {

    private String testName = "testName";
    private DateTime startDate = new DateTime();
    private DateTime endDate = new DateTime();
    public Course testCourse;

    @BeforeEach
    public void setUpTestCourse() {
        String name = this.testName;
        ArrayList<Module> modules = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        DateTime start_date = this.startDate;
        DateTime end_date = this.endDate;

        this.testCourse = new Course(name, modules, students, start_date, end_date);
    }

    @Test 
    @DisplayName("Test setName if null")
    public void testSetNameNull() {
        checkInvalidParamException(() -> {
                testCourse.setName(null);
        },"Course name cannot be empty or null");
    }

    @Test 
    @DisplayName("Test setName if empty")
    public void testSetNameEmpty() {
        checkInvalidParamException(() -> {
                testCourse.setName("");
        },"Course name cannot be empty or null");
    }

    @Test 
    @DisplayName("Test setName if blank")
    public void testSetNameBlank() {
        checkInvalidParamException(()->{
                testCourse.setName("     ");
        },"Course name cannot be empty or null");
    }

    @Test
    @DisplayName("Test setModules if null")
    public void testSetModulesNull() {
        checkInvalidParamException(()->{
            testCourse.setModules(null);
        },"Course modules cannot be set to null");
    }

    @Test
    @DisplayName("Test setStudents if null")
    public void testSetStudentsNull() {
        checkInvalidParamException(()->{
            testCourse.setStudents(null);
        },"Course students cannot be set to null");
    }

    @Test
    @DisplayName("Test setStartData if null")
    public void testStartDateNull() {
        checkInvalidParamException(()->{
            testCourse.setStart_date(null);
        },"Course start date cannot be null");
    }

    @Test
    @DisplayName("Test setStartData if after end date")
    public void testStartDateAfterEndDate() {
        checkInvalidParamException(()->{
            testCourse.setEnd_date(new DateTime(2020, 12, 22, 12, 12));
            testCourse.setStart_date(new DateTime(2021, 12, 22, 12, 12));
        },"Course start date cannot be after course end date");
    }

    @Test
    @DisplayName("Test setEndDate if null")
    public void testEndDateNull() {
        checkInvalidParamException(()->{
            testCourse.setEnd_date(null);
        },"Course end date cannot be null");
    }

    @Test
    @DisplayName("Test setEndDate if before start date")
    public void testEndDateAfterEndDate() {
        checkInvalidParamException(()->{
            testCourse.setEnd_date(new DateTime(2021, 12, 22, 12, 12));
            testCourse.setStart_date(new DateTime(2020, 12, 22, 12, 12));
            testCourse.setEnd_date(new DateTime(2019, 12, 22, 12, 12));
        },"Course end date cannot be before course start date");
    }

    @Test
    @DisplayName("Test getName")
    public void getName() {
        assertEquals(testCourse.getName(), this.testName);
    }

    @Test
    @DisplayName("Test getModules")
    public void getModules() {
        assertEquals(testCourse.getModules(), new ArrayList<>());
    }

    @Test
    @DisplayName("Test getStudents")
    public void getStudents() {
        assertEquals(testCourse.getStudents(), new ArrayList<>());
    }

    @Test
    @DisplayName("Test getStart_date")
    public void getStart_date() {
        assertEquals(testCourse.getStart_date(), this.startDate);
    }

    @Test
    @DisplayName("Test getEnd_date")
    public void getEnd_date() {
        assertEquals(testCourse.getEnd_date(), this.endDate);
    }

    public void checkInvalidParamException(Runnable courseMethod, String exceptionMessage) {
        Exception exception = assertThrows(InvalidParameterException.class, courseMethod::run);
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(exceptionMessage));
    }
}
