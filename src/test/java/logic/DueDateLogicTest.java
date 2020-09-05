package logic;

import exceptions.IssueDateException;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Assert;
import org.junit.Test;


public class DueDateLogicTest {

    private final DueDateLogic logic = new DueDateLogic();
    private static final LocalDateTime TEST_DATE_TIME = LocalDateTime.of(2020, Month.SEPTEMBER, 4, 14, 0, 0);
    private static final LocalDateTime RESULT_DATE_TIME = LocalDateTime.of(2020, Month.SEPTEMBER, 7, 14, 0, 0);
    private static final LocalDateTime RESULT_DATE_TIME_2 = LocalDateTime.of(2020, Month.SEPTEMBER, 8, 14, 0, 0);
    private static final LocalDateTime RESULT_DATE_TIME_3 = LocalDateTime.of(2020, Month.SEPTEMBER, 14, 14, 0, 0);
    private static final LocalDateTime RESULT_DATE_TIME_4 = LocalDateTime.of(2020, Month.SEPTEMBER, 7, 11, 0, 0);
    private static final LocalDateTime TEST_DATE_TIME_SATURDAY = LocalDateTime.of(2020, Month.SEPTEMBER, 5, 11, 0, 0);
    private static final LocalDateTime TEST_DATE_TIME_SUNDAY = LocalDateTime.of(2020, Month.SEPTEMBER, 6, 11, 0, 0);
    private static final LocalDateTime TEST_DATE_TIME_BEFORE_NON_WORKING_HOURS = LocalDateTime.of(2020, Month.SEPTEMBER, 4, 8, 59, 0);
    private static final LocalDateTime TEST_DATE_TIME_AFTER_NON_WORKING_HOURS = LocalDateTime.of(2020, Month.SEPTEMBER, 4, 17, 2, 0);


    @Test
    public void testDueDateLogicCorrectZeroHour() {
        Assert.assertEquals(TEST_DATE_TIME, logic.calculateDueDate(TEST_DATE_TIME, 0L));
    }

    @Test
    public void testDueDateLogicCorrectFiveHour() {
        Assert.assertEquals(RESULT_DATE_TIME_4, logic.calculateDueDate(TEST_DATE_TIME, 5L));
    }

    @Test
    public void testDueDateLogicCorrectEightHour() {
        Assert.assertEquals(RESULT_DATE_TIME, logic.calculateDueDate(TEST_DATE_TIME, 8L));
    }

    @Test
    public void testDueDateLogicCorrectSixteenHour() {
        Assert.assertEquals(RESULT_DATE_TIME_2, logic.calculateDueDate(TEST_DATE_TIME, 16L));
    }

    @Test
    public void testDueDateLogicCorrectFortyEightHour() {
        Assert.assertEquals(RESULT_DATE_TIME_3, logic.calculateDueDate(TEST_DATE_TIME, 48L));
    }

    @Test
    public void testTurnAroundTimeMinusNumberShouldThrowError() {
        Exception ex = Assert.assertThrows(IssueDateException.class, () -> logic.calculateDueDate(TEST_DATE_TIME, -1L));
        String expectedMessage = "Turn Around Time cannot be smaller than ZERO";
        Assert.assertEquals(expectedMessage, ex.getMessage());
    }

    @Test(expected = IssueDateException.class)
    public void testWeekendDateSaturdayShouldThrowError() {
        logic.calculateDueDate(TEST_DATE_TIME_SATURDAY, 8L);
    }

    @Test(expected = IssueDateException.class)
    public void testWeekendDateSundayShouldThrowError() {
        logic.calculateDueDate(TEST_DATE_TIME_SUNDAY, 8L);
    }

    @Test
    public void testWeekendDateShouldThrowSpecificErrorMessage() {
        Exception ex = Assert.assertThrows(IssueDateException.class, () -> logic.calculateDueDate(
            TEST_DATE_TIME_SATURDAY, 8L));
        String expectedMessage = "issues only can be reported in working days MONDAY to FRIDAY";
        Assert.assertTrue(ex.getMessage().contains(expectedMessage));
    }

    @Test(expected = IssueDateException.class)
    public void testBeforeNonWorkingHoursShouldThrowError() {
        logic.calculateDueDate(TEST_DATE_TIME_BEFORE_NON_WORKING_HOURS, 8L);
    }

    @Test(expected = IssueDateException.class)
    public void testAfterNonWorkingHoursShouldThrowError() {
        logic.calculateDueDate(TEST_DATE_TIME_AFTER_NON_WORKING_HOURS, 8L);
    }

    @Test
    public void testNonWorkingHoursShouldThrowSpecificErrorMessage() {
        Exception ex = Assert.assertThrows(IssueDateException.class, () -> logic.calculateDueDate(
            TEST_DATE_TIME_BEFORE_NON_WORKING_HOURS, 8L));
        Assert.assertThrows(IssueDateException.class,
                            () -> logic.calculateDueDate(TEST_DATE_TIME_AFTER_NON_WORKING_HOURS, 8L));
        String expectedMessage = "working hours between: 09:00 and 17:00";
        Assert.assertTrue(ex.getMessage().contains(expectedMessage));
    }

}
