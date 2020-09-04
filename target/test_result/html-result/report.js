$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/resources/features/DueDateTest.feature");
formatter.feature({
  "name": "DueDateLogic test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Test the function for DueDateLogic",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DueDate"
    }
  ]
});
formatter.step({
  "name": "I add test the calculate dueDate using Year: \u0027\u003cyear\u003e\u0027 Month: \u0027\u003cmonth\u003e\u0027 Day: \u0027\u003cday\u003e\u0027 Hour: \u0027\u003chours\u003e\u0027 Minute: \u0027\u003cminutes\u003e\u0027",
  "keyword": "When "
});
formatter.step({
  "name": "I receive result: \u0027\u003cdate\u003e\u0027 with turn around time: \u0027\u003ctat\u003e\u0027",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "year",
        "month",
        "day",
        "hours",
        "minutes",
        "date",
        "tat"
      ]
    },
    {
      "cells": [
        "2020",
        "9",
        "4",
        "14",
        "0",
        "2020-09-07T14:00:00",
        "8"
      ]
    },
    {
      "cells": [
        "2020",
        "9",
        "4",
        "14",
        "0",
        "2020-09-08T14:00:00",
        "16"
      ]
    },
    {
      "cells": [
        "2020",
        "9",
        "4",
        "14",
        "0",
        "2020-09-14T14:00:00",
        "48"
      ]
    },
    {
      "cells": [
        "2020",
        "9",
        "4",
        "14",
        "0",
        "2020-09-07T11:00:00",
        "5"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Test the function for DueDateLogic",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DueDate"
    }
  ]
});
formatter.step({
  "name": "I add test the calculate dueDate using Year: \u00272020\u0027 Month: \u00279\u0027 Day: \u00274\u0027 Hour: \u002714\u0027 Minute: \u00270\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "DueDateLogicCucumber.testCalculateDueDateLogic(String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I receive result: \u00272020-09-07T14:00:00\u0027 with turn around time: \u00278\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "DueDateLogicCucumber.getCalculateDueDateResult(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test the function for DueDateLogic",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DueDate"
    }
  ]
});
formatter.step({
  "name": "I add test the calculate dueDate using Year: \u00272020\u0027 Month: \u00279\u0027 Day: \u00274\u0027 Hour: \u002714\u0027 Minute: \u00270\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "DueDateLogicCucumber.testCalculateDueDateLogic(String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I receive result: \u00272020-09-08T14:00:00\u0027 with turn around time: \u002716\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "DueDateLogicCucumber.getCalculateDueDateResult(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test the function for DueDateLogic",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DueDate"
    }
  ]
});
formatter.step({
  "name": "I add test the calculate dueDate using Year: \u00272020\u0027 Month: \u00279\u0027 Day: \u00274\u0027 Hour: \u002714\u0027 Minute: \u00270\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "DueDateLogicCucumber.testCalculateDueDateLogic(String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I receive result: \u00272020-09-14T14:00:00\u0027 with turn around time: \u002748\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "DueDateLogicCucumber.getCalculateDueDateResult(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Test the function for DueDateLogic",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DueDate"
    }
  ]
});
formatter.step({
  "name": "I add test the calculate dueDate using Year: \u00272020\u0027 Month: \u00279\u0027 Day: \u00274\u0027 Hour: \u002714\u0027 Minute: \u00270\u0027",
  "keyword": "When "
});
formatter.match({
  "location": "DueDateLogicCucumber.testCalculateDueDateLogic(String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I receive result: \u00272020-09-07T11:00:00\u0027 with turn around time: \u00275\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "DueDateLogicCucumber.getCalculateDueDateResult(String,String)"
});
formatter.result({
  "status": "passed"
});
});