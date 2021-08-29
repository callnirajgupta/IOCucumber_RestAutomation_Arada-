@login @Regression
Feature: Login functionality

  @login1
  Scenario: Login as Admin
    Given user navigates to Arada login page
    When user login with "SuperAdmin" user in Arada
    Then verify that Arada dashboard page is displayed
    
    @login2
  Scenario: Login as Admin
    Given user navigates to Arada login page
    When user login with "Owner" user in Arada
    Then verify that Arada dashboard page is displayed
    
    
     @login21
  Scenario Outline: Login as Admin
    Given user navigates to Arada login page
    When user login with "<UserName>" and "<Password>" user in Arada
    Then verify that Arada dashboard page is displayed
    Examples:
    |UserName|Password|
    |demo_user5@exalogic.co|owner123|
    |demo_user5@exalogic.co|owner123|
    |demo_user5@exalogic.co|owner123|
    |demo_user5@exalogic.co|owner123|
    |demo_user5@exalogic.co|owner123|
    |demo_user5@exalogic.co|owner123|
    |demo_user5@exalogic.co|owner123|
    |user8@realcube.estate|owner123|
    
   @login12
  Scenario: Login as Admin
    Given user navigates to Arada login page
    When user login with "TenentOwner" user in Arada
    Then verify that Arada dashboard page is displayed
    
    @login3
  Scenario: Login as Finance
    Given user navigates to FINANCE login page
    When user login with "FinanceUser" user in Finance
    Then verify that Finance dashboard page is displayed
    
      @login4
  Scenario Outline: Login as Finance
    Given user navigates to FINANCE login page
    When user login with "FinanceUser" user in Finance
    Then verify that Finance dashboard page is displayed
    Examples:
    |count|
    |1|
    |1|
    |1|
    |1|
    
    
 