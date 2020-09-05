package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.LocalDateTime;
import logic.DueDateLogic;
import org.junit.Assert;


public class DueDateLogicCucumber {

    private final DueDateLogic logic = new DueDateLogic();
    private LocalDateTime calculatedTimeResult;
    private LocalDateTime expectedTimeResult;

    @Given("I add test data to calculate the dueDate using Year: '(.*)' Month: '(.*)' Day: '(.*)' Hour: '(.*)' Minute: '(.*)'")
    public void testCalculateDueDateLogic(String year, String month, String day, String hour, String minute) {
        expectedTimeResult = LocalDateTime.of(Integer.parseInt(year),
                                              Integer.parseInt(month),
                                              Integer.parseInt(day),
                                              Integer.parseInt(hour),
                                              Integer.parseInt(minute));
    }

    @When("I trigger the CalculateDueDateLogic with turn around time: '(.*)'")
    public void testTriggerCalculateDueDateLogic(String turnAroundTime) {
        calculatedTimeResult = logic.calculateDueDate(expectedTimeResult, (long) Integer.parseInt(turnAroundTime));
    }

    @Then("I receive result: '(.*)'")
    public void testCalculateDueDateResult(String result) {
        LocalDateTime parsedDate = LocalDateTime.parse(result);
        Assert.assertEquals(parsedDate, calculatedTimeResult);
    }

}
