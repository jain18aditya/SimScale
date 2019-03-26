Feature: Create new project workflow
  I want to use this feature file to test create new project workflow on simscale

  Scenario Outline: create new project positive workflow
    Given Launch browser with url "simscale.url"
    And User log in with UserName "user.email" and password "password"
    When user creates new project with inputs "<ProjectTitle>", "<Project_Description>", "<Category>", "<Tag>", "<Measurement_type>"
    Then Project should get created successfully
    And Logout the user

    Examples: 
      | ProjectTitle | Project_Description | Category   | Tag        | Measurement_type |
      | Project1     | ProjectDesc         | Aerospace | ProjectTag | SI               |
