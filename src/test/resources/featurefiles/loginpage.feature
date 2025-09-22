@login_feature
Feature: Login Page

#Background:
#    Given the browser is open
#    And the user navigates to the login page URL 'https://demoqa.com/login'

    Scenario: Login with empty fields
        Given the user is on the login page
        When the user leaves the username and password fields empty
        And clicks the login button
        Then a validation message should be displayed

     Scenario: Unsuccessful login with invalid credentials
        Given the user is on the login page
        When the user enters an invalid username 'shivG' and password 'Abcd@1234'
        And clicks the login button
        Then an error message should be displayed
    
    Scenario: Successful login with valid credentials
        Given the user is on the login page
        When the user enters a valid username 'shivG'and password 'Abc@1234'
        And clicks the login button
        Then the user should be redirected to the dashboard

   