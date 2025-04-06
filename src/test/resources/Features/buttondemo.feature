#Author: venu.vooda@gmail.com
Feature: Check whether Button Demo is present

  @demo
  Scenario: To traverse to Button demo page
    Given User is on selenium playbook base page
    When Click on Add Remove link
    Then validate Button page
	