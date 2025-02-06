Feature: Full Report Creation Flow

  Scenario: Create a full report with base, info, template, and table
    Given I am logged in as "edugov_admin" with password "CuShF33o"
    When I create a new report base with id "testing_qa20", Russian name "Тестовый отчет" and Kazakh name "Сынақ есеп"
    And I fill additional report info for report base "testing_qa20" with template id "testing_qa20"
    And I create a new report template for report base "testing_qa20" with Russian name "Шаблон отчета" and Kazakh name "Есеп үлгісі"
    And I open the report template page for report base "testing_qa20"
    And I open the template editor for report base "testing_qa20" and create a table named "Table1" with type "static", 5 rows and 4 columns
    And I save the template
    Then the report should be created successfully
