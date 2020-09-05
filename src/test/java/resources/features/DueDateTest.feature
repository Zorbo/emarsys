Feature: DueDateLogic test

  @DueDate
  Scenario Outline: Test the function for DueDateLogic
    Given I add test data to calculate the dueDate using Year: '<year>' Month: '<month>' Day: '<day>' Hour: '<hours>' Minute: '<minutes>'
    When I trigger the CalculateDueDateLogic with turn around time: '<turnAroundTime>'
    Then I receive result: '<date>'

    Examples:
      | year | month | day | hours | minutes | date                | turnAroundTime |
      | 2020 | 9     | 4   | 14    | 0       | 2020-09-07T14:00:00 | 8              |
      | 2020 | 9     | 4   | 14    | 0       | 2020-09-08T14:00:00 | 16             |
      | 2020 | 9     | 4   | 14    | 0       | 2020-09-14T14:00:00 | 48             |
      | 2020 | 9     | 4   | 14    | 0       | 2020-09-07T11:00:00 | 5              |
