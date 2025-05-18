Feature: this feature is to test login functionality validation

@T1
Scenario Outline: to check login using valid login credentials

Given user is in login page of sauce demo
When user enters valid "<username>" and password "<password>"
Then user should be logged in successfully to inventory page


Examples:

| username     | password   |
|standard_user |secret_sauce|
| visual_user  |secret_sauce|

@T2
Scenario: to check login using invalid login credentials
Given user is in login page of sauce demo
When user enters invalid credentials
| sabari | wrongpassword |
Then user should not be logged in successfully to inventory page