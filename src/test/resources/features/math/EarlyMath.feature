
@tag
Feature: EarlyMath

  @tag1
  Scenario: test1
    Given The user navigates to early math page
    And The user starts the addition subtraction challenge
    When The user selects the correct answer for the question
    |5|
    Then The user should see the message