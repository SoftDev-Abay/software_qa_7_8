Feature: Search in Reports Registry

  Scenario: Search by code in column 2
    Given I am logged in as "edugov_admin" with password "CuShF33o"
    When I search for "040010" in column 2
    Then I should see the code "040010" with title "Д-9 раздел I. Сведения о ..."
