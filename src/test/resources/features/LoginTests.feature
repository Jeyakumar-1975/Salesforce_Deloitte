@Login @Regression
Feature: Login tests As Salesforce Customer , I can login to salesforce.com


  Scenario Outline: Login to salesforce using valid account that registered in personal and corporate account type
    Given Login form in login page
    When Input "<Email>" and "<Password>" to login into app
    Given Home page is displayed
    And Click on accounts menu from home page
    Then Click on new button to create new account
    And User will enter account name as "<Account Name>"
    Examples:
      | Email                                | Password    | Account Name |
      | jeyakumar.ranganathan-pgxd@force.com | Ranipet@321 | J001         |

  Scenario Outline: Verify invalid user login
    Given Login form in login page
    When Input "<Email>" and "<Password>" to login into app
    Then verify error message as "<ErrorMsg>"
    Examples:
      | Email                                | Password     | ErrorMsg                                                                                                   |
      | jeyakumar.ranganathan-pgxd@force.com | Ranipet@3212 | Please check your username and password. If you still can't log in, contact your Salesforce administrator. |
      | jeyakumar.ranganathan-pgxd@force.com | Ranipet@3212 | Please check your username and password. If you still can't log in, contact your Salesforce administrator. |
      | jeyakumar.ranganathan-pgxd@force.com | Ranipet@3212 | Please check your username and password. If you still can't log in, contact your Salesforce administrator. |
      | jeyakumar.ranganathan-pgxd@force.com | Ranipet@3212 | Please check your username and password. If you still can't log in, contact your .                         |


