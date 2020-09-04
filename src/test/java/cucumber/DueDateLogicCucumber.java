package cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDateTime;
import logic.DueDateLogic;
import org.junit.Assert;


public class DueDateLogicCucumber {

    private final DueDateLogic logic = new DueDateLogic();
    private LocalDateTime time;

    @When("I add test the calculate dueDate using Year: '(.*)' Month: '(.*)' Day: '(.*)' Hour: '(.*)' Minute: '(.*)'")
    public void testCalculateDueDateLogic(String year, String month, String day, String hour, String minute) {
        time = LocalDateTime.of(Integer.parseInt(year),
                                Integer.parseInt(month),
                                Integer.parseInt(day),
                                Integer.parseInt(hour),
                                Integer.parseInt(minute));
    }

    @Then("I receive result: '(.*)' with turn around time: '(.*)'")
    public void getCalculateDueDateResult(String result, String tat) {
        LocalDateTime parsedDate = LocalDateTime.parse(result);
        Assert.assertEquals(parsedDate, logic.calculateDueDate(time, (long) Integer.parseInt(tat)));
    }

}
