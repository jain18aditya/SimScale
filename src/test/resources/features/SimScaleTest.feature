Feature: Place online order
  I want to use this feature to test product shopping over a website

  Scenario: Register new user and place order
    Given Launch browser with url "simscale.url"
	  And User log in with UserName "user.email" and password "password"
		And Logout the user

  #Scenario: Login with existing user and place order
    #Given Launch browser with url "simscale.url"
#	  And User log in with UserName "user.email" and password "password"
#		And Logout the user
#		And close the browser
