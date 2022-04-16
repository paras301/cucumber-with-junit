Feature: Dummy Rest Api Functionality Scenarios

  Scenario Outline: Dummy Rest Api GET
    Given Get Call to "<url>"
    Then Response "<responseMessage>" is validated

    Examples:
      | url                                               | responseMessage                        |
      | http://dummy.restapiexample.com/api/v1/employee/1 | Successfully! Record has been fetched. |