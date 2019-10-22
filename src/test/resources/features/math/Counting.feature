#Author: your.email@your.domain.com
@tag
Feature: To test the course couting

  @tag1
  Scenario: To verify the course title description
    Given The user navigates to early math page
    When The user navigates to addition subtration course
    And The user navigtes to intro to addition page
    Then The user should see the description in about section
      | Learn what it means to add. The examples used are 1+1 and 2+3. Created by Sal Khan. |
