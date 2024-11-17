Feature: As a user, I want to explore CDL website

  @smoke
  Scenario: User should able to navigate 'Our Mission' page sucessfully
    Given User is on CDL Home Page
   When User clicks on CDL Menu bar
    And user clicks on 'ABOUT' Tab
    And User clicks on 'Our Mission'
   Then User should successfully navigate to 'Our Mission' Page

