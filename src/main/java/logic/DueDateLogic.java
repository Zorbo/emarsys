package logic;


import exceptions.IssueDateException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class responsible to calculate Date for the Issue Tracking System
 *
 * @author tamas.kiss
 */
public class DueDateLogic {

    private static final Logger logger = LoggerFactory.getLogger(DueDateLogic.class);
    private static final LocalTime START = LocalTime.of(9, 0);
    private static final LocalTime FINISH = LocalTime.of(17, 0);
    private static final long NANOS_TO_ADD = 1L;
    private static final int HOURS = 1;
    private static final int ZERO = 0;

    /**
     * Calculate the issue due date
     *
     * @param submitDate The date the issue submitted
     * @param turnAroundTime The turn around time for the issue
     * @return The time of completion
     */
    public LocalDateTime calculateDueDate(LocalDateTime submitDate, Long turnAroundTime) {
        logger.info("Starting calculating due date for the sent issue");
        String dateFormat = submitDate.atZone(ZoneId.of("GMT")).format(DateTimeFormatter.RFC_1123_DATE_TIME);

        if (turnAroundTime < ZERO ) {
            throw new IssueDateException("Turn Around Time cannot be smaller than ZERO");
        }
        if (isWeekend(submitDate) || !isBetweenWorkingHours(submitDate)) {
            throw new IssueDateException("Issue reported: " + dateFormat
                                             + ", issues only can be reported in working days MONDAY to FRIDAY and"
                                             + " working hours between: 09:00 and 17:00");
        }

        LocalDateTime resolvedDate = submitDate;
        while (turnAroundTime != ZERO) {
            resolvedDate = resolvedDate.plusHours(HOURS);
            if (!isWeekend(resolvedDate) && isBetweenWorkingHours(resolvedDate)) {
                turnAroundTime--;
            }
        }
        return resolvedDate;
    }

    private boolean isWeekend(LocalDateTime submitDate) {
        return submitDate.getDayOfWeek().equals(DayOfWeek.SATURDAY) || submitDate.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    private boolean isBetweenWorkingHours(LocalDateTime submitDate) {
        LocalTime current = LocalTime.of(submitDate.getHour(), submitDate.getMinute());
        return current.isAfter(START) && current.isBefore(FINISH.plusNanos(NANOS_TO_ADD));
    }
}
