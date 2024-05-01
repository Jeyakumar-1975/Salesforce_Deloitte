@AccModify @Regression
Feature: Login tests As Salesforce Customer , I can modify account

  Scenario Outline: Login to salesforce and test account modification
    Given Login form in login page
    When Input "<Email>" and "<Password>" to login into app
    Given Home page is displayed
    And Click on accounts menu from home page
    Then Click on new button to create new account
    And User will enter account name as "<Account Name>"
    Then Click on save button
    And Click on accounts menu from home page
    Then verify "<Account Name>" in account listing page
    And click on "<Account Name>" account
    And click on modify account name
    And user will update account name as "<Updated Account Name>"
    Then Click on save button
    And Click on accounts menu from home page
    Then verify update "<Updated Account Name>" in account listing page
    Examples:
      | Email                                | Password    | Account Name | Updated Account Name |
      | jeyakumar.ranganathan-pgxd@force.com | Ranipet@321 |              |                      |

