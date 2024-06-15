#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Signup and Login
  This is Signup and Login page feature descriprion

  @Register
  Scenario: To verify the User is able to register successfully.
    Given User is on home page
    When User cliks on create account button
    And User fillup the required registration form.
    And User Click on create Account
    Then Check User is registered successfully.
    
  @Register 
  Scenario: To check the User should not be duplicate.
  	Given User is on home page
    When User cliks on create account button
    And User fillup the required registration form.
    And User Click on create Account
    Then Check User is already registered

   
    
  @Login
  Scenario Outline: Check user will not login with invalid credential "<username>" and "<password>"
    Given User is on login page
    When User enters valid "<username>" and "<password>"
    Then Check user is not allowed to login page
   Examples:
		|username|password|
		|vikasverma2291@outlook.com|incorrectpassword|
		|v123ikasverma2291@outlook.com|Password@123|
		
		
		@Login
  Scenario Outline: Check User login successfully with valid "<username>" and "<password>"
    Given User is on login page
    When User enters valid "<username>" and "<password>"
    Then Check user is navigated to login page
   Examples:
		|username|password|
		|vikasverma2291@outlook.com|Password@123|
		
    

