Feature: Create new project workflow
  I want to use this feature file to test create new project workflow on simscale

  Background: 
    Given Launch browser with url "simscale.url"
    And User log in with UserName "user.email" and password "password"

  Scenario Outline: create new project positive workflow
    When user creates new project with inputs "<ProjectTitle>", "<Project_Description>", "<Category>", "<Tag>", "<Measurement_type>"
    Then Project should be displayed on "simscale.url" with "<ProjectTitle>"
    And Logout the user

    #  Project title and description are mandatory params
    Examples: 
      | ProjectTitle | Project_Description | Category  | Tag        | Measurement_type |
      | Project1     | ProjectDesc1        | Aerospace | ProjectTag | SI               |
      | Project2     | ProjectDesc2        |           |            |                  |

  Scenario Outline: Delete project positive workflow
    When User deletes "<ProjectTitle>"
    Then validate "<ProjectTitle>" is deleted
    And Logout the user

    Examples: 
      | ProjectTitle |
      | Project1     |
      | Project2     |

  Scenario Outline: field validation
    When user creates new project with inputs "<ProjectTitle>", "<Project_Description>", "<Category>", "<Tag>", "<Measurement_type>"
    Then Validate error message for "<ProjectTitle>", "<Project_Description>", "<errorMessage>"
    And Logout the user

    Examples: 
      | ProjectTitle | Project_Description | Category | Tag | Measurement_type | errorMessage                                                       |
      |              | ProjectDesc1        |          |     |                  | Project title must be at least 5 characters long                   |
      | Project2     |                     |          |     |                  | Description must be at least 5 characters long for public projects |
