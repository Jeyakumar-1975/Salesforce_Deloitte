@AccSearch @Regression
Feature: Login tests As Salesforce Customer , I can search account


  Scenario Outline: Login to salesforce and test account creation
    Given Login form in login page
    When Input "<Email>" and "<Password>" to login into app
    Given Home page is displayed
    And Click on accounts menu from home page
    And input account "<Account Name>" for search
    Examples:
      | Email                                | Password    | Account Name |
      | jeyakumar.ranganathan-pgxd@force.com | Ranipet@321 | J00011       |
      | jeyakumar.ranganathan-pgxd@force.com | Ranipet@321 | ACC23        |
