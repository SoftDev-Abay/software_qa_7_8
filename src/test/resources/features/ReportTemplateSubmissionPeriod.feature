Feature: Report Template Submission Period

  Scenario: Create a submission period for an existing template
    Given I am logged in as "edugov_admin" with password "CuShF33o"
    And I am on the report template page for report base "testing_qa19"
    When I create a submission period with period "2025" and template name "Шаблон отчета" and start date "2025-01-01" and end date "2025-12-31"
    Then I should see a success message or be able to confirm it was created
