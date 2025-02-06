Feature: User Login

  # This scenario tests a successful login flow
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I login with username "edugov_admin" and password "CuShF33o"
    Then I should be redirected to "https://esep.govtec.kz/admin"
