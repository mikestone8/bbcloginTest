@bbc_before @bbc_after
Feature: login to the bbc site

#  Scenario: login successfully to the bbc news site
#    Given I am on the bbc login page
#    When I press the Sign in button
#    Then I can successfully log into the bbc site

    Scenario: login into the bbc site and change my postcode
      Given I am on the bbc login page
      When I press the Sign in button
      Then I can successfully log into the bbc site
      And I can access my accounts setting to change the postcode set