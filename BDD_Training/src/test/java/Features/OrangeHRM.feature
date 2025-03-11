@OrangeHRM
  Feature: OrangeHRM Check Test Cases

    @AllEmpty
    Scenario: Empty Username and Password
      Given User at "Login" Page
      When Clicks to "Login" button
      Then Checks required notifications about username and pw

    @FalseLogin
      Scenario: False Username and Pw
        Given User at "Login" Page
        When User Writes the Username "admin123" and Pw "Admin"
        When Clicks to "Login" button
        Then Checks the Error Message

    @CorrectLogin
      Scenario: Correct Username and Pw
        Given User at "Login" Page
        When User Writes the Username "Admin" and Pw "admin123"
        When Clicks to "Login" button
        Then User validates we are the the home page
