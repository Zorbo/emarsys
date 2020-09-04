Feature: DueDateLogic test

  @DueDate
  Scenario Outline: Test the function for DueDateLogic
    When I add test the calculate dueDate using Year: '<year>' Month: '<month>' Day: '<day>' Hour: '<hours>' Minute: '<minutes>'
    Then I receive result: '<date>' with turn around time: '<tat>'

    Examples:
      | year | month | day | hours | minutes | date                | tat |
      | 2020 | 9     | 4   | 14    | 0       | 2020-09-07T14:00:00 | 8   |
      | 2020 | 9     | 4   | 14    | 0       | 2020-09-08T14:00:00 | 16  |
      | 2020 | 9     | 4   | 14    | 0       | 2020-09-14T14:00:00 | 48  |
      | 2020 | 9     | 4   | 14    | 0       | 2020-09-07T11:00:00 | 5   |
