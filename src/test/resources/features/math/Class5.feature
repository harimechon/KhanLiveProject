#Author: your.email@your.domain.com
@tag
Feature: To test class 5 math courses

  @tag1
  Scenario: To verify the course list under class 5 math
    Given The user is in class5 math course
    When The user navigates to shapes and angles
    Then The user should see the list of videos
      | Angle measurement & circle arcs | Acute, right, & obtuse angles | Measuring angles in degrees | Recognizing angles | Identifying an angle | Measuring angles using a protractor | Measuring angles using a protractor 2 |
    And The user should see the list parctice courses
      | Angle types | Recognize angles | Draw right, acute, and obtuse angles | Benchmark angles | Measure angles |
