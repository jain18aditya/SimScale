Feature: Create new project workflow
  I want to use this feature file to test create new project workflow on simscale

  Scenario Outline: create new project positive workflow
    Given Launch browser with url "simscale.url"
    And User log in with UserName "user.email" and password "password"
    When user creates new project with inputs "<ProjectTitle>", "<Project_Description>", "<Category>", "<Tag>", "<Measurement_type>"
    Then Project should be displayed on "simscale.url" with "<ProjectTitle>"
    And Logout the user

		#Project title and description are mandatory params
    Examples: 
     	| ProjectTitle | Project_Description | Category  | Tag        | Measurement_type |
      | Project1     | ProjectDesc1        | Aerospace | ProjectTag | SI               |
      | Project2     | ProjectDesc2        | 					 | 						|                  |