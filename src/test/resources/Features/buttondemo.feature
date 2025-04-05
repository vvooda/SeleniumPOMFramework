#Author: venu.vooda@gmail.com
Feature: Check whether Button Demo is present

  @demo
  Scenario: To traverse to Button demo page
    Given User is on selenium playbook base page
    #And some other precondition
    When open selenium base page
    And Click on Add Remove link
    #And yet another action
    Then validate Button page
    #And check more outcomes
